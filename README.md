# jenkins-notification-library

A library that contains a single function, sendNotification, that sends the name of the job followed by its status, to certain services.

Note that the node this runs on should be specified by the labels "hascurl" and "linux".

Its parameters are as follows.

## `ifttt`

If `true`, send a notification to IFTTT. Your IFTTT key must be in a usable credential called "ifttt-key". The webhook event name should be called "jenkins".

More to come later, probably.
