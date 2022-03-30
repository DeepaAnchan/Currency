package com.example.convertCurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertCurrencyService {

	@Autowired
	private ManageCurrencyConversionFeignClient manageCurrencyConversionFeignClient;

	public ExchangeValue getConversionFactorAmtOfACountry(String countryCode) {
		System.out.println("ConvertCurrencyService:  getConversionFactorAmtOfACountry method.");

		return manageCurrencyConversionFeignClient.getCFValFromManageCrncyConversionService(countryCode);
	}

}
