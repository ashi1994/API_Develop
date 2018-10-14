package com.apis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.constants.Constant;
import com.model.User;

@RestController
@RequestMapping("/ashiwani")
public class ControllerPost {
	    
	  
    @PostMapping(value ="/postcall")
    @ResponseBody
    public User getdetails(@RequestBody User us1,@RequestHeader (value="userId", required=true) String userId,@RequestHeader (value="trackingNumber", required=true) int trackingNumber) throws Exception {
   	 if(userId.equals(Constant.userid)){
   	 us1.setId("1");
   	 us1.setTrackingNumber(trackingNumber);
   	 java.util.Date date=new java.util.Date();
   	 us1.setCreatedOn(date);
   	 }
   	 else
   		 throw new Exception("Invalid User Id");
      return us1;
    }
    
    
   	 }


