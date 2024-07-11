package com.jaret82.conversor.modelos;

import java.text.DecimalFormat;

public class Moneda {
    private String monedaEntrante;
    private String monedaSaliente;
    private double ratioConversion;
    private double resultadoConversion;
    private double cantidad;

    public Moneda(MonedaExchangeRate monedaExch, double cantidad){
        this.monedaEntrante = monedaExch.base_code();
        this.monedaSaliente = monedaExch.target_code();
        this.ratioConversion = monedaExch.conversion_rate();
        this.resultadoConversion = monedaExch.conversion_result();
        this.cantidad = cantidad;
    }
    /*
    public String getMonedaEntrante() {
        return monedaEntrante;
    }

    public String getMonedaSaliente() {
        return monedaSaliente;
    }

    public double getRatioConversion() {
        return ratioConversion;
    }

    public double getResultadoConversion() {
        return resultadoConversion;
    }
    */
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#####");
        return "El valor "+cantidad+"["+monedaEntrante+"]"+" corresponde al valor final de"+
                " =>>> "+resultadoConversion+"["+monedaSaliente+"]"+".\n"+
                "Cada "+monedaEntrante+" equivale a: "+df.format(ratioConversion)+"["+monedaSaliente+"]";
    }
}
