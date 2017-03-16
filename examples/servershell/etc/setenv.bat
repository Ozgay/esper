@echo off

if "%JAVA_HOME%" == "" (
  echo.
  echo JAVA_HOME not set
  goto EOF
)

if not exist "%JAVA_HOME%\bin\java.exe" (
  echo.
  echo Cannot find java executable, check JAVA_HOME
  goto EOF
)

set LIB=..\..\..\esper\lib
set EXLIB=..\..\..\examples\lib
set IOLIB=..\..\..\esperio\lib

set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;..\target\classes
set CLASSPATH=%CLASSPATH%;..\..\..\esper-6.0.1.jar
set CLASSPATH=%CLASSPATH%;%LIB%\cglib-nodep-3.2.4.jar
set CLASSPATH=%CLASSPATH%;%LIB%\slf4j-api-1.7.21.jar
set CLASSPATH=%CLASSPATH%;%LIB%\slf4j-log4j12-1.7.21.jar
set CLASSPATH=%CLASSPATH%;%LIB%\log4j-1.2.17.jar
set CLASSPATH=%CLASSPATH%;%LIB%\antlr-runtime-4.5.3.jar
set CLASSPATH=%CLASSPATH%;%EXLIB%\jms.jar
set CLASSPATH=%CLASSPATH%;%IOLIB%\apache-activemq-6.0.1-incubator.jar

goto EOF

:badenv
echo.
echo Error: required libraries not found in %LIB% directory
goto EOF

:badenv_esperlib
echo.
echo Error: esper.jar not found in ..\..\ 

:EOF
