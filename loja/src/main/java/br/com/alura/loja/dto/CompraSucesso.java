package br.com.alura.loja.dto;

import br.com.alura.loja.model.Compra;

public class CompraSucesso {

    private Long id;
    private Integer tempoPreparo;
    private String enderecoEntrega;

    public CompraSucesso(Long id, Integer tempoPreparo, String enderecoEntrega) {
        this.id = id;
        this.tempoPreparo = tempoPreparo;
        this.enderecoEntrega = enderecoEntrega;
    }

    public CompraSucesso(Compra compra) {
        this.id = compra.getId();
        this.tempoPreparo = compra.getTempoPreparo();
        this.enderecoEntrega = compra.getEnderecoEntrega();
    }

    public Long getId() {
        return id;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }
}
