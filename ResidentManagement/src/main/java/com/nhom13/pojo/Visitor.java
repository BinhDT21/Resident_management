/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "visitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visitor.findAll", query = "SELECT v FROM Visitor v"),
    @NamedQuery(name = "Visitor.findById", query = "SELECT v FROM Visitor v WHERE v.id = :id"),
    @NamedQuery(name = "Visitor.findByName", query = "SELECT v FROM Visitor v WHERE v.name = :name"),
    @NamedQuery(name = "Visitor.findByRelation", query = "SELECT v FROM Visitor v WHERE v.relation = :relation")})
public class Visitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "relation")
    private String relation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "visitorId")
    private Set<ResidentVisitor> residentVisitorSet;

    public Visitor() {
    }

    public Visitor(Integer id) {
        this.id = id;
    }

    public Visitor(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @XmlTransient
    public Set<ResidentVisitor> getResidentVisitorSet() {
        return residentVisitorSet;
    }

    public void setResidentVisitorSet(Set<ResidentVisitor> residentVisitorSet) {
        this.residentVisitorSet = residentVisitorSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitor)) {
            return false;
        }
        Visitor other = (Visitor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom13.pojo.Visitor[ id=" + id + " ]";
    }
    
}
