package com.sbiepay.merchant.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
	
	@Value("${mkValue}")
    private String mkValue;
	
	@Value("${kkValue}")
	private String kkValue;

	public String getMkValue() {
		return mkValue;
	}

	public String getKkValue() {
		return kkValue;
	}

	

}
