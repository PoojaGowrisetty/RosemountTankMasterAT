To run the code in IDE 
prerequisite required 
1. Java installed
     - To install java go to site - https://download.oracle.com/java/21/latest/jdk-21_windows-x64_bin.exe (sha256)
     - Install with double click
     - Set the Java path in environment variables with JAVA_HOME and add the JDK path usually it will be "C:\Program Files\Java\jdk-21"
     - add the path in "Path" variable
     - To verify successful installation go to cmd prompt and type java -version , version of java will be displayed.
2. Install Eclipse IDE
      - To install Eclipse IDE go to "https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2025-06/R/eclipse-inst-jre-win64.exe" ( it is windows 64 environment)
      - Double click and select "Eclipse IDE for Java Developers"
      - After complete installation , launch the IDE
      - Since my project is in BDD and TestNG , go to help - Eclipse marketplace - install "Cucumber Eclipse Plugin" and "TestNG for Eclipse"

Steps in Eclipse IDE 
    - File - Open Projects from file system - select the directory path of the project and click Finish
    - you can run in two ways 
       using TestRunner - Right click on TestRunner file - Run as - TestNG Test
       using pom.xml - Open file - right click - run as - maven test

To run in the Jenkins pipeline 
1. setup the Jenkins
      download the Jenkins war file - "https://www.jenkins.io/download/" - Generic java war file
      place this file in automation folder
      Go to cmd  java -jar Jenkins.war
      copy password displayed , go to "http://localhost:8080/"
      create username and password .
      in dashboard - Manage Jenkins - plugins - install maven integration
      Manage Jenkins - tools- JDK installations -  Name - MyJava , JAVA_HOME - "C:\Program Files\Java\jdk-21"
                              Git installations -  name - MyGit , path - C:\Program Files\Git\bin\git.exe
                              Maven installations - Name - MyMaven , Click Install automatically and select version "3.9.11" Apply and save

2. Creating pipeline
         Dashboard - New item - Give project name - Pipeline
         go to Pipeline - in Defination - select Pipeline script from SCM
         Choose Git, Add the repository URL - https://github.com/PoojaGowrisetty/RosemountTankMasterAT.git
         Script path as Jenkinsfile , click apply and save
3. To run in Jenkins
          - Dashboard - select project - Click Build Now

  
