Java latest version
Java JDK 8 or latest -> Set the env variable for JDK (remeber to add %VARIABLE% to the system recognize it as env variable)
For VS Code must install the Extension pack for Java
Android Studio -> SDK Manager -> SDK Platforms - latest 2 android versions -> SDK Tools - Android Emulator, Android SDK Build Tools and Android SDK Platform Tools...
...Before click OK button, copy Android SDK Location to configure ANDROID_HOME to env variable
After set up all the env variable, restart the system and then run in cmd the following commands: adb, emulator and uiautomatorviewer, if it´s all ok, a message after each command must be displayed
Create a new project in Android Studio, go to Device Manager and create a new device, remember to select the latest stable Android Version
After the device be successfuly created, you can close Android Studio
To open the emulator, use the following command: emulator @emulator_name (you cand find the emulator name using the command: emulator -list-avds)
Intall Appium desktop and Appium Inspector:
Appium Desktop: https://github.com/appium/appium-desktop/releases
Appium Inspector: https://github.com/appium/appium-inspector/releases
Open Appium desktop and set all these capabilities:
"platformName", "Android"
"deviceName", "emulator"
"automationName", "uiautomator2"
"appPackage", "com.ctappium" //-> App package found in the step bellow
"appActivity", "com.ctappium.MainActivity" //-> App Activity found in the step bellow

Open CMD and input the command line: emulator -list-avds
copy the device name
run the command emulator @device_name
Open a new cmd windows and run the command adb shell
Open some app on android emulator
now in CMD run the command: dumpsys window windows
Ctrl+F to find the app by name
Back to Appium and set the Remote Path to "/wd/hub and then "Start Session"
You Should be able to access and code the first actions on the emulator

Videos for env setup:
Java JDK: https://www.youtube.com/watch?v=pssv4KwkpBM&list=PL0jj4QpaE1wp-e_EzRPxYIPKVl601RpcL
Android Studio and Appium: https://www.youtube.com/watch?v=xB_nF6hKocg&list=PL0jj4QpaE1wp-e_EzRPxYIPKVl601RpcL&index=2
Appium 2: https://www.youtube.com/watch?v=xB_nF6hKocg&list=PL0jj4QpaE1wp-e_EzRPxYIPKVl601RpcL&index=2
Appium 3: https://www.youtube.com/watch?v=tQNAvcslBy8&list=PL0jj4QpaE1wp-e_EzRPxYIPKVl601RpcL&index=3

To run this test code, you must to start Appium Server
First install the Appium server
Then install the Appium via npm with the command: npm install -g appium
In th terminal, bat or code, run "appium" to start the server