package br.com.conversor;

import com.google.gson.annotations.SerializedName;

public class Conversor {
    @SerializedName("conversion_rate")
    private double taxaDeConversao;
    private String moedaInicial;
    private String moedaFinal;

    public void mostrarResultado(double valor) {
        System.out.printf("""
                O valor %.2f [%s] convertido é %.2f [%s]
                """, valor, this.moedaInicial, converterMoeda(valor), this.moedaFinal);
    }

    public double converterMoeda(double valor) {
        return  valor * taxaDeConversao;
    }

    public double getTaxaDeConversao() {
        return taxaDeConversao;
    }

    public void setTaxaDeConversao(double taxaDeConversao) {
        this.taxaDeConversao = taxaDeConversao;
    }

    public String getMoedaInicial() {
        return moedaInicial;
    }

    public void setMoedaInicial(String moedaInicial) {
        this.moedaInicial = moedaInicial;
    }

    public String getMoedaFinal() {
        return moedaFinal;
    }

    public void setMoedaFinal(String moedaFinal) {
        this.moedaFinal = moedaFinal;
    }

    @Override
    public String toString() {
        return "Moeda{" +
                "taxaDeConversao=" + taxaDeConversao +
                '}';
    }
}
