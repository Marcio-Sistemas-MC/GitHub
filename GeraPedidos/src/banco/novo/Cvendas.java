/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.novo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Paulo
 */
@Entity
@Table(name = "cvendas")
@NamedQueries({
    @NamedQuery(name = "Cvendas.findAll", query = "SELECT c FROM Cvendas c")})
public class Cvendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CvendasPK cvendasPK;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "horario")
    private String horario;
    @Column(name = "turno")
    private String turno;
    @Column(name = "flag_tipomov")
    private Integer flagTipomov;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "qtd_prod")
    private BigDecimal qtdProd;
    @Column(name = "total_cust")
    private BigDecimal totalCust;
    @Column(name = "total_bruto")
    private BigDecimal totalBruto;
    @Column(name = "desconto_itens")
    private BigDecimal descontoItens;
    @Column(name = "total_prod")
    private BigDecimal totalProd;
    @Column(name = "valorbrutovenda")
    private BigDecimal valorbrutovenda;
    @Column(name = "totjurosforma")
    private BigDecimal totjurosforma;
    @Column(name = "desconto_v")
    private BigDecimal descontoV;
    @Column(name = "por_desc")
    private BigDecimal porDesc;
    @Column(name = "acresc_v")
    private BigDecimal acrescV;
    @Column(name = "por_acres")
    private BigDecimal porAcres;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "valor_pg")
    private BigDecimal valorPg;
    @Column(name = "troco")
    private BigDecimal troco;
    @Column(name = "nomecli")
    private String nomecli;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "inscricao")
    private String inscricao;
    @Column(name = "operador")
    private String operador;
    @Column(name = "codusuario")
    private Integer codusuario;
    @Column(name = "codvendedor")
    private Integer codvendedor;
    @Column(name = "fone")
    private String fone;
    @Column(name = "codcondpgto")
    private Integer codcondpgto;
    @Column(name = "vencimento")
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    @Column(name = "codentregador")
    private Integer codentregador;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "ref_ent")
    private String refEnt;
    @Column(name = "flag_cancelado")
    private String flagCancelado;
    @Column(name = "canceladata")
    @Temporal(TemporalType.TIMESTAMP)
    private Date canceladata;
    @Column(name = "cancelausuario")
    private Integer cancelausuario;
    @Column(name = "nomedependente")
    private String nomedependente;
    @Column(name = "seqnf")
    private Integer seqnf;
    @Column(name = "obsvenda")
    private String obsvenda;
    @Column(name = "pesocalc")
    private Integer pesocalc;
    @Column(name = "pesoreal")
    private Integer pesoreal;
    @Column(name = "endere_logra")
    private String endereLogra;
    @Column(name = "endere_num")
    private String endereNum;
    @Column(name = "endere_compl")
    private String endereCompl;
    @Column(name = "codcidade")
    private Integer codcidade;
    @Column(name = "endere")
    private String endere;
    @Column(name = "uf")
    private String uf;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "cancelamotivo")
    private String cancelamotivo;
    @Column(name = "logdatahoraalt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logdatahoraalt;
    @Column(name = "devolvincnvenda")
    private Integer devolvincnvenda;
    @Column(name = "devolvincncaixa")
    private String devolvincncaixa;
    @Column(name = "codautdesconto")
    private Integer codautdesconto;
    @Column(name = "trocochtroco")
    private BigDecimal trocochtroco;
    @Column(name = "flagimpresso")
    private String flagimpresso;
    @Column(name = "flag_tipomovorig")
    private Integer flagTipomovorig;
    @Column(name = "qtdeitens")
    private BigDecimal qtdeitens;
    @Column(name = "totalbaseicms")
    private BigDecimal totalbaseicms;
    @Column(name = "totalicms")
    private BigDecimal totalicms;
    @Column(name = "entregadom")
    private String entregadom;
    @Column(name = "nfcenumero")
    private Integer nfcenumero;
    @Column(name = "nfcetipoemis")
    private Integer nfcetipoemis;
    @Column(name = "nfceambiente")
    private Integer nfceambiente;
    @Column(name = "nfcedhcont")
    private String nfcedhcont;
    @Column(name = "nfcejustcont")
    private String nfcejustcont;
    @Column(name = "nfcechaveacesso")
    private String nfcechaveacesso;
    @Column(name = "nfcenumrecibo")
    private String nfcenumrecibo;
    @Column(name = "nfcesituacao")
    private Integer nfcesituacao;
    @Column(name = "nfcenumprotocolo")
    private String nfcenumprotocolo;
    @Column(name = "nfcecstat")
    private String nfcecstat;
    @Column(name = "nfceretorno")
    private String nfceretorno;
    @Column(name = "nfcenumprotcanc")
    private String nfcenumprotcanc;
    @JoinColumn(name = "cod_cliente", referencedColumnName = "codpessoa")
    @ManyToOne
    private Clientes codCliente;

    public Cvendas() {
    }

    public Cvendas(CvendasPK cvendasPK) {
        this.cvendasPK = cvendasPK;
    }

    public Cvendas(int nvenda, String ncaixa) {
        this.cvendasPK = new CvendasPK(nvenda, ncaixa);
    }

    public CvendasPK getCvendasPK() {
        return cvendasPK;
    }

    public void setCvendasPK(CvendasPK cvendasPK) {
        this.cvendasPK = cvendasPK;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Integer getFlagTipomov() {
        return flagTipomov;
    }

    public void setFlagTipomov(Integer flagTipomov) {
        this.flagTipomov = flagTipomov;
    }

    public BigDecimal getQtdProd() {
        return qtdProd;
    }

    public void setQtdProd(BigDecimal qtdProd) {
        this.qtdProd = qtdProd;
    }

    public BigDecimal getTotalCust() {
        return totalCust;
    }

    public void setTotalCust(BigDecimal totalCust) {
        this.totalCust = totalCust;
    }

    public BigDecimal getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(BigDecimal totalBruto) {
        this.totalBruto = totalBruto;
    }

    public BigDecimal getDescontoItens() {
        return descontoItens;
    }

    public void setDescontoItens(BigDecimal descontoItens) {
        this.descontoItens = descontoItens;
    }

    public BigDecimal getTotalProd() {
        return totalProd;
    }

    public void setTotalProd(BigDecimal totalProd) {
        this.totalProd = totalProd;
    }

    public BigDecimal getValorbrutovenda() {
        return valorbrutovenda;
    }

    public void setValorbrutovenda(BigDecimal valorbrutovenda) {
        this.valorbrutovenda = valorbrutovenda;
    }

    public BigDecimal getTotjurosforma() {
        return totjurosforma;
    }

    public void setTotjurosforma(BigDecimal totjurosforma) {
        this.totjurosforma = totjurosforma;
    }

    public BigDecimal getDescontoV() {
        return descontoV;
    }

    public void setDescontoV(BigDecimal descontoV) {
        this.descontoV = descontoV;
    }

    public BigDecimal getPorDesc() {
        return porDesc;
    }

    public void setPorDesc(BigDecimal porDesc) {
        this.porDesc = porDesc;
    }

    public BigDecimal getAcrescV() {
        return acrescV;
    }

    public void setAcrescV(BigDecimal acrescV) {
        this.acrescV = acrescV;
    }

    public BigDecimal getPorAcres() {
        return porAcres;
    }

    public void setPorAcres(BigDecimal porAcres) {
        this.porAcres = porAcres;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorPg() {
        return valorPg;
    }

    public void setValorPg(BigDecimal valorPg) {
        this.valorPg = valorPg;
    }

    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }

    public String getNomecli() {
        return nomecli;
    }

    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Integer getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(Integer codusuario) {
        this.codusuario = codusuario;
    }

    public Integer getCodvendedor() {
        return codvendedor;
    }

    public void setCodvendedor(Integer codvendedor) {
        this.codvendedor = codvendedor;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Integer getCodcondpgto() {
        return codcondpgto;
    }

    public void setCodcondpgto(Integer codcondpgto) {
        this.codcondpgto = codcondpgto;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Integer getCodentregador() {
        return codentregador;
    }

    public void setCodentregador(Integer codentregador) {
        this.codentregador = codentregador;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRefEnt() {
        return refEnt;
    }

    public void setRefEnt(String refEnt) {
        this.refEnt = refEnt;
    }

    public String getFlagCancelado() {
        return flagCancelado;
    }

    public void setFlagCancelado(String flagCancelado) {
        this.flagCancelado = flagCancelado;
    }

    public Date getCanceladata() {
        return canceladata;
    }

    public void setCanceladata(Date canceladata) {
        this.canceladata = canceladata;
    }

    public Integer getCancelausuario() {
        return cancelausuario;
    }

    public void setCancelausuario(Integer cancelausuario) {
        this.cancelausuario = cancelausuario;
    }

    public String getNomedependente() {
        return nomedependente;
    }

    public void setNomedependente(String nomedependente) {
        this.nomedependente = nomedependente;
    }

    public Integer getSeqnf() {
        return seqnf;
    }

    public void setSeqnf(Integer seqnf) {
        this.seqnf = seqnf;
    }

    public String getObsvenda() {
        return obsvenda;
    }

    public void setObsvenda(String obsvenda) {
        this.obsvenda = obsvenda;
    }

    public Integer getPesocalc() {
        return pesocalc;
    }

    public void setPesocalc(Integer pesocalc) {
        this.pesocalc = pesocalc;
    }

    public Integer getPesoreal() {
        return pesoreal;
    }

    public void setPesoreal(Integer pesoreal) {
        this.pesoreal = pesoreal;
    }

    public String getEndereLogra() {
        return endereLogra;
    }

    public void setEndereLogra(String endereLogra) {
        this.endereLogra = endereLogra;
    }

    public String getEndereNum() {
        return endereNum;
    }

    public void setEndereNum(String endereNum) {
        this.endereNum = endereNum;
    }

    public String getEndereCompl() {
        return endereCompl;
    }

    public void setEndereCompl(String endereCompl) {
        this.endereCompl = endereCompl;
    }

    public Integer getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(Integer codcidade) {
        this.codcidade = codcidade;
    }

    public String getEndere() {
        return endere;
    }

    public void setEndere(String endere) {
        this.endere = endere;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCancelamotivo() {
        return cancelamotivo;
    }

    public void setCancelamotivo(String cancelamotivo) {
        this.cancelamotivo = cancelamotivo;
    }

    public Date getLogdatahoraalt() {
        return logdatahoraalt;
    }

    public void setLogdatahoraalt(Date logdatahoraalt) {
        this.logdatahoraalt = logdatahoraalt;
    }

    public Integer getDevolvincnvenda() {
        return devolvincnvenda;
    }

    public void setDevolvincnvenda(Integer devolvincnvenda) {
        this.devolvincnvenda = devolvincnvenda;
    }

    public String getDevolvincncaixa() {
        return devolvincncaixa;
    }

    public void setDevolvincncaixa(String devolvincncaixa) {
        this.devolvincncaixa = devolvincncaixa;
    }

    public Integer getCodautdesconto() {
        return codautdesconto;
    }

    public void setCodautdesconto(Integer codautdesconto) {
        this.codautdesconto = codautdesconto;
    }

    public BigDecimal getTrocochtroco() {
        return trocochtroco;
    }

    public void setTrocochtroco(BigDecimal trocochtroco) {
        this.trocochtroco = trocochtroco;
    }

    public String getFlagimpresso() {
        return flagimpresso;
    }

    public void setFlagimpresso(String flagimpresso) {
        this.flagimpresso = flagimpresso;
    }

    public Integer getFlagTipomovorig() {
        return flagTipomovorig;
    }

    public void setFlagTipomovorig(Integer flagTipomovorig) {
        this.flagTipomovorig = flagTipomovorig;
    }

    public BigDecimal getQtdeitens() {
        return qtdeitens;
    }

    public void setQtdeitens(BigDecimal qtdeitens) {
        this.qtdeitens = qtdeitens;
    }

    public BigDecimal getTotalbaseicms() {
        return totalbaseicms;
    }

    public void setTotalbaseicms(BigDecimal totalbaseicms) {
        this.totalbaseicms = totalbaseicms;
    }

    public BigDecimal getTotalicms() {
        return totalicms;
    }

    public void setTotalicms(BigDecimal totalicms) {
        this.totalicms = totalicms;
    }

    public String getEntregadom() {
        return entregadom;
    }

    public void setEntregadom(String entregadom) {
        this.entregadom = entregadom;
    }

    public Integer getNfcenumero() {
        return nfcenumero;
    }

    public void setNfcenumero(Integer nfcenumero) {
        this.nfcenumero = nfcenumero;
    }

    public Integer getNfcetipoemis() {
        return nfcetipoemis;
    }

    public void setNfcetipoemis(Integer nfcetipoemis) {
        this.nfcetipoemis = nfcetipoemis;
    }

    public Integer getNfceambiente() {
        return nfceambiente;
    }

    public void setNfceambiente(Integer nfceambiente) {
        this.nfceambiente = nfceambiente;
    }

    public String getNfcedhcont() {
        return nfcedhcont;
    }

    public void setNfcedhcont(String nfcedhcont) {
        this.nfcedhcont = nfcedhcont;
    }

    public String getNfcejustcont() {
        return nfcejustcont;
    }

    public void setNfcejustcont(String nfcejustcont) {
        this.nfcejustcont = nfcejustcont;
    }

    public String getNfcechaveacesso() {
        return nfcechaveacesso;
    }

    public void setNfcechaveacesso(String nfcechaveacesso) {
        this.nfcechaveacesso = nfcechaveacesso;
    }

    public String getNfcenumrecibo() {
        return nfcenumrecibo;
    }

    public void setNfcenumrecibo(String nfcenumrecibo) {
        this.nfcenumrecibo = nfcenumrecibo;
    }

    public Integer getNfcesituacao() {
        return nfcesituacao;
    }

    public void setNfcesituacao(Integer nfcesituacao) {
        this.nfcesituacao = nfcesituacao;
    }

    public String getNfcenumprotocolo() {
        return nfcenumprotocolo;
    }

    public void setNfcenumprotocolo(String nfcenumprotocolo) {
        this.nfcenumprotocolo = nfcenumprotocolo;
    }

    public String getNfcecstat() {
        return nfcecstat;
    }

    public void setNfcecstat(String nfcecstat) {
        this.nfcecstat = nfcecstat;
    }

    public String getNfceretorno() {
        return nfceretorno;
    }

    public void setNfceretorno(String nfceretorno) {
        this.nfceretorno = nfceretorno;
    }

    public String getNfcenumprotcanc() {
        return nfcenumprotcanc;
    }

    public void setNfcenumprotcanc(String nfcenumprotcanc) {
        this.nfcenumprotcanc = nfcenumprotcanc;
    }

    public Clientes getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Clientes codCliente) {
        this.codCliente = codCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cvendasPK != null ? cvendasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cvendas)) {
            return false;
        }
        Cvendas other = (Cvendas) object;
        if ((this.cvendasPK == null && other.cvendasPK != null) || (this.cvendasPK != null && !this.cvendasPK.equals(other.cvendasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.novo.Cvendas[ cvendasPK=" + cvendasPK + " ]";
    }
    
}
