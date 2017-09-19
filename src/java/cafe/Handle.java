/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Son Tong
 */
@Entity
@Table(name = "handle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Handle.findAll", query = "SELECT h FROM Handle h"),
    @NamedQuery(name = "Handle.findById", query = "SELECT h FROM Handle h WHERE h.id = :id"),
    @NamedQuery(name = "Handle.findByOrdernumber", query = "SELECT h FROM Handle h WHERE h.ordernumber = :ordernumber"),
    @NamedQuery(name = "Handle.findByName", query = "SELECT h FROM Handle h WHERE h.name = :name"),
    @NamedQuery(name = "Handle.findByCost", query = "SELECT h FROM Handle h WHERE h.cost = :cost"),
    @NamedQuery(name = "Handle.findByIdproduct", query = "SELECT h FROM Handle h WHERE h.idproduct = :idproduct")})
public class Handle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Column(name = "ordernumber")
    private Integer ordernumber;
    @Size(max = 64)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost")
    private Double cost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproduct")
    private int idproduct;

    public Handle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }
    
}
