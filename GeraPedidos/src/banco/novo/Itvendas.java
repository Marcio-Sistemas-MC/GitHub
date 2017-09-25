/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.novo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Paulo
 */
@Entity
@Table(name = "itvendas")
@NamedQueries({
    @NamedQuery(name = "Itvendas.findAll", query = "SELECT i FROM Itvendas i")})
public class Itvendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItvendasPK itvendasPK;
    @Column(name = "refere1")
    private String refere1;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quanta1")
    private BigDecimal quanta1;
    @Column(name = "precobruto")
    private BigDecimal precobruto;
    @Column(name = "precoespecial")
    private BigDecimal precoespecial;
    @Column(name = "preco1")
    private BigDecimal preco1;
    @Column(name = "custo1")
    private BigDecimal custo1;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "vir_refere")
    private String virRefere;
    @Column(name = "tipot")
    private String tipot;
    @Column(name = "alqitem")
    private BigDecimal alqitem;
    @Column(name = "cstitem")
    private String cstitem;
    @Column(name = "quantadevol")
    private BigDecimal quantadevol;
    @Column(name = "valimpbruto")
    private BigDecimal valimpbruto;
    @Column(name = "valimp")
    private BigDecimal valimp;
    @Column(name = "flagretorno")
    private String flagretorno;
    @Column(name = "obsitem")
    private String obsitem;
    @Column(name = "csosn")
    private String csosn;
    @Column(name = "codcfop")
    private String codcfop;
    @Column(name = "baseicms")
    private BigDecimal baseicms;
    @Column(name = "valicms")
    private BigDecimal valicms;
    @JoinColumn(name = "codpro", referencedColumnName = "codpro")
    @ManyToOne
    private Produtos codpro;

    public Itvendas() {
    }

    public Itvendas(ItvendasPK itvendasPK) {
        this.itvendasPK = itvendasPK;
    }

    public Itvendas(int nvenda, String ncaixa, int nitem) {
        this.itvendasPK = new ItvendasPK(nvenda, ncaixa, nitem);
    }

    public ItvendasPK getItvendasPK() {
        return itvendasPK;
    }

    public void setItvendasPK(ItvendasPK itvendasPK) {
        this.itvendasPK = itvendasPK;
    }

    public String getRefere1() {
        return refere1;
    }

    public void setRefere1(String refere1) {
        this.refere1 = refere1;
    }

    public BigDecimal getQuanta1() {
        return quanta1;
    }

    public void setQuanta1(BigDecimal quanta1) {
        this.quanta1 = quanta1;
    }

    public BigDecimal getPrecobruto() {
        return precobruto;
    }

    public void setPrecobruto(BigDecimal precobruto) {
        this.precobruto = precobruto;
    }

    public BigDecimal getPrecoespecial() {
        return precoespecial;
    }

    public void setPrecoespecial(BigDecimal precoespecial) {
        this.precoespecial = precoespecial;
    }

    public BigDecimal getPreco1() {
        return preco1;
    }

    public void setPreco1(BigDecimal preco1) {
        this.preco1 = preco1;
    }

    public BigDecimal getCusto1() {
        return custo1;
    }

    public void setCusto1(BigDecimal custo1) {
        this.custo1 = custo1;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getVirRefere() {
        return virRefere;
    }

    public void setVirRefere(String virRefere) {
        this.virRefere = virRefere;
    }

    public String getTipot() {
        return tipot;
    }

    public void setTipot(String tipot) {
        this.tipot = tipot;
    }

    public BigDecimal getAlqitem() {
        return alqitem;
    }

    public void setAlqitem(BigDecimal alqitem) {
        this.alqitem = alqitem;
    }

    public String getCstitem() {
        return cstitem;
    }

    public void setCstitem(String cstitem) {
        this.cstitem = cstitem;
    }

    public BigDecimal getQuantadevol() {
        return quantadevol;
    }

    public void setQuantadevol(BigDecimal quantadevol) {
        this.quantadevol = quantadevol;
    }

    public BigDecimal getValimpbruto() {
        return valimpbruto;
    }

    public void setValimpbruto(BigDecimal valimpbruto) {
        this.valimpbruto = valimpbruto;
    }

    public BigDecimal getValimp() {
        return valimp;
    }

    public void setValimp(BigDecimal valimp) {
        this.valimp = valimp;
    }

    public String getFlagretorno() {
        return flagretorno;
    }

    public void setFlagretorno(String flagretorno) {
        this.flagretorno = flagretorno;
    }

    public String getObsitem() {
        return obsitem;
    }

    public void setObsitem(String obsitem) {
        this.obsitem = obsitem;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public String getCodcfop() {
        return codcfop;
    }

    public void setCodcfop(String codcfop) {
        this.codcfop = codcfop;
    }

    public BigDecimal getBaseicms() {
        return baseicms;
    }

    public void setBaseicms(BigDecimal baseicms) {
        this.baseicms = baseicms;
    }

    public BigDecimal getValicms() {
        return valicms;
    }

    public void setValicms(BigDecimal valicms) {
        this.valicms = valicms;
    }

    public Produtos getCodpro() {
        return codpro;
    }

    public void setCodpro(Produtos codpro) {
        this.codpro = codpro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itvendasPK != null ? itvendasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itvendas)) {
            return false;
        }
        Itvendas other = (Itvendas) object;
        if ((this.itvendasPK == null && other.itvendasPK != null) || (this.itvendasPK != null && !this.itvendasPK.equals(other.itvendasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.novo.Itvendas[ itvendasPK=" + itvendasPK + " ]";
    }
    
}
