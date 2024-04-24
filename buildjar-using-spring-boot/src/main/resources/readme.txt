

Add this jar to another project as dependency as: Install ad maven and add it class .m2 file
	mvn install:install-file -Dfile=path/to/sqljdbc41.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc41 -Dversion=4.1 -Dpackaging=jar
	
	<dependency>
	   <groupId>com.microsoft.sqlserver</groupId>
	   <artifactId>sqljdbc41</artifactId>
	   <version>4.1</version>
	</dependency>
OR
Keep it on prodject resources libs directory then:
	<dependency>
	    <groupId>com.example</groupId>
	    <artifactId>rest-controller-project</artifactId>
	    <version>1.0-SNAPSHOT</version>
	    <scope>system</scope>
	    <systemPath>${basedir}/src/main/resources/libs/rest-controller-project-1.0-SNAPSHOT.jar</systemPath>
	</dependency>
	


