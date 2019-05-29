definition(
    name: "BigTalker2-Parent-DEV",
    namespace: "rayzurbock",
    author: "rayzur@rayzurbock.com",
    description: "Let's talk about mode changes, switches, motions, and so on.",
    category: "Fun & Social",
	//singleInstance: true,
    iconUrl: "http://lowrance.cc/ST/icons/BigTalker.png",
    iconX2Url: "http://lowrance.cc/ST/icons/BigTalker@2x.png",
    iconX3Url: "http://lowrance.cc/ST/icons/BigTalker@2x.png")

preferences {
    page(name: "pageStart")
    page(name: "pageTalkNow")
    page(name: "pageConfigureSpeechDeviceType")
    page(name: "pageConfigureDefaults")
    page(name: "pageHelpPhraseTokens")
//End preferences
}

def pageStart(){
    state.childAppName = "BigTalker2-Child-DEV"
    state.parentAppName = "BigTalker2-Parent-DEV"
    state.namespace = "rayzurbock"
	setVersion()
    state.hubType = getHubType()
    LOGDEBUG("Hub Type: ${state.hubType}")
	setFormatting()
    state.supportedVoices = ["Ivy(en-us)","Joanna(en-us)","Joey(en-us)","Justin(en-us)","Matthew(en-us)","Kendra(en-us)","Kimberly(en-us)","Salli(en-us)","Amy(en-gb)","Brian(en-gb)","Emma(en-gb)","Miguel(es-us)","Penelope(es-us)"]
    if (checkConfig()) { 
        // Do nothing here, but run checkConfig() 
    } 
    dynamicPage(name: "pageStart", title: "Big Talker", install: false, uninstall: (app.getInstallationState() == "COMPLETE")){
    	def formatSettingRootStart = state.formatSettingRootStart
		def formatSettingRootEnd = state.formatSettingRootEnd
		def formatSettingOptionalStart = state.formatSettingOptionalStart
		def formatSettingOptionalEnd = state.formatSettingOptionalEnd
        def formatUlStart = state.formatUlStart
		def formatUlEnd = state.formatUlEnd
        def formatLiStart = state.formatLiStart
		def formatLiEnd = state.formatLiEnd
        def formatIStart = state.formatIStart
		def formatIEnd = state.formatIEnd
        def formatStrongStart = state.formatStrongStart
		def formatStrongEnd = state.formatStrongEnd
        def formatHr = state.formatHr
        def formatBr = state.formatBr
        def formatCenterStart = state.formatCenterStart
        def formatCenterEnd = state.formatCenterEnd
        section(){
        	LOGDEBUG("install state=${app.getInstallationState()}.")
        	def mydebug_pollnow = ""
            if (!(state.configOK)) { 
                href "pageConfigureSpeechDeviceType", title:"Configure", description:"Tap to configure"
            } else {
                //V1Method href "pageConfigureEvents", title: "Configure Events", description: "Tap to configure events"
                //href "pageStatus", title:"Status", description:"Tap to view status"
                href "pageConfigureDefaults", title: "Configure Defaults", description: "Tap to configure defaults"
				href "pageTalkNow", title:"Talk Now", description:"Tap to setup talk now" 
            }
        }
        section("Event Groups") {}
        section(){
        	def apps = getChildApps()?.sort{ it.label }
        	if (state.configOK) {
            	if (apps?.size() == 0) {
                	paragraph "You have not configured any event groups yet."
                    app(name: "BTEvt-", appName: state.childAppName, namespace: state.namespace, title: "Add Event Group", description: "Tap to configure event triggers", multiple: true, uninstall: false)
                } else {
            		app(name: "BTEvt-", appName: state.childAppName, namespace: state.namespace, title: "Add Event Group", description: "Tap to configure event triggers", multiple: true, uninstall: false)
                }
            }
        }
        section(){
        	if ((settings?.debugmode == true) && (state.speechDeviceType == "capability.musicPlayer") && (settings?.resumePlay == true)) {
            		input name: "debug_pollnow", type: "bool", title: "DEBUG: Poll Now (simply toggle)", multiple: false, required: false, submitOnChange: true, defaultValue: false
            		if (!(settings.debug_pollnow == mydebug_pollnow)) { poll() }
            }
        }
        section("About"){
            def AboutApp = ""
            AboutApp += "${formatHr}Big Talker is a SmartApp that can make your house talk depending on various triggered events.${formatBr}${formatBr}"
            if (state.hubType == "Hubitat") {AboutApp += "Pair with a Hubitat compatible audio device such as Sonos, Ubi, LANnouncer, and/or VLC Thing (running on your computer or Raspberry Pi)${formatBr}"}
            if (state.hubType == "SmartThings") {AboutApp += "Pair with a SmartThings compatible audio device such as Sonos, Ubi, LANnouncer, VLC Thing (running on your computer or Raspberry Pi), a DLNA device using the 'Generic MediaRenderer' SmartApp/Device and/or AskAlexa SmartApp${formatBr}"}
            paragraph(AboutApp)
			updateCheck()
			//checkButtons()
			displayVersionStatus()
        }
		section("${formatHr}${formatHr}${formatStrongStart}${formatCenterStart}Donations${formatCenterEnd}${formatStrongEnd}"){
				def DonateOptions = ""
				DonateOptions += "Big Talker is provided to the community for free.  It takes a lot of time to build and support any complex app.  If you wish to support the time and effort put into development you may submit a donation with one of the following:${formatBr}"
				DonateOptions += "${formatUlStart}"
                if (state.hubType == "Hubitat"){
					DonateOptions += "${formatLiStart}${formatStrongStart}Cash.me${formatStrongEnd} = <a target='_blank' href='https://cash.me/$Lowrance'>https://cash.me/$Lowrance</a> (use a debit card, it\'s free for both of us)${formatLiEnd}"
					DonateOptions += "${formatLiStart}${formatStrongStart}Venmo${formatStrongEnd} = <a target='_blank' href='https://venmo.com/code?user_id=2603208862072832399'>@BrianLowrance</a>${formatLiEnd}"
					DonateOptions += "${formatLiStart}${formatStrongStart}Paypal.me${formatStrongEnd} = <a target='_blank' href='https://paypal.me/brianlowrance'>https://paypal.me/brianlowrance</a> (They take a little since I setup my account as a business account)${formatLiEnd}"
                } else {
                	DonateOptions += "${formatLiStart}${formatStrongStart}Cash.me${formatStrongEnd} = https://cash.me/\$Lowrance (use a debit card, it\'s free for both of us)${formatLiEnd}"
					DonateOptions += "${formatLiStart}${formatStrongStart}Venmo${formatStrongEnd} @BrianLowrance${formatLiEnd}"
					DonateOptions += "${formatLiStart}${formatStrongStart}Paypal.me${formatStrongEnd} = https://paypal.me/brianlowrance${formatLiEnd}"
                }
				paragraph(DonateOptions)					
		}
    }
}

