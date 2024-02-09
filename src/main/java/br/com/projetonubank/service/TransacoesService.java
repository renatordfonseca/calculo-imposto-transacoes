package br.com.projetonubank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.projetonubank.entity.TransacoesEntity;

@Service
public class TransacoesService {

	@Autowired RestTemplate restTemplate;
	
    @Autowired ObjectMapper objectMapper;

    public String calcularImpostosJSON() {
    	
    	TransacoesEntity[] operations = {
                new TransacoesEntity("buy", 10000, 10.00),
                new TransacoesEntity("sell", 5000, 2.00),
                new TransacoesEntity("sell", 2000, 20.00),
                new TransacoesEntity("sell", 2000, 20.00),
                new TransacoesEntity("sell", 1000, 25.00),
                new TransacoesEntity("buy", 10000, 20.00),
                new TransacoesEntity("sell", 5000, 15.00),
                new TransacoesEntity("sell", 4350, 30.00),
                new TransacoesEntity("sell", 650, 30.00)
            };
    	
        double mediaPonderada = 0;
        double prejuizoPassado = 0;
        
        List<Double> impostos = new ArrayList<>();
        
        for (TransacoesEntity operation : operations) {
            if (operation.getOperation().equals("buy")) {

                mediaPonderada = ((mediaPonderada * (operation.getQuantity() + prejuizoPassado))
                        + (operation.getQuantity() * operation.getUnitCost())) / (operation.getQuantity() + prejuizoPassado);
                impostos.add(0.00); 
            } else if (operation.getOperation().equals("sell")) {

                double valorTotalOperacao = operation.getUnitCost() * operation.getQuantity();
                double lucro = 0;

                if (operation.getUnitCost() > mediaPonderada) {

                    lucro = (operation.getUnitCost() - mediaPonderada) * operation.getQuantity();

                    if (valorTotalOperacao > 20000) {
                        double imposto = 0.2 * (lucro - prejuizoPassado);
                        impostos.add(imposto);
                        prejuizoPassado = 0;
                    } else {
                        impostos.add(0.00);
                    }
                } else {

                    prejuizoPassado += (mediaPonderada - operation.getUnitCost()) * operation.getQuantity();
                    impostos.add(0.00); 
                }

                lucro -= prejuizoPassado;
                if (lucro < 0) {
                    prejuizoPassado = -lucro;
                    lucro = 0;
                } else {
                    prejuizoPassado = 0;
                }
            }
        }

        List<TaxResponse> taxResponses = new ArrayList<>();
        for (Double imposto : impostos) {
            taxResponses.add(new TaxResponse(imposto));
        }

        String jsonResult = "[]";
        try {
            jsonResult = objectMapper.writeValueAsString(taxResponses);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }

    private static class TaxResponse {
        @JsonProperty("tax")
        private final Double tax;

        public TaxResponse(Double tax) {
            this.tax = tax;
        }
    }

}
