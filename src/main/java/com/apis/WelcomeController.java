package com.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apis.rabbitmqsender.RabbitMQSender;


@RestController

@RequestMapping("/ashiwani")
public class WelcomeController {
	
	 @RequestMapping(method = RequestMethod.GET,value="/welcome")
	    public String get() {
	        return "Greetings from Spring Boot";
	    }
	 
     /**
      * Multiple Multiple URIs mapping
      * @return
      *  localhost:8080/home
	     localhost:8080/home/
	     localhost:8080/home/page
	     localhost:8080/home/pageabc
	     localhost:8080/home/view/
	     localhost:8080/home/view/view
      */
	 @RequestMapping(value = {"","/page", "page*", "view/*,**/msg"})
		    String indexMultipleMapping() {
		        return "Hello from index multiple mapping.";
		    }  
	 /**
	
	 **/
	 /**
	  * Single headers
	  * @author ashiwani.ranjan
	  *
	  */	 

	 @RequestMapping(method = RequestMethod.GET,value="/getcall",headers = {"content-type=application/json"},produces = "application/json")
	 @ResponseBody
	    public String getWithHeader() {
	        return "Hello Boot!";
	        
	    }
	 /**
	  *  Multiple HTTP request methods to the same controller method
	  * @return
	  */
	 @RequestMapping(value = {"/doj/spring"}, method = {RequestMethod.GET, RequestMethod.POST})
	 @ResponseBody
	 public String getDOJHome() {
	     return "Get a DOJ Home Page";
	 }
	 
	 
     /**
      * Multiple headers
      * @author ashiwani.ranjan
      *
      */
	
	     @RequestMapping(value = "/head", headers = {"content-type=text/plain","content-type=text/html"}) 
	     public String post() {
	         return "Mapping applied along with headers";
	     }
	     
	     /**
	      * Query Param- /ashiwani/name?person="ashiwani"
	      * @author ashiwani.ranjan
	      *
	      */
	     
	     @RequestMapping(value = "/name")
	     String getName(@RequestParam(value = "person") String personName) {
	         return "Hello "+personName;
	     }
	     
	     /**
	      * Query Param- ashiwani/twoname?name=ashiwan&age=22
	      * @author ashiwani.ranjan
	      *
	      */
	     
	     @RequestMapping(value = "/twoname")
	     String getName(@RequestParam String name,@RequestParam String age1) {
	         return "Hello "+name+" Age1 "+age1;
	     }
	     
	     /**
	      * Sum API
	      * Path Variable
	      */
	     @GetMapping(value="/sum/{id1}/{id2}")
	     int getSum(@PathVariable String id1,@PathVariable String id2) {
	    	 int a=Integer.parseInt(id1);
	    	 int b=Integer.parseInt(id2);
	    	 return (a+b);
	     }
	     
	     /**
	      * Minus API
	      * Path Variable
	      */
	     @GetMapping(value="/sub/{id1}/{id2}")
	     int getSub(@PathVariable String id1,@PathVariable String id2) {
	    	 int a=Integer.parseInt(id1);
	    	 int b=Integer.parseInt(id2);
	    	 return (a-b);
	     }
	     
	     /**
	      * Multiply API
	      * Path Variable
	      */
	     @GetMapping(value="/mul/{id1}/{id2}")
	     int getMul(@PathVariable String id1,@PathVariable String id2) {
	    	 int a=Integer.parseInt(id1);
	    	 int b=Integer.parseInt(id2);
	    	 return (a*b);
	     }
	     
	     /**
	      * Division API
	      * Path Variable
	      * ashiwani/div/121/33
	      */
	     @GetMapping(value="/div/{id1}/{id2}")
	     int getdiv(@PathVariable String id1,@PathVariable String id2) {
	    	 int a=Integer.parseInt(id1);
	    	 int b=Integer.parseInt(id2);
	    	 return (a/b);
	     }
	     
	     /**
	      * Fallback for all requests
	      * @return
	      */
	     
	     @RequestMapping(value = {"*"})
	     @ResponseBody
	     public String getDOJDefaultPage() {
	         return "Get a DOJ Default Page";
	     }
	     

	     
	           
	 }

