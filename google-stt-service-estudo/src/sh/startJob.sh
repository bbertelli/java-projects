#!/bin/bash

echo "Start job";

export GOOGLE_APPLICATION_CREDENTIALS="/opt/crm-speech/key.json"

nohup java -jar /opt/crm-speech/speech.jar "/Uploads/SCHMERSAL/CRM/"  "/Uploads/SCHMERSAL/CRM/" 5000 &

echo pid > pid

echo "Finished job"

