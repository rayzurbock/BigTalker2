definition(
    name: "BigTalker2-Child-DEV",
    namespace: "rayzurbock",
    author: "rayzur@rayzurbock.com",
    description: "Do not install in the mobile app, Save don't publish (needed by BigTalker2)",
    category: "Fun & Social",
    parent: "rayzurbock:BigTalker2-Parent-DEV",
    iconUrl: "http://lowrance.cc/ST/icons/BigTalker.png",
    iconX2Url: "http://lowrance.cc/ST/icons/BigTalker@2x.png",
    iconX3Url: "http://lowrance.cc/ST/icons/BigTalker@2x.png")

preferences {
    page(name: "pageConfigureEvents")
    page(name: "pageConfigMotion")
    page(name: "pageConfigSwitch")
    page(name: "pageConfigPresence")
    page(name: "pageConfigLock")
    page(name: "pageConfigContact")
    page(name: "pageConfigMode")
    page(name: "pageConfigThermostat")
    page(name: "pageConfigAcceleration")
    page(name: "pageConfigWater")
    page(name: "pageConfigSmoke")
    page(name: "pageConfigButton")
    page(name: "pageConfigTime")
    page(name: "pageConfigSHM")
    page(name: "pageConfigPowerMeter")
    page(name: "pageConfigRoutine")
	page(name: "pageConfigAlarm")
	page(name: "pageConfigFilterStatus")
    page(name: "pageHelpPhraseTokens")
	
}

def pageConfigureEvents(){
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
	setVersion()
    state.hubType = parent.returnVar("hubType")
    dynamicPage(name: "pageConfigureEvents", title: "Configure Events", install: (!(app?.getInstallationState == true)), uninstall: (app?.getInstallationState == true)) {
        section("Group Settings:"){
            label(name: "labelRequired", title: "Event Group Name:", defaultValue: "Change this", required: true, multiple: false)
            input(name: "groupEnabled", type: "bool", title: "Enable Group", required: true, defaultValue: true)
        }
        section("Talk on events:") {
            if (settings.timeSlotTime1 || settings.timeSlotTime2 || settings.timeSlotTime3) {
                href "pageConfigTime", title: "Time", description: "Tap to modify", state:"complete"
            } else {
                href "pageConfigTime", title: "Time", description: "Tap to configure"
            }
            if (settings.motionDeviceGroup1 || settings.motionDeviceGroup2 || settings.motionDeviceGroup3) {
                href "pageConfigMotion", title:"Motion", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigMotion", title:"Motion", description:"Tap to configure"
            }
            if (settings.switchDeviceGroup1 || settings.switchDeviceGroup2 || settings.switchDeviceGroup3) {
                href "pageConfigSwitch", title:"Switch", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigSwitch", title:"Switch", description:"Tap to configure"
            }
            if (settings.presenceDeviceGroup1 || settings.presenceDeviceGroup2 || settings.presenceDeviceGroup3) {
                href "pageConfigPresence", title:"Presence", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigPresence", title:"Presence", description:"Tap to configure"
            }
            if (settings.lockDeviceGroup1 || settings.lockDeviceGroup2 || settings.lockDeviceGroup3) {
                href "pageConfigLock", title:"Lock", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigLock", title:"Lock", description:"Tap to configure"
            }
            if (settings.contactDeviceGroup1 || settings.contactDeviceGroup2 || settings.contactDeviceGroup3) {
                href "pageConfigContact", title:"Contact", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigContact", title:"Contact", description:"Tap to configure"
            }
            if (settings.modePhraseGroup1 || settings.modePhraseGroup2 || settings.modePhraseGroup3) {
                href "pageConfigMode", title:"Mode", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigMode", title:"Mode", description:"Tap to configure"
            }
            if (settings.thermostatDeviceGroup1 || settings.thermostatDeviceGroup2 || settings.thermostatDeviceGroup3) {
                href "pageConfigThermostat", title:"Thermostat", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigThermostat", title:"Thermostat", description:"Tap to configure"
            }
            if (settings.accelerationDeviceGroup1 || settings.accelerationDeviceGroup2 || settings.accelerationDeviceGroup3) {
                href "pageConfigAcceleration", title: "Acceleration", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigAcceleration", title: "Acceleration", description:"Tap to configure"
            }
            if (settings.waterDeviceGroup1 || settings.waterDeviceGroup2 || settings.waterDeviceGroup3) {
                href "pageConfigWater", title: "Water", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigWater", title: "Water", description:"Tap to configure"
            }
            if (settings.smokeDeviceGroup1 || settings.smokeDeviceGroup2 || settings.smokeDeviceGroup3) {
                href "pageConfigSmoke", title: "Smoke", description:"Tap to modify", state:"complete"
            } else { 
                href "pageConfigSmoke", title: "Smoke", description:"Tap to configure"
            }
            if (settings.buttonDeviceGroup1 || settings.buttonDeviceGroup2 || settings.buttonDeviceGroup3) {
                href "pageConfigButton", title: "Button", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigButton", title: "Button", description:"Tap to configure"
            }
			if (settings.alarmDeviceGroup1 || settings.alarmDeviceGroup2 || settings.alarmDeviceGroup3) {
                href "pageConfigAlarm", title: "Alarm", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigAlarm", title: "Alarm", description:"Tap to configure"
            }
			if (settings.consumableDeviceGroup1 || settings.consumableDeviceGroup2 || settings.consumableDeviceGroup3) {
                href "pageConfigFilterStatus", title: "Filter Status", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigFilterStatus", title: "Filter Status", description:"Tap to configure"
            }
            if (hubType == "SmartThings"){
            	if (settings.SHMTalkOnHome || settings.SHMTalkOnAway || settings.SHMTalkOnDisarm) {
                	href "pageConfigSHM", title: "Smart Home Monitor", description:"Tap to modify", state:"complete"
            	} else {
                	href "pageConfigSHM", title: "Smart Home Monitor", description:"Tap to configure"
            	}
            }
			if (settings.powerMeterDeviceGroup1 || settings.powerMeterDeviceGroup2 || settings.powerMeterDeviceGroup3) {
                href "pageConfigPowerMeter", title: "Power Meter", description:"Tap to modify", state:"complete"
            } else {
                href "pageConfigPowerMeter", title: "Power Meter", description:"Tap to configure"
            }
            if (hubType == "SmartThings"){
            	if (settings.routineDeviceGroup1 || settings.routineDeviceGroup2 || settings.routineDeviceGroup3) {
                	href "pageConfigRoutine", title: "Routine", description:"Tap to modify", state:"complete"
            	} else {
                	href "pageConfigRoutine", title: "Routine", description:"Tap to configure"
            	}
            }
        }
		updateCheck()
		//checkButtons()
		section(){
        	displayVersionStatus()
        }
    }
}

