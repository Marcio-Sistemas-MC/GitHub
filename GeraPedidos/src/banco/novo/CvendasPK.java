/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.novo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Paulo
 */
@Embeddable
public class CvendasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "nvenda")
    private int nvenda;
    @Basic(optional = false)
    @Column(name = "ncaixa")
    private String ncaixa;

    public CvendasPK() {
    }

    public CvendasPK(int nvenda, String ncaixa) {
        this.nvenda = nvenda;
        this.ncaixa = ncaixa;
    }

    public int getNvenda() {
        return nvenda;
    }

    public void setNvenda(int nvenda) {
        this.nvenda = nvenda;
    }

    public String getNcaixa() {
        return ncaixa;
    }

    public void setNcaixa(String ncaixa) {
        this.ncaixa = ncaixa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nvenda;
        hash += (ncaixa != null ? ncaixa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CvendasPK)) {
            return false;
        }
        CvendasPK other = (CvendasPK) object;
        if (this.nvenda != other.nvenda) {
            return false;
        }
        if ((this.ncaixa == null && other.ncaixa != null) || (this.ncaixa != null && !this.ncaixa.equals(other.ncaixa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "banco.novo.CvendasPK[ nvenda=" + nvenda + ", ncaixa=" + ncaixa + " ]";
    }
    
}
