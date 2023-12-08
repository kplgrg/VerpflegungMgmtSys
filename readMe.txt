Readme - VerflegungsMgmt Spring Boot Anwendung

Diese Readme-Datei enthält Anweisungen zur Konfiguration der Datenbank und zur Ausführung der Spring Boot Anwendung "VerflegungsMgmt" auf Ihrem lokalen System.

Voraussetzungen:

1. Java: Stellen Sie sicher, dass Sie Java (JRE oder JDK) auf Ihrem System installiert haben. Die Anwendung wurde mit Java 17 entwickelt.

2. PostgreSQL: Die Anwendung verwendet eine PostgreSQL-Datenbank. Stellen Sie sicher, dass PostgreSQL auf Ihrem System installiert und ausgeführt wird. Sie können PostgreSQL unter folgender Adresse herunterladen: https://www.postgresql.org/download/

Datenbank-Konfiguration:

1. Erstellen Sie eine leere PostgreSQL-Datenbank mit dem Namen "VerpflegungsMgmt" auf Ihrem lokalen Server.

Anwendungsausführung über SpringTool - Variante 1:

1. Bitte Import der ZIP.Datei VerpflegungsMgmtSys.zip in SpringTool Suite oder Eclipse

2. Öffnen Sie die Datei "application.properties" in der Spring Boot Anwendung.

3. Stellen Sie sicher, dass die folgenden Eigenschaften für die Datenbankverbindung festgelegt sind:
   
   spring.datasource.url = jdbc:postgresql://localhost:5432/VerpflegungsMgmt
   spring.datasource.username = (IHR USERNAME)
   spring.datasource.password = (IHR PASSWORT)
   
   Passen Sie den Benutzernamen und das Passwort an, um Ihre PostgreSQL-Anmeldeinformationen einzugeben, 
   falls Sie andere als die Standardanmeldeinformationen verwendet haben.

4. Bitte pom.xml Datei - Update MAVEN aktualisieren

5. Die Spring Boot Anwendung kann nun gestartet werden und sollte unter der URL "http://localhost:8080" erreichbar sein.

Anwendungsausführung über jar.Datei - Variante 2:

1. Öffnen Sie die Datei "application.properties" mit einem Text-Editor und stellen Sie sicher, dass die folgenden Eigenschaften für die Datenbankverbindung festgelegt sind:
   
   spring.datasource.url = jdbc:postgresql://localhost:5432/VerpflegungsMgmt
   spring.datasource.username = (IHR USERNAME)
   spring.datasource.password = (IHR PASSWORT) 

2. Öffnen Sie die JAR-Datei "VerpflegungsMgmtsys.jar" (wird im Hintgrund ausgeführt)

3. Die Anwendung wird jetzt gestartet und sollte unter der URL "http://localhost:8080" erreichbar sein.

