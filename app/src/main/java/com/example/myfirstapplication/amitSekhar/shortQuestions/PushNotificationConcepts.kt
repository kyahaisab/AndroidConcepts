package com.example.myfirstapplication.amitSekhar.shortQuestions

/*
Q. How does the Android Push Notification system work?
Ans. We generally FCM, google firebase cloud messaging system to send notification to user.
Say we want to develop our own push notification. In that case we need to develop persistent connection between
server and the client using web socket connection(it is 2 way connection). So our and server needs to be connected all the time
Say we have 100 apps, so these 100 apps connected all the time to different server, which will drain battery and performance issue.

So how does this google system works: we have app, google server and our own server. So we will send our message to google server
with app credentials, google server will send it to google services in our app with credentials, that will send message to our app
as credentials have package info with msg and other details. This way we save ourself making 100 connections at a time.
 */