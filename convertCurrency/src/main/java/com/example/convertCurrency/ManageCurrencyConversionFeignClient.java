package com.example.convertCurrency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@LoadBalancerClient(name = "manage-currency-conversion", configuration =  LoadBalancerConfiguration.class) 


@FeignClient(name = "manage-currency-conversion")//, url = "${feign.client.url}")
public interface ManageCurrencyConversionFeignClient {
	
	@GetMapping(value = "/manageCurrencyCoversionEntity/{countryCode}")
	public ExchangeValue getCFValFromManageCrncyConversionService(@PathVariable String countryCode);

}
