# Swagger Sample App using embedded Jersey JAX-RS Applications

## Overview
This is a Java project to build a stand-alone server which implements the Swagger spec.  You can find out 
more about both the spec and the framework at http://swagger.wordnik.com.  For more information 
about Wordnik's APIs, please visit http://developer.wordnik.com.  There is an online version of this
server at http://petstore.swagger.wordnik.com/api/api-docs.json

### To build from source
Please follow instructions to build the top-level [swagger-core project](https://github.com/wordnik/swagger-core).

### To run (with Maven)
To run the server, run this task:

    mvn exec:java -Dexec.mainClass="com.wordnik.swagger.sample.jersey.SampleJaxRsApplication"

This will start Jersey's Grizzly2 HttpServer embedded on port 8002.

### Testing the server
Once started, you can navigate to [http://localhost:8002/api/api-docs](http://localhost:8002/api/api-docs) to view the Swagger Resource Listing.
This tells you that the server is up and ready to demonstrate Swagger.

### Using the UI
There is an HTML5-based API tool available in a separate project.  This lets you inspect the API using an 
intuitive UI.  You can pull this code from here:  https://github.com/wordnik/swagger-ui

You can then open the `dist/index.html` file in any HTML5-enabled browser.  Upen opening, enter the
URL of your server in the top-centered input box (default is [http://localhost:8002/api/api-docs](http://localhost:8002/api/api-docs)).  Click the "Explore" 
button and you should see the resources available on the server.