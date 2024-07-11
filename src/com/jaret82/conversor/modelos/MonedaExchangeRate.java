package com.jaret82.conversor.modelos;

public record MonedaExchangeRate(String result,
                                 String base_code,
                                 String target_code,
                                 double conversion_rate,
                                 double conversion_result) {
}
