package com.sbiepay.merchant.controller;

/*import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
*/
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class MyComponent {
	
	@Value("${mkValue}")
    private String mkValue;
	
	@Value("${kkValue}")
	private String kkValue;
	
	@Value("${successUrl}")
	private String successUrl;
	
	@Value("${failUrl}")
	private String failUrl;
	
	@Value("${merchantId}")
	private String merchantId;
	

	public String getMkValue() {
		return mkValue;
	}

	public String getKkValue() {
		return kkValue;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public String getFailUrl() {
		return failUrl;
	}

	public String getMerchantId() {
		return merchantId;
	}

	
}
