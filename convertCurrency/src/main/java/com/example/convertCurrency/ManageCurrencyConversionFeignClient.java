package com.example.convertCurrency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "manage-currency-conversion", url = "${MANAGE-CURRENCY-CONVERSION_HOST:http://localhost}:8000")
public interface ManageCurrencyConversionFeignClient {
	
	@GetMapping(value = "/manage-currency-conversion/{countryCode}")
	public ExchangeValue getCFValFromManageCrncyConversionService(@PathVariable String countryCode);

}
