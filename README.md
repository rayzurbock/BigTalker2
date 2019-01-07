# BigTalker2
Have you ever wanted a talking house? Now you can! With the Big Talker SmartApp!

When Hubitat is paired with a compatible audio device (such as a Sonos, Ubi, LANnouncer, VLCThing, etc) and Big Talker SmartApp, your house can say what you want it to say when events occur.

Please review the documentation at http://thingsthataresmart.wiki/index.php?title=BigTalker

For VLCThing + BigTalker in Hubitat, you may need the following modified driver:
https://raw.githubusercontent.com/rayzurbock/hubitat/master/devices/VLCThing_BLMOD

# Installation
* Login to your Hubitat web interface
* Click Apps Code
* Click New App
* Copy the Hubitat code URL into your clipboard 
  * **Parent:** https://raw.githubusercontent.com/rayzurbock/BigTalker2/Hubitat/smartapps/rayzurbock/bigtalker2.src/bigtalker2.groovy
  * **Child:** https://raw.githubusercontent.com/rayzurbock/BigTalker2/Hubitat/smartapps/rayzurbock/bigtalker2-child.src/bigtalker2-child.groovy
* Click Import
* Paste the URL
* Click Import
* Click Save  
* Repeat for both parent and child code
* Click Apps
* Click Add User App
* Select BigTalker2
* Select Configure to configure the app defaults
* Important: Select your mode.  Read the prompt. 
  * Speech Synthesis works with devices using the speak() function. Only supports text to speech. Doesn't support mp3 playback.
  * musicPlayer works with devices that use the playText(), playTextAndRestore, playTextAndResume functions, does support mp3 playback.
* Go back into the BigTalker2 app
* Test using Talk Now
* Configure Event Groups as desired
