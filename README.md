# Implementation Description

This application will use a Factory style creational pattern to create Delivery requests, which will be sent to drivers.
There will be four classes in this project: Shop, Delivery Request, Driver, and Main.

Driver class will have data fields for name (final String) and current request (DeliveryRequest). The setter method for the Request will only set a new request if there is not currently one. The method will return a boolean, true if a new request was taken, false if the request was rejected. The constructor will take in a String for the driver's name.

Delivery Request object will have data fields for Description (String), Shop name (String), and delivery address (String). There will be standard getters and setters for each. It will have a contructor that will take in a String for the Description, String for the shop name, and String for the shop address.

Shop object will have data fields for name (final String), address (final String). There will be getters for these fields. The constructor will take in two strings, to set the data fields. It will have a method for creating a Delivery Request that takes in a String for the Description and String for the delivery Address. It will then call the Delivery Request Contructor and return the instance of the DeliveryRequest. 

Main will have a List of all available Drivers and all available shops. It will create 3 drivers and one shop in the initial version of this project. It will use a method to search the shop array for a specific shop, and call its makeRequest method with a hard coded description. The main class will then use a method to broadcast the returned request to all drivers, and it will be assigned to the first available driver.

# Project Template

This is a Java Maven Project Template


# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```

We recommand the above command for running the project. 

Alternativly, you can run the following command. It will generate a single jar file with all of the dependencies. 

```bash
mvn clean compile assembly:single

java -Dlog4j.configuration=file:log4j.properties -classpath ./target/JavaProjectTemplate-1.0-SNAPSHOT-jar-with-dependencies.jar  edu.bu.met.cs665.Main
```


# Run all the unit test classes.


```bash
mvn clean compile test

```

# Using Findbugs 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn findbugs:gui 
```

or 


```bash
mvn findbugs:findbugs
```


For more info about FindBugs see 

http://findbugs.sourceforge.net/

And about Maven Findbug plugin see 
https://gleclaire.github.io/findbugs-maven-plugin/index.html


You can install Findbugs Eclipse Plugin 

http://findbugs.sourceforge.net/manual/eclipse.html



SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```


# Generate  coveralls:report 

You can find more info about coveralls 

https://coveralls.io/

```bash
mvn -DrepoToken=YOUR-REPO-TOCKEN-ON-COVERALLS  cobertura:cobertura coveralls:report
```


