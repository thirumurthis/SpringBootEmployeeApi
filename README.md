# SpringBootEmployeeApi
A sample Spring boot application 

### Spring annoatation used
##### @RestController
*{can be used in the controller class, at class level or method level}*
##### @RequestMapping  (method=RequestMethod.GET, produces = MediaType.APPLICATION.JSON_VALUE, path="{id}") 
*{options, cosumes}*
##### @RequestBody  
*{when the default constructor not available for Bean or POJO, use @JsonProperty annotation on bean}*
##### @PathVariable 
*{goes witht the path attribute/properties of the @RequestMapping annoation, to distingush the URI resource}*
##### @Repository
*{similar to @component annotation, this has a slight variation and better demorcation of the layer in the MVC patter for spring-boot}*
##### @Service
*{similar to @component annotation, this has a slight variation to mark ths class a service layer}*
##### @JsonProperty
*{jackson annotation used within the spring boot parent jar, in this case the value default attribute should match the bean class properties name. For ex. in Employee class, private  @JsonProperty("id") UUId id; }*

### HTTP METHOD USAGE
##### GET
*{for SELECTCING or getting data from the database, select statments}*

##### POST
*{for INSERTING or creating a entry, persisting a record, inserting data to database}*

##### PUT
*{for UPDATING the record to the database}*
##### DELETE
*{for DELETING the record or entry from the database}*

### Terminology
##### Endpoint
*{in the controller or resource every @RequestMapping at the method level is referred as endpoint}*

##### Client
*{the controller class is a client for service class, also PostMan/Browser is a client for Controller class}*

##### PayLoad
*{in this case any data that is passes from the client browser/PostMan, in this case it is a JSON payload retrived by controller/resources using @RequestBody annotation}*


### HTML PayLoad usage
##### static folder
*{The static folder can hold .html, .css, etc file, to render the html page. In this case we can create an index.html and have some conent displayed in the screen too}*

##### template folder
*{template folder holds template file that can be resolved by java code, template engine like Apache velocity, Thymeleaf, etc engines}*
