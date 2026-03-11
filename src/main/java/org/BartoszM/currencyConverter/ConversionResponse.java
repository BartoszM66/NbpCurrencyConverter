package org.BartoszM.currencyConverter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConversionResponse {
    private String currencyCode;
    private double originalAmount;
    private double exchangeRate;
    private double resultInPln;
}
