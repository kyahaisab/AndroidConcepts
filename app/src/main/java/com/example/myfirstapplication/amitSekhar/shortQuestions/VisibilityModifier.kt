package com.example.myfirstapplication.amitSekhar.shortQuestions

/*
-Go in project view: You will see app module, create another module(Downloader) parallel app module
-In downloader module there are two classes ->DownloadProcess and DownloadExpose, where DownloadExpose is provide public method
to download songs to other classes/modules.
-To access DownloadExpose methods in app module classes, add the file in gradle file of app.
-Now we don't that anyone outside downloader module can access any of our classes except DownloadExpose, so put internal before
every class of downloader class. Making private instead of internal will create problem as other classes inside same module will
not be able to use it.

*** IMP: Don't module with package: using internal inside package class all are expose in same and other package of a module
         but not in different module.
 */