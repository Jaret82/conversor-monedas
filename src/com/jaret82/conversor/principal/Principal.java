package com.jaret82.conversor.principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jaret82.conversor.calculos.Opcion;
import com.jaret82.conversor.modelos.Moneda;
import com.jaret82.conversor.modelos.MonedaExchangeRate;

import java.util.InputMismatchException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String textoBienvenida = """
                    *************************************
                    Sea Bienvenido al conversor de Monedas ;)
                    1) Dólar =>> Sol Peruano
                    2) Sol Peruano =>> Dólar
                    3) Dólar =>> Peso Argentino
                    4) Peso Argentino =>> Dolar
                    5) Real Brasileño =>> Dólar
                    6) Dólar =>> Real Brasileño
                    7) Peso Colombiano =>> Dolar
                    8) Salir
                    Digite una opción válida:
                    *************************************
                    """;
        Scanner entrada = new Scanner(System.in);
        //Ingresar API-KEY de ExchangeRate-API
        //-----------------------------------
        String apiKey = "";
        //-----------------------------------
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while (true) {
            System.out.println(textoBienvenida);
            try {
                Opcion opcion = new Opcion(entrada.nextInt());
                if (opcion.getOpcion() == 8) {
                    System.out.println("Programa finalizado");
                    break;
                } else if (opcion.getOpcion() < 1 || opcion.getOpcion() > 8) {
                    System.out.println("Opcion no válida!.");
                } else {
                    System.out.println("Ingresa el valor que deseas convertir:");
                    double cantidad = entrada.nextDouble();
                    String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" +
                            opcion.getMonedas()[0] + "/" + opcion.getMonedas()[1] + "/" + cantidad;

                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(direccion))
                            .build();
                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());

                    String json = response.body();

                    MonedaExchangeRate miMonedaExchangeRate = gson.fromJson(json, MonedaExchangeRate.class);

                    Moneda miMoneda = new Moneda(miMonedaExchangeRate, cantidad);
                    System.out.println(miMoneda);
                }
            }catch(InputMismatchException e){
                System.out.println("Opción no válida.");
                entrada.nextLine();
            } catch(Exception e){
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        }
    }
}