def pageTalkNow(){
    dynamicPage(name: "pageTalkNow", title: "Talk Now", install: false, uninstall: false){
        section(""){
        	def myTalkNowResume = false
            paragraph ("Speak the following phrase:\nNote: must differ from the last spoken phrase\n")
            if (state.speechDeviceType == "capability.musicPlayer") {
            	input name: "talkNowVolume", type: "number", title: "Set volume to (overrides default):", required: false, submitOnChange: true
            	input name: "talkNowResume", type: "bool", title: "Enable audio resume", multiple: true, required: false, submitOnChange: true, defaultValue: (settings?.resumePlay == false) ? false : true
                input name: "talkNowVoice", type: "enum", title: "Select custom voice:", options: state.supportedVoices, required: false, submitOnChange: true
                myTalkNowResume = settings.talkNowResume
            }
            input name: "speechTalkNow", type: "text", title: "Speak phrase", required: false, submitOnChange: true
            input name: "talkNowSpeechDevice", type: state.speechDeviceType, title: "Talk with these text-to-speech devices", multiple: true, required: false, submitOnChange: true
            //LOGDEBUG("previoustext=${state.lastTalkNow} New=${settings.speechTalkNow}")
            if (((!(state.lastTalkNow == settings.speechTalkNow)) && (settings.talkNowSpeechDevice)) || (settings.speechTalkNow?.contains("%askalexa%"))){
                //Say stuff!
                if (state.speechDeviceType == "capability.musicPlayer") {
                	myTalkNowResume = (myTalkNowResume == "") ? settings.resumeAudio : true //use global setting if TalkNow is not set
                	if (settings?.talkNowResume == null) {mytalkNowResume = true}  //default to true if not set.
				} else {
					//speechSynthesis does not use the following settings; make sure they are not null though
					myVolume = "100"
					myTalkNowResume = false
					personality = false
					myVoice = ""
				}
                def customevent = [displayName: 'BigTalker:TalkNow', name: 'TalkNow', value: 'TalkNow', descriptionText: "Talk Now"]
                def myVolume = getDesiredVolume(settings?.talkNowVolume)
                def myVoice = getMyVoice(settings.talkNowVoice)
                //def myVoice = (!(talkNowVoice == null || talkNowVoice == "")) ? talkNowVoice : (settings?.speechVoice ? settings.speechVoice : "Sallie(en-us)")
                def personality = false
                LOGDEBUG ("TalkNow Voice=${myVoice}")
                Talk("Talk Now", settings.speechTalkNow, settings.talkNowSpeechDevice, myVolume, myTalkNowResume, personality, myVoice, customevent)
                state.lastTalkNow = settings.speechTalkNow
            }
        }
        section("Help"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
    }
}

def getMyVoice(deviceVoice){
    def myVoice = "Not Used"
    if (state?.speechDeviceType == "capability.musicPlayer") {
    	log.debug "getMyVoice[parent]: deviceVoice=${deviceVoice ? deviceVoice : "Not selected"}"
        log.debug "getMyVoice[parent]: settings.speechVoice=${settings?.speechVoice}"
		myVoice = (!(deviceVoice == null || deviceVoice == "")) ? deviceVoice : (settings?.speechVoice ? settings?.speechVoice : "Salli(en-us)")
    }
    return myVoice
}

def pageHelpPhraseTokens(){
	//KEEP IN SYNC WITH CHILD!
        dynamicPage(name: "pageHelpPhraseTokens", title: "Available Phrase Tokens", install: false, uninstall:false){
    	def formatSettingRootStart = state.formatSettingRootStart
		def formatSettingRootEnd = state.formatSettingRootEnd
		def formatSettingOptionalStart = state.formatSettingOptionalStart
		def formatSettingOptionalEnd = state.formatSettingOptionalEnd
        def formatUlStart = state.formatUlStart
		def formatUlEnd = state.formatUlEnd
        def formatLiStart = state.formatLiStart
		def formatLiEnd = state.formatLiEnd
        def formatIStart = state.formatIStart
		def formatIEnd = state.formatIEnd
        def formatStrongStart = state.formatStrongStart
		def formatStrongEnd = state.formatStrongEnd
       section("The following tokens can be used in your event phrases and will be replaced as listed:"){
       	   def AvailTokens = ""
           AvailTokens += "${formatUlStart}"
           if (state.hubType == "SmartThings"){ AvailTokens += "${formatLiStart}${formatStrongStart}%askalexa%{formatStrongEnd} = Send phrase to AskAlexa SmartApp's message queue${formatLiEnd}" }
		   AvailTokens += "${formatLiStart}${formatStrongStart}%groupname%${formatStrongEnd} = Name that you gave for the event group${formatLiEnd}"
           AvailTokens += "${formatLiStart}${formatStrongStart}%date%${formatStrongEnd} = Current date; January 01 20xx${formatLiEnd}"
           AvailTokens += "${formatLiStart}${formatStrongStart}%day%${formatStrongEnd} = Current day; Monday${formatLiEnd}"
           AvailTokens += "${formatLiStart}${formatStrongStart}%devicename%${formatStrongEnd} = Triggering devices display name${formatLiEnd}"
           AvailTokens += "${formatLiStart}${formatStrongStart}%devicetype%${formatStrongEnd} = Triggering device type; motion, switch, etc${formatLiEnd}"
           AvailTokens += "${formatLiStart}${formatStrongStart}%devicechange%${formatStrongEnd} = State change that occurred; on/off, active/inactive, etc...${formatLiEnd}"
           AvailTokens += "${formatLiStart}${formatStrongStart}%description%${formatStrongEnd} = The description of the event that is to be displayed to the user in the mobile application.${formatLiEnd}"
           AvailTokens += "${formatLiStart}${formatStrongStart}%locationname%${formatStrongEnd} = Hub location name; home, work, etc${formatLiEnd}"
           AvailTokens += "${formatLiStart}${formatStrongStart}%lastmode%${formatStrongEnd} = Last hub mode; home, away, etc${formatLiEnd}"
           AvailTokens += "${formatLiStart}${formatStrongStart}%mode%${formatStrongEnd} = Current hub mode; home, away, etc${formatLiEnd}"
           AvailTokens += "${formatLiStart}${formatStrongStart}%mp3(url)%${formatStrongEnd} = Play hosted MP3 file; URL should be http://www.domain.com/path/file.mp3"
           AvailTokens += "${formatUlStart}${formatLiStart}${formatIStart}No other tokens or phrases can be used with %mp3(url)%${formatIEnd}${formatLiEnd}${formatUlEnd}"
		   AvailTokens += "${formatLiEnd}"
           AvailTokens += "${formatLiStart}${formatStrongStart}%time%${formatStrongEnd} = Current hub time; HH:mm am/pm${formatStrongEnd}${formatLiEnd}"
		   AvailTokens += "${formatUlEnd}"
		   if (state.hubType == "SmartThings"){ AvailTokens += "${formatLiStart}${formatStrongStart}%shmstatus%${formatStrongEnd} = SmartHome Monitor Status (Disarmed, Armed Home, Armed Away)${formatLiEnd}" }
           if (state.hubType == "SmartThings"){ AvailTokens += "${formatLiStart}${formatStrongStart}%weathercurrent%${formatStrongEnd} = Current weather based on hub location${formatLiEnd}" }
           if (state.hubType == "SmartThings"){ AvailTokens += "${formatLiStart}${formatStrongStart}%weathercurrent(00000)%${formatStrongEnd} = Current weather* based on custom zipcode (replace 00000)${formatLiEnd}" }
           if (state.hubType == "SmartThings"){ AvailTokens += "${formatLiStart}${formatStrongStart}%weathertoday%${formatStrongEnd} = Today's weather forecast* based on hub location${formatLiEnd}" }
           if (state.hubType == "SmartThings"){ AvailTokens += "${formatLiStart}${formatStrongStart}%weathertoday(00000)%${formatStrongEnd} = Today's weather forecast* based on custom zipcode (replace 00000)${formatLiEnd}" }
           if (state.hubType == "SmartThings"){ AvailTokens += "${formatLiStart}${formatStrongStart}%weathertonight%${formatStrongEnd} = Tonight's weather forecast* based on hub location${formatLiEnd}" }
           if (state.hubType == "SmartThings"){ AvailTokens += "${formatLiStart}${formatStrongStart}%weathertonight(00000)%${formatStrongEnd} = Tonight's weather* forecast based on custom zipcode (replace 00000)${formatLiEnd}" }
           if (state.hubType == "SmartThings"){ AvailTokens += "${formatLiStart}${formatStrongStart}%weathertomorrow%${formatStrongEnd} = Tomorrow's weather forecast* based on hub location${formatLiEnd}" }
           if (state.hubType == "SmartThings"){ AvailTokens += "${formatLiStart}${formatStrongStart}%weathertomorrow(00000)%${formatStrongEnd} = Tomorrow's weather forecast* based on custom zipcode (replace 00000)${formatLiEnd}" }
           paragraph(AvailTokens)
       }
   }
}

def pageConfigureSpeechDeviceType(){
	def myNextPage = ""
    if (!(state?.installed == true)) { state.installed = false; state.speechDeviceType = "capability.musicPlayer"; myNextPage = "pageConfigureDefaults"}
    dynamicPage(name: "pageConfigureSpeechDeviceType", title: "Configure", nextPage: myNextPage, install: false, uninstall: false) {
        //section ("Speech Device Type Support"){
        section (){
			if (state.installed == true) { 
				paragraph "<font color=red><strong>PROCEED WITH CAUTION!</strong></font>\n<font color=red><strong>WARNING!</strong></font> If you change this setting after the app has been configured, you will need to update your selected default and custom speech devices!\n <strong>To Cancel:</strong> Don't move the switch and press Next (or Done)\n<font color=red><strong>PROCEED WITH CAUTION!</strong></font>"
			}
            paragraph "${app.label} can support either 'Music Player' or 'Speech Synthesis' devices."
            if (state.hubType == "SmartThings") { paragraph "'Music Player' typically supports devices such as Sonos, VLCThing, Generic Media Renderer.\n'Speech Synthesis' typically supports devices such as Ubi and LANnouncer.\n\nIf only using with AskAlexa this setting can be ignored.\n\nWARNING: This setting cannot be changed without reinstalling ${app.label}."}
            if (state.hubType == "Hubitat") { paragraph "'Music Player' typically supports devices such as Sonos, VLCThing.\n'Speech Synthesis' typically supports devices such as Ubi and LANnouncer."}
            input "speechDeviceType", "bool", title: "ON=Music Player\nOFF=Speech Synthesis", required: true, defaultValue: true, submitOnChange: true
            //paragraph "Click Next to continue configuration...\n"
            if (speechDeviceType == true) {state.speechDeviceType = "capability.musicPlayer"}
            if (speechDeviceType == false) {state.speechDeviceType = "capability.speechSynthesis"}
        }
    }
//End pageConfigureSpeechDeviceType()
}

def pageConfigureDefaults(){
	unsubscribe()
	myRunIn(3, initSubscribe)
	state.mode = location.mode
	state.lastMode = state.mode
    if (state?.installed == true) { 
       state.dynPageProperties = [
            name:      "pageConfigureDefaults",
            title:     "Configure Defaults",
            install:   false,
            uninstall: false,
            //nextPage:  "pageConfigureEvents"
        ]
    } else {
       state.dynPageProperties = [
            name:      "pageConfigureDefaults",
            title:     "Configure Defaults",
            install:   true,
            uninstall: false
        ]
    }
    return dynamicPage(state.dynPageProperties) {
    //dynamicPage(name: "pageConfigureDefaults", title: "Configure Defaults", nextPage: "${myNextPage}", install: false, uninstall: false) {
		section("${state.formatSettingRootStart}Talk with:${state.formatSettingRootEnd}"){
           if (state.speechDeviceType == null || state.speechDeviceType == "") { state.speechDeviceType = "capability.musicPlayer" }
           input "speechDeviceDefault", state.speechDeviceType, title: "Talk with these text-to-speech devices (default)", multiple: true, required: false, submitOnChange: false
        }
        if (state.speechDeviceType == "capability.musicPlayer") {
            section ("${state.formatSettingRootStart}Adjust volume during announcement <I>(optional; Supports: Sonos, VLC-Thing):${state.formatSettingRootEnd}"){
            	input "speechMinimumVolume", "number", title: "Minimum volume for announcement (0-100%, Default: 50%):", required: false
                input "speechVolume", "number", title: "Set volume during announcement (0-100%):", required: false
                input "speechVoice", "enum", title: "Select voice:", options: state.supportedVoices, required: true, defaultValue: "Salli(en-us)"
            }
            section ("${state.formatSettingRootStart}Attempt to resume playing audio <I>(optional; Supports: Sonos, VLC-Thing):${state.formatSettingRootEnd}"){
            	input "resumePlay", "bool", title: "Resume Play:", required: true, defaultValue: true
                input "allowScheduledPoll", "bool", title: "Enable polling device status (recommended)", required: true, defaultValue: true
            }
        }
        section (""){
            input "speechModesDefault", "mode", title: "${state.formatSettingRootStart}Talk only while in these modes (default)${state.formatSettingRootEnd}", multiple: true, required: true, submitOnChange: false
        }
        section ("${state.formatSettingRootStart}Only between these times:${state.formatSettingRootEnd}"){
            input "defaultStartTime", "time", title: "Don't talk before: ", required: false, submitOnChange: true
            input "defaultEndTime", "time", title: "Don't talk after: ", required: (!(settings.defaultStartTime == null)), submitOnChange: true
        }
        section(){
            input "personalityMode", "bool", title: "${state.formatSettingRootStart}Allow Personality?${state.formatSettingRootEnd}", required: true, defaultValue: false
            input "debugmode", "bool", title: "${state.formatSettingRootStart}Enable debug logging${state.formatSettingRootEnd}", required: true, defaultValue: false, submitOnChange: true
			if (debugmode) { 
				if (state.debugMode == false || state?.debugMode == null){
					state.debugMode = true; myRunIn(1800, disableDebug); LOGTRACE("Debug logging has been enabled.  Will auto-disable in 30 minutes.")
				}
			} else {
				state.debugMode = false; unschedule("disableDebug");  LOGTRACE("Debug logging is not enabled.")
			}
        }
		section("Advanced"){
				href "pageConfigureSpeechDeviceType", title:"Change Speech Mode", description:"Tap to change speech mode (musicPlayer <> speechSynthesis)"
		}
    }
}

def installed() {
	state.installed = true
    //LOGTRACE("Installed with settings: ${settings}")
    LOGTRACE("Installed (Parent Version: ${state.version})")
	initialize()
    if (((settings?.allowScheduledPoll == true || state?.allowScheduledPoll == true)) || ((settings?.allowScheduledPoll == null) || (state?.allowScheduledPoll == null))){ 
    	myRunIn(60, poll) 
    }
//End installed()
}

def updated() {
    unschedule()
    state.installed = true
	//LOGTRACE("Updated with settings: ${settings}")
    LOGTRACE("Updated settings (Parent Version: ${state.version})")
    unsubscribe()
    initialize()
    if (((settings?.allowScheduledPoll == true || state?.allowScheduledPoll == true)) || ((settings?.allowScheduledPoll == null) || (state?.allowScheduledPoll == null))){ 
    	myRunIn(60, poll) 
    }
//End updated()
}

def checkConfig() {
    def configErrorList = ""
    if (!(state.speechDeviceType)){
       state.speechDeviceType = "capability.musicPlayer" //Set a default if the app was update and didn't contain settings.speechDeviceType
    }
    if ((settings?.allowScheduledPoll == true) && (settings?.resumePlay == true)) { state.allowScheduledPoll = true }
    if ((settings?.allowScheduledPoll == null) || (settings?.resumePlay == null)) { state.allowScheduledPoll = true }
	if ((settings?.allowScheduledPoll == false) || (settings?.resumePlay == false)) { state.allowScheduledPoll = false}
//    if (!(settings.speechDeviceDefault)){
//        configErrorList += "  ** Default speech device(s) not selected,"
//    }
    if (!(state.installed == true)) {
	    configErrorList += "  ** state.installed not True,"
	}
    if (!(configErrorList == "")) { 
        LOGDEBUG ("checkConfig() returning FALSE (${configErrorList})")
        state.configOK = false
        return false //Errors occurred.  Config check failed.
    } else {
        LOGDEBUG ("checkConfig() returning TRUE (${configErrorList})")
        state.configOK = true
        return true
    }
}

def initialize() {
    if (!(checkConfig())) { 
        def msg = ""
        msg = "ERROR: App not properly configured!  Can't start.\n"
        msg += "ERRORs:\n${state.configErrorList}"
        LOGTRACE(msg)
        if (state.hubType == "SmartThings") {sendNotificationEvent(msg)}
        state.polledDevices = ""
        return //App not properly configured, exit, don't subscribe
    }
	version()
	LOGTRACE("Initialized (Parent Version: ${state.version})")
    if (state.hubType == "SmartThings") {sendNotificationEvent("${app.label.replace(" ","").toUpperCase()}: Settings activated")}
    state.lastMode = location.mode
    state.lastTalkNow = settings.speechTalkNow
	initSubscribe()
//End initialize()
}

def initSubscribe() {
	//Subscribe Mode
	LOGDEBUG("Subscribed")
    subscribe(location, "mode", onModeChangeEvent) //Keep track of mode changes
}

def processPhraseVariables(appname, phrase, evt){
    try {
    	def zipCode = location.zipCode
    	def mp3Url = ""
    	if (phrase.toLowerCase().contains("%mp3(")) { 
    		if (phrase.toLowerCase().contains(".mp3)%")) {
            	def phraseMP3Start = (phrase.toLowerCase().indexOf("%mp3(") + 5)
            	def phraseMP3End = (phrase.toLowerCase().indexOf(".mp3)%"))
            	mp3Url = phrase.substring(phraseMP3Start, phraseMP3End)
            	LOGDEBUG("MP3 URL: ${mp3Url}")
            	phrase = phrase.replace("%mp3(","")
            	phrase = phrase.replace(".mp3)%", ".mp3")
            	phrase = phrase.replace (" ", "%20")
            	phrase = phrase.replace ("+", "%2B")
            	phrase = phrase.replace ("-", "%2D")
        	} else {
	            phrase = "Invalid M P 3 URL found in M P 3 token"
    	    }
	        return phrase
    	}
    	if (phrase.toLowerCase().contains(" percent ")) { phrase = phrase.replace(" percent ","%") }
    	if (phrase.toLowerCase().contains("%groupname%")) {
    		phrase = phrase.toLowerCase().replace('%groupname%', appname)
    	}
    	if (phrase.toLowerCase().contains("%devicename%")) {
	    	try {
    	    	phrase = phrase.toLowerCase().replace('%devicename%', evt.displayName)  //User given name of the device triggering the event
        	}
        	catch (ex) { 
        		LOGDEBUG("evt.displayName failed; trying evt.device.displayName")
        		try {
                	phrase = phrase.toLowerCase().replace('%devicename%', evt.device.displayName) //User given name of the device triggering the event
            	}
            	catch (ex2) {
	            	LOGDEBUG("evt.device.displayName filed; trying evt.device.name")
    	            try {
        	        	phrase = phrase.toLowerCase().replace('%devicename%', evt.device.name) //SmartThings name for the device triggering the event
            	    }
                	catch (ex3) {
                		LOGDEBUG("evt.device.name filed; Giving up")
                    	phrase = phrase.toLowerCase().replace('%devicename%', "Device Name Unknown")
                	}
            	}
       		}
    	}
    	if (phrase.toLowerCase().contains("%devicetype%")) {phrase = phrase.toLowerCase().replace('%devicetype%', evt.name)}  //Device type: motion, switch, etc...
    	if (phrase.toLowerCase().contains("%devicechange%")) {phrase = phrase.toLowerCase().replace('%devicechange%', evt.value)}  //State change that occurred: on/off, active/inactive, etc...
    	if (phrase.toLowerCase().contains("%description%")) {phrase = phrase.toLowerCase().replace('%description%', evt.descriptionText)}  //Description of the event which occurred via device-specific text`
    	if (phrase.toLowerCase().contains("%locationname%")) {phrase = phrase.toLowerCase().replace('%locationname%', location.name)}
    	if (phrase.toLowerCase().contains("%lastmode%")) {phrase = phrase.toLowerCase().replace('%lastmode%', state.lastMode)}
    	if (phrase.toLowerCase().contains("%mode%")) {phrase = phrase.toLowerCase().replace('%mode%', location.mode)}
    	if (phrase.toLowerCase().contains("%time%")) {
    		phrase = phrase.toLowerCase().replace('%time%', getTimeFromCalendar(false,true))
        	if ((phrase.toLowerCase().contains("00:")) && (phrase.toLowerCase().contains("am"))) {phrase = phrase.toLowerCase().replace('00:', "12:")}
        	if ((phrase.toLowerCase().contains("24:")) && (phrase.toLowerCase().contains("am"))) {phrase = phrase.toLowerCase().replace('24:', "12:")}
        	if ((phrase.toLowerCase().contains("0:")) && (!phrase.toLowerCase().contains("10:")) && (phrase.toLowerCase().contains("am"))) {phrase = phrase.toLowerCase().replace('0:', "12:")}
    	}
    	if (phrase.toLowerCase().contains("%weathercurrent%")) {phrase = phrase.toLowerCase().replace('%weathercurrent%', getWeather("current", zipCode)); phrase = adjustWeatherPhrase(phrase)}
    	if (phrase.toLowerCase().contains("%weathertoday%")) {phrase = phrase.toLowerCase().replace('%weathertoday%', getWeather("today", zipCode)); phrase = adjustWeatherPhrase(phrase)}
    	if (phrase.toLowerCase().contains("%weathertonight%")) {phrase = phrase.toLowerCase().replace('%weathertonight%', getWeather("tonight", zipCode));phrase = adjustWeatherPhrase(phrase)}
    	if (phrase.toLowerCase().contains("%weathertomorrow%")) {phrase = phrase.toLowerCase().replace('%weathertomorrow%', getWeather("tomorrow", zipCode));phrase = adjustWeatherPhrase(phrase)}
    	if (phrase.toLowerCase().contains("%weathercurrent(")) {
	        if (phrase.toLowerCase().contains(")%")) {
	            def phraseZipStart = (phrase.toLowerCase().indexOf("%weathercurrent(") + 16)
	            def phraseZipEnd = (phrase.toLowerCase().indexOf(")%"))
	            zipCode = phrase.substring(phraseZipStart, phraseZipEnd)
	            LOGDEBUG("Custom zipCode: ${zipCode}")
	            phrase = phrase.toLowerCase().replace("%weathercurrent(${zipCode.toLowerCase()})%", getWeather("current", zipCode.toLowerCase()))
	            phrase = adjustWeatherPhrase(phrase.toLowerCase())
	        } else {
	            phrase = "Custom Zip Code format error in request for current weather"
	        }
	    }
	    if (phrase.toLowerCase().contains("%weathertoday(")) {
	        if (phrase.contains(")%")) {
	            def phraseZipStart = (phrase.toLowerCase().indexOf("%weathertoday(") + 14)
	            def phraseZipEnd = (phrase.toLowerCase().indexOf(")%"))
	            zipCode = phrase.substring(phraseZipStart, phraseZipEnd)
	            LOGDEBUG("Custom zipCode: ${zipCode}")
	            phrase = phrase.toLowerCase().replace("%weathertoday(${zipCode.toLowerCase()})%", getWeather("today", zipCode.toLowerCase()))
	            phrase = adjustWeatherPhrase(phrase.toLowerCase())
	        } else {
	            phrase = "Custom Zip Code format error in request for today's weather"
	        }
	    }
	    if (phrase.toLowerCase().contains("%weathertonight(")) {
	        if (phrase.contains(")%")) {
	            def phraseZipStart = (phrase.toLowerCase().indexOf("%weathertonight(") + 16)
	            def phraseZipEnd = (phrase.toLowerCase().indexOf(")%"))
	            zipCode = phrase.substring(phraseZipStart, phraseZipEnd)
	            LOGDEBUG("Custom zipCode: ${zipCode}")
	            phrase = phrase.toLowerCase().replace("%weathertonight(${zipCode.toLowerCase()})%", getWeather("tonight", zipCode.toLowerCase()))
	            phrase = adjustWeatherPhrase(phrase)
	        } else {
	            phrase = "Custom Zip Code format error in request for tonight's weather"
	        }
	    }
	    if (phrase.toLowerCase().contains("%weathertomorrow(")) {
	        if (phrase.contains(")%")) {
	            def phraseZipStart = (phrase.toLowerCase().indexOf("%weathertomorrow(") + 17)
	            def phraseZipEnd = (phrase.toLowerCase().indexOf(")%"))
	            zipCode = phrase.substring(phraseZipStart, phraseZipEnd)
	            LOGDEBUG("Custom zipCode: ${zipCode}")
	            phrase = phrase.toLowerCase().replace("%weathertomorrow(${zipCode.toLowerCase()})%", getWeather("tomorrow", zipCode.toLowerCase()))
	            phrase = adjustWeatherPhrase(phrase)
	        } else {
	            phrase = "Custom ZipCode format error in request for tomorrow's weather"
	        }
	    }
	    if (state.speechDeviceType == "capability.speechSynthesis"){
	        //ST TTS Engine pronunces "Dash", so only convert for speechSynthesis devices (LANnouncer)
	        if (phrase.contains(",")) { phrase = phrase.replace(","," - ") }
	        //if (phrase.contains(".")) { phrase = phrase.replace("."," - ") }
	    }
	    if (phrase.toLowerCase().contains("%shmstatus%")) {
	    	def shmstatus = location.currentState("alarmSystemStatus")?.value
	        LOGDEBUG("SHMSTATUS=${shmstatus}")
			def shmmessage = [off : "Disarmed", away: "Armed, away", home: "Armed, home"][shmstatus] ?: shmstatus
	        LOGDEBUG("SHMMESSAGE=${shmmessage}")
	        phrase = phrase.replace("%shmstatus%", shmmessage)
	    }
	    if (phrase.contains('"')) { phrase = phrase.replace('"',"") }
	    if (phrase.contains("'")) { phrase = phrase.replace("'","") }
	    if (phrase.toLowerCase().contains("10s")) { phrase = phrase.toLowerCase().replace("10s","tens") }
	    if (phrase.toLowerCase().contains("20s")) { phrase = phrase.toLowerCase().replace("20s","twenties") }
	    if (phrase.toLowerCase().contains("30s")) { phrase = phrase.toLowerCase().replace("30s","thirties") }
	    if (phrase.toLowerCase().contains("40s")) { phrase = phrase.toLowerCase().replace("40s","fourties") }
	    if (phrase.toLowerCase().contains("50s")) { phrase = phrase.toLowerCase().replace("50s","fifties") }
	    if (phrase.toLowerCase().contains("60s")) { phrase = phrase.toLowerCase().replace("60s","sixties") }
	    if (phrase.toLowerCase().contains("70s")) { phrase = phrase.toLowerCase().replace("70s","seventies") }
	    if (phrase.toLowerCase().contains("80s")) { phrase = phrase.toLowerCase().replace("80s","eighties") }
	    if (phrase.toLowerCase().contains("90s")) { phrase = phrase.toLowerCase().replace("90s","nineties") }
	    if (phrase.toLowerCase().contains("100s")) { phrase = phrase.toLowerCase().replace("100s","one hundreds") }
	    if (phrase.toLowerCase().contains("%askalexa%")) {
	    	phrase=phrase.toLowerCase().replace("%askalexa%","")
	        if (!(phrase == "") && (!(phrase == null))){
	    		LOGTRACE("Sending to AskAlexa: ${phrase}.")
		        sendLocationEvent(name: "AskAlexaMsgQueue", value: "BigTalker", isStateChange: true, descriptionText: phrase)
	        }else{
	        	LOGERROR("Phrase only contained %askalexa%. Nothing to say/send.")
	        }
	    }
	    if (phrase.toLowerCase().contains("%date%")) {
	    	phrase=phrase.toLowerCase().replace("%date%",(new Date().format( 'MMMM dd' )))
	    }
	    if (phrase.toLowerCase().contains("%day%")) {
	    	phrase=phrase.toLowerCase().replace("%day%",(new Date().format('EEEE',location.timeZone)))
	    }
	    if (phrase.contains("%")) { phrase = phrase.replace("%"," percent ") }
	    return phrase
	} catch(ex) { 
		LOGTRACE("There was a problem processing your desired phrase: ${phrase}. ${ex}")
    	phrase = "Sorry, there was a problem processing your desired BigTalker phrase token."
    	return phrase
	}
}

def addPersonalityToPhrase(phrase, evt){
	LOGDEBUG("addPersonalityToPhrase(${phrase},${evt})")
    def response = new String[20]
    response[0] = ""
    def options = 0
    def genericresponse = new String[20]
    genericresponse[0] = ""
    def genericoptions = 0
    def myRandom = 0
    //SWITCHES BEGIN
    if (evt.value == "on") {
    	if (phrase.contains("light")){
        	options = 12
  			response[1] = "{POST}please don't forget to turn the light off"
           	response[2] = "{POST}night vision goggles would do the same but I guess they are more expensive."
            response[3] = "{POST}Thanks Thomas Edison!"
            response[4] = "{POST}Wow, this is bright!"
            response[5] = "{POST}Where are my sunglasses."
            response[6] = "{POST}there goes the electricity bill!"
            response[7] = "{POST}the same old thing everyday."
            response[8] = "{POST}It is about time it was awfully dark!"
            response[9] = "{POST}Glad you are here, I was lonely"
            response[10] = "{POST}Is it time for us to play?"
            response[11] = "{PRE}Oh, Hi"
            response[12] = "{PRE}Oh, Hi there"
        } else {
        	//Something turned on, but it wasn't a light
        	options = 4
            response[1] = "{POST}there goes the electricity bill!"
            response[2] = "{POST}the same old thing everyday."
            response[3] = "{PRE}Oh, Hi"
            response[4] = "{PRE}Oh, Hi there"
        }
    }
    if (evt.value == "off") {
    	if (phrase.contains("light")){
        	options = 12
           	response[1] = "{POST}It's about time!"
            response[2] = "{POST}time to save some money!"
            response[3] = "{POST}wow, it's dark"
            response[4] = "{POST}going green are we?"
            response[5] = "{POST}I'll still be here, in the dark."
            response[6] = "{POST}Hey! You know I am afraid of the dark."
            response[7] = "{POST}Please don't leave me alone in the dark."
            response[8] = "{POST}Good thing you turned that off it was hurting my eyes!"
            response[8] = "{POST}You really like saving money!"
            response[10] = "{POST}Is it time to go to sleep?"
            response[11] = "{PRE}Oh, Hi"
            response[12] = "{PRE}Oh, Hi there"
        } else {
        	//Something turned off, but it wasn't a light
        	options = 5
        	response[1] = "{POST}It's about time!"
            response[2] = "{POST}time to save some money!"
            response[3] = "{POST}going green are we?"
            response[4] = "{PRE}Oh, Hi"
            response[5] = "{PRE}Oh, Hi there"
        }
    }
    //SWITCHES END
    def UseGenericRandom = 0
    myRandom = (new Random().nextInt(10))
    if (myRandom == 1 || myRandom == 4 || myRandom == 7) {
    	//GENERIC RESPONSES BEGIN
    	genericoptions = 4
    	genericresponse[1] = "{PRE}Hey there"
    	genericresponse[2] = "{PRE}Don't mean to bother but"
        genericresponse[3] = "{PRE}All I know is"
        genericresponse[4] = "{POST}that is all I know."
    	//GENERIC RESPONSES END
    	myRandom = (new Random().nextInt(genericoptions))
        LOGDEBUG("genericoptions=${genericoptions};myRandom=${myRandom};phrase=${genericresponse[myRandom]}")
    	if (genericresponse[myRandom].contains("{PRE}")) {
    		genericresponse[myRandom] = genericresponse[myRandom].replace("{PRE}", "")
        	phrase = genericresponse[myRandom] + ", " + phrase
    	}
    	if (genericresponse[myRandom].contains("{POST}")) {
    		genericresponse[myRandom] = genericresponse[myRandom].replace("{POST}", "")
        	phrase = phrase + ", " + genericresponse[myRandom]
    	}
        return phrase
    }
    if (options == 0) { return phrase }
    myRandom = (new Random().nextInt(options))
    LOGDEBUG("options=${options};myRandom=${myRandom};phrase=${response[myRandom]}")
    if (response[myRandom].contains("{PRE}")) {
    	response[myRandom] = response[myRandom].replace("{PRE}", "")
        phrase = response[myRandom] + ", " + phrase
    }
    if (response[myRandom].contains("{POST}")) {
    	response[myRandom] = response[myRandom].replace("{POST}", "")
        phrase = phrase + ", " + response[myRandom]
    }
    return phrase
}

def adjustWeatherPhrase(phraseIn){
    def phraseOut = ""
    phraseOut = phraseIn.toUpperCase()
    phraseOut = phraseOut.replace(" N ", " North ")
    phraseOut = phraseOut.replace(" S ", " South ")
    phraseOut = phraseOut.replace(" E ", " East ")
    phraseOut = phraseOut.replace(" W ", " West ")
    phraseOut = phraseOut.replace(" NNE ", " North Northeast ")
    phraseOut = phraseOut.replace(" NNW ", " North Northwest ")
    phraseOut = phraseOut.replace(" SSE ", " South Southeast ")
    phraseOut = phraseOut.replace(" SSW ", " South Southwest ")
    phraseOut = phraseOut.replace(" ENE ", " East Northeast ")
    phraseOut = phraseOut.replace(" ESE ", " East Southeast ")
    phraseOut = phraseOut.replace(" WNW ", " West Northeast ")
    phraseOut = phraseOut.replace(" WSW ", " West Southwest ")
    phraseOut = phraseOut.replace(" MPH", " Miles Per Hour")
    phraseOut = phraseOut.replace(" MM)", " Milimeters ")
    LOGDEBUG ("Adjust Weather: In=${phraseIn} Out=${phraseOut}")
    return phraseOut
}

def Talk(appname, phrase, customSpeechDevice, volume, resume, personality, voice, evt){
	def myDelay = 100
    def myVoice = settings?.speechVoice
    if (myVoice == "" || myVoice == null) { myVoice = "Salli(en-us)" } 
    if (!(voice == "" || voice == null)) { 
        myVoice = voice
    }
   	myVoice = myVoice.replace("(en-us)","")
   	myVoice = myVoice.replace("(en-gb)","")
   	myVoice = myVoice.replace("(es-us)","")
    if (state.speechDeviceType == "capability.musicPlayer") { 
    	myDelay = TalkQueue(appname, phrase, customSpeechDevice, volume, resume, personality, voice, evt) 
        state.lastTalkTime = now()
    }
	def currentSpeechDevices = []
   	def smartAppSpeechDevice = false
    def playAudioFile = false
   	def spoke = false
    LOGDEBUG ("TALK(app=${appname},customdevice=${customSpeechDevice},volume=${volume},resume=${resume},personality=${personality},myDelay=${myDelay},voice=${myVoice},evt=${evt},phrase=${phrase})")
   	if ((phrase?.toLowerCase())?.contains("%askalexa%")) {smartAppSpeechDevice = true}
   	if (!(phrase == null) && !(phrase == "")) {
		phrase = processPhraseVariables(appname, phrase, evt)
	    if (personality && !(phrase.toLowerCase().contains(".mp3"))) { phrase = addPersonalityToPhrase(phrase, evt) }
	}
	if (phrase == null || phrase == "") {
   		LOGERROR(processPhraseVariables(appname, "BigTalker - Check configuration. Phrase is empty for %devicename%", evt))
    	if (state.hubType == "SmartThings") {sendNotification(processPhraseVariables(appname, "BigTalker - Check configuration. Phrase is empty for %devicename%", evt))}
	}
	if (resume == null) { resume = true }
	if ((state.speechDeviceType == "capability.musicPlayer") && (!( phrase==null ) && !(phrase==""))){
		state.sound = ""
		state.ableToTalk = false
		if (!(settings.speechDeviceDefault == null) || !(customSpeechDevice == null)) {
			LOGTRACE("TALK(${appname}.${evt.name})|mP@|${volume} >> ${phrase}")
            if (resume) { LOGTRACE("TALK(${appname}.${evt.name})|mP| Resume is desired") } else { LOGTRACE("TALK(${appname}.${evt.name})|mP| Resume is not desired") }
			if (!(phrase.toLowerCase().contains(".mp3"))){
            	try {
					state.sound = textToSpeech(phrase instanceof List ? phrase[0] : phrase, myVoice) 
					state.ableToTalk = true
				} catch(e) {
					LOGERROR("TALK(${appname}.${evt.name})|mP| ST Platform issue (textToSpeech)? ${e}")
					//Try Again
					try {
						LOGTRACE("TALK(${appname}.${evt.name})|mP| Trying textToSpeech function again...")
					state.sound = textToSpeech(phrase instanceof List ? phrase[0] : phrase, myVoice)
					state.ableToTalk = true
					} catch(ex) {
						LOGERROR("TALK(${appname}.${evt.name})|mP| ST Platform issue (textToSpeech)? I tried textToSpeech() twice, ${state.hubType} wouldn't convert/process.  I give up, Sorry..")
						if (state.hubType == "SmartThings") {sendNotificationEvent("ST Platform issue? textToSpeech() failed.")}
						if (state.hubType == "SmartThings") {sendNotification("BigTalker couldn't announce: ${phrase}")}
					} //try again before final error(ableToTalk)
				} //try (ableToTalk)
            } else {
            	LOGTRACE("TALK(${appname}.${evt.name})|mP| MP3=${phrase}")
            	def sound = [uri:phrase, duration:10]
                state.sound = sound
                playAudioFile = true
                state.ableToTalk = true
                LOGTRACE("Sound=${state.sound}")
            }
   	        if ((state?.allowScheduledPoll == true || state?.allowScheduledPoll == null) && (resume)) {
				unschedule("poll")
				LOGDEBUG("TALK(${appname}.${evt.name})|mP| Delaying polling for 120 seconds")
				myRunIn(120, poll)
           	}
			if (state.ableToTalk){
				state.sound.duration = (state.sound.duration.toInteger() + 5).toString()  //Try to prevent cutting out, add seconds to the duration
				if (!(customSpeechDevice == null)) {
					currentSpeechDevices = customSpeechDevice
				} else {
					//Use Default Speech Device
					currentSpeechDevices = settings.speechDeviceDefault
				} //if (!(customSpeechDevice == null))
				LOGTRACE("TALK(${appname}.${evt.name})|mP| Last poll: ${state.lastPoll}")
				//Iterate Speech Devices and talk
				def attrs = currentSpeechDevices.supportedAttributes
				currentSpeechDevices.each(){
					LOGDEBUG("TALK(${appname}.${evt.name})|mP| attrs=${attrs}")
					def currentStatus = ""
                   	try {
                    	currentStatus = it?.latestValue("status")
   	                } catch (ex) { LOGDEBUG("ERROR getting device currentStatus") }
					def currentTrack = ""
           	        try {
              	    	currentTrack = it?.latestState("trackData")?.jsonValue
                   	} catch (ex) { LOGDEBUG("ERROR getting device currentTrack") }
					def currentVolume = 0
					if (it.hasAttribute("level")) { currentVolume = it.latestValue("level") }
					if (it.hasAttribute("volume")) { currentVolume = it.latestValue("volume") }
					if (currentVolume == 0) { LOGDEBUG("ERROR getting device currentVolume") }
                   	def minimumVolume = 50
                   	if (settings?.speechMinimumVolume >= 0) {minimumVolume = settings.speechMinimumVolume}
                   	if (minimumVolume > 100) {minimumVolume = 100}
                   	def desiredVolume = volume
                   	//try {
                   	//	desiredVolume = settings?.speechVolume
                   	//} catch (ex) { LOGDEBUG("ERROR getting desired default volume"); desiredVolume = -1 }
                   	if (desiredVolume > 100) {desiredVolume = 100}
                   	LOGDEBUG("TALK(${appname}.${evt.name})|mP| currentStatus:${currentStatus}")
					LOGDEBUG("TALK(${appname}.${evt.name})|mP| currentTrack:${currentTrack}")
					LOGDEBUG("TALK(${appname}.${evt.name})|mP| currentVolume:${currentVolume}")
					LOGDEBUG("TALK(${appname}.${evt.name})|mP| Sound: ${state.sound.uri} , ${state.sound.duration}")
					if (desiredVolume > -1){ 
                   		LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it.displayName} | Volume: ${currentVolume}, Desired Volume: ${desiredVolume}")
                   	} else {
	                    if (!(currentVolume >= minimumVolume)) {
   		                	LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it.displayName} | Volume: ${currentVolume}, Minimum Volume: ${minimumVolume}; adjusting.")
       		            } else {
           		        	LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it.displayName} | Volume: ${currentVolume}, Minimum Volume: ${minimumVolume}; acceptable.")
               		    }
                   	}
					if (!(currentTrack == null)){
						//currentTrack has data
						if (!(currentTrack?.status == null)) { LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it.displayName} | Current Status: ${currentStatus}, CurrentTrack: ${currentTrack}, CurrentTrack.Status: ${currentTrack.status}.") }
						if (currentTrack?.status == null) { LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it.displayName} | Current Status: ${currentStatus}, CurrentTrack: ${currentTrack}.") }
						if ((currentStatus == 'playing' || currentTrack?.status == 'playing') && (!((currentTrack?.status == 'stopped') || (currentTrack?.status == 'paused')))) {  //Give currentTrack.status presidence if it exists, it seems more accurate
							if (resume) {
                            	LOGTRACE ("Sending playTrackandResume() 1")
								LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it?.displayName} | cT<>null | cS/cT=playing | Sending playTrackAndResume() | CVol=${currentVolume} | SVol=${desiredVolume}")
								if (desiredVolume > -1) { 
									//if (desiredVolume == currentVolume){playTrackAndResume(it, state.sound.uri, state.sound.duration, myDelay)}
									//if (!(desiredVolume == currentVolume)){playTrackAndResume(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)}
									playTrackAndResume(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)
									spoke = true
								} else { 
									//if (currentVolume >= minimumVolume) { playTrackAndResume(it, state.sound.uri, state.sound.duration, myDelay) }
									if (currentVolume >= minimumVolume) { playTrackAndResume(it, state.sound.uri, state.sound.duration, currentVolume, myDelay, phrase) }
									if (currentVolume < minimumVolume) { playTrackAndResume(it, state.sound.uri, state.sound.duration, minimumVolume, myDelay, phrase) }
									spoke = true
								} //if (desiredVolume)
							} else {
								//resume is not desired
								LOGTRACE ("Sending playTrackandRestore() 2 - ${it?.displayName} - cVol = ${currentVolume}")
                               	LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it?.displayName} | cT<>null | cS/cT=playing | NoResume! | Sending playTrackAndRestore() | CVol=${currentVolume} | SVol=${desiredVolume}")
								if (desiredVolume > -1) { 
									//if (desiredVolume == currentVolume){playTrackAndRestore(it, state.sound.uri, state.sound.duration, myDelay)}
									//if (!(desiredVolume == currentVolume)){playTrackAndRestore(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)}
									playTrackAndRestore(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)
									spoke = true
								} else { 
									//if (currentVolume >= minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, myDelay) }
									if (currentVolume >= minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, currentVolume, myDelay, phrase) }
									if (currentVolume < minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, minimumVolume, myDelay, phrase) }
									spoke = true
								} // if (desiredVolume)
							} // if (resume)	
						} else {
							if ((!currentTrack?.status == 'playing') && (currentStatus == 'playing')) {
								LOGDEBUG "TALK(${appname}.${evt.name})|mP| ${it?.displayName} | Discrepency in CS/CT, going with CT! | CS= ${currentStatus} CT=${currentTrack.status}"
							}
							LOGTRACE ("Sending playTrackandRestore() 3 - to ${it?.displayName} - cVol = ${currentVolume}")
                           	LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it?.displayName} | cT<>null | cS/cT<>playing | Sending playTrackAndRestore() | CVol=${currentVolume} | SVol=${desiredVolume}")
							if (desiredVolume > -1) { 
								//if (desiredVolume == currentVolume){playTrackAndRestore(it, state.sound.uri, state.sound.duration, myDelay)}
								//if (!(desiredVolume == currentVolume)){playTrackAndRestore(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)}
								playTrackAndRestore(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)
								spoke = true
							} else { 
								//if (currentVolume >= minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, myDelay) }
								if (currentVolume >= minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, currentVolume, myDelay, phrase) }
								if (currentVolume < minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, minimumVolume, myDelay, phrase) }
								spoke = true
							}// if (desiredVolume)
						}// if ((currentStatus == 'playing' || currentTrack?.status == 'playing') && (!((currentTrack?.status == 'stopped') || (currentTrack?.status == 'paused'))))
					} else {
						//currentTrack==null. currentTrack doesn't have data or is not supported on this device
						if (!(currentStatus == null)) {
							LOGTRACE("TALK(${appname}.${evt.name})|mP|  ${it?.displayName} | (2) Current Status: ${currentStatus}.")
							if (currentStatus == "disconnected") {
								//VLCThing?
								if (resume) {
									LOGTRACE ("Sending playTrackandResume() 4")
                   	                LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it?.displayName} | cT=null | cS=disconnected | Sending playTrackAndResume() | CVol=${currentVolume} | SVol=${desiredVolume}")
									if (desiredVolume > -1) { 
										//if (desiredVolume == currentVolume){playTrackAndResume(it, state.sound.uri, state.sound.duration, myDelay)}
										//if (!(desiredVolume == currentVolume)){playTrackAndResume(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)}
										playTrackAndResume(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)
										spoke = true
									} else { 
										//if (currentVolume >= minimumVolume) { playTrackAndResume(it, state.sound.uri, state.sound.duration, myDelay) }
										if (currentVolume >= minimumVolume) { playTrackAndResume(it, state.sound.uri, state.sound.duration, currentVolume, myDelay, phrase) }
										if (currentVolume < minimumVolume) { playTrackAndResume(it, state.sound.uri, state.sound.duration, minimumVolume, myDelay, phrase) }
										spoke = true
									}
								} else {
									//resume is not desired
                       	            LOGTRACE ("Sending playTrackandRestore() 5")
									LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it?.displayName} | cT=null | cS=disconnected | No Resume! | Sending playTrackAndRestore() | CVol=${currentVolume} | SVol=${desiredVolume}")
									if (desiredVolume > -1) { 
										//if (desiredVolume == currentVolume){playTrackAndRestore(it, state.sound.uri, state.sound.duration, myDelay)}
										//if (!(desiredVolume == currentVolume)){playTrackAndRestore(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)}
										playTrackAndRestore(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)
										spoke = true
									} else { 
										//if (currentVolume >= minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, myDelay) }
										if (currentVolume >= minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, currentVolume, myDelay, phrase) }
										if (currentVolume < minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, minimumVolume, myDelay, phrase) }
										spoke = true
									}// if (desiredVolume)
								}// if (resume)
							} else {
								if (currentStatus == "playing") {
									if (resume) {
                                    	LOGTRACE ("Sending playTrackandResume() 6")
										LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it?.displayName} | cT=null | cS=playing | Sending playTrackAndResume() | CVol=${currentVolume} | SVol=${desiredVolume}")
										if (desiredVolume > -1) { 
											//if (desiredVolume == currentVolume){playTrackAndResume(it, state.sound.uri, state.sound.duration, myDelay)}
											//if (!(desiredVolume == currentVolume)){playTrackAndResume(it,state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)}
											playTrackAndResume(it,state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)
											spoke = true
										} else { 
											//if (currentVolume >= minimumVolume) { playTrackAndResume(it, state.sound.uri, state.sound.duration, myDelay) }
											if (currentVolume >= minimumVolume) { playTrackAndResume(it, state.sound.uri, state.sound.duration, currentVolume, myDelay, phrase) }
											if (currentVolume < minimumVolume) { playTrackAndResume(it, state.sound.uri, state.sound.duration, minimumVolume, myDelay, phrase) }
											spoke = true
										}// if (desiredVolume)
									} else {
										//resume not desired
										LOGTRACE ("Sending playTrackandRestore() 7")
           	                            LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it?.displayName} | cT=null | cS=playing | No Resume! | Sending playTrackAndRestore() | CVol=${currentVolume} | SVol=${desiredVolume}")
										if (desiredVolume > -1) { 
											//if (desiredVolume == currentVolume){playTrackAndRestore(it, state.sound.uri, state.sound.duration, myDelay)}
											//if (!(desiredVolume == currentVolume)){playTrackAndRestore(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)}
											playTrackAndRestore(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)
											spoke = true
										} else { 
											//if (currentVolume >= minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, myDelay) }
											if (currentVolume >= minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, currentVolume, myDelay, phrase) }
											if (currentVolume < minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, minimumVolume, myDelay, phrase) }
											spoke = true
										}// if (desiredVolume)
									}// if (resume)
								} else {
									//currentStatus <> "playing"
                                    LOGTRACE ("Sending playTrackandRestore() 8")
									LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it?.displayName} | cT=null | cS<>playing | Sending playTrackAndRestore() | CVol=${currentVolume} | SVol=${desiredVolume}")
									if (desiredVolume > -1) { 
										//if (desiredVolume == currentVolume){playTrackAndRestore(it,state.sound.uri, state.sound.duration, myDelay)}
										//if (!(desiredVolume == currentVolume)){playTrackAndRestore(it,state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)}
										playTrackAndRestore(it,state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)
										spoke = true
									} else { 
										//if (currentVolume >= minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, myDelay) }
										if (currentVolume >= minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, currentVolume, myDelay, phrase) }
										if (currentVolume < minimumVolume) { playTrackAndRestore(it, state.sound.uri, state.sound.duration, minimumVolume, myDelay, phrase) }
										spoke = true
									}// if (desiredVolume)
								}// if (currentStatus == "playing")
							}// if (currentStatus == "disconnected"))
						} else {
							//currentTrack and currentStatus are both null
							LOGTRACE ("Sending playTrackandRestore() 9")
       	                    LOGTRACE("TALK(${appname}.${evt.name})|mP| ${it.displayName} | (3) cT=null | cS=null | Sending playTrackAndRestore() | CVol=${currentVolume} | SVol=${desiredVolume}")
							if (desiredVolume > -1) { 
                                //if (desiredVolume == currentVolume){playTrackAndRestore(it, state.sound.uri, state.sound.duration, myDelay)}
								//if (!(desiredVolume == currentVolume)){playTrackAndRestore(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)}
								playTrackAndRestore(it, state.sound.uri, state.sound.duration, desiredVolume, myDelay, phrase)
								spoke = true
							} else { 
								//if (currentVolume >= minimumVolume) { it.playTrackAndRestore(state.sound.uri, state.sound.duration, myDelay) }
								if (currentVolume >= minimumVolume) { it.playTrackAndRestore(state.sound.uri, state.sound.duration, currentVolume, myDelay, phrase) }
								if (currentVolume < minimumVolume) { it.playTrackAndRestore(state.sound.uri, state.sound.duration, minimumVolume, myDelay, phrase) }
								spoke = true
							} //if (desiredVolume)
						} //currentStatus == null
					} //currentTrack == null
				} //currentSpeechDevices.each()
			} //state.ableToTalk
		} //if (!(settings.speechDeviceDefault == null) || !(customSpeechDevice == null))
	}// if (state.speechDeviceType=="capability.musicPlayer")
	if ((state.speechDeviceType == "capability.speechSynthesis") && (!( phrase==null ) && !(phrase==""))){
		//capability.speechSynthesis is in use
		if (!(settings?.speechDeviceDefault == null) || !(customSpeechDevice == null)) {
			LOGTRACE("TALK(${appname}.${evt.name}) |sS| >> ${phrase}")
			if (!(customSpeechDevice == null)) {
				currentSpeechDevices = customSpeechDevice
			} else {
				//Use Default Speech Device
				currentSpeechDevices = settings.speechDeviceDefault
			}// If (!(customSpeechDevice == null))
			//Iterate Speech Devices and talk
			def attrs = currentSpeechDevices.supportedAttributes
			currentSpeechDevices.each(){
				// Determine device name either by it.displayName or it.device.displayName (whichever works)
				LOGDEBUG("FINGERPRINT ${it.displayName} cap:${it.getSupportedCapabilities} comm:${it.getSupportedCommands()} att:${it.getSupportedAttributes()}")
				try {
					LOGTRACE("TALK(${appname}.${evt.name}) |sS| ${it.displayName} | Sending speak().")
				}
				catch (ex) {
					LOGDEBUG("TALK(${appname}.${evt.name}) |sS| it.displayName failed, trying it.device.displayName")
					try {
						LOGTRACE("TALK(${appname}.${evt.name}) |sS| ${it.device.displayName} | Sending speak().")
					}
					catch (ex2) {
						LOGDEBUG("TALK(${appname}.${evt.name}) |sS| it.device.displayName failed, trying it.device.name")
						LOGTRACE("TALK(${appname}.${evt.name}) |sS| ${it.device.name} | Sending speak().")
					}
				}
				spoke = true
				it.speak(phrase)
			}// currentSpeechDevices.each()
		} //if (!(settings.speechDeviceDefault == null) || !(customSpeechDevice == null))
	} //if (state.speechDeviceType == "capability.speechSynthesis")

	if ((!(smartAppSpeechDevice) && !(spoke)) && (!(phrase == null) && !(phrase == "")) && !(playAudioFile)) {
		//No musicPlayer, speechSynthesis, or smartAppSpeechDevices selected. No route to export speech!
		LOGTRACE("TALK(${appname}.${evt.name}) |ERROR| No selected speech device or smartAppSpeechDevice token in phrase. ${phrase}")
	} else {
    	if ((smartAppSpeechDevice && !spoke) && (!(phrase == null) && !(phrase == ""))){
			LOGTRACE("TALK(${appname}.${evt.name}) |sA| Sent to another smartApp.")
       	}
   	}
    phrase = ""
}//Talk()

