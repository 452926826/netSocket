进入文件夹 cd Exam03

加载jar包
mvn install:install-file  -Dfile=D:/lib/gson-2.2.4.jar  -DgroupId=hand  -DartifactId=Exam03 -Dversion=1.2 -Dpackaging=jar
mvn install:install-file  -Dfile=D:/lib/httpclient-4.5.2.jar  -DgroupId=hand  -DartifactId=Exam03 -Dversion=1.2 -Dpackaging=jar
mvn install:install-file  -Dfile=D:/lib/httpclient-cache-4.5.2.jar  -DgroupId=hand  -DartifactId=Exam03 -Dversion=1.2 -Dpackaging=jar
mvn install:install-file  -Dfile=D:/lib/httpcore-4.4.4.jar  -DgroupId=hand  -DartifactId=Exam03 -Dversion=1.2 -Dpackaging=jar
mvn install:install-file  -Dfile=D:/lib/httpmime-4.5.2.jar  -DgroupId=hand  -DartifactId=Exam03 -Dversion=1.2 -Dpackaging=jar

运行：  mvn clean compile exec:java -Dexec.mainClass="hand.Main"
生成的文件在  Exam03/new.xml  和   Exam03/json.json