package br.com.alura.loja.controller;

import br.com.alura.loja.dto.CompraDTO;
import br.com.alura.loja.dto.CompraSucesso;
import br.com.alura.loja.service.CompraService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public CompraSucesso realizaCompra(@RequestBody CompraDTO compra) {
        return this.compraService.realizaCompra(compra);
    }
}
