package org.BartoszM.currencyConverter;

import lombok.Data;
import java.util.List;

@Data
public class NbpResponse {
    private String currency;
    private String code;
    private List<Rate> rates;
}
