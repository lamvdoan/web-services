# README

### Summary
Used the Jersey Framework to build a RESTful API.  This API takes a list of emails and returns the unique count of 
emails that are from Gmail (ignores underscores and anything onwards with the plus sign).


### Reference
* [Gradle War File Generation](https://docs.gradle.org/current/userguide/war_plugin.html)
* [Quick Guide to set up Tomcat](https://www.ntu.edu.sg/home/ehchua/programming/howto/Tomcat_HowTo.html#configure)



### Requirements
* Latest version of Java: 13.0.1
* Latest version of Gradle: 6.0.1
* Latest version of Tomcat: 9.0 


### Steps
1. Execute the Gradle script and fetch the dependencies

        cd  ~/<directory with the code>/web-services/
        gradle build

2. Create a war file:

        gradle war

3. Copy the generated .war file into tomcat/webapps/

        mv build/libs/web-services.war ~/<tomcat directory>/webapps/web-services.war

4. Start Tomcat
        
        cd ~/<tomcat directory>
        sudo ./tomcat/bin/catalina.sh run

5. Call the POST request:

        curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H "Postman-Token: 03ef43b3-d871-9dd2-2b7f-29ce390bbb4c" -d '{
            "emails" : ["Lamvdoan@gmail.com", 
            "Lamvdoan+5@gmail.com",
            "Lamv.doan@gmail.com",
            "Lamvdoan1@gmail.com"
            ]
        }' "http://localhost:8080/web-services/api/emails"

6. For the example, the response should have a total count of 2.
