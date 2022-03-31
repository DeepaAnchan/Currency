package com.example.convertCurrency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*Commented b'cos, if manage-currency-conversion is up, only then MANAGE-CURRENCY-CONVERSION_SERVICE_HOST value 
* is obtained by ConvertCurrency when it starts.
@FeignClient(name = "manage-currency-conversion", url = "${MANAGE-CURRENCY-CONVERSION_SERVICE_HOST:http://localhost}:8000")
*/

/*Thus, it is recommended to use custom env variables(Here, MANAGE-CURRENCY-CONVERSION_URI) rather than the default
env variables (Here, MANAGE-CURRENCY-CONVERSION_SERVICE_HOST) created by Kubernates.*/

@FeignClient(name = "manage-currency-conversion", url = "${MANAGE-CURRENCY-CONVERSION_URI:http://localhost}:8000")
public interface ManageCurrencyConversionFeignClient {
	
	@GetMapping(value = "/manage-currency-conversion/{countryCode}")
	public ExchangeValue getCFValFromManageCrncyConversionService(@PathVariable String countryCode);

}
