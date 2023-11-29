@echo off

REM Compile java code that uses ANTLR4 classes
javac -classpath lib\antlr-4.13.1-complete.jar;. %*
