package com.sbiepay.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.epay.encdata.controller.RedirectUrl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
//import com.epay.encdata.controller.*;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
@RestController
public class AppController {

	@Autowired
MyComponent myComponent;

	
	@PostMapping("/callme")
	public RedirectView testCallme2(HttpServletRequest req)
	{
		RedirectUrl  encRequest=new RedirectUrl ();
		
        String merchantOrderNumber = req.getParameter("hiddenMerchantOrderNo");
        String orderAmount = req.getParameter("orderAmount");
     
        System.out.println("Parameter 1: " + merchantOrderNumber);
        System.out.println("Parameter 2: " + orderAmount);
       
        try {
		//	return new RedirectView(encRequest.redirectCall2(merchantOrderNumber,orderAmount,URLEncoder.encode(req.getParameter("mk"),"UTF-8"),URLEncoder.encode(req.getParameter("kk"),"UTF-8")));
        	
        	//return new RedirectView(encRequest.redirectCall2(merchantOrderNumber,orderAmount,req.getParameter("mk"),req.getParameter("kk")));
    		
        	//return new RedirectView(encRequest.redirectCall2(merchantOrderNumber,orderAmount,myComponent.getMkValue(),myComponent.getKkValue()));
        	
        	return new RedirectView(encRequest.redirectCall3(merchantOrderNumber,orderAmount,myComponent.getMkValue(),myComponent.getKkValue(),myComponent.getMerchantId(),myComponent.getSuccessUrl(),myComponent.getFailUrl()));
        	
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
       return new RedirectView("https://www.google.com/");
	}
	

}
