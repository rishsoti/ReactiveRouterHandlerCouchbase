# ReactiveRouterHandlerCouchbaseDb
Reactive Rest APIs with Spring WebFlux and Reactive CouchbaseDb using Handler and Routers


## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. CouchbaseDb - 6.x.x

## Steps to Setup

**1. Clone the application**

git clone https://github.com/rishsoti/ReactiveRouterHandlerMongodb.git```


**2. Build and Run the app using maven**

Right click on the application and run as springboot App

The server will start at <http://localhost:8080>.

**3. How to configure couchbase**


*1. Download and install Couchbase*

*2. Run through the initial setup and navigate to the dashboard on http://127.0.0.1:8091*

*3. In Buckets: create a new bucket called demo*

*4. In Security: Add a new user called demouser with password 123456 and grant application access to the bucket demo*

*5. In Query: Add a primary index to the bucket demo by executing the query CREATE PRIMARY INDEX ON demo USING GSI;*

*6. In Indexes -> Views: Add a new development view*

*7. design document name is student*

*8. view name is all*

*9. edit the view and change the code of Map to function (doc, meta) { emit(meta.id, doc); }*

*10. In Indexes -> Views: Publish the view*



**4. Exploring the Rest APIs**


The application defines following REST APIs

1. GET hr/students - Get All Students

2. POST hr/students - Create a new student

3. GET hr/students/{id} - Retrieve a Student by Id

4. PUT hr/students/{id} - Update a Student

5. DELETE hr/students/{id} - Delete a Student

**5. Lombok Dependency**


We are using here project Lombok dependency in order to avoid boilerplate code as it gives you facility to create getter,setters,constructors all by simple annotations.

Please have a look on the link for further details and if you are familiar with the same then you can just skip this step.

https://projectlombok.org/

**6. Reactive Programming Overview**

Reactive programming is a non-blocking application that is asynchronous, even-driven and requires a small number of threads to scale.

**7. Spring WebFlux**

Spring WebFlux is the new reactive web framework that comes with Spring 5. It is not a replacement for Spring MVC but a fully non-blocking, Reactive Streams back pressure supporting framework.

**8. Main Components**

The Mono

Mono: Returns 0 or 1 element.
The Mono API allows producing only one value.
Mono<String> mono = Mono.just(“Spring Framework”);
Mono<String> mono = Mono.empty();
This is limited to no more than one element.
  
The Flux

Flux: Returns 0…N elements.
The Flux can be endless, it can produce multiple values. Here, we have a static stream of the thee elements.
Flux<String> flux = Flux.just(“One”, “Two”, “Three”);