def pageConfigMotion(){
    dynamicPage(name: "pageConfigMotion", title: "Configure talk on motion", install: false, uninstall: false) {
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
		//CONFIGURATION
		section(){
			def defaultSpeechActive1 = ""
            def defaultSpeechInactive1 = ""
            if (!motionDeviceGroup1) {
                defaultSpeechActive1 = "%devicename% is now %devicechange%"
                defaultSpeechInactive1 = "%devicename% is now %devicechange%"
            }
			input name: "motionDeviceGroup1", type: "capability.motionSensor", title: "${formatSettingRootStart}Motion Sensor(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "motionTalkOnActive1", type: "text", title: "${formatSettingRootStart}Say this on motion active:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechActive1, submitOnChange: true
            input name: "motionTestOnActive1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test motion active phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "motionTalkOnInactive1", type: "text", title: "${formatSettingRootStart}Say this on motion inactive:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechInactive1, submitOnChange: true
            input name: "motionTestOnInactive1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test motion inactive phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "motionPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"], submitOnChange: true
            input name: "motionSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false, submitOnChange: true
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "motionVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false, submitOnChange: true
            	input name: "motionResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true, submitOnChange: true
                input name: "motionVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${parent.SettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
		//RESTRICTIONS
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "motionModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "motionStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "motionEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.motionStartTime1 == null))
            input name: "motionDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            //input name: "motionCount1", type: "number", title: "${formatSettingOptionalEnd}Do this only x times (next prompt)...${parent.formatSettingOptionalEnd}", required: false, submitOnChange: true
            //input name: "motionCountUnit1", type:"enum", title: "${formatSettingOptionalEnd}... per ${parent.formatSettingOptionalEnd}", required: settings.motionCount1, options: ["Minute", "Hour", "Day"]
            input name: "motionDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
		//HELP
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		def phraseTestTogDeviceUpper = "Motion"
		def phraseTestTogDeviceLower = "motion"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Active"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Inactive"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigMotion()
}

def pageConfigSwitch(){
    dynamicPage(name: "pageConfigSwitch", title: "Configure talk on switch", install: false, uninstall: false) {
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
		//CONFIGURATION
        section(){
            def defaultSpeechOn1 = ""
            def defaultSpeechOff1 = ""
            if (!switchDeviceGroup1) {
                defaultSpeechOn1 = "%devicename% is now %devicechange%"
                defaultSpeechOff1 = "%devicename% is now %devicechange%"
            }
            input name: "switchDeviceGroup1", type: "capability.switch", title: "${formatSettingRootStart}Switch(es)${formatSettingRootEnd}", required: false, multiple: true
            input name: "switchTalkOnOn1", type: "text", title: "${formatSettingRootStart}Say this when switch is turned ON:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechOn1, submitOnChange: true
            input name: "switchTestOnOn1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test switch ON phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "switchTalkOnOff1", type: "text", title: "${formatSettingRootStart}Say this when switch is turned OFF:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechOff1, submitOnChange: true
            input name: "switchTestOnOff1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test switch OFF phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "switchPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"], submitOnChange: true
            input name: "switchSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false, submitOnChange: true
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "switchVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false, submitOnChange: true
            	input name: "switchResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true, submitOnChange: true
                input name: "switchVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
		//RESTRICTIONS
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            //IN DEVELOPMENT  input name: "switchOnThreshold", type: "number", title: "${formatSettingOptionalStart}If it's on for more than this many minutes (default 0)${formatSettingOptionalEnd}", required: false, defaultValue: 0
            input name: "switchModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "switchStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "switchEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.switchStartTime1 == null))
            input name: "switchDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "switchDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
		//HELP
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Switch"
		def phraseTestTogDeviceLower = "switch"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "On"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Off"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigSwitch()
}

def pageConfigPresence(){
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
    dynamicPage(name: "pageConfigPresence", title: "Configure talk on presence", install: false, uninstall: false) {
		//CONFIGURATION
        section(){
            def defaultSpeechArrive1 = ""
            def defaultSpeechLeave1 = ""
			def testState = ""
            if (!presenceDeviceGroup1) {
                defaultSpeechArrive1 = "%devicename% has arrived"
                defaultSpeechLeave1 = "%devicename% has left"
            }
            input name: "presenceDeviceGroup1", type: "capability.presenceSensor", title: "${formatSettingRootStart}Presence Sensor(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "presenceTalkOnPresent1", type: "text", title: "${formatSettingRootStart}Say this when someone arrives:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechArrive1
			input name: "presenceTestOnPresent1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test arrival phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "presenceTalkOnNot present1", type: "text", title: "${formatSettingRootStart}Say this when someone leaves:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechLeave1
			input name: "presenceTestOnNot present1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test departure phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "presencePersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "presenceSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalEnd}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "presenceVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
            	input name: "presenceResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "presenceVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
		//RESTRICTIONS
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "presenceModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "presenceStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "presenceEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.presenceStartTime1 == null))
            input name: "presenceDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "presenceDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
		//HELP
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Presence"
		def phraseTestTogDeviceLower = "presence"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Present"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Not present"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigPresence()
}

def pageConfigLock(){
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
    dynamicPage(name: "pageConfigLock", title: "Configure talk on lock", install: false, uninstall: false) {
		//CONFIGURATION
        section(){
            def defaultSpeechUnlock1 = ""
            def defaultSpeechLock1 = ""
            if (!lockDeviceGroup1) {
                defaultSpeechUnlock1 = "%devicename% is now unlocked"
                defaultSpeechLock1 = "%devicename% is now locked"
            }
            input name: "lockDeviceGroup1", type: "capability.lock", title: "${formatSettingRootStart}Lock(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "lockTalkOnUnlock1", type: "text", title: "${formatSettingRootStart}Say this when unlocked:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechUnlock1
			input name: "lockTestOnUnlock1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test unlock phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "lockTalkOnLock1", type: "text", title: "${formatSettingRootStart}Say this when locked:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechLock1
			input name: "lockTestOnLock1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test lock phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "lockPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "lockSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "lockVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
            	input name: "lockResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "lockVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
		//RESTRICTIONS
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "lockModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "lockStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "lockEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.lockStartTime1 == null))
            input name: "lockDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s${formatSettingOptionalEnd})", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "lockDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
		//HELP
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Lock"
		def phraseTestTogDeviceLower = "lock"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Lock"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Unlock"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigLock()
}

def pageConfigContact(){
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
    dynamicPage(name: "pageConfigContact", title: "Configure talk on contact sensor", install: false, uninstall: false) {
		//CONFIGURATION
        section(){
            def defaultSpeechOpen1 = ""
            def defaultSpeechClosed1 = ""
            if (!contactDeviceGroup1) {
                defaultSpeechOpen1 = "%devicename% is now %devicechange%"
                defaultSpeechClosed1 = "%devicename% is now %devicechange%"
            }
            input name: "contactDeviceGroup1", type: "capability.contactSensor", title: "${formatSettingRootStart}Contact sensor(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "contactTalkOnOpen1", type: "text", title: "${formatSettingRootStart}Say this when opened:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechOpen1
			input name: "contactTestOnOpen1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test opened phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "contactTalkOnClosed1", type: "text", title: "${formatSettingRootStart}Say this when closed:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechClosed1
			input name: "contactTestOnClosed1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test closed phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "contactPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingRootEnd}", required: false, options: ["Yes", "No"]
            input name: "contactSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "contactVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "contactResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "contactVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
		//RESTRICTIONS
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            //IN DEVELOPMENT input name: "contactOpenThreshold", type: "number", title: "If it's open for more than this many minutes (default 0)", required: false, defaultValue: 0
            input name: "contactModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "contactStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "contactEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.contactStartTime1 == null))
            input name: "contactDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "contactDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
		//HELP
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Contact"
		def phraseTestTogDeviceLower = "contact"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Open"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Closed"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigContact()
}

def pageConfigMode(){
    def locationmodes = []
    location.modes.each(){
       locationmodes += it
    }
    LOGDEBUG("locationmodes=${locationmodes}", true)
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
    dynamicPage(name: "pageConfigMode", title: "Configure talk on home mode change", install: false, uninstall: false) {
		//CONFIGURATION
        section(){
            def defaultSpeechMode1 = ""
            if (!modePhraseGroup1) {
                defaultSpeechMode1 = "%locationname% mode has changed from %lastmode% to %mode%"
            }
            input name: "modePhraseGroup1", type:"mode", title:"${formatSettingRootStart}When mode changes to:${formatSettingRootEnd}", required:false, multiple:true, submitOnChange:false
            input name: "modeExcludePhraseGroup1", type: "mode", title: "${formatSettingOptionalStart}But not when changed from (optional):${formatSettingOptionalEnd}", required: false, multiple: true
            input name: "modeTalkOnChange1", type: "text", title: "${formatSettingRootStart}Say this when home mode is changed${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechMode1
			input name: "modeTestOnChange1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test mode change phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "modePersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "modePhraseSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "modePhraseVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "modePhraseResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "modePhraseVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
		//RESTRICTIONS
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "modeStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "modeEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: false//(!(settings.modeStartTime1 == null))
            input name: "modeDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "modeDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
		//HELP
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Mode"
		def phraseTestTogDeviceLower = "mode"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Change"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigMode()
}

def pageConfigThermostat(){
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
    dynamicPage(name: "pageConfigThermostat", title: "Configure talk when thermostat state is:", install: false, uninstall: false) {
        section(){
            def defaultSpeechIdle1 = ""
            def defaultSpeechHeating1 = ""
            def defaultSpeechCooling1 = ""
            def defaultSpeechFan1 = ""
            if (!thermostatDeviceGroup1) {
                defaultSpeechIdle1 = "%devicename% is now off"
                defaultSpeechHeating1 = "%devicename% is now heating"
                defaultSpeechCooling1 = "%devicename% is now cooling"
                defaultSpeechFan1 = "%devicename% is now circulating fan"
            }
            input name: "thermostatDeviceGroup1", type: "capability.thermostat", title: "${formatSettingRootStart}Thermostat(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "thermostatTalkOnIdle1", type: "text", title: "${formatSettingRootStart}Say this on change to Idle:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechIdle1
			input name: "thermostatTestOnIdle1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test Idle phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "thermostatTalkOnHeating1", type: "text", title: "${formatSettingRootStart}Say this on change to heating:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechHeating1
			input name: "thermostatTestOnHeating1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test Heating phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "thermostatTalkOnCooling1", type: "text", title: "${formatSettingRootStart}Say this on change to cooling:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechCooling1
			input name: "thermostatTestOnCooling1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test Cooling phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "thermostatTalkOnFan1", type: "text", title: "${formatSettingRootStart}Say this on change to fan only:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechFan1
			input name: "thermostatTestOnFan1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test Fan phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "thermostatPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "thermostatSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "thermostatVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
            	input name: "thermostatResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "thermostatVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "thermostatModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "thermostatStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "thermostatEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.thermostatStartTime1 == null))
            input name: "thermostatDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "thermostatDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Thermostat"
		def phraseTestTogDeviceLower = "thermostat"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Idle"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Heating"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Cooling"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Fan"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigThermostat()
}

def pageConfigAcceleration(){
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
    dynamicPage(name: "pageConfigAcceleration", title: "Configure talk on acceleration", install: false, uninstall: false) {
        section(){
            def defaultSpeechActive1 = ""
            def defaultSpeechInactive1 = ""
            if (!accelerationDeviceGroup1) {
                defaultSpeechActive1 = "%devicename% acceleration %devicechange%"
                defaultSpeechInactive1 = "%devicename% acceleration is no longer active"
            }
            input name: "accelerationDeviceGroup1", type: "capability.accelerationSensor", title: "${formatSettingRootStart}Acceleration sensor(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "accelerationTalkOnActive1", type: "text", title: "${formatSettingRootStart}Say this when activated:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechActive1
			input name: "accelerationTestOnActive1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test activate phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "accelerationTalkOnInactive1", type: "text", title: "${formatSettingRootStart}Say this when inactivated:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechInactive1
			input name: "accelerationTestOnInactive1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test inactivate phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "accelerationPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "accelerationSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "accelerationVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
            	input name: "accelerationResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "accelerationVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "accelerationModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "accelerationStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "accelerationEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.accelerationStartTime1 == null))
            input name: "accelerationDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "accelerationDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Acceleration"
		def phraseTestTogDeviceLower = "acceleration"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Active"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Inactive"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigAcceleration()
}

def pageConfigWater(){
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
    dynamicPage(name: "pageConfigWater", title: "Configure talk on water", install: false, uninstall: false) {
        section(){
            def defaultSpeechWet1 = ""
            def defaultSpeechDry1 = ""
            if (!waterDeviceGroup1) {
                defaultSpeechWet1 = "%devicename% is %devicechange%"
                defaultSpeechDry1 = "%devicename% is %devicechange%"
            }
            input name: "waterDeviceGroup1", type: "capability.waterSensor", title: "${formatSettingRootStart}Water sensor(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "waterTalkOnWet1", type: "text", title: "${formatSettingRootStart}Say this when wet:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechWet1
			input name: "waterTestOnWet1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test wet phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "waterTalkOnDry1", type: "text", title: "${formatSettingRootStart}Say this when dry:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechDry1
			input name: "waterTestOnDry1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test dry phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "waterPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "waterSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "waterVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "waterResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "waterVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "waterModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "waterStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "waterEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.waterStartTime1 == null))
            input name: "waterDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "waterDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Water"
		def phraseTestTogDeviceLower = "water"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Wet"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Dry"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigWater()
}

def pageConfigSmoke(){
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
    dynamicPage(name: "pageConfigSmoke", title: "Configure talk on smoke", install: false, uninstall: false) {
        section(){
            def defaultSpeechDetect1 = ""
            def defaultSpeechClear1 = ""
            def defaultSpeechTested1 = ""
            if (!smokeDeviceGroup1) {
                defaultSpeechDetect1 = "Smoke, %devicename% has detected smoke"
                defaultSpeechClear1 = "Smoke, %devicename% has cleared smoke alert"
                defaultSpeechTested1 = "Smoke, %devicename% has been tested"
            }
            input name: "smokeDeviceGroup1", type: "capability.smokeDetector", title: "${formatSettingRootStart}Smoke detector(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "smokeTalkOnDetect1", type: "text", title: "${formatSettingRootStart}Say this when detected:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechDetect1
			input name: "smokeTestOnDetect1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test smoke detected phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "smokeTalkOnClear1", type: "text", title: "${formatSettingRootStart}Say this when cleared:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechClear1
			input name: "smokeTestOnClear1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test smoke cleared phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "smokeTalkOnTested1", type: "text", title: "${formatSettingRootStart}Say this when tested:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechTested1
			input name: "smokeTestOnTested1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test smoke tested phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "smokePersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "smokeSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "smokeVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "smokeResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "smokeVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "smokeModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "smokeStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "smokeEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.smokeStartTime1 == null))
            input name: "smokeDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "smokeDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Smoke"
		def phraseTestTogDeviceLower = "smoke"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Detect"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Clear"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Tested"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigSmoke()
}

def pageConfigButton(){
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
    dynamicPage(name: "pageConfigButton", title: "Configure talk on button press", install: false, uninstall: false) {
        section(){
            def defaultSpeechButton1 = ""
            def defaultSpeechButtonHold1 = ""
            if (!buttonDeviceGroup1) {
                defaultSpeechButton1 = "%devicename% button pressed"
                defaultSpeechButtonHold1 = "%devicename% button held"
            }
            input name: "buttonDeviceGroup1", type: "capability.button", title: "${formatSettingRootStart}Button(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "buttonTalkOnPressed1", type: "text", title: "${formatSettingRootStart}Say this when pressed:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechButton1
			input name: "buttonTestOnPressed1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test pressed phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "buttonTalkOnHeld1", type: "text", title: "${formatSettingRootStart}Say this when held:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechButtonHold1
			input name: "buttonTestOnHeld1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test held phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "buttonPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "buttonSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "buttonVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "buttonResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "buttonVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "buttonModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "buttonStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "buttonEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.buttonStartTime1 == null))
            input name: "buttonDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "buttonDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Button"
		def phraseTestTogDeviceLower = "button"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Pressed"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Held"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigButton()
}

def pageConfigAlarm(){
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
    dynamicPage(name: "pageConfigAlarm", title: "Configure talk on alarm", install: false, uninstall: false) {
        section(){
            def defaultSpeechAlarmOff1 = ""
            def defaultSpeechAlarmBoth1 = ""
			def defaultSpeechAlarmSiren1 = ""
			def defaultSpeechAlarmStrobe1 = ""
            if (!alarmDeviceGroup1) {
                defaultSpeechAlarmOff1 = "%devicename% alarm is now off"
                defaultSpeechAlarmBoth1 = "%devicename% alarm siren and strobe are now active"
				defaultSpeechAlarmSiren1 = "%devicename% alarm siren is now active"
				defaultSpeechAlarmStrobe1 = "%devicename% alarm strobe is now active"
            }
            input name: "alarmDeviceGroup1", type: "capability.alarm", title: "${formatSettingRootStart}Alarm(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "alarmTalkOnOff1", type: "text", title: "${formatSettingRootStart}Say this when turned off:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechAlarmOff1
			input name: "alarmTestOnOff1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test off phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "alarmTalkOnBoth1", type: "text", title: "${formatSettingRootStart}Say this when siren and strobe are active:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechAlarmBoth1
			input name: "alarmTestOnBoth1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test siren and strobe active phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
			input name: "alarmTalkOnSiren1", type: "text", title: "${formatSettingRootStart}Say this when only the siren is active:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechAlarmSiren1
			input name: "alarmTestOnSiren1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test siren phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
			input name: "alarmTalkOnStrobe1", type: "text", title: "${formatSettingRootStart}Say this when only the strobe is active:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechAlarmStrobe1
			input name: "alarmTestOnStrobe1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test strobe phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "alarmPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "alarmSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "alarmVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "alarmResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "alarmVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "alarmModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "alarmStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "alarmEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.buttonStartTime1 == null))
            input name: "alarmDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "alarmDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Alarm"
		def phraseTestTogDeviceLower = "alarm"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Off"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Both"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Siren"
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Strobe"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigAlarm()
}

def pageConfigFilterStatus(){
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
    dynamicPage(name: "pageConfigFilterStatus", title: "Configure talk on Filter Status change", install: false, uninstall: false) {
        section(){
            def defaultSpeechFilterStatusNormal1 = ""
            def defaultSpeechFilterStatusReplace1 = ""
            if (!filteStatusDeviceGroup1) {
                defaultSpeechFilterStatusNormal1 = "%devicename% filter is normal"
                defaultSpeechFilterStatusReplace1 = "%devicename% filter needs to be replaced"
            }
            input name: "filterStatusGroup1", type: "capability.filterstatus", title: "${formatSettingRootStart}Filter(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "filterStatusTalkOnNormal1", type: "text", title: "${formatSettingRootStart}Say this when filter status changes to normal:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechFilterStatusNormal1
			input name: "filterStatusTestOnNormal1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test normal phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "filterStatusTalkOnReplace1", type: "text", title: "${formatSettingRootStart}Say this when filter status changes to replace:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechFilterStatusReplace1
			input name: "filterStatusTestOnReplace1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test replace phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "filterStatusPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "filterSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "filterStatusVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "filterStatusResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "filterStatusVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "filterStatusModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "filterStatusStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "filterStatusEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.buttonStartTime1 == null))
            input name: "filterStatusDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "filterStatusDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "FilterStatus"
		def phraseTestTogDeviceLower = "filterStatus"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Normal"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Replace"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigFilterStatus()
}

def pageConfigSHM(){
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
    dynamicPage(name: "pageConfigSHM", title: "Configure talk on Smart Home Monitor status change", install: false, uninstall: false) {
    	section(){
        	input name: "SHMPersonality", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
        }
        section("Smart Home Monitor - Armed, Away"){
            def defaultSpeechSHMAway = ""
            if ((!SHMTalkOnAway) && (!SHMTalkOnHome) && (!SHMTalkOnDisarm)) {
                defaultSpeechSHMAway = "Smart Home Monitor is now Armed in Away mode"
            }
            input name: "SHMTalkOnAway", type: "text", title: "${formatSettingRootStart}Say this when Armed, Away:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechSHMAway
			input name: "SHMTestOnAway", type: "bool", title: "${formatSettingOptionalStart}Toggle to test Armed, Away phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "SHMSpeechDeviceAway", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "SHMDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "SHMVolumeAway", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
            	input name: "SHMResumePlayAway", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "SHMVoiceAway", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("Restrictions (Armed, Away)"){
            input name: "SHMModesAway", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "SHMStartTimeAway", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "SHMEndTimeAway", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.SHMStartTimeAway == null))
            input name: "SHMAwayDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
        }
        section("Smart Home Monitor - Armed, Home"){
        	def defaultSpeechSHMHome = ""
            if ((!SHMTalkOnAway) && (!SHMTalkOnHome) && (!SHMTalkOnDisarm)) {
                defaultSpeechSHMHome = "Smart Home Monitor is now Armed in Home mode"
            }
            input name: "SHMTalkOnHome", type: "text", title: "${formatSettingRootStart}Say this when Armed, Home:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechSHMHome
			input name: "SHMTestOnHome", type: "bool", title: "${formatSettingOptionalStart}Toggle to test Armed, Home phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "SHMSpeechDeviceHome", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "SHMVolumeHome", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
            	input name: "SHMResumePlayHome", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "SHMVoiceHome", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("Restrictions (Armed, Home)"){
            input name: "SHMModesHome", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "SHMStartTimeHome", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "SHMEndTimeHome", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.SHMStartTimeHome == null))
            input name: "SHMHomeDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
        }
        section("Smart Home Monitor - Disarmed"){
        	def defaultSpeechSHMDisarm = ""
            if ((!SHMTalkOnAway) && (!SHMTalkOnHome) && (!SHMTalkOnDisarm)) {
                defaultSpeechSHMDisarm = "Smart Home Monitor is now Disarmed"
            }
            input name: "SHMTalkOnDisarm", type: "text", title: "${formatSettingRootStart}Say this when Disarmed:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechSHMDisarm
			input name: "SHMTestOnDisarm", type: "bool", title: "${formatSettingOptionalStart}Toggle to test Disarmed phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "SHMSpeechDeviceDisarm", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "SHMVolumeDisarm", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "SHMResumePlayDisarm", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "SHMVoiceDisarm", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("Restrictions (Disarmed)"){
            input name: "SHMModesDisarm", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "SHMStartTimeDisarm", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "SHMEndTimeDisarm", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.SHMStartTimeDisarm == null))
            input name: "SHMDisarmDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch - Deviates from standard template
		def phraseTestTogDeviceUpper = "SHM"
		def phraseTestTogDeviceLower = "shm"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Away"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice${phraseTestTogState}" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}", settings."${phraseTestTogDeviceLower}SpeechDevice${phraseTestTogState}", settings."${phraseTestTogDeviceLower}Volume${phraseTestTogState}", settings."${phraseTestTogDeviceLower}ResumePlay${phraseTestTogState}", settings."${phraseTestTogDeviceLower}Personality${phraseTestTogState}", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}${phraseTestTogState}" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}${phraseTestTogState}" //capture toggle switch state
        }
		phraseTestTogState = "Home"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice${phraseTestTogState}" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}", settings."${phraseTestTogDeviceLower}SpeechDevice${phraseTestTogState}", settings."${phraseTestTogDeviceLower}Volume${phraseTestTogState}", settings."${phraseTestTogDeviceLower}ResumePlay${phraseTestTogState}", settings."${phraseTestTogDeviceLower}Personality${phraseTestTogState}", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}${phraseTestTogState}" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}${phraseTestTogState}" //capture toggle switch state
        }
		phraseTestTogState = "Disarm"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice${phraseTestTogState}" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}", settings."${phraseTestTogDeviceLower}SpeechDevice${phraseTestTogState}", settings."${phraseTestTogDeviceLower}Volume${phraseTestTogState}", settings."${phraseTestTogDeviceLower}ResumePlay${phraseTestTogState}", settings."${phraseTestTogDeviceLower}Personality${phraseTestTogState}", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}${phraseTestTogState}" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}${phraseTestTogState}" //capture toggle switch state
        }
    }
//End pageConfigSHM()
}

def pageConfigTime(){
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
    dynamicPage(name: "pageConfigTime", title: "Configure talk at specific time", install: false, uninstall: false) {
        section("Schedule 1"){
            input name: "timeSlotDays1", type: "enum", title: "${formatSettingRootStart}Which day(s)${formatSettingRootEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "timeSlotTime1", type: "time", title: "${formatSettingRootStart}Time of day${formatSettingRootEnd}", required: false
            input name: "timeSlotTalkOnTime1", type: "text", title: "${formatSettingRootStart}Say on schedule:${formatSettingRootEnd}", required: false
			input name: "timeSlotTestOnTime1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test schedule phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "timeSlotPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "timeSlotSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "timeSlotVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "timeSlotResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "timeSlotVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("Restrictions (Schedule 1)"){
            input name: "timeSlotModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "timeSlotDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
		section("Schedule 2"){
            input name: "timeSlotDays2", type: "enum", title: "${formatSettingRootStart}Which day(s)${formatSettingRootEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "timeSlotTime2", type: "time", title: "${formatSettingRootStart}Time of day${formatSettingRootEnd}", required: false
            input name: "timeSlotTalkOnTime2", type: "text", title: "${formatSettingRootStart}Say on schedule:${formatSettingRootEnd}", required: false
			input name: "timeSlotTestOnTime2", type: "bool", title: "${formatSettingOptionalStart}Toggle to test schedule phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "timeSlotPersonality2", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "timeSlotSpeechDevice2", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "timeSlotVolume2", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "timeSlotResumePlay2", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "timeSlotVoice2", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("Restrictions (Schedule 2)"){
            input name: "timeSlotModes2", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "timeSlotDisableSwitch2", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
		section("Schedule 3"){
            input name: "timeSlotDays3", type: "enum", title: "${formatSettingRootStart}Which day(s)${formatSettingRootEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "timeSlotTime3", type: "time", title: "${formatSettingRootStart}Time of day${formatSettingRootEnd}", required: false
            input name: "timeSlotTalkOnTime3", type: "text", title: "${formatSettingRootStart}Say on schedule:${formatSettingRootEnd}", required: false
			input name: "timeSlotTestOnTime3", type: "bool", title: "${formatSettingOptionalStart}Toggle to test schedule phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "timeSlotPersonality3", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "timeSlotSpeechDevice3", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "timeSlotVolume3", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "timeSlotResumePlay3", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "timeSlotVoice3", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("Restrictions (Schedule 3)"){
            input name: "timeSlotModes3", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "timeSlotDisableSwitch3", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch - Deviates from standard template
		def phraseTestTogDeviceUpper = "TimeSlot"
		def phraseTestTogDeviceLower = "timeSlot"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Time1"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" //capture toggle switch state
        }
		phraseTestTogState = "Time2"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice2") { myVoice = settings?."${phraseTestTogDeviceLower}Voice2" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}", settings."${phraseTestTogDeviceLower}SpeechDevice2", settings."${phraseTestTogDeviceLower}Volume2", settings."${phraseTestTogDeviceLower}ResumePlay2", settings."${phraseTestTogDeviceLower}Personality2", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" //capture toggle switch state
        }
		phraseTestTogState = "Time3"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice3") { myVoice = settings?."${phraseTestTogDeviceLower}Voice3" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}", settings."${phraseTestTogDeviceLower}SpeechDevice3", settings."${phraseTestTogDeviceLower}Volume3", settings."${phraseTestTogDeviceLower}ResumePlay3", settings."${phraseTestTogDeviceLower}Personality3", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}" //capture toggle switch state
        }
    }
}

def pageConfigPowerMeter(){
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
    dynamicPage(name: "pageConfigPowerMeter", title: "Configure talk on power consumption", install: false, uninstall: false) {
        section(){
            def defaultSpeechPowerMeterRise1 = ""
            def defaultSpeechPowerMeterNormal1 = ""
            def defaultSpeechPowerMeterFall1 = ""
            state.powerMeterState = ""
            if (!powerMeterDeviceGroup1) {
                defaultSpeechPowerMeterRise1 = "%devicename% power level is high at %value% watts"
                defaultSpeechPowerMeterNormal1 = "%devicename% power level is within normal range"
                defaultSpeechPowerMeterFall1 = "%devicename% power level is low at %value% watts"
            }
            input name: "powerMeterDeviceGroup1", type: "capability.powerMeter", title: "${formatSettingRootStart}Power Meter(s)${formatSettingRootEnd}", required: false, multiple: true
            input name: "powerMeterTalkOnRise1", type: "text", title: "${formatSettingRootStart}Say this if power rises above threshold:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechPowerMeterRise1, submitOnChange: true
			input name: "powerMeterTestOnRise1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test power rise phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "powerMeterTalkOnFall1", type: "text", title: "${formatSettingRootStart}Say this if power falls below threshold:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechPowerMeterFall1, submitOnChange: true
			input name: "powerMeterTestOnFall1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test power fall phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "powerMeterTalkOnNormal1", type: "text", title: "${formatSettingRootStart}Say this if power returns to normal:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechPowerMeterNormal1, submitOnChange: false
			input name: "powerMeterTestOnNormal1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test power normal phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "powerMeterTalkOnRiseThold1", type: "number", title: "${formatSettingRootStart}High energy usage threshold (watts):${formatSettingRootEnd}", required: powerMeterTalkOnRise1, defaultValue: defaultSpeechpowerMeterRise1
            input name: "powerMeterTalkOnFallThold1", type: "number", title: "${formatSettingRootStart}Low energy usage threshold (watts):${formatSettingRootEnd}", required: powerMeterTalkOnFall1, defaultValue: defaultSpeechpowerMeterFall1
            input name: "powerMeterPersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "powerMeterSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "powerMeterVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "powerMeterResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "powerMeterVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "powerMeterModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "powerMeterStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "powerMeterEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.waterStartTime1 == null))
            input name: "powerMeterDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "powerMeterDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "PowerMeter"
		def phraseTestTogDeviceLower = "powerMeter"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Rise"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Fall"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
		phraseTestTogState = "Normal"
		if (state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null) {state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = false} //init var
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigpowerMeter()
}

def pageConfigRoutine(){
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
    dynamicPage(name: "pageConfigRoutine", title: "Configure talk when routine runs", install: false, uninstall: false) {
        section(){
            def defaultSpeechRoutine1 = ""
            if (!routineDeviceGroup1) {
                defaultSpeechRoutine1 = "%routine% routine has been run"
            }
            def routines = location.helloHome?.getPhrases()*.label
            if (routines) {
            	// sort them alphabetically
            	routines.sort()
            }
            input name: "routineDeviceGroup1", type: "enum", title: "${formatSettingRootStart}Routine${formatSettingRootEnd}", required: true, multiple: true, options: routines
            input name: "routineTalkOnRun1", type: "text", title: "${formatSettingRootStart}Say when this routine runs:${formatSettingRootEnd}", required: false, defaultValue: defaultSpeechRoutine1
			input name: "routineTestOnRun1", type: "bool", title: "${formatSettingOptionalStart}Toggle to test routine phrase${formatSettingOptionalEnd}", required: false, defaultValue: false, submitOnChange: true
            input name: "routinePersonality1", type: "enum", title: "${formatSettingOptionalStart}Allow Personality (overrides default)?:${formatSettingOptionalEnd}", required: false, options: ["Yes", "No"]
            input name: "routineSpeechDevice1", type: parent.returnVar("speechDeviceType"), title: "${formatSettingOptionalStart}Talk with these text-to-speech devices (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
            	input name: "routineVolume1", type: "number", title: "${formatSettingOptionalStart}Set volume to (overrides default):${formatSettingOptionalEnd}", required: false
                input name: "routineResumePlay1", type: "bool", title: "${formatSettingOptionalStart}Attempt to resume playing audio?${formatSettingOptionalEnd}", required: false, defaultValue: (parent.returnVar("resumePlay") == false) ? false : true
                input name: "routineVoice1", type: "enum", title: "${formatSettingOptionalStart}Voice (overrides default):${formatSettingOptionalEnd}", options: parent.returnVar("supportedVoices"), required: false, submitOnChange: true
            }
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Restrictions${formatCenterEnd}${formatSettingRootEnd}"){
            input name: "routineModes1", type: "mode", title: "${formatSettingOptionalStart}Talk when in these mode(s) (overrides default)${formatSettingOptionalEnd}", multiple: true, required: false
            input name: "routineStartTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk before (overrides default)${formatSettingOptionalEnd}", required: false, submitOnChange: true
            input name: "routineEndTime1", type: "time", title: "${formatSettingOptionalStart}Don't talk after (overrides default)${formatSettingOptionalEnd}", required: (!(settings.buttonStartTime1 == null))
            input name: "routineDays1", type: "enum", title: "${formatSettingOptionalStart}Restrict to these day(s)${formatSettingOptionalEnd}", required: false, options: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"], multiple: true
            input name: "routineDisableSwitch1", type: "capability.switch", title: "${formatSettingOptionalStart}Disable when this switch is off${formatSettingOptionalEnd}", required: false, multiple: false
        }
        section("${formatBr}${formatHr}${formatHr}${formatSettingRootStart}${formatCenterStart}Help${formatCenterEnd}${formatSettingRootEnd}"){
            href "pageHelpPhraseTokens", title:"Phrase Tokens", description:"Tap for a list of phrase tokens"
        }
		//Test Phrase Toggle Switch
		def phraseTestTogDeviceUpper = "Routine"
		def phraseTestTogDeviceLower = "routine"
		def phraseTestTogState = ""
		def testEvent = ""
		def myVoice = ""
		phraseTestTogState = "Run"
		if ((!(settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" == null)) && (settings?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" != state?."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1")) { //test toggle switch state
			testEvent = [displayName: "Big Talker Test", name: "${phraseTestTogDeviceUpper}${phraseTestTogState}Test", value: phraseTestTogState]
            myVoice = parent.returnVar("speechVoice")
			if (settings?."${phraseTestTogDeviceLower}Voice1") { myVoice = settings?."${phraseTestTogDeviceLower}Voice1" }
			sendTalk(app.label, settings."${phraseTestTogDeviceLower}TalkOn${phraseTestTogState}1", settings."${phraseTestTogDeviceLower}SpeechDevice1", settings."${phraseTestTogDeviceLower}Volume1", settings."${phraseTestTogDeviceLower}ResumePlay1", settings."${phraseTestTogDeviceLower}Personality1", myVoice, testEvent)
			state."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" = settings."${phraseTestTogDeviceLower}TestOn${phraseTestTogState}1" //capture toggle switch state
        }
    }
//End pageConfigRoutine()
}


def pageHelpPhraseTokens(){
	//KEEP IN SYNC WITH CHILD!
        dynamicPage(name: "pageHelpPhraseTokens", title: "Available Phrase Tokens", install: false, uninstall:false){
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

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

def initialize() {
    if (state.groupEnabled == true || state.groupEnabled == "true" || state.groupEnabled == null) {
    	app.updateLabel("${app.label.replace(" (disabled)","")}")
        initSchedule()
        initSubscribe()
        if (state.hubType == "SmartThings") {sendNotificationEvent("${app.label.replace(" ","").toUpperCase()}: Settings activated")}
        state.lastMode = location.mode
    }
    LOGTRACE("Initialized (Parent Version: ${parent.returnVar("version")}; Child Version: ${state.version}; Group Enabled: ${settings.groupEnabled})")
//End initialize()
}
def updated() {
    state.groupEnabled = settings.groupEnabled
	setVersion()
	LOGTRACE("Updating settings (Parent Version: ${parent.returnVar("version")}; Child Version: ${state.version}; Group Enabled: ${state.groupEnabled})")
    state.installed = true
    unschedule()
    unsubscribe()
    if (state.groupEnabled == true || state.groupEnabled == "true" || state.groupEnabled == null) { 
        initialize() 
    } else {
        if (!(app.label.contains(" (disabled)"))) { app.updateLabel("${app.label.replace("${app.label}","${app.label} (disabled)")}") }
	}
}
def installed() {
	state.groupEnabled = settings.groupEnabled
	setVersion()
	LOGTRACE("Installed (Parent Version: ${parent.returnVar("version")}; Child Version: ${state.version}; Group Enabled: ${state.groupEnabled})")
	state.installed = true
	if (state.groupEnabled == true || state.groupEnabled == "true" || state.groupEnabled == null) { 
        initialize() 
    } else {
        if (!(app.label.contains(" (disabled)"))) { app.updateLabel("${app.label.replace("${app.label}","${app.label} (disabled)")}") }
	}
}

def initSubscribe(){
    //NOTICE: Only call from initialize()!
    LOGDEBUG ("BEGIN initSubscribe()", true)
    //Subscribe Motions
    if (motionDeviceGroup1) { subscribe(motionDeviceGroup1, "motion", onMotion1Event) }
    //Subscribe Switches
    if (switchDeviceGroup1) { subscribe(switchDeviceGroup1, "switch", onSwitch1Event) }
    //Subscribe Presence
    if (presenceDeviceGroup1) { subscribe(presenceDeviceGroup1, "presence", onPresence1Event); LOGDEBUG("Subscribed to presence: ${presenceDeviceGroup1}",false) }
    //Subscribe Lock
    if (lockDeviceGroup1) { subscribe(lockDeviceGroup1, "lock", onLock1Event) }
    //Subscribe Contact
    if (contactDeviceGroup1) { subscribe(contactDeviceGroup1, "contact", onContact1Event) }
    //Subscribe Thermostat
    if (thermostatDeviceGroup1) { subscribe(thermostatDeviceGroup1, "thermostatOperatingState", onThermostat1Event) }
    //Subscribe Acceleration
    if (accelerationDeviceGroup1) { subscribe(accelerationDeviceGroup1, "acceleration", onAcceleration1Event) }
    //Subscribe Water
    if (waterDeviceGroup1) { subscribe(waterDeviceGroup1, "water", onWater1Event) }
    //Subscribe Smoke
    if (smokeDeviceGroup1) { subscribe(smokeDeviceGroup1, "smoke", onSmoke1Event) }
    //Subscribe Button
    if (buttonDeviceGroup1) { subscribe(buttonDeviceGroup1, "button", onButton1Event) }
	//Subscribe Alarm
    if (alarmDeviceGroup1) { subscribe(alarmDeviceGroup1, "alarm", onAlarm1Event) }
	//Subscribe Filter Status
    if (filterStatusDeviceGroup1) { subscribe(filterStatusDeviceGroup1, "filterstatus", onFilterStatus1Event) }
	//Subscribe Oven Mode
    if (ovenModeDeviceGroup1) { subscribe(ovenModeDeviceGroup1, "filterstatus", onOvenMode1Event) }
    //Subscribe SHM
    if (SHMTalkOnAway || SHMTalkOnHome || SHMTalkOnDisarm) { subscribe(location, "alarmSystemStatus", onSHMEvent) }
    //Subscribe PowerMeter
    if (powerMeterDeviceGroup1) { subscribe(powerMeterDeviceGroup1, "power", onPowerMeter1Event) }
    //Subscribe Routine
    if (routineDeviceGroup1) { subscribe(location, "routineExecuted", onRoutineEvent) }
    //Subscribe Mode
    if (modePhraseGroup1) { subscribe(location, "mode", onModeChangeEvent) }
    
    LOGDEBUG ("END initSubscribe()", true)
}

def initSchedule(){
    LOGDEBUG ("BEGIN initSchedule()", true)
    //Subscribe Schedule
    if (timeSlotTime1) { schedule(timeSlotTime1, onSchedule1Event) }
    if (timeSlotTime2) { schedule(timeSlotTime2, onSchedule2Event) }
    if (timeSlotTime3) { schedule(timeSlotTime3, onSchedule3Event) }
    LOGDEBUG ("END initSchedule()", true)
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// PROCESS RESTRICTIONS
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

def processRestrictions(devicetype,index){
	def allowed = true
    if (!(processDisableSwitch(devicetype,index))){
    	LOGDEBUG("RESTRICTION: Disable switch is set to disable", true)
        allowed = false
    }
	if (!(dayAllowed(devicetype,index))) {
    	LOGDEBUG("RESTRICTION: Remain silent today", true)
        allowed = false
    }
	if (!(timeAllowed(devicetype,index))) {
    	LOGDEBUG("RESTRICTION: Remain silent in current time period", true)
        allowed = false
    }
    if (!(devicetype == "mode")) {
    	if (!(modeAllowed(devicetype,index))) {
    		LOGDEBUG("RESTRICTION: Remain silent while in mode ${location.mode}", true)
        	allowed = false
    	}
    }
    //if (!(processCountRestriction(devicetype,index))){
    //}
    return allowed
}

def stringToDate(strToConvert){
	return Date.parse("yyyy-MM-dd'T'HH:mm:ss.SSSZ", strToConvert)
}

def timeAllowed(devicetype,index){
    def now = new Date()
    //Check Default Setting
    //devicetype = mode, motion, switch, presence, lock, contact, thermostat, acceleration, water, smoke, button
	if (!(settings."${devicetype}StartTime${index}" == null)){
		if (timeOfDayIsBetween(stringToDate(settings."${devicetype}StartTime${index}"), stringToDate(settings."${devicetype}EndTime${index}"), now, location.timeZone)) { return true } else { return false }
	}
    //No overrides have returned True, process Default
    if (parent.returnVar("defaultStartTime") == null) { 
    	return true 
    } else {
        if (timeOfDayIsBetween(parent.returnVar("defaultStartTime"), parent.returnVar("defaultEndTime"), now, location.timeZone)) { return true } else { return false }
    }
}

def modeAllowed(devicetype,index) {
    //Determine if we are allowed to speak in our current mode based on the calling device or default setting
    //devicetype = motion, switch, presence, lock, contact, thermostat, acceleration, water, smoke, button
	if (settings."${devicetype}Modes${index}") {
		if (settings."${devicetype}Modes${index}".contains(location.mode)){
			//Custom mode for this event is in use and we are in one of those modes
			return true
		} else {
			//Custome mode for this event is in use and we are not in one of those modes
			return false
		}
	} else {
		return (parent.returnVar("speechModesDefault").contains(location.mode)) //True if we are in an allowed Default mode, False if not
	}
}

def dayAllowed(devicetype,index){
	def allowedDays = []
	allowedDays = settings?."${devicetype}Days${index}"
	return processDayRestriction(allowedDays)
}

def processDayRestriction(allowedDays){
    def todayStr = (new Date().format('EEEE', location.timeZone))
    LOGDEBUG("Today=${todayStr}, Allowed:${allowedDays}", false)
    if (allowedDays == null || allowedDays == ""){
        return true
    }
    if (allowedDays.contains(todayStr) || allowedDays == null) {
        return true
    } else {
        return false
    }
}

def processCountRestriction(devicetype, index) {
// IN DEVELOPMENT 3/9/2018
		def maxCount = 0
        def countUnit = "None"
        switch(devicetype) {
        case "motion":
        	if (index == 1){
            	maxCount = settings?.motionCount1
                countUnit = settings?.motionCountUnit1
                //
                //switch(countUnit){
                //	case "Minute":
                //    	lastActive = getLastActivity()
                //    case "Hour": 
                //    case "Day": {}
                //}
                //return 
				processDayRestriction(allowedDays)
                //
                return true // Return allow by default during initial development
        	}
    }
}

def processDisableSwitch(devicetype, index) {
	LOGDEBUG("processDisableSwitch: ${devicetype}DisableSwitch${index}", false)
	try{
		if (settings?."${devicetype}DisableSwitch${index}".currentSwitch == "on" || settings?."${devicetype}DisableSwitch${index}" == null) {return true} else {return false}
	} catch(err) {
		return true
	}
}

def shouldDelay(devicetype, eventTime, thresholdMinutes) {
	// IN DEVELOPMENT
  	if (thresholdMinutes == null || thresholdMinutes == 0){ 
		LOGDEBUG("No threshold defined", true)
  		return false 
  	}
	def elapsed = now() - eventTime
    def threshold = ((thresholdMinutes != null && thresholdMinutes != "") ? thresholdMinutes * 60000 : 60000) - 1000
	LOGDEBUG("Threshold:${threshold},Elapsed:${elapsed}", false)
    if (elapsed >= threshold) {
        LOGDEBUG("${devicetype} has stayed open long enough since last check ($elapsed ms)", true)
        return false
    } else {
        LOGDEBUG("${devicetype} has not stayed open long enough since last check ($elapsed ms):  doing nothing", true)
    }
    return true
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//// General Functions
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

def getTimeFromDateString(inputtime, includeAmPm){
    //I couldn't find the way to do this in ST / Groovy, so I made my own function
    //Obtains the time from a supplied specifically formatted date string (ie: from a preference of type "time")
    //LOGDEBUG "InputTime: ${inputtime}", true"$
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
    //LOGDEBUG "OutputTime: ${outputtime}", true"$
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
    //LOGDEBUG("myRunIn(${delay_s},${func})", true)

    if (delay_s > 0) {
        def tms = now() + (delay_s * 1000)
        def date = new Date(tms)
        runOnce(date, func)
        //LOGDEBUG("'${func}' scheduled to run at ${date}", true)
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// HANDLE EVENTS
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//BEGIN HANDLE MOTIONS
def onMotion1Event(evt){
 	def deviceType = "motion" //lowercase first char
	def deviceState1 = "active"   //on,open,etc
	def deviceState2 = "inactive"  //off,closed,etc
	def deviceState3 = ""
	def deviceState4 = ""
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}
//END HANDLE MOTIONS

//BEGIN HANDLE SWITCHES
//START QUEUE FOR LEFT IN STATE -- IN DEVELOPMENT
def runQueuedSwitch1Event(){
	def deviceType = "switch" //lowercase first char
	def deviceState1 = "on"   //on,open,etc
	def deviceState2 = "off"  //off,closed,etc
	def deviceState3 = ""
	def deviceState4 = ""
	def index = 1
	def evt = [name: state.switch1EventName, displayName: state.switch1EventDisplayName, value: state.switch1EventValue]
	LOGDEBUG("Processing Queued Message: (${evt})", true)
	processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}
//END QUEUE FOR LEFT IN STATE -- IN DEVELOPMENT

def onSwitch1Event(evt){
	def deviceType = "switch" //lowercase first char
	def deviceState1 = "on"   //on,open,etc
	def deviceState2 = "off"  //off,closed,etc
	def deviceState3 = ""
	def deviceState4 = ""
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}
//END HANDLE SWITCHES

//BEGIN HANDLE PRESENCE
def onPresence1Event(evt){
	def deviceType = "presence" //lowercase first char
	def deviceState1 = "present"   //on,open,etc
	def deviceState2 = "not present"  //off,closed,etc
	def deviceState3 = ""
	def deviceState4 = ""
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
    //processPresenceEvent(1, evt)
}
//END HANDLE PRESENCE

//BEGIN HANDLE LOCK
def onLock1Event(evt){
	def deviceType = "lock" //lowercase first char
	def deviceState1 = "locked"   //on,open,etc
	def deviceState2 = "unlocked"  //off,closed,etc
	def deviceState3 = ""
	def deviceState4 = ""
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}

//END HANDLE LOCK

//BEGIN HANDLE CONTACT
def onContact1Event(evt){
	def deviceType = "contact" //lowercase first char
	def deviceState1 = "open"   //on,open,etc
	def deviceState2 = "closed"  //off,closed,etc
	def deviceState3 = ""
	def deviceState4 = ""
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}
//END HANDLE CONTACT

//BEGIN HANDLE THERMOSTAT
def onThermostat1Event(evt){
	def deviceType = "thermostat" //lowercase first char
	def deviceState1 = "idle"   //on,open,etc
	def deviceState2 = "heating"  //off,closed,etc
	def deviceState3 = "cooling"
	def deviceState4 = "fan only"
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
    //processThermostatEvent(1, evt)
}
//END HANDLE THERMOSTAT

//BEGIN HANDLE ACCELERATION
def onAcceleration1Event(evt){
	def deviceType = "acceleration" //lowercase first char
	def deviceState1 = "active"   //on,open,etc
	def deviceState2 = "inactive"  //off,closed,etc
	def deviceState3 = ""
	def deviceState4 = ""
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}
//END HANDLE ACCELERATION

//BEGIN HANDLE WATER
def onWater1Event(evt){
    def deviceType = "water" //lowercase first char
	def deviceState1 = "wet"   //on,open,etc
	def deviceState2 = "dry"  //off,closed,etc
	def deviceState3 = ""
	def deviceState4 = ""
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}
//END HANDLE WATER

//BEGIN HANDLE SMOKE
def onSmoke1Event(evt){
	def deviceType = "smoke" //lowercase first char
	def deviceState1 = "detected"   //on,open,etc
	def deviceState2 = "clear"  //off,closed,etc
	def deviceState3 = "tested"
	def deviceState4 = ""
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}
//END HANDLE SMOKE

//BEGIN HANDLE BUTTON
def onButton1Event(evt){
	def deviceType = "button" //lowercase first char
	def deviceState1 = "pushed"   //on,open,etc
	def deviceState2 = "held"  //off,closed,etc
	def deviceState3 = ""
	def deviceState4 = ""
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}

//END HANDLE BUTTON

//BEGIN HANDLE ALARM
def onAlarm1Event(evt){
	def deviceType = "alarm" //lowercase first char
	def deviceState1 = "off"   //on,open,etc
	def deviceState2 = "strobe"  //off,closed,etc
	def deviceState3 = "siren"
	def deviceState4 = "both"
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}

//END HANDLE ALARM

//BEGIN HANDLE FILTER STATUS
def onFilterStatus1Event(evt){
	def deviceType = "filterStatus" //lowercase first char
	def deviceState1 = "normal"   //on,open,etc
	def deviceState2 = "replace"  //off,closed,etc
	def deviceState3 = ""
	def deviceState4 = ""
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}

//END HANDLE FILTER STATUS

//BEGIN HANDLE OVEN MODE
def onOvenMode1Event(evt){
	def deviceType = "ovenMode" //lowercase first char
	def deviceState1 = "heating"   //on,open,etc
	def deviceState2 = "grill"  //off,closed,etc
	def deviceState3 = "warming"
	def deviceState4 = "defrosting"
	def index = 1
	if (!(evt?.device.name == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.name }
	if (!(evt?.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.displayName }
	if (!(evt?.device.displayName == null)) { state."${deviceType}${index}EventDisplayName" = evt.device.displayName }
	state."${deviceType}${index}EventDisplayName" = evt.displayName
	state."${deviceType}${index}EventName" = evt.name
	state."${deviceType}${index}EventValue" = evt.value
	state."${deviceType}${index}EventTime" = now()
	LOGDEBUG("(on${deviceType}${index}Event)StateSet:" + state."${deviceType}${index}EventName" + "-" + state."${deviceType}${index}EventDisplayName" + "-" + state."${deviceType}${index}EventValue" + "(" + state."${deviceType}${index}EventValue".capitalize() + ")",false)
    processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt)
}

//END HANDLE OVEN MODE

////BEGIN PROCESSEVENT
def processEvent(deviceType, deviceState1, deviceState2, deviceState3, deviceState4, index, evt){
	def resume = ""; resume = parent.returnVar("resumePlay"); if (resume == "") { resume = true }
    def personality = ""; personality = parent.returnVar("personalityMode"); if (personality == "" || personality == null) { personality = false }
    def myVolume = -1
	def myVoice = getMyVoice(settings?."${deviceType}Voice${index}")
	LOGDEBUG("(processEvent(): ${evt.name}, ${index}, ${evt.value}, ${myVoice}", true)
    //Check Restrictions
	if (!(processRestrictions("${deviceType}",index))){ return }
	//LOGDEBUG("VarCheck" + (evt.value == "${deviceState1}") + "," + deviceType + "," + state."${deviceType}${index}EventTime" + "," + settings."${deviceType}${deviceState1.capitalize()}Threshold",False)
	// START QUEUE FOR LEFT IN STATE -- IN DEVELOPMENT
	/*
	if (evt.value == "${deviceState1}" && shouldDelay(deviceType, state."${deviceType}${index}EventTime", settings."${deviceType}${deviceState1.capitalize()}Threshold")) {
		runIn(60, "runQueued${deviceType.capitalize()}${index}Event", [overwrite: false])
		LOGDEBUG("Queued message",true)
        return
    }
	unschedule("runQueued${deviceType.capitalize()}${index}Event")
    */
	// END QUEUE FOR LEFT IN STATE -- IN DEVELOPMENT
    state.TalkPhrase = null
    state.speechDevice = null
	if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
		if (index == 1) {
			if (!(settings?.switchResumePlay1 == null)) { resume = settings.switchResumePlay1 }
		}
        if (resume == null) { resume = true }
	} else { resume = false }
	if (settings?."${deviceType}Personality${index}" == "Yes") {personality = true}
	if (settings?."${deviceType}Personality${index}" == "No") {personality = false}
    if (evt.value == deviceState1) {
		state.TalkPhrase = settings."${deviceType}TalkOn${deviceState1.capitalize()}${index}"; state.speechDevice = settings."${deviceType}SpeechDevice${index}"; myVolume = getDesiredVolume(settings."${deviceType}Volume${index}")
        if (!(state?.TalkPhrase == null)) {sendTalk(app.label,state.TalkPhrase, state.speechDevice, myVolume, resume, personality, myVoice, evt)} else {LOGDEBUG("Not configured to speak for this event (${evt.value} <> ${deviceState1})", true)}
    }
    if (evt.value == deviceState2) {
        state.TalkPhrase = settings."${deviceType}TalkOn${deviceState2.capitalize()}${index}"; state.speechDevice = settings."${deviceType}SpeechDevice${index}"; myVolume = getDesiredVolume(settings."${deviceType}Volume${index}")
        if (!(state?.TalkPhrase == null)) {sendTalk(app.label,state.TalkPhrase, state.speechDevice, myVolume, resume, personality, myVoice, evt)} else {LOGDEBUG("Not configured to speak for this event (${evt.value} <> ${deviceState2})", true)}
    }
	if (evt.value == deviceState3) {
        state.TalkPhrase = settings."${deviceType}TalkOn${deviceState3.capitalize()}${index}"; state.speechDevice = settings."${deviceType}SpeechDevice${index}"; myVolume = getDesiredVolume(settings."${deviceType}Volume${index}")
        if (!(state?.TalkPhrase == null)) {sendTalk(app.label,state.TalkPhrase, state.speechDevice, myVolume, resume, personality, myVoice, evt)} else {LOGDEBUG("Not configured to speak for this event (${evt.value} <> ${deviceState3})", true)}
    }
	if (evt.value == deviceState4) {
        state.TalkPhrase = settings."${deviceType}TalkOn${deviceState4.capitalize()}${index}"; state.speechDevice = settings."${deviceType}SpeechDevice${index}"; myVolume = getDesiredVolume(settings."${deviceType}Volume${index}")
        if (!(state?.TalkPhrase == null)) {sendTalk(app.label,state.TalkPhrase, state.speechDevice, myVolume, resume, personality, myVoice, evt)} else {LOGDEBUG("Not configured to speak for this event (${evt.value} <> ${deviceState3})", true)}
    }
    state.TalkPhrase = null
    state.speechDevice = null
}
////END PROCESSEVENT

///////////////////////////////////////
///////////////////////////////////////
// SPECIAL DEVICES / PROCESSING      //
///////////////////////////////////////
///////////////////////////////////////

//BEGIN MODE CHANGE
def onModeChangeEvent(evt){
    processModeChangeEvent(1, evt)
}
def processModeChangeEvent(index, evt){
	def resume = ""; resume = parent.returnVar("resumePlay"); if (resume == "") { resume = true }
    def personality = ""; personality = parent.returnVar("personalityMode"); if (personality == "" || personality == null) { personality = false }
    def myVolume = -1
    def myVoice = getMyVoice(settings?.modeVoice1)
    LOGDEBUG("(onModeEvent): Last Mode: ${state.lastMode}, New Mode: ${location.mode}, ${myVoice}", true)
	//LOGDEBUG("(onModeEvent): Restricted FROM modes: ${settings.modeExcludePhraseGroup1}",true)
	//LOGDEBUG("(onModeEvent): FROM restriction test: ${(settings.modeExcludePhraseGroup1.contains(state.lastMode))},${(!(settings.modeExcludePhraseGroup1 == null))}",true)
    //Check Restrictions
    if (!(processRestrictions("mode",index))){ return }
	if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
		if (index == 1) {
			if (!settings?.modePhraseResumePlay1 == null) { resume = settings.modePhraseResumePlay1 }
		}
        if (resume == null) { resume = true }
	} else { resume = false }
    if (settings?.modePersonality1 == "Yes") {personality = true}
    if (settings?.modePersonality1 == "No") {personality = false}
    if (settings.modePhraseGroup1.contains(location.mode)){
        if (!(settings.modeExcludePhraseGroup1 == null)){
            //settings.modeExcluePhraseGroup1 is not empty
            if ((settings.modeExcludePhraseGroup1.contains(state.lastMode)) == false) {
				//LOGDEBUG("onModeEvent(): Exclusion modes exist but we are not coming from one of them",true)
                //If we are not coming from an exclude mode, Talk.
                state.TalkPhrase = null
                state.speechDevice = null
                state.TalkPhrase = settings.modeTalkOnChange1; state.speechDevice = modePhraseSpeechDevice1; myVolume = getDesiredVolume(settings.modePhraseVolume1)
                if (!(state?.TalkPhrase == null)) {sendTalk(app.label,state.TalkPhrase, state.speechDevice, myVolume, resume, personality, myVoice, evt)} else {LOGDEBUG("Not configured to speak for this event", true)}
                state.TalkPhrase = null
                state.speechDevice = null
            } else {
                LOGDEBUG("Mode change silent due to exclusion configuration (${state.lastMode} >> ${location.mode})", true)
            }
        } else {
            //settings.modeExcluePhraseGroup1 is empty, no exclusions, Talk.
			//LOGDEBUG("onModeEvent(): Exclusion modes do not exist",true)
            state.TalkPhrase = null
            state.speechDevice = null
            state.TalkPhrase = settings.TalkOnModeChange1; state.speechDevice = modePhraseSpeechDevice1; myVolume = getDesiredVolume(settings.modePhraseVolume1)
            if (!(state?.TalkPhrase == null)) {sendTalk(app.label,state.TalkPhrase, state.speechDevice, myVolume, resume, personality, myVoice, evt)} else {LOGDEBUG("Not configured to speak for this event", true)}
            state.TalkPhrase = null
            state.speechDevice = null
        }
    }
	state.lastMode = location.mode
}
//END MODE CHANGE

//BEGIN HANDLE SHM
def onSHMEvent(evt){
	if (evt.value == "away") {processSHMEvent(1, evt)}
    if (evt.value == "stay") {processSHMEvent(2, evt)}
    if (evt.value == "off") {processSHMEvent(3, evt)}
}

def processSHMEvent(index, evt){
	def resume = ""; resume = parent.returnVar("resumePlay"); if (resume == "") { resume = true }
    def personality = ""; personality = parent.returnVar("personalityMode"); if (personality == "" || personality == null) { personality = false }
    def myVolume = -1
    def myVoice = ""
    LOGDEBUG("(onSHMEvent): ${evt.name}, ${index}, ${evt.value}, NotSetYet", true)
	//Check Restrictions
    if (!(processRestrictions("SHM",index))){ return }
    state.TalkPhrase = null
    state.speechDevice = null
	if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
		if (index == 1) {
			if (!settings?.SHMResumePlayAway == null) { resume = settings.SHMResumePlayAway }
            if (settings?.SHMVoiceAway) { myVoice = getMyVoice(settings?.SHMVoiceAway) }
		}
		if (index == 2) {
			if (!settings?.SHMResumePlayHome == null) { resume = settings.SHMResumePlayHome }
            if (settings?.SHMVoiceHome) { myVoice = getMyVoice(settings?.SHMVoiceHome) }
		}
		if (index == 3) {
			if (!settings?.SHMResumePlayDisarm == null) { resume = settings.SHMResumePlayDisarm }
            if (settings?.SHMVoiceDisarm) { myVoice = getMyVoice(settings?.SHMVoiceDisarm) }
		}
        if (resume == null) { resume = true }
	} else { resume = false }
    if (settings?.SHMPersonality == "Yes") {personality = true}
    if (settings?.SHMPersonality == "No") {personality = false}
    if (index == 1) {state.TalkPhrase = settings.SHMTalkOnAway; state.speechDevice = SHMSpeechDeviceAway; myVolume = getDesiredVolume(settings.SHMVolumeAway)}
    if (index == 2) {state.TalkPhrase = settings.SHMTalkOnHome; state.speechDevice = SHMSpeechDeviceHome; myVolume = getDesiredVolume(settings.SHMVolumeHome)}
    if (index == 3) {state.TalkPhrase = settings.SHMTalkOnDisarm; state.speechDevice = SHMSpeechDeviceDisarm; myVolume = getDesiredVolume(settings.SHMVolumeDisarm)}
    if (!(state?.TalkPhrase == null)) {sendTalk(app.label,state.TalkPhrase, state.speechDevice, myVolume, resume, personality, myVoice, evt)} else {LOGDEBUG("Not configured to speak for this event", true)}
    state.TalkPhrase = null
    state.speechDevice = null
}
//END HANDLE SHM

//BEGIN HANDLE ENERGY METER
def onPowerMeter1Event(evt){
    processPowerMeterEvent(1, evt)
}

def processPowerMeterEvent(index, evt){
	def resume = ""; resume = parent.returnVar("resumePlay"); if (resume == "") { resume = true }
    def personality = ""; personality = parent.returnVar("personalityMode"); if (personality == "" || personality == null) { personality = false }
    def myVolume = -1
    def myVoice = getMyVoice(settings?.buttonVoice1)
    def energySpeak = false
    def powerLevel = 0
    def deviceName = ""
    try {
		deviceName = evt.displayName  //User given name of the device triggering the event
    } catch (ex) { 
    	LOGDEBUG("processPowerMeterEvent() evt.displayName failed; trying evt.device.displayName", false)
        try {
        	deviceName = evt.device.displayName //User given name of the device triggering the event
		} catch (ex2) {
			LOGDEBUG("processPowerMeterEvent() evt.device.displayName filed; trying evt.device.name")
			try {
				deviceName = evt.device.name //SmartThings name for the device triggering the event
			} catch (ex3) {
				LOGDEBUG("processPowerMeterEvent() evt.device.name filed; Giving up")
				deviceName = "Unknown"
			}
		}
	}
    //powerLevel = Math.round(evt.value.toDouble()).toString()
    try {
    	powerLevel = evt?.value?.toDouble()?.trunc()?.toString()?.replace(".0","")
    } catch (err) {
    	powerLevel = evt?.value
    }
    LOGDEBUG("(onPowerMeterEvent): ${evt.name}, ${index}, ${evt.value}, ${powerLevel}, ${myVoice}", true)
	//Check Restrictions
    if (!(processRestrictions("powerMeter",index))){ return }
    state.TalkPhrase = null
    state.speechDevice = null
	if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
		if (index == 1) {
			if (!settings?.powerMeterResumePlay1 == null) { resume = settings.powerMeterResumePlay1 }
		}
        if (resume == null) { resume = true }
	} else { resume = false }
    if (settings?.powerMeterPersonality1 == "Yes") {personality = true}
    if (settings?.powerMeterPersonality1 == "No") {personality = false}
    if (!(state?.powerMeterState.contains("|${deviceName}-"))) {
    	state.powerMeterState = "${state.powerMeterState}|${deviceName}-UNKNOWN|"
    }
    //HIGH
    if (powerLevel?.toDouble() > settings?.powerMeterTalkOnRiseThold1?.toDouble()) { 
    	if ((!(state?.powerMeterState?.contains("|${deviceName}-HIGH|"))) && energySpeak == false) { 
        	state.powerMeterState = state.powerMeterState.replace("|${deviceName}-UNKNOWN|","|${deviceName}-HIGH|")
            state.powerMeterState = state.powerMeterState.replace("|${deviceName}-NORMAL|","|${deviceName}-HIGH|")
            state.powerMeterState = state.powerMeterState.replace("|${deviceName}-LOW|","|${deviceName}-HIGH|")
            energySpeak = true 
        }
    }
    //NORMAL
    if (((powerLevel?.toDouble() > settings?.powerMeterTalkOnFallThold1?.toDouble()) || settings?.powerMeterTalkOnFallThold1?.toDouble() == 0) && (powerLevel?.toDouble() < settings?.powerMeterTalkOnRiseThold1?.toDouble())) { 
    	if ((!(state?.powerMeterState?.contains("|${deviceName}-NORMAL|"))) && energySpeak == false) { 
        	state.powerMeterState = state.powerMeterState.replace("|${deviceName}-UNKNOWN|","|${deviceName}-NORMAL|")
            state.powerMeterState = state.powerMeterState.replace("|${deviceName}-LOW|","|${deviceName}-NORMAL|")
            state.powerMeterState = state.powerMeterState.replace("|${deviceName}-HIGH|","|${deviceName}-NORMAL|")
            energySpeak = true 
        }
        if (settings?.powerMeterTalkOnFallThold1?.toDouble() == 0) { 
        	// If Low = 0, Then override LOW alert, we've returned to Normal (can't go lower).
        	state.powerMeterState = state.powerMeterState.replace("|${deviceName}-UNKNOWN|","|${deviceName}-NORMAL|")
            state.powerMeterState = state.powerMeterState.replace("|${deviceName}-HIGH|","|${deviceName}-NORMAL|")
        }
    }
    //LOW
    if ((powerLevel?.toDouble() < settings?.powerMeterTalkOnFallThold1?.toDouble()) && settings?.powerMeterTalkOnFallThold1?.toDouble() > 0) { 
    	if ((!(state?.powerMeterState?.contains("|${deviceName}-LOW|"))) && energySpeak == false) { 
        	state.powerMeterState = state.powerMeterState.replace("|${deviceName}-UNKNOWN|","|${deviceName}-LOW|")
            state.powerMeterState = state.powerMeterState.replace("|${deviceName}-NORMAL|","|${deviceName}-LOW|")
            state.powerMeterState = state.powerMeterState.replace("|${deviceName}-HIGH|","|${deviceName}-LOW|")
            energySpeak = true 
        }
    }
    if (index == 1 && state.powerMeterState.contains("|${deviceName}-HIGH|") && energySpeak) {state.TalkPhrase = settings.powerMeterTalkOnRise1; state.speechDevice = powerMeterSpeechDevice1; myVolume = getDesiredVolume(settings.powerMeterVolume1)}
    if (index == 1 && state.powerMeterState.contains("|${deviceName}-NORMAL|") && energySpeak) {state.TalkPhrase = settings.powerMeterTalkOnNormal1; state.speechDevice = powerMeterSpeechDevice1; myVolume = getDesiredVolume(settings.powerMeterVolume1)}
    if (index == 1 && state.powerMeterState.contains("|${deviceName}-LOW|") && energySpeak) {state.TalkPhrase = settings.powerMeterTalkOnFall1; state.speechDevice = powerMeterSpeechDevice1; myVolume = getDesiredVolume(settings.powerMeterVolume1)}
    LOGDEBUG("energySpeak=${energySpeak}, powerLevel=${powerLevel}, state.powerMeterState=${state.powerMeterState}", false)
    if (!(state?.TalkPhrase == null)) {
    	if (state.TalkPhrase.toLowerCase().contains("%value%")) { 
    		state.TalkPhrase = state.TalkPhrase.toLowerCase().replace("%value%",powerLevel)
    	}
    	sendTalk(app.label,state.TalkPhrase, state.speechDevice, myVolume, resume, personality, myVoice, evt)
    } else {
    	LOGDEBUG("Not configured to speak for this event", true)
    }
    state.TalkPhrase = null
    state.speechDevice = null
}
//END HANDLE ENERGY METER

//BEGIN HANDLE ROUTINE
def onRoutineEvent(evt){
	if (settings?.routineDeviceGroup1?.contains(evt.displayName)){
    	//Only process configured routines
    	processRoutineEvent(1, evt)
    }
}

def processRoutineEvent(index, evt){
	def resume = ""; resume = parent.returnVar("resumePlay"); if (resume == "") { resume = true }
    def personality = ""; personality = parent.returnVar("personalityMode"); if (personality == "" || personality == null) { personality = false }
    def myVolume = -1
    def myVoice = getMyVoice(settings?.routineVoice1)
    LOGDEBUG("(onRoutineEvent): ${evt.displayName}, ${index}, '${evt.displayName}' executed, ${myVoice}", true)
	//Check Restrictions
    if (!(processRestrictions("routine",index))){ return }
    state.TalkPhrase = null
    state.speechDevice = null
	if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
		if (index == 1) {
			if (!settings?.routineResumePlay1 == null) { resume = settings.routineResumePlay1 }
		}
        if (resume == null) { resume = true }
	} else { resume = false }
    if (settings?.routinePersonality1 == "Yes") {personality = true}
    if (settings?.routinePersonality1 == "No") {personality = false}
    if (index == 1) { state.TalkPhrase = settings.routineTalkOnRun1; state.speechDevice = routineSpeechDevice1; myVolume = getDesiredVolume(settings.routineVolume1)}
    if (state.TalkPhrase.toLowerCase().contains("%routine%")) { 
    	state.TalkPhrase = state.TalkPhrase.toLowerCase().replace("%routine%",evt.displayName)
    }
    if (!(state?.TalkPhrase == null)) {sendTalk(app.label,state.TalkPhrase, state.speechDevice, myVolume, resume, personality, myVoice, evt)} else {LOGDEBUG("Not configured to speak for this event", true)}
    state.TalkPhrase = null
    state.speechDevice = null
}
//END HANDLE ROUTINE

//BEGIN HANDLE TIME SCHEDULE
def onSchedule1Event(){
    processScheduledEvent(1, timeSlotTime1, timeSlotDays1)
}
def onSchedule2Event(){
    processScheduledEvent(2, timeSlotTime2, timeSlotDays2)
}
def onSchedule3Event(){
    processScheduledEvent(3, timeSlotTime3, timeSlotDays3)
}

def processScheduledEvent(index, eventtime, alloweddays){
	
	def resume = ""; resume = parent.returnVar("resumePlay")
    if (resume == "" || resume == null) { resume = false }
    def personality = ""; personality = parent.returnVar("personalityMode"); if (personality == "" || personality == null) { personality = false }
    def timeNow = getTimeFromCalendar(false, true)
    //def personality = false; personality = parent.returnVar("personalityMode
    //if (personality == "" || personality == null) { personality = false }
    def myVolume = -1
    def myVoice = ""
    if (index == 1) {myVoice = getMyVoice(settings?.timeSlotVoice1)}
    if (index == 2) {myVoice = getMyVoice(settings?.timeSlotVoice2)}
    if (index == 3) {myVoice = getMyVoice(settings?.timeSlotVoice3)}
    LOGDEBUG("(onScheduledEvent): ${timeNow}, ${index}, ${myVoice}", true)
    //Check Restrictions
    if (!(processRestrictions("timeSlot",index))){ return }
	if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
		if (index == 1){if (!settings?.timeSlotResumePlay1 == null) { resume = settings.timeSlotResumePlay1 }}
		if (index == 2){if (!settings?.timeSlotResumePlay2 == null) { resume = settings.timeSlotResumePlay2 }}
		if (index == 3){if (!settings?.timeSlotResumePlay3 == null) { resume = settings.timeSlotResumePlay3 }}
	}
	if (resume == null) { resume = true } else { resume = false }
    if (index == 1 && settings?.timeSlotPersonality1 == "Yes") {personality = true}
    if (index == 1 && settings?.timeSlotPersonality1 == "No") {personality = false}
	if (index == 2 && settings?.timeSlotPersonality2 == "Yes") {personality = true}
    if (index == 2 && settings?.timeSlotPersonality2 == "No") {personality = false}
    if (index == 3 && settings?.timeSlotPersonality3 == "Yes") {personality = true}
    if (index == 3 && settings?.timeSlotPersonality3 == "No") {personality = false}  
	if (index == 1) { state.TalkPhrase = settings.timeSlotTalkOnTime1; state.speechDevice = timeSlotSpeechDevice1; myVolume = getDesiredVolume(settings.timeSlotVolume1) }
	if (index == 2) { state.TalkPhrase = settings.timeSlotTalkOnTime2; state.speechDevice = timeSlotSpeechDevice2; myVolume = getDesiredVolume(settings.timeSlotVolume2) }
	if (index == 3) { state.TalkPhrase = settings.timeSlotTalkOnTime3; state.speechDevice = timeSlotSpeechDevice3; myVolume = getDesiredVolume(settings.timeSlotVolume3) }
	def customevent = [displayName: 'BigTalker:OnSchedule', name: 'OnSchedule', value: "${todayStr}@${timeNow}"]
	sendTalk(app.label,state.TalkPhrase, state.speechDevice, myVolume,resume, personality, myVoice, customevent)
	state.TalkPhrase = null
    state.speechDevice = null
}
//END HANDLE TIME SCHEDULE

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
def getDesiredVolume(invol) {
	def globalVolume = parent.returnVar("speechVolume")
    def globalMinimumVolume = parent.returnVar("speechMinimumVolume")
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
    if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") { 
    	LOGDEBUG("finalVolume: ${finalVolume}", true)
    }
    return finalVolume
}

def getMyVoice(deviceVoice){
    def myVoice = "Not Used"
    if (!(deviceVoice == null )) { myVoice = deviceVoice }
    if (parent.returnVar("speechDeviceType") == "capability.musicPlayer") {
    	LOGDEBUG("getMyVoice: deviceVoice=${myVoice}",false)
        LOGDEBUG("getMyVoice: settings.parent.speechVoice=${parent.returnVar("speechVoice")}",false)
		myVoice = (!(deviceVoice == null || deviceVoice == "")) ? deviceVoice : (parent.returnVar("speechVoice") ? parent.returnVar("speechVoice") : "Salli(en-us)")
    }
    return myVoice
}

def sendTalk(appname, phrase, customSpeechDevice, volume, resume, personality, voice, evt){
    LOGDEBUG("parent.Talk(app=Me,customdevice=${customSpeechDevice},volume=${volume},resume=${resume},personality=${personality},voice=${voice},evt=${evt},phrase=${phrase})", false)
	parent.Talk(appname, phrase, customSpeechDevice, volume, resume, personality, voice, evt)
}

def LOGDEBUG(txt, send){
	if (txt == null) { 
		log.debug "Debug log data was null"
		if (send == true) { parent.LOGDEBUG("[CHILD:${app.label}] Debug log data was null") }
	}
	if (send == true || send == null || send == "") { def sendToParent = true } else { def sendToParent = false }
	if (parent?.returnVar("debugMode") && sendToParent) {parent.LOGDEBUG("[CHILD:${app?.label}] ${txt}")}
    try {
    	if (parent?.returnVar("debugMode") || sendToParent == false) { log.debug("BIGTALKER2-CHILD[${app?.label?.replace(" ","").toUpperCase()}](${state.version}) || ${txt}")}
    } catch(ex) {
		log.error("LOGDEBUG unable to output requested data! || ${txt} || ERR(${ex})")
    }
}
def LOGTRACE(txt){
	parent.LOGTRACE("[CHILD:${app.label}] ${txt}")
    try {
    	log.trace("BIGTALKER2-CHILD[${app.label.replace(" ","").toUpperCase()}](${state.version}) || ${txt}")
    } catch(ex) {
    	log.error("LOGTRACE unable to output requested data!")
    }
}
def LOGERROR(txt){
	parent.LOGERROR("[CHILD:${app.label}] ${txt}")
    try {
    log.error("BIGTALKER2-CHILD[${app.label.replace(" ","").toUpperCase()}](${state.version}) || ERROR: ${txt}")
    } catch(ex) {
    	log.error("LOGERROR unable to output requested data!")
    }
}

def version(){
    resetBtnName()
	//schedule("0 0 9 ? * FRI *", updateCheck) //  Check for updates at 9am every Friday
	updateCheck()  
    //checkButtons()
    //pauseOrNot()
    
}

def checkButtons(){
    LOGDEBUG("Running checkButtons",false)
    appButtonHandler("updateBtn")
}


def appButtonHandler(btn){
    state.btnCall = btn
    if(state.btnCall == "updateBtn"){
       log.info "Checking for updates now..."
        updateCheck()
        pause(3000)
  		state.btnName = state.versionBtn
        runIn(2, resetBtnName)
    }
    if(state.btnCall == "updateBtn1"){
    state.btnName = "Update Available - Click Here" 
    //httpGet("https://github.com/CobraVmax/Hubitat/tree/master/Apps' target='_blank")
    }
    
}   
def resetBtnName(){
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
    def versionInfo = ""
	versionInfo = "${formatHr}${formatHr}${formatStrongStart}${formatCenterStart}Version Information${formatCenterEnd}${formatStrongEnd}${formatBr}"
	if(state.versionStatus){
    	if (state.hubType == "Hubitat") {
			versionInfo += "<img src='http://lowrance.cc/ST/icons/BigTalker-CurrentVersion.png'</img>${formatBr}${state.ExternalName} - Version: ${state.version} ${formatBr}<font face='Lucida Handwriting'>${state.Copyright} </font>"
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
	if (state?.versionStatus == null) { state.versionStatus = "${formatIStart}Unknown${formatIEnd}" }
	def paramsUD = [uri: "https://lowrance.cc/ST/manifests/RayzurCodeHE.json"]
	if (updateCheckAllowed() || lastKnownVersionStatus == "${formatIStart}Unknown${formatIEnd}" || lastKnownVersionStatus == null){
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
					state.versionStatus = "${formatStrongStart}** This app is no longer supported by ${state.author}  **${formatStrongEnd}"  
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
	LOGDEBUG("updateCheckAllowed() timeDiff=${timeDiff}, proceed=${proceed}", false)
	if (proceed) {
		//log.debug("updateCheckAllowed(): result: proceed")
		state.updateNextCheckDate = new Date().getTime() + updateCheckIntervalInMil
		return true
	} else { 
		//log.debug("updateCheckAllowed(): result: do not proceed (${timeDiff})")
		return false
	}
	
}

def setVersion(){
		state.version = "2.1.2.0"	 
		state.InternalName = "BigTalker2-Child-DEV" 
		state.ExternalName = "BigTalker2 Child-DEV"
		state.updateActiveUseIntervalMin = 30 //time in minutes to check for updates while using the App
}
