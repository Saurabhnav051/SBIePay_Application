package com.sbiepay.merchant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.epay.encdata.controller.RedirectUrl;

//import com.epay.encdata.controller.*;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
@RestController
//@Service
public class AppController {
//	@Autowired
//	AppController1 a=new AppController1() ;
//	
//	public int getdata() {
//		return a.getSum(4, 6);
//	}
//	

@Autowired
MyComponent myComponent;

	
	@GetMapping("/callme2")
	public RedirectView testCallme()
	{
		RedirectUrl  encRequest=new RedirectUrl ();
		
		return encRequest.redirectWithRedirectAttributes();
		//return encRequest.redirectcallredirect(req);
		//"https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+URLEncoder.encode(aggregatorHosted.getEncryptTrans(),"UTF-8")+"&EncryptbillingDetails="+URLEncoder.encode(aggregatorHosted.getEncryptbillingDetails(),"UTF-8")+"&EncryptshippingDetais="+URLEncoder.encode(aggregatorHosted.getEncryptshippingDetais(),"UTF-8")+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction"
		
		//return new RedirectView(encRequest.redirectCall2("LfoP5","12","",""));
	
	  
	
	}
	
	
	@PostMapping("/callme")
	public RedirectView testCallme2(HttpServletRequest req)
	{
		RedirectUrl  encRequest=new RedirectUrl ();
		
        String merchantOrderNumber = req.getParameter("hiddenMerchantOrderNo");
        String orderAmount = req.getParameter("orderAmount");
        
     
        System.out.println("Parameter 1: " + merchantOrderNumber);
        System.out.println("Parameter 2: " + orderAmount);
        
//		return encRequest.redirectWithRedirectAttributes();
		//return encRequest.redirectcallredirect(req);
		//"https://uat.sbiepay.sbi/secure/AggregatorHostedListener?EncryptTrans="+URLEncoder.encode(aggregatorHosted.getEncryptTrans(),"UTF-8")+"&EncryptbillingDetails="+URLEncoder.encode(aggregatorHosted.getEncryptbillingDetails(),"UTF-8")+"&EncryptshippingDetais="+URLEncoder.encode(aggregatorHosted.getEncryptshippingDetais(),"UTF-8")+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction"
		
		return new RedirectView(encRequest.redirectCall2(merchantOrderNumber,orderAmount,myComponent.getMkValue(),myComponent.getKkValue()));
	
		//return encRequest.redirectcallredirect(req1);
	
	}
	

}
