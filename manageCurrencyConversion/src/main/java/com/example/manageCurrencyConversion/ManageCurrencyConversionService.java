package com.example.manageCurrencyConversion;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageCurrencyConversionService {

	@Autowired
	private ManageCurrencyConversionRepository manageCurrencyCoversionRepository;
	
	
	public ManageCurrencyConversionEntity saveCurrencyConversionData(ManageCurrencyConversionEntity currencyConversionEntity) {
		System.out.println("Inside ManageCurrencyConversionService - saveCurrencyConversionData");
		ManageCurrencyConversionEntity savedEntity = null;
		if (currencyConversionEntity != null) {
			try {
				savedEntity = manageCurrencyCoversionRepository.save(currencyConversionEntity);
			} catch (Exception e) {
				System.out.println("" + e.getMessage());
			}
		}
		return savedEntity;
	}
	
	public Double getConversionFactorData(String countryCode) {
		System.out.println("Inside ManageCurrencyConversionService - getConversionFactorData");
		Optional<ManageCurrencyConversionEntity> entity = null;
		Double conversionFactor = 0.0;
		if (countryCode != null && !countryCode.isEmpty()) {
			try {
				entity = manageCurrencyCoversionRepository.findById(countryCode);
				if (entity.isPresent()) {
					conversionFactor = entity.get().getConversionFactor();
				}
			} catch (Exception e) {
				System.out.println("" + e.getMessage());
			}
		}
		return conversionFactor;
	}
	
	public boolean updateCurrencyConversionData(ManageCurrencyConversionEntity newCurrencyConversionEntity) {
		System.out.println("Inside ManageCurrencyConversionService - updateCurrencyConversionData");
		boolean success = false;
		if (newCurrencyConversionEntity.getCountryCode() != null) {
			try {
				manageCurrencyCoversionRepository.findById(newCurrencyConversionEntity.getCountryCode())
						.map(oldCurrencyConversionEntity -> {
							oldCurrencyConversionEntity
									.setConversionFactor(newCurrencyConversionEntity.getConversionFactor());
							return manageCurrencyCoversionRepository.save(oldCurrencyConversionEntity);
						}).orElseGet(() -> {
							return manageCurrencyCoversionRepository.save(newCurrencyConversionEntity);
						});

				success = true;
			} catch (Exception e) {
				System.out.println("" + e.getMessage());
			}
		}
		return success;
	}


}
