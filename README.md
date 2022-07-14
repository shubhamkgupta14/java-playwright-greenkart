# Java-Playwright Feamework

Sample website - [Greenkart](https://rahulshettyacademy.com/seleniumPractise/#/)  

### Adding Dependencies in pom.xml

**Plawright**
```
	<dependency>
		<groupId>com.microsoft.playwright</groupId>
		<artifactId>playwright</artifactId>
		<version>1.17.1</version>
	</dependency>
```

**Cucumber**
```
	<dependency>
		<groupId>io.cucumber</groupId>
		<artifactId>cucumber-java</artifactId>
		<version>6.10.4</version>
	</dependency>
	<dependency>
		<groupId>io.cucumber</groupId>
		<artifactId>cucumber-testng</artifactId>
		<version>6.10.4</version>
	</dependency>
	<dependency>
		<groupId>io.cucumber</groupId>
		<artifactId>cucumber-picocontainer</artifactId>
		<version>6.10.4</version>
	</dependency>
```

**Extent-Report**
```
	<dependency>
		<groupId>tech.grasshopper</groupId>
		<artifactId>extentreports-cucumber6-adapter</artifactId>
		<version>2.1.0</version>
	</dependency>
	<dependency>
		<groupId>com.aventstack</groupId>
		<artifactId>extentreports</artifactId>
		<version>5.0.4</version>
	</dependency>
```

### Accessing the folders
* ```src/main/java``` contains *Page Factory Classes*, *Services Classes*, *Constants Class*, and *Common Function Class*.
* ```src/test/java``` contains *Step Definitions* and *Test Runner*.
* ```src/test/resources``` contains *Data Properties files*, *Feature files*, *Config files*, and *Report Config files*.

### Run the test case
* In the ```TestRunner.java``` file add the tag name for which scenario we want to test and run as ```TestNG Test```.

### Generate the Report
* Refresh the Project and the report ```report.html``` will be added in ```~/test-output/Report``` folder.

### Capturing the video
* In the ```services/InitFactory.java``` class we can add the browserContext Options while creating the browserContext Object and can specify the video path.
        ```browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));```
* If we do not need to record video then we can create simple object.
        ```browserContext = browser.newContext();```
