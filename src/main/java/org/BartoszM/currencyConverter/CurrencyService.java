package org.BartoszM.currencyConverter;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ConversionResponse convert(String currencyCode, double amount) {
        String nbpUrl = "http://api.nbp.pl/api/exchangerates/rates/a/" + currencyCode + "/?format=json";
        NbpResponse response = restTemplate.getForObject(nbpUrl, NbpResponse.class);
        if (response == null || response.getRates() == null || response.getRates().isEmpty()) {
            throw new RuntimeException("Nie udało się pobrać kursu dla waluty" + currencyCode);
        }
        double exchangeRate = response.getRates().get(0).getMid();
        double resultInPln = amount * exchangeRate;
        return new ConversionResponse(currencyCode.toUpperCase(), amount, exchangeRate, resultInPln);
    }
}
