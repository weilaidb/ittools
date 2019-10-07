
cd /d C:\Users\dell\AppData\Local\Android\Sdk\platform-tools
adb shell ps -ef  > log.log
adb shell dumpsys window >> log.log
explorer .
