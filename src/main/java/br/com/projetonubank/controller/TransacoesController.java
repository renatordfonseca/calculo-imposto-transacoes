package br.com.projetonubank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetonubank.service.TransacoesService;

@RestController
public class TransacoesController {
	
	@Autowired
	private TransacoesService transacoesService;
	
    @GetMapping("/transacoes")
    public String getOperations() {
        return transacoesService.calcularImpostosJSON();
    }

}
