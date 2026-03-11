package org.BartoszM.currencyConverter;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    private final RestTemplate restTemplate;

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private double getExchangeRate(String currencyCode){
        String nbpUrl =  "http://api.nbp.pl/api/exchangerates/rates/a/" + currencyCode + "/?format=json";
        NbpResponse response = restTemplate.getForObject(nbpUrl, NbpResponse.class);
        if (response == null || response.getRates() == null || response.getRates().isEmpty()){
            throw new RuntimeException("Nie udało się pobrać kursu dla waluty: " + currencyCode);
        }
        return response.getRates().get(0).getMid();
    }

    public double convertForeignToPln(String currencyCode, double amount){
        double exchangeRate = getExchangeRate(currencyCode);
        return amount * exchangeRate;
    }

    public double convertPlnToForeign(String currencyCode, double amount){
        double exchangeRate = getExchangeRate(currencyCode);
        return amount/exchangeRate;
    }
}
