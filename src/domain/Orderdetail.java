/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

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
 * @author Yong
 */
@Entity
@Table(name = "ORDERDETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM Orderdetail o")
    , @NamedQuery(name = "Orderdetail.findByDetailid", query = "SELECT o FROM Orderdetail o WHERE o.detailid = :detailid")
    , @NamedQuery(name = "Orderdetail.findByOrderid", query = "SELECT o FROM Orderdetail o WHERE o.orderid = :orderid")
    , @NamedQuery(name = "Orderdetail.findByCustomerid", query = "SELECT o FROM Orderdetail o WHERE o.customerid = :customerid")
    , @NamedQuery(name = "Orderdetail.findByCustomername", query = "SELECT o FROM Orderdetail o WHERE o.customername = :customername")
    , @NamedQuery(name = "Orderdetail.findByFlowertype", query = "SELECT o FROM Orderdetail o WHERE o.flowertype = :flowertype")
    , @NamedQuery(name = "Orderdetail.findByOrderdate", query = "SELECT o FROM Orderdetail o WHERE o.orderdate = :orderdate")
    , @NamedQuery(name = "Orderdetail.findByDeliverydate", query = "SELECT o FROM Orderdetail o WHERE o.deliverydate = :deliverydate")
    , @NamedQuery(name = "Orderdetail.findByPickupdate", query = "SELECT o FROM Orderdetail o WHERE o.pickupdate = :pickupdate")
    , @NamedQuery(name = "Orderdetail.findByQuantity", query = "SELECT o FROM Orderdetail o WHERE o.quantity = :quantity")
    , @NamedQuery(name = "Orderdetail.findByPrice", query = "SELECT o FROM Orderdetail o WHERE o.price = :price")
    , @NamedQuery(name = "Orderdetail.findByAddress", query = "SELECT o FROM Orderdetail o WHERE o.address = :address")})
public class Orderdetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DETAILID")
    private String detailid;
    @Basic(optional = false)
    @Column(name = "ORDERID")
    private String orderid;
    @Basic(optional = false)
    @Column(name = "CUSTOMERID")
    private String customerid;
    @Basic(optional = false)
    @Column(name = "CUSTOMERNAME")
    private String customername;
    @Basic(optional = false)
    @Column(name = "FLOWERTYPE")
    private String flowertype;
    @Basic(optional = false)
    @Column(name = "ORDERDATE")
    private String orderdate;
    @Column(name = "DELIVERYDATE")
    private String deliverydate;
    @Column(name = "PICKUPDATE")
    private String pickupdate;
    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private double price;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;

    public Orderdetail() {
    }

    public Orderdetail(String detailid) {
        this.detailid = detailid;
    }

    public Orderdetail(String detailid, String orderid, String customerid, String customername, String flowertype, String orderdate,String deliverydate,String pickupdate, int quantity, double price, String address) {
        this.detailid = detailid;
        this.orderid = orderid;
        this.customerid = customerid;
        this.customername = customername;
        this.flowertype = flowertype;
        this.orderdate = orderdate;
        this.deliverydate = deliverydate;
        this.pickupdate = pickupdate;
        this.quantity = quantity;
        this.price = price;
        this.address = address;
    }


    public String getDetailid() {
        return detailid;
    }

    public void setDetailid(String detailid) {
        this.detailid = detailid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getFlowertype() {
        return flowertype;
    }

    public void setFlowertype(String flowertype) {
        this.flowertype = flowertype;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getPickupdate() {
        return pickupdate;
    }

    public void setPickupdate(String pickupdate) {
        this.pickupdate = pickupdate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailid != null ? detailid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetail)) {
            return false;
        }
        Orderdetail other = (Orderdetail) object;
        if ((this.detailid == null && other.detailid != null) || (this.detailid != null && !this.detailid.equals(other.detailid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Domain.Orderdetail[ detailid=" + detailid + " ]";
    }
    
}
