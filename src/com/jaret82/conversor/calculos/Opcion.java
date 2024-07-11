package com.jaret82.conversor.calculos;

public class Opcion {
    private int opcion;
    private String[] monedas = new String[2];

    public Opcion(int opcion) {
        this.opcion = opcion;
        switch (opcion) {
            case 1:
                monedas[0] = "USD";
                monedas[1] = "PEN";
                break;
            case 2:
                monedas[0] = "PEN";
                monedas[1] = "USD";
                break;
            case 3:
                monedas[0] = "USD";
                monedas[1] = "ARS";
                break;
            case 4:
                monedas[0] = "ARS";
                monedas[1] = "USD";
                break;
            case 5:
                monedas[0] = "BRL";
                monedas[1] = "USD";
                break;
            case 6:
                monedas[0] = "USD";
                monedas[1] = "BRL";
                break;
            case 7:
                monedas[0] = "COP";
                monedas[1] = "USD";
        }
    }

    public int getOpcion() {
        return opcion;
    }

    public String[] getMonedas() {
        return monedas;
    }
}
