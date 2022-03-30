package com.example.convertCurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class ConvertCurrencyController {
	@Autowired
	private ConvertCurrencyService convertCurrencyService;


	public Double convertCurrencyCircuitBreakerFallBack(String countryCode,Double amount) {
		System.out.println("Inside the fallback method");
		return 0.0;
	}
	
	@GetMapping(value = "/convertCurrency/{countryCode}/{amount}/")
	@HystrixCommand(fallbackMethod = "convertCurrencyCircuitBreakerFallBack") 
	public Double convertCurrency(@PathVariable String countryCode, @PathVariable Double amount) {
		System.out.println("Inside the convertCurrency method.");
		Double convertedAmount = 0.0;
		if (countryCode != null) {
			System.out.println("Before call");
			convertedAmount = amount * (convertCurrencyService.getConversionFactorAmtOfACountry(countryCode));
			System.out.println("After call");

		}
		
		return convertedAmount;
	}
	
	
	
}
