# README

### Requirements
* Latest version of Java: 13.0.1
* Latest version of Gradle: 6.0.1
* Latest version of Tomcat: 9.0 


### Important Notes
* unit tests for gmail counts are passing
* web service is implemented and not testable
* Hitting the HTTP GET request returns a 404, stuck on Step 4 and 5.


### Steps
NOTE: This is probably where things went south and not working

1. Create a war file:

        cd  ~/<directory with the code>/gmail_checker/src/main/webapp
        jar -cvf gmail_checker.war *

2. Copy the generated .war file into tomcat/webapps/
3. Start Tomcat
        
        cd ~/<tomcat directory>
        ./tomcat/bin/catalina.sh run

4. I created a test request to see if a plain HTTP GET request would work. The test request should return a status of 200 with an output of 5.

        curl -X GET -H "Content-Type: application/json" -H "Accept: application/json" -H "Cache-Control: no-cache" -H "Postman-Token: 60bf28b7-39cb-fc40-2445-d2e2a2f671c5" "http://localhost:8080/gmail_checker/api/emails"

5. Call the POST request:

        curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -H "Cache-Control: no-cache" -H "Postman-Token: ef8edb91-43ed-0ff3-4b93-9ab740e3c066" -d '{
        "emails" : ["Lamvdoan@gmail.com", 
        "Lamvdoan+5@gmail.com",
        "Lamv.doan@gmail.com",
        "Lamvdoan1@gmail.com"
        ]}' "http://localhost:8080/api/emails"

6. The response should have a total count of 2.


### Troubleshooting
NOTE: Based on findings via Google
1. Copying the compiled classes in and paste into the src/main/webapp/WEB-INF/classes
2. Modified the WEB-INF/web.xml
3. Added a META-INF/context.xml
4. Modified the pom.xml
5. Used different URIs, with URI starting with and without "gmail_checker" 
6. Set the values of many different files to gmail_checker