def timeAllowed(devicetype,index){
    def now = new Date()
    //Check Default Setting
    //devicetype = mode, motion, switch, presence, lock, contact, thermostat, acceleration, water, smoke, button
    switch (devicetype) {
        case "mode":
            if (index == 1 && (!(settings.modeStartTime1 == null))) {
                if (timeOfDayIsBetween(settings.modeStartTime1, settings.modeEndTime1, now, location.timeZone)) { return true } else { return false }
            }
        case "motion":
            if (index == 1 && (!(settings.motionStartTime1 == null))) {
                if (timeOfDayIsBetween(settings.motionStartTime1, settings.motionEndTime1, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 2 && (!(settings.motionStartTime2 == null))) {
                if (timeOfDayIsBetween(settings.motionStartTime2, settings.motionEndTime2, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 3 && (!(settings.motionStartTime3 == null))) {
                if (timeOfDayIsBetween(settings.motionStartTime3, settings.motionEndTime3, now, location.timeZone)) { return true } else { return false }
            }
        case "switch":
            if (index == 1 && (!(settings.switchStartTime1 == null))) {
                    if (timeOfDayIsBetween(settings.switchStartTime1, settings.switchEndTime1, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 2 && (!(settings.switchStartTime2 == null))) {
                if (timeOfDayIsBetween(settings.switchStartTime2, settings.switchEndTime2, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 3 && (!(settings.switchStartTime3 == null))) {
                if (timeOfDayIsBetween(settings.switchStartTime3, settings.switchEndTime3, now, location.timeZone)) { return true } else { return false }
            }
        case "presence":
            if (index == 1 && (!(settings.presenceStartTime1 == null))) {
                if (timeOfDayIsBetween(settings.presenceStartTime1, settings.presenceEndTime1, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 2 && (!(settings.presenceStartTime2 == null))) {
                if (timeOfDayIsBetween(settings.presenceStartTime2, settings.presenceEndTime2, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 3 && (!(settings.presenceStartTime3 == null))) {
                if (timeOfDayIsBetween(settings.presenceStartTime3, settings.presenceEndTime3, now, location.timeZone)) { return true } else { return false }
            }
        case "lock":
            if (index == 1 && (!(settings.lockStartTime1 == null))) {
                if (timeOfDayIsBetween(settings.lockStartTime1, settings.lockEndTime1, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 2 && (!(settings.lockStartTime2 == null))) {
                if (timeOfDayIsBetween(settings.lockStartTime2, settings.lockEndTime2, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 3 && (!(settings.lockStartTime3 == null))) {
                if (timeOfDayIsBetween(settings.lockStartTime3, settings.lockEndTime3, now, location.timeZone)) { return true } else { return false }
            }
        case "contact":
            if (index == 1 && (!(settings.contactStartTime1 == null))) {
                if (timeOfDayIsBetween(settings.contactStartTime1, settings.contactEndTime1, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 2 && (!(settings.contactStartTime2 == null))) {
                if (timeOfDayIsBetween(settings.contactStartTime2, settings.contactEndTime2, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 3 && (!(settings.contactStartTime3 == null))) {
                if (timeOfDayIsBetween(settings.contactStartTime3, settings.contactEndTime3, now, location.timeZone)) { return true } else { return false }
            }
        case "thermostat":
            if (index == 1 && (!(settings.thermostatStartTime1 == null))) {
                if (timeOfDayIsBetween(settings.thermostatStartTime1, settings.thermostatEndTime1, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 2 && (!(settings.thermostatStartTime2 == null))) {
                if (timeOfDayIsBetween(settings.thermostatStartTime2, settings.thermostatEndTime2, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 3 && (!(settings.thermostatStartTime3 == null))) {
                if (timeOfDayIsBetween(settings.thermostatStartTime3, settings.thermostatEndTime3, now, location.timeZone)) { return true } else { return false }
            }
        case "acceleration":
            if (index == 1 && (!(settings.accelerationStartTime1 == null))) {
                if (timeOfDayIsBetween(settings.accelerationStartTime1, settings.accelerationEndTime1, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 2 && (!(settings.accelerationStartTime2 == null))) {
                if (timeOfDayIsBetween(settings.accelerationStartTime2, settings.accelerationEndTime2, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 3 && (!(settings.accelerationStartTime3 == null))) {
                if (timeOfDayIsBetween(settings.accelerationStartTime3, settings.accelerationEndTime3, now, location.timeZone)) { return true } else { return false }
            }
        case "water":
            if (index == 1 && (!(settings.waterStartTime1 == null))) {
                if (timeOfDayIsBetween(settings.waterStartTime1, settings.waterEndTime1, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 2 && (!(settings.waterStartTime2 == null))) {
                    if (timeOfDayIsBetween(settings.waterStartTime2, settings.waterEndTime2, now, location.timeZone)) { return true } else { return false }
                }
            if (index == 3 && (!(settings.waterStartTime3 == null))) {
                if (timeOfDayIsBetween(settings.waterStartTime3, settings.waterEndTime3, now, location.timeZone)) { return true } else { return false }
            }
        case "smoke":
            if (index == 1 && (!(settings.smokeStartTime1 == null))) {
                if (timeOfDayIsBetween(settings.smokeStartTime1, settings.smokeEndTime1, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 2 && (!(settings.smokeStartTime2 == null))) {
                if (timeOfDayIsBetween(settings.smokeStartTime2, settings.smokeEndTime2, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 3 && (!(settings.smokeStartTime3 == null))) {
                if (timeOfDayIsBetween(settings.smokeStartTime3, settings.smokeEndTime3, now, location.timeZone)) { return true } else { return false }
            }
        case "button":
            if (index == 1 && (!(settings.buttonStartTime1 == null))) {
                if (timeOfDayIsBetween(settings.buttonStartTime1, settings.buttonEndTime1, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 2 && (!(settings.buttonStartTime2 == null))) {
                if (timeOfDayIsBetween(settings.buttonStartTime2, settings.buttonEndTime2, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 3 && (!(settings.buttonStartTime3 == null))) {
                if (timeOfDayIsBetween(settings.buttonStartTime3, settings.buttonEndTime3, now, location.timeZone)) { return true } else { return false }
            }
        case "SHM":
            if (index == 1 && (!(settings.SHMStartTimeAway == null))) {
                if (timeOfDayIsBetween(settings.SHMStartTimeAway, settings.SHMEndTimeAway, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 2 && (!(settings.SHMStartTimeHome == null))) {
                if (timeOfDayIsBetween(settings.SHMStartTimeHome, settings.SHMEndTimeHome, now, location.timeZone)) { return true } else { return false }
            }
            if (index == 3 && (!(settings.SHMStartTimeDisarm == null))) {
                if (timeOfDayIsBetween(settings.SHMStartTimeDisarm, settings.SHMEndTimeDisarm, now, location.timeZone)) { return true } else { return false }
            }
    }
    
    //No overrides have returned True, process Default
    if (settings.defaultStartTime == null) { 
    	return true 
    } else {
        if (timeOfDayIsBetween(settings.defaultStartTime, settings.defaultEndTime, now, location.timeZone)) { return true } else { return false }
    }
}

def modeAllowed(devicetype,index) {
    //Determine if we are allowed to speak in our current mode based on the calling device or default setting
    //devicetype = motion, switch, presence, lock, contact, thermostat, acceleration, water, smoke, button
    switch (devicetype) {
        case "motion":
            if (index == 1) {
                //Motion Group 1
                if (settings.motionModes1) {
                    if (settings.motionModes1.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //Motion Group 2
                if (settings.motionModes2) {
                    if (settings.motionModes2.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //Motion Group 3
                if (settings.motionModes3) {
                    if (settings.motionModes3.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "motion"
        case "switch":
            if (index == 1) {
                //Switch Group 1
                if (settings.switchModes1) {
                    if (settings.switchModes1.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //Switch Group 2
                if (settings.switchModes2) {
                    if (settings.switchModes2.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //Switch Group 3
                if (settings.switchModes3) {
                    if (settings.switchModes3.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "switch"
        case "presence":
            if (index == 1) {
                //Presence Group 1
                if (settings.presenceModes1) {
                    if (settings.presenceModes1.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //Presence Group 2
                if (settings.presenceModes2) {
                    if (settings.presenceModes2.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //Presence Group 3
                if (settings.presenceModes3) {
                    if (settings.presenceModes3.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "presence"
        case "lock":
            if (index == 1) {
                //Lock Group 1
                if (settings.lockModes1) {
                    if (settings.lockModes1.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //Lock Group 2
                if (settings.lockModes2) {
                    if (settings.lockModes2.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //Lock Group 3
                if (settings.lockModes3) {
                    if (settings.lockModes3.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "lock"
        case "contact":
            if (index == 1) {
                //Contact Group 1
                if (settings.contactModes1) {
                    if (settings.contactModes1.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //Contact Group 2
                if (settings.contactModes2) {
                    if (settings.contactModes2.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //Contact Group 3
                if (settings.contactModes3) {
                    if (settings.contactModes3.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "contact"
        case "thermostat":
            if (index == 1) {
                //Thermostat Group 1
                if (settings.thermostatModes1) {
                    if (settings.thermostatModes1.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //Thermostat Group 2
                if (settings.thermostatModes2) {
                    if (settings.thermostatModes2.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //Thermostat Group 3
                if (settings.thermostatModes3) {
                    if (settings.thermostatModes3.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "thermostat"
        case "acceleration":
            if (index == 1) {
                //Acceleration Group 1
                if (settings.accelerationModes1) {
                    if (settings.accelerationModes1.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //Acceleration Group 2
                if (settings.accelerationModes2) {
                    if (settings.accelerationModes2.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //Acceleration Group 3
                if (settings.accelerationModes3) {
                    if (settings.accelerationModes3.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "acceleration"
        case "water":
            if (index == 1) {
                //Water Group 1
                if (settings.waterModes1) {
                    if (settings.waterModes1.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //Water Group 2
                if (settings.waterModes2) {
                    if (settings.waterModes2.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //Water Group 3
                if (settings.waterModes3) {
                    if (settings.waterModes3.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "water"
        case "smoke":
            if (index == 1) {
                //Smoke Group 1
                if (settings.smokeModes1) {
                    if (settings.smokeModes1.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //Smoke Group 2
                if (settings.smokeModes2) {
                    if (settings.smokeModes2.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //Smoke Group 3
                if (settings.smokeModes3) {
                    if (settings.smokeModes3.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "smoke"
        case "button":
            if (index == 1) {
                //Button Group 1
                if (settings.buttonModes1) {
                    if (settings.buttonModes1.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //Button Group 2
                if (settings.buttonModes2) {
                    if (settings.buttonModes2.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //Button Group 3
                if (settings.buttonModes3) {
                    if (settings.buttonModes3.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "button"
        case "SHM":
            if (index == 1) {
                //SHM Armed Away
                if (settings.SHMModesAway) {
                    if (settings.SHMModesAway.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //SHM Armed Home
                if (settings.SHMModesHome) {
                    if (settings.SHMModesHome.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //SHM Disarmed
                if (settings.SHMModesDisarm) {
                    if (settings.SHMModesDisarm.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "SHM"
        case "timeSlot":
            if (index == 1) {
                //TimeSlot Group 1
                if (settings.timeSlotModes1) {
                    if (settings.timeSlotModes1.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 2) {
                //TimeSlot Group 2
                if (settings.timeSlotModes2) {
                    if (settings.timeSlotModes2.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
            if (index == 3) {
                //TimeSlot Group 3
                if (settings.timeSlotModes3) {
                    if (settings.timeSlotModes3.contains(location.mode)) {
                        //Custom mode for this event is in use and we are in one of those modes
                        return true
                    } else {
                        //Custom mode for this event is in use and we are not in one of those modes
                        return false
                    }
                } else {
                    return (settings.speechModesDefault.contains(location.mode)) //True if we are in an allowed Default mode, False if not
                }
            }
        //End: case "timeSlot"
    } //End: switch (devicetype)
}

def getTimeFromDateString(inputtime, includeAmPm){
    //I couldn't find the way to do this in ST / Groovy, so I made my own function
    //Obtains the time from a supplied specifically formatted date string (ie: from a preference of type "time")
    //LOGDEBUG "InputTime: ${inputtime}"
    def outputtime = inputtime
    def am_pm = "??"
    outputtime = inputtime.substring(11,16)
    if (includeAmPm) {
        if ((outputtime.substring(0,2)).toInteger() < 12) { 
            am_pm = "am" 
        } else { 
            am_pm = "pm"
            def newHH = ((outputtime.substring(0,2)).toInteger() - 12)
            outputtime = newHH + outputtime.substring(2,5)
        }
        outputtime += am_pm
    }
    //LOGDEBUG "OutputTime: ${outputtime}"
    return outputtime
}

def getTimeFromCalendar(includeSeconds, includeAmPm){
    //Obtains the current time:  HH:mm:ss am/pm
    def calendar = Calendar.getInstance()
	calendar.setTimeZone(location.timeZone)
	def timeHH = calendar.get(Calendar.HOUR)
    def timemm = calendar.get(Calendar.MINUTE)
    def timess = calendar.get(Calendar.SECOND)
    def timeampm = calendar.get(Calendar.AM_PM) ? "pm" : "am"
    def timestring = "${timeHH}:${timemm}"
    if (includeSeconds) { timestring += ":${timess}" }
    if (includeAmPm) { timestring += " ${timeampm}" }
    return timestring
}

//myRunIn from ST:Geko / Statusbits SmartAlarm app http://statusbits.github.io/smartalarm/
private def myRunIn(delay_s, func) {
    //LOGDEBUG("myRunIn(${delay_s},${func})")

    if (delay_s > 0) {
        def tms = now() + (delay_s * 1000)
        def date = new Date(tms)
        runOnce(date, func)
        //LOGDEBUG("'${func}' scheduled to run at ${date}")
    }
}

def TalkQueue(appname, phrase, customSpeechDevice, volume, resume, personality, voice, evt){
    //IN DEVELOPMENT
    // Already talking or just recently (within x seconds) started talking
    // Queue up current request(s), give time for current action to complete, then speak and flush queue
    def threshold = 0
    def minDelay = 6 //Minimum seconds between talking
    try {
    	if (!(state?.sound?.duration == null)) { 
    		threshold = state.sound.duration.toInteger() //Use the last musicPlayer sound duration from the last Talk call as the minimum delay
    	}
    } catch (exception) {
    	threshold = 10
    }
    def durationFromLastTalkReq = 9999
    //if (!(state.lastTalkTime == null)) { durationFromLastTalk = ((now() - state?.lastTalkTime)/1000).intValue() }
    if (!(state.lastTalkRequest == null)) { durationFromLastTalkReq = ((now() - state?.lastTalkRequest)/1000).intValue() }
    state.lastTalkRequest = now()
    def tooSoon = (durationFromLastTalkReq < threshold)
    def neededDelay = (((threshold - durationFromLastTalkReq) * 1000) + 1000)
    LOGDEBUG ("TALKQUEUE(Threshold=${threshold},DurationFromLastTalkReq=${durationFromLastTalkReq},lastTalkReq=${state.lastTalkRequest},lastTalkTime=${state.lastTalkTime}, TooSoon=${tooSoon}, Calc=${neededDelay}")
    if (tooSoon) {
    	if (neededDelay < 0) { 
        	neededDelay = 0 
        } else {
    		if (neededDelay < (minDelay * 1000)) { neededDelay = (minDelay * 1000) }
        }
    	LOGDEBUG("TALKQUEUE()-Spoke too recently; delaying ${(neededDelay / 1000)} seconds.")
        return neededDelay
    } else {
    	LOGDEBUG("TALKQUEUE()-OK to speak; (${(durationFromLastTalkReq)})")
    	return 0
    }
}

def getWeather(mode, zipCode) {
	// Uses Weather.gov for data retrieval
	def msg = ""
	//zipCode is not used.  Data only works with US GPS coordinates due to data source (weather.gov)
	if ((state?.latitude == null || state?.latitude == "") && settings?.latitude == null) { state.latitude = "${location.latitude}" }
	if ((state?.longitude == null || state?.longitude == "") && settings?.latitude == null) { state.longitude = "${location.longitude}" }
	//Get weather info by hub lat/long GPS coordinates.
	wxURI1 = "https://api.weather.gov/points/${state.latitude}%2C${state.longitude}"
	LOGTRACE("DEBUG wxURI1: ${wxURI1}")
	def requestParams1 =
		[
			uri:  wxURI1,
			requestContentType: "application/json",
			contentType: "application/json"
		]
	httpGet(requestParams1)	{	  response1 ->
		LOGTRACE("DEBUG response1.status: ${response1?.status}")
		if (response1?.status == 200){
			LOGTRACE ("response1=${response1.data}")
			if(response1.data.properties){
				def wxURI2 = response1.data.properties.forecast
				def requestParams2 =
					[
						uri:  wxURI2,
						requestContentType: "application/json",
						contentType: "application/json"
					]
				LOGTRACE("DEBUG wxURI2: ${wxURI2}")
				httpGet(requestParams2)	{	  response2 ->
					LOGTRACE("DEBUG response2.status: ${response1?.status}")
					if (response2?.status == 200){
						if(response2.data.properties.periods){
							period0Name = response2.data.properties.periods[0].name
							period0DetailedForecast = response2.data.properties.periods[0].detailedForecast
							period1Name = response2.data.properties.periods[1].name
							period1DetailedForecast = response2.data.properties.periods[1].detailedForecast
							period2Name = response2.data.properties.periods[2].name
							period2DetailedForecast = response2.data.properties.periods[2].detailedForecast
							LOGDEBUG("Weather periodNames: [0:${period0Name},1:${period1Name},2:${period2Name}]; mode=${mode}")
							if (mode == "current" || mode == "today") {
								msg = "The forecast for ${period0Name} is ${period0DetailedForecast}"
							}
							if (mode == "tonight") {
								if (period0Name == "Tonight") {msg = "The forecast for ${period0Name} is ${period0DetailedForecast}"}
								if (period1Name == "Tonight") {msg = "The forecast for ${period1Name} is ${period1DetailedForecast}"}
							}
							if (mode == "tomorrow") {
								if (period0Name == "Tonight") {msg = "The forecast for ${period1Name} is ${period1DetailedForecast}"}
								if (period1Name == "Tonight") {msg = "The forecast for ${period2Name} is ${period2DetailedForecast}"}
							}
							msg = msg.replaceAll(/([0-9]+)C/,'$1 degrees celsius')
    						msg = msg.replaceAll(/([0-9]+)F/,'$1 degrees fahrenheit')
							LOGTRACE("returning msg=${msg}")
							LOGDEBUG("msg = ${msg}")
							return(msg)
						}
					}
				}
			}
		}
	}
}

/*
OLD SmartThings - WeatherUnderground backed code
def getWeather(mode, zipCode) {
    //Function derived from "Sonos Weather Forecast" SmartApp by Smartthings (modified)
    LOGDEBUG("Processing: getWeather(${mode},${zipCode})")
	def weather = getWeatherFeature("forecast", zipCode)
	def current = getWeatherFeature("conditions", zipCode)
	def isMetric = location.temperatureScale == "C"
	def delim = ""
	def sb = new StringBuilder()
	if (mode == "current") {
			if (isMetric) {
               	sb << "The current temperature is ${Math.round(current.current_observation.temp_c)} degrees."
            }
            else {
               	sb << "The current temperature is ${Math.round(current.current_observation.temp_f)} degrees."
            }
			delim = " "
	} //mode == current
    else if (mode == "today") {
		sb << delim
		sb << "Today's forecast is "
		if (isMetric) {
           	sb << weather.forecast.txt_forecast.forecastday[0].fcttext_metric 
        }
        else {
           	sb << weather.forecast.txt_forecast.forecastday[0].fcttext
        }
	} //mode == today
	else if (mode == "tonight") {
        sb << delim
		sb << "Tonight will be "
		if (isMetric) {
          	sb << weather.forecast.txt_forecast.forecastday[1].fcttext_metric 
        }
        else {
        	sb << weather.forecast.txt_forecast.forecastday[1].fcttext
        }
	} //mode == tonight
	else if (mode == "tomorrow") {
		sb << delim
		sb << "Tomorrow will be "
		if (isMetric) {
           	sb << weather.forecast.txt_forecast.forecastday[2].fcttext_metric 
        }
        else {
          	sb << weather.forecast.txt_forecast.forecastday[2].fcttext
        }
	} //mode == tomorrow
    else {
        sb < "ERROR: Requested weather mode was not recognized."
    }//mode = unknown
	def msg = sb.toString()
    msg = msg.replaceAll(/([0-9]+)C/,'$1 degrees celsius')
    msg = msg.replaceAll(/([0-9]+)F/,'$1 degrees fahrenheit')
    LOGDEBUG("msg = ${msg}")
	return(msg)
}
*/

def poll(){
    if (settings?.resumePlay == true || settings?.resumePlay == null) {
		unschedule("poll")
    	//LOGDEBUG("poll() settings=${settings?.allowScheduledPoll}")
    	//LOGDEBUG("poll() state=${state?.allowScheduledPoll}")
    	//LOGDEBUG("poll() resumePlay=${settings?.resumePlay}")
    	if (((settings?.allowScheduledPoll == true || state?.allowScheduledPoll == true)) || ((settings?.allowScheduledPoll == null) || (state?.allowScheduledPoll == null))) {
	    	state.allowScheduledPoll = true
    	} else {
    		state.allowScheduledPoll = false
        	LOGDEBUG("Polling is not desired, disabling after this poll.")
    	}
    	if (state.speechDeviceType == "capability.musicPlayer") {
        	LOGDEBUG("Polling speech device(s) for latest status")
        	state.polledDevices = ""
        	try {
            	if (!(settings?.speechDeviceDefault == null)) {dopoll(settings.speechDeviceDefault)}
            	if (!(settings?.motionSpeechDevice1 == null)) {dopoll(settings.motionSpeechDevice1)}
            	if (!(settings?.motionSpeechDevice2 == null)) {dopoll(settings.motionSpeechDevice2)}
            	if (!(settings?.motionSpeechDevice3 == null)) {dopoll(settings.motionSpeechDevice3)}
            	if (!(settings?.switchSpeechDevice1 == null)) {dopoll(settings.switchSpeechDevice1)}
            	if (!(settings?.switchSpeechDevice2 == null)) {dopoll(settings.switchSpeechDevice2)}
            	if (!(settings?.switchSpeechDevice3 == null)) {dopoll(settings.switchSpeechDevice3)}
            	if (!(settings?.presSpeechDevice1 == null)) {dopoll(settings.presSpeechDevice1)}
            	if (!(settings?.presSpeechDevice2 == null)) {dopoll(settings.presSpeechDevice2)}
            	if (!(settings?.presSpeechDevice3 == null)) {dopoll(settings.presSpeechDevice3)}
            	if (!(settings?.lockSpeechDevice1 == null)) {dopoll(settings.lockSpeechDevice1)}
            	if (!(settings?.lockSpeechDevice2 == null)) {dopoll(settings.lockSpeechDevice2)}
            	if (!(settings?.lockSpeechDevice3 == null)) {dopoll(settings.lockSpeechDevice3)}
            	if (!(settings?.contactSpeechDevice1 == null)) {dopoll(settings.contactSpeechDevice1)}
            	if (!(settings?.contactSpeechDevice2 == null)) {dopoll(settings.contactSpeechDevice2)}
            	if (!(settings?.contactSpeechDevice3 == null)) {dopoll(settings.contactSpeechDevice3)}
            	if (!(settings?.modePhraseSpeechDevice1 == null)) {dopoll(settings.modePhraseSpeechDevice1)}
            	if (!(settings?.thermostatSpeechDevice1 == null)) {dopoll(settings.thermostatSpeechDevice1)}
            	if (!(settings?.accelerationSpeechDevice1 == null)) {dopoll(settings.accelerationSpeechDevice1)}
            	if (!(settings?.accelerationSpeechDevice2 == null)) {dopoll(settings.accelerationSpeechDevice2)}
            	if (!(settings?.accelerationSpeechDevice3 == null)) {dopoll(settings.accelerationSpeechDevice3)}
            	if (!(settings?.waterSpeechDevice1 == null)) {dopoll(settings.waterSpeechDevice1)}
            	if (!(settings?.waterSpeechDevice2 == null)) {dopoll(settings.waterSpeechDevice2)}
            	if (!(settings?.waterSpeechDevice3 == null)) {dopoll(settings.waterSpeechDevice3)}
            	if (!(settings?.smokeSpeechDevice1 == null)) {dopoll(settings.smokeSpeechDevice1)}
            	if (!(settings?.smokeSpeechDevice2 == null)) {dopoll(settings.smokeSpeechDevice2)}
            	if (!(settings?.smokeSpeechDevice3 == null)) {dopoll(settings.smokeSpeechDevice3)}
            	if (!(settings?.buttonSpeechDevice1 == null)) {dopoll(settings.buttonSpeechDevice1)}
            	if (!(settings?.buttonSpeechDevice2 == null)) {dopoll(settings.buttonSpeechDevice2)}
            	if (!(settings?.buttonSpeechDevice3 == null)) {dopoll(settings.buttonSpeechDevice3)}
            	if (!(settings?.timeslotSpeechDevice1 == null)) {dopoll(settings.timeslotSpeechDevice1)}
            	if (!(settings?.timeslotSpeechDevice2 == null)) {dopoll(settings.timeslotSpeechDevice2)}
            	if (!(settings?.timeslotSpeechDevice3 == null)) {dopoll(settings.timeslotSpeechDevice3)}
        	} catch(e) {
	            LOGERROR("One of your speech devices is not responding.  Poll failed.")
                LOGDEBUG("BT_poll() Error: ${e}")
    	    }
        	state.lastPoll = getTimeFromCalendar(true,true)
        	//LOGDEBUG("poll: state.polledDevices == ${state?.polledDevices}")
        	if (!(state?.polledDevices == "")) {
	        	//Reschedule next poll
    	    	if (((settings?.allowScheduledPoll == true || state?.allowScheduledPoll == true)) || ((settings?.allowScheduledPoll == null) || (state?.allowScheduledPoll == null))) {
        	    	LOGDEBUG("Rescheduling Poll")
            	    myRunIn(60, poll) 
            	}
        	} else {
        		LOGDEBUG("No speech devices polled. Cancelling polling.")
        	}
    	}
	}
}
def dopoll(pollSpeechDevice){
    pollSpeechDevice.each(){
    	def devicename = ""
        try {
        	devicename = it.displayName
        } catch (ex) {}
        if (devicename == "") {
        	try {
            	devicename = it.device.displayName
            } catch (ex) {}
        }
        if (devicename == "") {
        	LOGERROR("dopoll(${pollSpeechDevice}) - Unable to get devicename")
        }
        if (!(state?.polledDevices?.find("|${devicename}|"))) {
            state.polledDevices = state?.polledDevices + "|${devicename}|"
            LOGDEBUG("dopoll(${devicename}) Polling ")
            state.refresh = false
            state.poll = false
            try {
                //LOGTRACE("refresh()")
                it.refresh()
                state.refresh = true
            }
            catch (ex) {
                LOGDEBUG("ERROR(informational): it.refresh: ${ex}")
                state.refresh = false
            }
            //LOGDEBUG("dopoll(${devicename}) after refresh() ")
            if (!(state.refresh)) {
                try {
                    //LOGTRACE("poll()")
                    it.poll()
                    state.poll = true
                    state.refresh = true
                }
                catch (ex) {
                    LOGDEBUG ("ERROR(informational): it.poll: ${ex}")
                    state.poll = false
                    state.refresh = false
                }
            }
            //LOGDEBUG("dopoll(${devicename}) after poll()")
            //LOGDEBUG("dopoll(${devicename}) refresh=${state.refresh} poll=${state.poll}")
    	    //LOGDEBUG("dopoll(${it.displayName})cS=${it?.latestValue('status')},cT=${it?.latestState("trackData")?.jsonValue?.status},cV=${it?.latestState("level")?.integerValue ? it?.latestState("level")?.integerValue : 0}")
            if (it?.latestValue('status') == "no_device_present") { LOGTRACE("During polling, the handler for ${devicename} indicated the device was not found.") } //VLCThing
        }
        LOGDEBUG("dopoll - polled devices: ${state?.polledDevices}")
    }
}

def getDesiredVolume(invol) {
	def globalVolume = settings?.speechVolume
    def globalMinimumVolume = settings?.speechMinimumVolume
    def myVolume = invol
    def finalVolume = -1
    if (myVolume > 0) { 
    	finalVolume = myVolume
	} else {
		if (globalVolume > 0) {
			finalVolume = globalVolume
		} else {
            if (globalMinimumVolume > 0) {
                finalVolume = globalMinimumVolume
            } else {
                finalVolume = 50 //Default if no volume parameters are set
            }
        }
	}
    if (state.speechDeviceType == "capability.musicPlayer") { 
    	LOGDEBUG("finalVolume: ${finalVolume}")
    }
    return finalVolume
}

def setMode(mode){
  // Remove this function
}

def onModeChangeEvent(evt){
	state.lastMode = state.mode
	state.mode = location.mode
	LOGDEBUG("LastMode=${state.lastMode} Mode=${location.mode}")
}

def disableDebug(){
	LOGTRACE("Debug timer has expired. Disabling debugging")
	state.debugMode = false
	unschedule("disableDebug")
	settings.debugmode = false
}

def LOGDEBUG(txt){
	if (state.debugMode) { 
		def msgfrom = "[PARENT] "
		def appLabel = (app?.label == null) ? state.InternalName : app.label //Some child calls to parent.LOGDEBUG result in app.label being null, correct
		appLabel = appLabel.replace(" ","")
		appLabel.toUpperCase()
		if (txt?.contains("[CHILD:")) { msgfrom = "" }
    	try {
    		log.debug("${appLabel}(${state.version}) || ${msgfrom}${txt}")
    	} catch(ex) {
			log.error("LOGDEBUG unable to output requested data! || err:${ex}")
    	}
	}
}
def LOGTRACE(txt){
	def msgfrom = "[PARENT] "
	def appLabel = (app?.label == null) ? state.InternalName : app.label //Some child calls to parent.LOGTRACE result in app.label being null, correct
	appLabel = appLabel.replace(" ","")
	appLabel.toUpperCase()
    if (txt?.contains("[CHILD:")) { msgfrom = "" }
    try {
    	log.trace("${appLabel}(${state.version}) || ${msgfrom}${txt}")
    } catch(ex) {
    	log.error("LOGTRACE unable to output requested data!")
    }
}
def LOGERROR(txt){
	def msgfrom = "[PARENT] "
	def appLabel = (app?.label == null) ? state.InternalName : app.label //Some child calls to parent.LOGERROR result in app.label being null, correct
	appLabel = appLabel.replace(" ","")
	appLabel.toUpperCase()
    if (txt?.contains("[CHILD:")) { msgfrom = "" }
    try {
    log.error("${appLabel}(${state.version}) || ${msgfrom}ERROR: ${txt}")
    } catch(ex) {
    	log.error("LOGERROR unable to output requested data!")
    }
}

def getHubType(){
    if (location.hubs[0].id.toString().length() > 5) { return "SmartThings" } else { return "Hubitat" }
}

def returnVar(var) {
    def dataType = "String"
    def returnValue
    if (!(settings."${var}" == null)) { returnValue = settings."${var}" }
    if (!(state."${var}" == null)) { returnValue = state."${var}" }
	if (!(atomicState."${var}" == null)) { returnValue = atomicState."${var}" }
    def dateTest = returnValue =~ /\d\d\d\d-\d\d-\d\dT\d\d:/
    if (dateTest) { dataType = "Date" }
    if (returnValue == "true") { dataType = "Boolean" }
    if (returnValue == "false") { dataType = "Boolean" }
    if (returnValue == true) { dataType = "Boolean" }
    if (returnValue == false) { dataType = "Boolean" }
    if (dataType == "Date") {returnValue = Date.parse("yyyy-MM-dd'T'HH:mm:ss.SSSZ", returnValue)}
    //LOGDEBUG ("returnVar(${var}), DataType:${dataType}, Value: ${returnValue}")
    if (returnValue == null || returnValue == "") {}
    return returnValue
}

def playTrackAndRestore(device, uri, duration, volume, myDelay, phrase) {
    LOGDEBUG("playTrackAndRestore(${device.displayName},${uri},${duration},${volume},${myDelay})")
    if (state.hubType == "SmartThings") {
    	device.playTrackAndRestore("uri": uri, "duration":duration, volume, [delay: myDelay])
		//device.playTrackAndRestore(uri, duration, volume, [delay: myDelay])
    }
    if (state.hubType == "Hubitat") {
		def isEchoSpeaksLike = device.hasCommand("setVolumeAndSpeak")
		def isSonosLike = device.hasCommand("playTrackAndRestore") //Hubitat only supports playTrackAndRestore(uri,volume) for Sonos
		def supportsPlayTrack = device.hasCommand("playTrack")
		def supportsSetLevel = device.hasCommand("setLevel")
		def supportsSetVolume = device.hasCommand("setVolume")
		def supportsUnmute = device.hasCommand("unmute")
		def supportsATTRLevel = device.hasAttribute("level")
		def supportsATTRVolume = device.hasAttribute("volume")
		def curVol = -100
		if (supportsATTRLevel){ curVol = device.latestValue("level") }
		if (supportsATTRVolume){ curVol = device.latestValue("volume") }
		LOGDEBUG("FINGERPRINT ${device.displayName} cap:${device.getSupportedCapabilities} comm:${device.getSupportedCommands()} att:${device.getSupportedAttributes()}")
		if (isSonosLike){ //NEED ADDITIONAL SUPPORTED COMMANDS/ATTRIBUTES TO FINGERPRINT!
			// SONOS SUPPORT
			LOGDEBUG("playTrackAndRestore: Sonos like device detected, Please send previous debug log entry to Rayzurbock for Fingerprinting.")
			//LOGDEBUG("playTrackAndRestore: Sonos like device detected, calling playTrackAndRestore(uri,vol)")
			//device.playTrackAndRestore(uri, volume)  //Hubitat only supports playTrackAndRestore(uri,volume) for Sonos
			//return
		}
		if (isEchoSpeaksLike) {
			// ECHOSPEAKS SUPPORT
			// setVolumeSpeakAndRestore - Sets volume, plays message, restores volume
			LOGDEBUG("playTrackAndRestore: EchoSpeaks like device detected, calling setVolumeSpeakAndRestore(volume, message)")
			setVolumeSpeakAndRestore(volume, phrase)
			return
		}
		if (supportsPlayTrack) {
			def curTrack = device.trackData
			if (supportsUnmute){
				LOGDEBUG("playTrackAndRestore[playTrack]: unmute()")
				device.unmute()
				pauseExecution(250)
			} else {
				LOGDEBUG("playTrackAndRestore[playTrack]: unmute() is not supported by this device (${device.displayName})")
			}
			if (supportsSetLevel || supportsSetVolume){
				if (supportsSetLevel){
					LOGDEBUG("playTrackAndRestore[playTrack]: setLevel(${volume})")
					device.setLevel(volume)
					pauseExecution(250)
				}
				if (supportsSetVolume && !supportsSetLevel){
					LOGDEBUG("playTrackAndRestore[playTrack]: setVolume(${volume})")
					device.setVolume(volume)
					pauseExecution(250)
				}
			} else {
				LOGDEBUG("playTrackAndRestore[playTrack]: setLevel/setVolume is not supported by this device (${device.displayName})")
			}
			LOGDEBUG("playTrackAndRestore[playTrack]: playTrack(${uri})")
			device.playTrack(uri)
			pauseExecution((duration.toInteger() * 1000))
			if (supportsSetLevel || supportsSetVolume){
				if ((curVol > -100) && supportsSetLevel){
					LOGDEBUG("playTrackAndRestore[playTrack]: setLevel(${curVol})")
					device.setLevel(curVol)
					pauseExecution(250)
				}
				if ((curVol > -100) && (supportsSetVolume && !supportsSetLevel)){
					LOGDEBUG("playTrackAndRestore[playTrack]: setVolume(${curVol})")
					device.setVolume(curVol)
					pauseExecution(250)
				}
			} else {
				LOGDEBUG("playTrackAndRestore[playTrack]: setLevel/setVolume is not supported by this device (${device.displayName})")
			}
			if (!curTrack?.uri == null){
				LOGDEBUG("playTrackAndRestore[playTrack]: restoreTrack(${curTrack.uri})")
				if (device.hasCommand("restoreTrack")){
					device.restoreTrack(curTrack.uri)
				} else {
					LOGDEBUG("playTrackAndRestore[playTrack]: restoreTrack() is not supported by this device (${device.displayName})")
				}
			}
		}
    }
}

def playTrackAndResume(device, uri, duration, volume, myDelay, phrase) {
    LOGDEBUG("playTrackAndResume(${device.displayName},${uri},${duration},${volume},${myDelay})")
    if (state.hubType == "SmartThings") {
    	device.playTrackAndResume("uri":uri, "duration":duration, "volume":volume, [delay: myDelay])
    }
    if (state.hubType == "Hubitat") {
		def isEchoSpeaksLike = device.hasCommand("setVolumeAndSpeak")
		def isSonosLike = device.hasCommand("playTrackAndRestore") //Hubitat only supports playTrackAndRestore(uri,volume) for Sonos
		def supportsPlayTrack = device.hasCommand("playTrack")
		def supportsSetLevel = device.hasCommand("setLevel")
		def supportsSetVolume = device.hasCommand("setVolume")
		def supportsUnmute = device.hasCommand("unmute")
		def supportsATTRLevel = device.hasAttribute("level")
		def supportsATTRVolume = device.hasAttribute("volume")
		def curVol = -100
		if (supportsATTRLevel){ curVol = device.latestValue("level") }
		if (supportsATTRVolume){ curVol = device.latestValue("volume") }
		LOGDEBUG("FINGERPRINT ${device.displayName} cap:${device.getSupportedCapabilities} comm:${device.getSupportedCommands()} att:${device.getSupportedAttributes()}")
		if (isSonosLike){ //NEED ADDITIONAL SUPPORTED COMMANDS/ATTRIBUTES TO FINGERPRINT!
			// SONOS SUPPORT
			LOGDEBUG("playTrackAndRestore: Sonos like device detected, Please send previous debug log entry to Rayzurbock for Fingerprinting.")
			//LOGDEBUG("playTrackAndRestore: Sonos like device detected, calling playTrackAndRestore(uri,vol)")
			//device.playTrackAndRestore(uri, volume)  //Hubitat only supports playTrackAndRestore(uri,volume) for Sonos
			//return
		}
		if (isEchoSpeaksLike) {
			// ECHOSPEAKS SUPPORT
			// setVolumeSpeakAndRestore - Sets volume, plays message, restores volume
			LOGDEBUG("playTrackAndResume: EchoSpeaks like device detected, calling setVolumeSpeakAndRestore(volume, message); Resume track not supported")
			setVolumeSpeakAndRestore(volume, phrase)
			return
		}
		if (supportsPlayTrack) {
			def curTrack = device.trackData
			if (supportsUnmute){
				LOGDEBUG("playTrackAndResume[playTrack]: unmute()")
				device.unmute()
				pauseExecution(250)
			} else {
				LOGDEBUG("playTrackAndResume[playTrack]: unmute() is not supported by this device (${device.displayName})")
			}
			if (supportsSetLevel || supportsSetVolume){
				if (supportsSetLevel){
					LOGDEBUG("playTrackAndResume[playTrack]: setLevel(${volume})")
					device.setLevel(volume)
					pauseExecution(250)
				}
				if (supportsSetVolume && !supportsSetLevel){
					LOGDEBUG("playTrackAndResume[playTrack]: setVolume(${volume})")
					device.setVolume(volume)
					pauseExecution(250)
				}
			} else {
				LOGDEBUG("playTrackAndResume[playTrack]: setLevel/setVolume is not supported by this device (${device.displayName})")
			}
			LOGDEBUG("playTrackAndResume[playTrack]: playTrack(${uri})")
			device.playTrack(uri)
			pauseExecution((duration.toInteger() * 600))
			if (supportsSetLevel || supportsSetVolume){
				if ((curVol > -100) && supportsSetLevel){
					LOGDEBUG("playTrackAndResume[playTrack]: setLevel(${curVol})")
					device.setLevel(curVol)
					pauseExecution(250)
				}
				if ((curVol > -100) && (supportsSetVolume && !supportsSetLevel)){
					LOGDEBUG("playTrackAndResume[playTrack]: setVolume(${curVol})")
					device.setVolume(volume)
					pauseExecution(250)
				}
			} else {
				LOGDEBUG("playTrackAndResume[playTrack]: setLevel/setVolume is not supported by this device (${device.displayName})")
			}
			if (!curTrack?.uri == null){
				LOGDEBUG("playTrackAndResume[playTrack]: resumeTrack(${curTrack.uri})")
				if (device.hasCommand("resumeTrack")){
					device.resumeTrack(curTrack.uri)
				} else {
					LOGDEBUG("playTrackAndRestore[playTrack]: restoreTrack() is not supported by this device (${device.displayName})")
					if (device.hasCommand("restoreTrack")){
						device.restoreTrack(curTrack.uri)
					}
				}
			}
		}
    }
}

def version(){
	//Cobra update code, modified by Rayzurbock
    resetBtnName()
	//schedule("0 0 9 ? * FRI *", updateCheck) //  Check for updates at 9am every Friday
	updateCheck()  
	//checkButtons()
    //pauseOrNot()
    
}

def checkButtons(){
	//Cobra update code
    LOGDEBUG("Running checkButtons")
    appButtonHandler("updateBtn")
}


def appButtonHandler(btn){
	//Cobra update code
    state.btnCall = btn
    if(state.btnCall == "updateBtn"){
       log.info "Checking for updates now..."
        updateCheck()
        pause(3000)
  		state.btnName = state.versionBtn
        runIn(2, resetBtnName)
    }
    if(state.btnCall == "updateBtn1"){
    state.btnName = "Update Available - refresh page" 
    //httpGet("https://github.com/CobraVmax/Hubitat/tree/master/Apps' target='_blank")
    }
    
}   
def resetBtnName(){
	//Cobra update code
//    log.info "Resetting Update Button Name"
	if(state.versionStatus != "Current"){
		state.btnName = state.versionBtn
	}
	else{
		state.btnName = "Check For Update" 
	}
}    

def displayVersionStatus(){
	//Cobra update code, modified by Rayzurbock
    def formatSettingRootStart = state.formatSettingRootStart
	def formatSettingRootEnd = state.formatSettingRootEnd
	def formatSettingOptionalStart = state.formatSettingOptionalStart
	def formatSettingOptionalEnd = state.formatSettingOptionalEnd
    def formatUlStart = state.formatUlStart
	def formatUlEnd = state.formatUlEnd
    def formatLiStart = state.formatLiStart
	def formatLiEnd = state.formatLiEnd
    def formatIStart = state.formatIStart
	def formatIEnd = state.formatIEnd
    def formatStrongStart = state.formatStrongStart
	def formatStrongEnd = state.formatStrongEnd
    def formatHr = state.formatHr
    def formatBr = state.formatBr
    def formatCenterStart = state.formatCenterStart
    def formatCenterEnd = state.formatCenterEnd
    def versionInfo = ""
	versionInfo = "${formatHr}${formatHr}${formatStrongStart}${formatCenterStart}Version Information${formatCenterEnd}${formatStrongEnd}${formatBr}"
	if(state.versionStatus){
    	if (state.hubType == "Hubitat") {
			versionInfo += "<img src='http://lowrance.cc/ST/icons/BigTalker-CurrentVersion.png'</img><BR>${state.ExternalName} - Version: ${state.version} <BR><font face='Lucida Handwriting'>${state.Copyright} </font>"
		}
    	if (state.hubType == "SmartThings") {
			versionInfo += "${state.ExternalName} - Version: ${state.version} ${formatBr} ${state.Copyright?.replace("&#9400;","(c)")}${formatBr}"
		}
    }
	if((state.versionStatus != "${formatStrongStart}** This app is no longer supported by $state.author  **${formatStrongEnd}") & (state.versionStatus != "Current")){
		input "updateBtn", "button", title: "${state.btnName}"
    
		//  section(){
		//		log.info "app.label = $app.label"
		//		input "pause1", "bool", title: "Pause This App", required: true, submitOnChange: true, defaultValue: false  
		//	}
		//	pauseOrNot()   
			//if(state.versionStatus != "Current"){
		versionInfo += "${formatStrongStart}${state.versionStatus}${formatStrongEnd}${formatBr}${state.updateURI}${formatBr}${formatStrongStart}${formatIStart}Release Notes:${formatIEnd}${formatStrongEnd}${state.UpdateInfo}${formatBr}"
			//}
		//section(" ") {
		//	input "updateNotification", "bool", title: "Send a 'Pushover' message when an update is available", required: true, defaultValue: false, submitOnChange: true 
		//	if(updateNotification == true){ input "speaker", "capability.speechSynthesis", title: "PushOver Device", required: true, multiple: true}
		//}
	} else {
		versionInfo += "${formatIStart}App is up to date${formatIEnd}"
	}
    paragraph versionInfo
}

def updateCheck(){
	setVersion()
	def lastKnownVersionStatus = state.versionStatus
	if (state?.versionStatus == null) { state.versionStatus = "<i>Unknown</i>" }
	def paramsUD = [uri: "https://lowrance.cc/ST/manifests/RayzurCodeHE.json"]
	if (updateCheckAllowed() || lastKnownVersionStatus == "<i>Unknown</i>" || lastKnownVersionStatus == null){
		state.Copyright = ""
		state.updateURI = ""
		state.UpdateInfo = ""
		state.author = ""
		state.versionBtn = ""
		def newVerRaw = ""
		def newVer = ""
		def currentVer = ""
		try {
			httpGet(paramsUD) { respUD ->
 			  //log.warn " Version Checking - Response Data: ${respUD.data}"   // Troubleshooting Debug Code 
				def copyrightRead = (respUD.data.copyright)
				state.Copyright = copyrightRead
				def updateUri = (respUD.data.versions.UpdateInfo.GithubFiles.(state.InternalName))
				state.updateURI = updateUri   
				newVerRaw = (respUD.data.versions.Application.(state.InternalName))
				newVer = (respUD.data.versions.Application.(state.InternalName).replace(".", ""))
				currentVer = state.version.replace(".", "")
				state.UpdateInfo = (respUD.data.versions.UpdateInfo.Application.(state.InternalName))
				state.author = (respUD.data.author)
				log.debug "currentVer=${currentVer}, newVer=${newVer}"
				if(newVer == "NLS"){
					state.versionStatus = "<b>** This app is no longer supported by ${state.author}  **</b>"  
					log.warn "** This app is no longer supported by ${state.author} **" 
				}
				else if(currentVer < newVer){
					state.versionStatus = "New Version Available (Version: ${newVerRaw})"
					log.warn "** There is a newer version of this app available  (Version: ${newVerRaw}) **"
					log.warn "** ${state.UpdateInfo} **"
					state.versionBtn = "UPDATE AVAILABLE"
					def updateMsg = "There is a new version of '${state.ExternalName}' available (Version: ${newVerRaw})"
					//pushOverNow(updateMsg)
				} 
				else{ 
					state.versionStatus = "Current"
					log.info "You are using the current version of this app"
				}
			}
		} catch (e) {
			log.error "Something went wrong: CHECK THE JSON FILE AND IT'S URI -  $e"
		}
		if(state.versionStatus != "Current"){
			state.versionBtn = "UPDATE AVAILABLE"
		}
		else{
			state.versionBtn = "No Update Available"
		}
	} else {
		return
	}
}

def updateCheckAllowed(){
	// rayzurbock code, used with Cobra update code
	def proceed = false
	def updateCheckCurrentDate = new Date().getTime()
	def updateCheckIntervalInMil = (state.updateActiveUseIntervalMin * 60000)
	if (state?.updateNextCheckDate == null) { state.updateNextCheckDate = new Date().getTime() }
	def timeDiff = state?.updateNextCheckDate - updateCheckCurrentDate
	if (timeDiff <= 0 || timeDiff == null) { proceed = true }
	if (state?.updateNextCheckDate == null) { proceed = true }
	//if (!(proceed == true)) { log.debug "updateCheckAllowed() result: not allowed to proceed"}
	LOGDEBUG("updateCheckAllowed() timeDiff=${timeDiff}, proceed=${proceed}")
	if (proceed) {
		//log.debug("updateCheckAllowed(): result: proceed")
		state.updateNextCheckDate = new Date().getTime() + updateCheckIntervalInMil
		return true
	} else { 
		//log.debug("updateCheckAllowed(): result: do not proceed (${timeDiff})")
		return false
	}
	
}

def setFormatting(){
	if (state.hubType == "Hubitat") {
		state.formatSettingRootStart = "<B><span style='color: blue;'>"
		state.formatSettingRootEnd = "</span></B>"
		state.formatSettingOptionalStart = "<B><span style='color: #6897bb;'>"
		state.formatSettingOptionalEnd = "</font></B>"
        state.formatUlStart = "<ul>"
        state.formatUlEnd = "</ul>"
        state.formatLiStart = "<li>"
        state.formatLiEnd = "</li>"
        state.formatIStart = "<i>"
        state.formatIEnd = "</i>"
        state.formatStrongStart = "<strong>"
        state.formatStrongEnd = "</strong>"
        state.formatHr = "<hr>"
        state.formatBr = "<br>"
        state.formatCenterStart = "<center>"
        state.formatCenterEnd = "</center>"
	}
	if (state.hubType == "SmartThings") { 
		state.formatSettingRootStart = ""
		state.formatSettingRootEnd = ""
		state.formatSettingOptionalStart = ""
		state.formatSettingOptionalEnd = ""
        state.formatUlStart = "\n"
        state.formatUlEnd = ""
        state.formatLiStart = ""
        state.formatLiEnd = "\n\n"
        state.formatIStart = ""
        state.formatIEnd = ""
        state.formatStrongStart = ""
        state.formatStrongEnd = ""
        state.formatHr = ""
        state.formatBr = "\n"
        state.formatCenterStart = ""
        state.formatCenterEnd = ""
	}
    /*
    	Place in PARENT functions that need formatting:
    	def formatSettingRootStart = state.formatSettingRootStart
		def formatSettingRootEnd = state.formatSettingRootEnd
		def formatSettingOptionalStart = state.formatSettingOptionalStart
		def formatSettingOptionalEnd = state.formatSettingOptionalEnd
        def formatUlStart = state.formatUlStart
		def formatUlEnd = state.formatUlEnd
        def formatLiStart = state.formatLiStart
		def formatLiEnd = state.formatLiEnd
        def formatIStart = state.formatIStart
		def formatIEnd = state.formatIEnd
        def formatStrongStart = state.formatStrongStart
		def formatStrongEnd = state.formatStrongEnd
        def formatHr = state.formatHr
        def formatBr = state.formatBr
        def formatCenterStart = state.formatCenterStart
        def formatCenterEnd = state.formatCenterEnd
        
        Place in CHILD functions that need formatting:
        def formatSettingRootStart = parent.returnVar("formatSettingRootStart")
		def formatSettingRootEnd = parent.returnVar("formatSettingRootEnd")
		def formatSettingOptionalStart = parent.returnVar("formatSettingOptionalStart")
		def formatSettingOptionalEnd = parent.returnVar("formatSettingOptionalEnd")
        def formatUlStart = parent.returnVar("formatUlStart")
		def formatUlEnd = parent.returnVar("formatUlEnd")
        def formatLiStart = parent.returnVar("formatLiStart")
		def formatLiEnd = parent.returnVar("formatLiEnd")
        def formatIStart = parent.returnVar("formatIStart")
		def formatIEnd = parent.returnVar("formatIEnd")
        def formatStrongStart = parent.returnVar("formatStrongStart")
		def formatStrongEnd = parent.returnVar("formatStrongEnd")
        def formatHr = parent.returnVar("formatHr")
		def formatBr = parent.returnVar("formatBr")
        def formatCenterStart = parent.returnVar("formatCenterStart")
		def formatCenterEnd = parent.returnVar("formatCenterEnd")
    */
}

def setVersion(){
		//Cobra update code, modified by Rayzurbock
		state.version = "2.1.2.0"	 
		state.InternalName = "BigTalker2-Parent-DEV" 
		state.ExternalName = "BigTalker2-DEV"
		state.updateActiveUseIntervalMin = 30 //time in minutes to check for updates while using the App
}
