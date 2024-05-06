package com.sbiepay.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.epay.encdata.config.AES256Bit;
import com.epay.encdata.controller.RedirectUrl;
import com.epay.encdata.util.GenericExceptionLog;
import com.epay.encdata.util.GetMekKey;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
//import com.epay.encdata.controller.*;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;
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
		 	
        	return new RedirectView(encRequest.redirectCall3(merchantOrderNumber,orderAmount,myComponent.getMkValue(),myComponent.getKkValue(),myComponent.getMerchantId(),myComponent.getSuccessUrl(),myComponent.getFailUrl()));
        	
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
       return new RedirectView("https://uat.sbiepay.sbi/");
	}
	
	public  String decrypt(String encryptedValue) throws NullPointerException, Exception {
		String decryptedValue = "";
		try {
			
			GetMekKey mekKey = new GetMekKey();
			String meKey= mekKey.getMeK(myComponent.getMerchantId(),myComponent.getKkValue(),myComponent.getMkValue());
			  
				SecretKeySpec secretkeyspec=null;
				secretkeyspec = AES256Bit.readKeyBytes(meKey);
				decryptedValue = AES256Bit.decrypt(encryptedValue, secretkeyspec);
			  
			  
			  

		}  catch (Exception ex) {
			GenericExceptionLog.exceptionJava(ex,
					"AESEncryptDecrypt.java :: An error occurred while decryption .",
					"AESEncryptDecrypt");
			
		}
		return decryptedValue;
	}
	
	
	public  String encrypt(String decryptedValue)
			throws NullPointerException, Exception {
		String encryptValue = "";
		GetMekKey mekKey = new GetMekKey();
		String meKey= mekKey.getMeK(myComponent.getMerchantId(),myComponent.getKkValue(),myComponent.getMkValue());
		
		SecretKeySpec secretkeyspec=null;
		secretkeyspec = AES256Bit.readKeyBytes(meKey);
		encryptValue = AES256Bit.encrypt(decryptedValue, secretkeyspec);
		
		
		return encryptValue;
		
	}

	

}
