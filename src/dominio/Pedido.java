package dominio;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Produto> pratosSelecionados = new ArrayList<>();
    private List<Produto> bebidasSelecionadas = new ArrayList<>();
    private List<Produto> vinhosSelecionados = new ArrayList<>();
    private double precoTotal = 0.0;
    private String observacao = "";

    public List<Produto> getPratosSelecionados() {
        return pratosSelecionados;
    }

    public void setPratosSelecionados(List<Produto> pratosSelecionados) {
        this.pratosSelecionados = pratosSelecionados;
    }

    public List<Produto> getBebidasSelecionadas() {
        return bebidasSelecionadas;
    }

    public void setBebidasSelecionadas(List<Produto> bebidasSelecionadas) {
        this.bebidasSelecionadas = bebidasSelecionadas;
    }

    public List<Produto> getVinhosSelecionados() {
        return vinhosSelecionados;
    }

    public void setVinhosSelecionados(List<Produto> vinhosSelecionados) {
        this.vinhosSelecionados = vinhosSelecionados;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
