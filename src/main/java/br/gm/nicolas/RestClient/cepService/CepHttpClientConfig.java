/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.nicolas.RestClient.cepService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

/**
 * Implementa a configuração do cliente ViaCep
 * 
 * @author nckz06_
 */
@Configuration
public class CepHttpClientConfig {
    
    /**
     * Injeta automaticamente o valor do servicos.viacep.base-url
     * que está no application.properties na variável apiBaseUrl
     * // https://viacep.com.br/ws/
     */
    @Value("${servicos.viacep.base-url}")
    private String cepApiBaseUrl;
    
    @Bean
    public RestClient cepRestClient() {
        return RestClient.builder()
                .baseUrl(cepApiBaseUrl)
                .defaultHeader(HttpHeaders.ACCEPT,
                        MediaType.APPLICATION_JSON_VALUE)
                .build();                   
    }
    
    
}
