/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.nicolas.RestClient.cepController;

import br.gm.nicolas.RestClient.cepService.CepDTO;
import br.gm.nicolas.RestClient.cepService.CepService;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller de integração API -> ViaCep
 * 
 * @author nckz06_
 */
@RestController
public class MyController {
    
    @Autowired
    private CepService cepService;
    
    @GetMapping("/cep/{cepID}")
    public ResponseEntity<CepDTO> buscaCep(@PathVariable String cepID) {
        
        Optional<CepDTO> optCepDTO = cepService.buscarCep(cepID);
        
        if(optCepDTO.isPresent()) {
            return ResponseEntity.ok(optCepDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }
    
    @GetMapping("/status")
    public Map<String, String> getMyControllerStatus() {
        
        Map status = new HashMap();
        status.put("status", "Ok");
        return status;
        
    }
    
}
