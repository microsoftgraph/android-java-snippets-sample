@echo off

SET testConfig={
SET testConfig=%testConfig% "test_client_id": "94da997e-c3f4-40b4-9901-ab5b75c0d1a5",
SET testConfig=%testConfig% "test_username": "ding.men@husky.neu.edu",
SET testConfig=%testConfig% "test_password": "%1"
SET testConfig=%testConfig%  }
echo %testConfig%
echo %testConfig% > testConfig.json

SET _adb_devices=%ANDROID_HOME%\platform-tools\adb.exe devices
FOR /f "skip=1" %%G IN ('%_adb_devices%') DO %ANDROID_HOME%\platform-tools\adb.exe -s %%G push testConfig.json ./data/local
