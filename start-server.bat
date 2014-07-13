   IF "%JREBEL_PATH%" == "" GOTO NOJREBEL
   :USEJREBEL
   		call set MAVEN_OPTS=-noverify -javaagent:"%JREBEL_PATH%" -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8485,server=y,suspend=n -Xmx512m -XX:MaxPermSize=256m %MAVEN_OPTS%
		call mvn jetty:run-war -DskipTests=true -Djetty.port=8082
   GOTO END
   :NOJREBEL
   		call set MAVEN_OPTS=-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=8485,server=y,suspend=n -XX:MaxPermSize=256m %MAVEN_OPTS%
		call mvn jetty:run-war -DskipTests=true -Djetty.port=8082
   GOTO END
   :END