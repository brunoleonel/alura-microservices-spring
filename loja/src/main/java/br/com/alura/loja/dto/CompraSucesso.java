package br.com.alura.loja.dto;

public class CompraSucesso {

    private Long id;
    private Integer tempoPreparo;
    private String enderecoEntrega;

    public CompraSucesso(Long id, Integer tempoPreparo, String enderecoEntrega) {
        this.id = id;
        this.tempoPreparo = tempoPreparo;
        this.enderecoEntrega = enderecoEntrega;
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
