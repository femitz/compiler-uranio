@echo off

REM Run ANTLR4 TestRig
rem SET CLASSPATH=".;lib/antlr-4.7.2-complete.jar;%CLASSPATH%" 
java -classpath lib\antlr-4.13.1-complete.jar;. org.antlr.v4.gui.TestRig %*