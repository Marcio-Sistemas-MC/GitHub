/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ateliê do Software Sistemas sobre Medida
 */
public class Produto {

    private int codigo;
    private String descricao = "";
    private String codBarras = "";
    private String undMedida = "";
    private double qdEstoque = 0;
    private double estoqueMin = 0;
    private double precoCusto = 0;
    private LocalDate datCusto = LocalDate.now();
    private char ativo = 'S';
    private double margemLucro = 0;
    private double precoVenda = 0;
    private LocalDate dataPreco = LocalDate.now();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getUndMedida() {
        return undMedida;
    }

    public void setUndMedida(String undMedida) {
        this.undMedida = undMedida;
    }

    public double getQdEstoque() {
        return qdEstoque;
    }

    public void setQdEstoque(double qdEstoque) {
        this.qdEstoque = qdEstoque;
    }

    public double getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(double estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public LocalDate getDatCusto() {
        return datCusto;
    }

    public void setDatCusto(LocalDate datCusto) {
        this.datCusto = datCusto;
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.datCusto.format(formatador);
    }

    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

    public double getMargemLucro() {
        return margemLucro;
    }

    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public LocalDate getDataPreco() {
        return dataPreco;
    }

    public void setDataPreco(LocalDate dataPreco) {
        this.dataPreco = dataPreco;
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataPreco.format(formatador);
    }

    public boolean isAtivo() {
        return this.ativo == 'S';
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", descricao=" + descricao + ", codBarras=" + codBarras + ", undMedida=" + undMedida + ", qdEstoque=" + qdEstoque + ", estoqueMin=" + estoqueMin + ", precoCusto=" + precoCusto + ", datCusto=" + datCusto + ", ativo=" + ativo + ", margemLucro=" + margemLucro + ", precoVenda=" + precoVenda + ", dataPreco=" + dataPreco + '}';
    }

    public double calculaPrecoVenda() {
        return this.precoCusto + (this.precoCusto * this.margemLucro / 100);
    }

}
