#!/bin/sh

nohup java -jar /home/edb/SpringBootGradleTemplate.jar 1> /dev/null 2>&1 &
# nohup java -jar -Dspring.profiles.active=dev /home/edb/SpringBootGradleTemplate.jar 1> /dev/null 2>&1 &

echo SpringBootGradleTemplate has been started !
