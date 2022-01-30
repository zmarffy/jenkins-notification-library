def call(Map map) {
    node('hascurl && linux') {
        env._RECENTLY_USED_NODE = env.NODE_NAME
        if (map.get('ifttt')) {
            withEnv(
                [
                    "PAYLOAD={\"value1\": \"$env.JOB_NAME $currentBuild.displayName $currentBuild.result\"}"
                ]
            ) {
                withCredentials(
                    [
                        string(
                            credentialsId: 'ifttt-key',
                            variable: 'IFTTT_KEY'
                        )
                    ]
                ) {
                    sh(
                        script: '''curl -sS -X POST -H "Content-Type: application/json" -d "$PAYLOAD" "https://maker.ifttt.com/trigger/jenkins/with/key/$IFTTT_KEY" > /dev/null''',
                        label: "POST to IFTTT"
                    )
                }
            }
        }
    }
}