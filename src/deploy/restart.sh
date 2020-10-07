#!/bin/bash

APP_BASE_DIR=/data/Forrester/ServiceTemplate
DEPLOYMENT_FILE=service-template.jar
APP_BASE_PATH=http://localhost:10000/ForrSVC/

JAVA_HOME=/usr/java/jdk1.8.0_151

if [ $# -eq 0 ] ; then
    echo 'Argument missing: profile'
    echo 'Usage : ./restart.sh [profile]'
    exit 1
fi

echo 'Stopping ServiceTemplate'
curl -X POST "${APP_BASE_PATH}/actuator/shutdown"

# wait 15 seconds
echo 'Going to sleep for 15s'
sleep 15s

echo 'Starting ServiceTemplate'

nohup $JAVA_HOME/bin/java -Xmx256m -Xss256k -Dprofile="$1" -Dapp.home=${APP_BASE_DIR} -jar ${APP_BASE_DIR}/bin/${DEPLOYMENT_FILE} > /dev/null 2>&1 &
