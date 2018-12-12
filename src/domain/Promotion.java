/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "PROMOTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p")
    , @NamedQuery(name = "Promotion.findByPromotionname", query = "SELECT p FROM Promotion p WHERE p.promotionname = :promotionname")
    , @NamedQuery(name = "Promotion.findByPromotionmonth", query = "SELECT p FROM Promotion p WHERE p.promotionmonth = :promotionmonth")
    , @NamedQuery(name = "Promotion.findByPromotiondetail", query = "SELECT p FROM Promotion p WHERE p.promotiondetail = :promotiondetail")
    , @NamedQuery(name = "Promotion.findByPromotiontc", query = "SELECT p FROM Promotion p WHERE p.promotiontc = :promotiontc")
    , @NamedQuery(name = "Promotion.findByPyear", query = "SELECT p FROM Promotion p WHERE p.pyear = :pyear")})
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROMOTIONNAME")
    private String promotionname;
    @Basic(optional = false)
    @Column(name = "PROMOTIONMONTH")
    private String promotionmonth;
    @Basic(optional = false)
    @Column(name = "PROMOTIONDETAIL")
    private String promotiondetail;
    @Basic(optional = false)
    @Column(name = "PROMOTIONTC")
    private String promotiontc;
    @Column(name = "PYEAR")
    private Integer pyear;

    public Promotion() {
    }

    public Promotion(String promotionname) {
        this.promotionname = promotionname;
    }

    public Promotion(String promotionname, String promotionmonth, String promotiondetail, String promotiontc,int pyear) {
        this.promotionname = promotionname;
        this.promotionmonth = promotionmonth;
        this.promotiondetail = promotiondetail;
        this.promotiontc = promotiontc;
        this.pyear=pyear;
    }

    public String getPromotionname() {
        return promotionname;
    }

    public void setPromotionname(String promotionname) {
        this.promotionname = promotionname;
    }

    public String getPromotionmonth() {
        return promotionmonth;
    }

    public void setPromotionmonth(String promotionmonth) {
        this.promotionmonth = promotionmonth;
    }

    public String getPromotiondetail() {
        return promotiondetail;
    }

    public void setPromotiondetail(String promotiondetail) {
        this.promotiondetail = promotiondetail;
    }

    public String getPromotiontc() {
        return promotiontc;
    }

    public void setPromotiontc(String promotiontc) {
        this.promotiontc = promotiontc;
    }

    public Integer getPyear() {
        return pyear;
    }

    public void setPyear(Integer pyear) {
        this.pyear = pyear;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promotionname != null ? promotionname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.promotionname == null && other.promotionname != null) || (this.promotionname != null && !this.promotionname.equals(other.promotionname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Domain.Promotion[ promotionname=" + promotionname + " ]";
    }
    
}
