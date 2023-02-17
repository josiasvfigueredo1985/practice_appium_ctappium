start adb "kill-server"
start   adb emu kill
sleep 5
start   adb "start-server"
start cmd cmed.exe /k "emulator @Pixel_2_API_30"