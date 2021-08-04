package br.com.alura.loja.service;

import br.com.alura.loja.client.FornecedorClient;
import br.com.alura.loja.dto.CompraDTO;
import br.com.alura.loja.dto.CompraSucesso;
import br.com.alura.loja.model.Compra;
import br.com.alura.loja.repository.CompraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompraService {

    private static final String URL_FORNECEDOR = "http://fornecedor/info";
    private FornecedorClient fornecedorClient;
    private CompraRepository compraRepository;

    public CompraService(FornecedorClient fornecedorClient, CompraRepository compraRepository) {
        this.fornecedorClient = fornecedorClient;
        this.compraRepository = compraRepository;
    }

    @Transactional
    public CompraSucesso realizaCompra(CompraDTO compra) {
        var info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
        var pedido = fornecedorClient.realizaPedido(compra.getItens());

        var novaCompra = new Compra(
                pedido.getId(),
                pedido.getTempoPreparo(),
                compra.getEndereco().toString()
        );

        this.compraRepository.save(novaCompra);
        return new CompraSucesso(novaCompra);
    }
}
