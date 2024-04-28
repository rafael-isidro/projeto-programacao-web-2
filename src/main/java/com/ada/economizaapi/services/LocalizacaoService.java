package com.ada.economizaapi.services;

import com.ada.economizaapi.entities.Localizacao;
import com.ada.economizaapi.services.responses.DistanceResponse;
import com.ada.economizaapi.services.responses.Feature;
import com.ada.economizaapi.services.responses.Properties;
import com.ada.economizaapi.services.responses.Segment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class LocalizacaoService {
    private final String API_KEY = "5b3ce3597851110001cf624822b8f2ef32ca4aa0906695f5d6a8e19c";

    public Double retornarDistanciaKm(Localizacao localizacaoOrigem, Localizacao localizacaoDestino) {

        return WebClient
                .create()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("api.openrouteservice.org")
                        .path("/v2/directions/driving-car")
                        .queryParam("api_key", API_KEY)
                        .queryParam("start", localizacaoOrigem.getCoordenadas())
                        .queryParam("end", localizacaoDestino.getCoordenadas())
                        .build())
                .retrieve()
                .bodyToMono(DistanceResponse.class)
                .flatMap(this::obterDistancia)
                .block();
    }


    private Mono<Double> obterDistancia(DistanceResponse response) {
        if (response != null && response.getFeatures() != null && response.getFeatures().length > 0) {
            Feature feature = response.getFeatures()[0];
            Properties properties = feature.getProperties();
            Segment[] segments = properties.getSegments();
            if (segments != null && segments.length > 0) {
                return Mono.just(segments[0].getDistance() / 1000.0);
            }
        }

        return Mono.error(new IllegalStateException("Não foi possível obter a distância da resposta."));
    }
}
