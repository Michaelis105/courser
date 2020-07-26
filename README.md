# courser
Online Course Registration System

To build and run web server only:
1.	Build and run Spring Boot web server (`./gradlew bootRun`)
2.	Visit web server RESTful API documentation at URL using preferred browser (http://localhost/swagger-ui.html#)
3.	Execute REST calls by clicking and trying out various REST endpoints listed on the Swagger UI documentation.

To build and package the UI and web server as a single deliverable:
1.	Navigate to `courser/web` directory (`cd courser/web`).
2.	Change all VueJS API calls to point to domain which Spring web server will be hosted on.
3.	Compile and minify project for production (`npm run build`).
4.	Copy all files and directories under `dist/` to Java static resources directory under `src/main/resources/static`. You may need to create the static directory.
5.	Navigate to `courser/` (project root).
6.	Build the jar (`./gradlew bootJar`)
7.	Copy the output jar located in `courser/build/libs/courser-0.0.1.jar` to the target environment where it will run.
8.	Run the jar (`java -jar courser-0.0.1.jar`). The web server should now answer REST requests and return the UI.
