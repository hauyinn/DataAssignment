/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
 * @author ASUS-PC
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByInvoiceid", query = "SELECT c FROM Customer c WHERE c.invoiceid = :invoiceid")
    , @NamedQuery(name = "Customer.findByAmount", query = "SELECT c FROM Customer c WHERE c.amount = :amount")
    , @NamedQuery(name = "Customer.findByStatus", query = "SELECT c FROM Customer c WHERE c.status = :status")
    , @NamedQuery(name = "Customer.findByTime", query = "SELECT c FROM Customer c WHERE c.time = :time")})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "INVOICEID")
    private String invoiceid;
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private double amount;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "TIME")
    private String time;

    public Customer() {
    }

    public Customer(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Customer(String invoiceid, double amount, String status, String time) {
        this.invoiceid = invoiceid;
        this.amount = amount;
        this.status = status;
        this.time = time;
    }

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceid != null ? invoiceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.invoiceid == null && other.invoiceid != null) || (this.invoiceid != null && !this.invoiceid.equals(other.invoiceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.Customer[ invoiceid=" + invoiceid + " ]";
    }
    
}
