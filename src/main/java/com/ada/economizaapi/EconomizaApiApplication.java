package com.ada.economizaapi;

import com.ada.economizaapi.entities.Localizacao;
import com.ada.economizaapi.entities.Mercado;
import com.ada.economizaapi.entities.Pessoa;
import com.ada.economizaapi.services.LocalizacaoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class EconomizaApiApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LocalizacaoService localizacaoService = new LocalizacaoService();
        Pessoa pessoa = new Pessoa();
        Mercado mercado1 = new Mercado();
        Mercado mercado2 = new Mercado();

        String coordenadasOrigem = "-35.87041300255157, -7.229628747555913";
        Localizacao localizacaoPessoa = new Localizacao(coordenadasOrigem);
        pessoa.setLocalizacao(localizacaoPessoa);

        String coordenadasMercado1 = "-35.87979648750262, -7.219900831494763";
        Localizacao localizacaoMercado1 = new Localizacao(coordenadasMercado1);
        mercado1.setLocalizacao(localizacaoMercado1);

        String coordenadasMercado2 = "-35.885581258807875, -7.227354594808309";
        Localizacao localizacaoMercado2 = new Localizacao(coordenadasMercado2);
        mercado2.setLocalizacao(localizacaoMercado2);

        Double distancia1 = localizacaoService.retornarDistanciaKm(localizacaoPessoa, localizacaoMercado1);
        Double distancia2 = localizacaoService.retornarDistanciaKm(localizacaoPessoa, localizacaoMercado2);
        System.out.printf("Distância até mercado 1: %.2fKm%n", distancia1);
        System.out.printf("Distância até mercado 2: %.2fKm%n", distancia2);

        scanner.close();

        SpringApplication.run(EconomizaApiApplication.class, args);
    }

}
