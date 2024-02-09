package br.com.projetonubank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.projetonubank.entity.TransacoesEntity;
import br.com.projetonubank.service.TransacoesService;

public class TransacoesServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private ObjectMapper objectMapper;

    private TransacoesService transacoesService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        transacoesService = new TransacoesService();
        objectMapper = new ObjectMapper();
        transacoesService.restTemplate = restTemplate;
        transacoesService.objectMapper = objectMapper;
    }

    @Test
    public void testCalcularImpostosJSON() throws JsonProcessingException {
        TransacoesEntity[] operations = {
                new TransacoesEntity("buy", 10, 100.0),
                new TransacoesEntity("sell", 5, 120.0),
                new TransacoesEntity("buy", 8, 110.0)
        };
        when(restTemplate.getForObject("http://localhost:3000", TransacoesEntity[].class))
                .thenReturn(operations);

        String result = transacoesService.calcularImpostosJSON();

        assertEquals("[{\"tax\":0.0},{\"tax\":48.0},{\"tax\":0.0}]", result);
    }
}
