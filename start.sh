#!/bin/bash

echo "*******************  BUILDING MODULE  *****************************************"
mvn clean install

echo "*******************  COLLECTING DEPENDENCIES  *********************************"
mvn package

echo "*******************  EXECUTING PROGRAM******************************************"
java -cp target/prode-app-1.0-SNAPSHOT-jar-with-dependencies.jar -Dactivejdbc.log prode.App
