java -Dwebdriver.ie.driver=IEDriverServer.exe -jar selenium-server-standalone-3.3.1.jar -port 5555 -role node -hub http://localhost:4444/grid/register -browser "browserName=internet explorer,platform=WINDOWS,maxInstances=2" -maxSession 2