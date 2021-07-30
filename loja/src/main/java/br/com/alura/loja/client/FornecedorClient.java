package br.com.alura.loja.client;

import br.com.alura.loja.dto.InfoFornecedorDTO;
import br.com.alura.loja.dto.ItemDTO;
import br.com.alura.loja.dto.PedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

    @RequestMapping(method = RequestMethod.POST, value = "/pedido")
    PedidoDTO realizaPedido(List<ItemDTO> itens);
}
