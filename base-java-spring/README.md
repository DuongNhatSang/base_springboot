## SETUP PROJECT

### 1. Environment preparation

- Create database in MySQL 8.0
- Java 17
- Update url datasource to the configuration file (application-local.yml for local environment, application-dev.yml for develop environment, application-prod.yml for production environment)
- Update spring.profiles.active in the application.yml file to set the profile for the application (If you do not specify a value, the application will take the default value is "local")

### 2. Build Project

##### 2.1 Build by IntelliJ

- Open Run/Debug Configurations popup by click menu Run/Edit Configurations...
- Add new Spring Boot Configuration
- Input 'MainClass' to Main class field
- Run Project

##### 2.2 Build by cmd

- Open cmd in root folder (project folder) and run command line: `./gradlew -P<env> bootJar` (env values: local, dev, prod)
- If there is no `-P<env>` option then the "local" profile will be selected

### 3. Checkstyle

##### 3.1 Configuration
- Check `build.gradle` file
    + Enable plugin: `id 'checkstyle'`
    + Apply plugin: `'checkstyle`' for subprojects
    + Uncomment `checkStyle` define

##### 3.2 Build by cmd
- Run `./gradlew check` to check style