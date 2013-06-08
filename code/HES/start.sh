#!/bin/bash
gnome-terminal -e "java -jar out/artifacts/NameServer_jar/NameServer.jar"
gnome-terminal -e "java -jar out/artifacts/DHL_Mock_UP_jar/DHL-Mock-UP.jar"
gnome-terminal -e "java -jar out/artifacts/HAPSAR_Mock_Up_jar/HAPSAR-Mock-Up.jar"
gnome-terminal -e "java -jar out/artifacts/ClientInstanz_jar/ClientInstanz.jar"
gnome-terminal -e "java -jar out/artifacts/HES_jar/HES.jar 1"
gnome-terminal -e "java -jar out/artifacts/HES_jar/HES.jar 2"


