package br.com.alura.loja.service;

import br.com.alura.loja.client.FornecedorClient;
import br.com.alura.loja.dto.CompraDTO;
import br.com.alura.loja.dto.CompraSucesso;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private static final String URL_FORNECEDOR = "http://fornecedor/info";
    private FornecedorClient fornecedorClient;

    public CompraService(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    public CompraSucesso realizaCompra(CompraDTO compra) {
        var info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
        var pedido = fornecedorClient.realizaPedido(compra.getItens());

        return new CompraSucesso(
                pedido.getId(),
                pedido.getTempoPreparo(),
                info.getEndereco().toString()
        );
    }
}
