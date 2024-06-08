/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nhom13.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "resident")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resident.findAll", query = "SELECT r FROM Resident r"),
    @NamedQuery(name = "Resident.findById", query = "SELECT r FROM Resident r WHERE r.id = :id"),
    @NamedQuery(name = "Resident.findByBalance", query = "SELECT r FROM Resident r WHERE r.balance = :balance")})
public class Resident implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "balance")
    private Long balance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residentId")
    private Set<Feedback> feedbackSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residentId")
    private Set<Answer> answerSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residentId")
    private Set<ElectronicLocker> electronicLockerSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residentId")
    private Set<ResidentVisitor> residentVisitorSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residentId")
    private Set<Invoice> invoiceSet;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private User userId;

    @Transient
    private long unpaidInvoiceCount;
    @Transient
    private long waitingInvoiceCount;
    @Transient
    private long paidInvoiceCount;

    public long getUnpaidInvoiceCount() {
        return unpaidInvoiceCount;
    }

    public void setUnpaidInvoiceCount(long unpaidInvoiceCount) {
        this.unpaidInvoiceCount = unpaidInvoiceCount;
    }

    public long getWaitingInvoiceCount() {
        return waitingInvoiceCount;
    }

    public void setWaitingInvoiceCount(long waitingInvoiceCount) {
        this.waitingInvoiceCount = waitingInvoiceCount;
    }

    public long getPaidInvoiceCount() {
        return paidInvoiceCount;
    }

    public void setPaidInvoiceCount(long paidInvoiceCount) {
        this.paidInvoiceCount = paidInvoiceCount;
    }

    public Resident() {
    }

    public Resident(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @XmlTransient
    public Set<Feedback> getFeedbackSet() {
        return feedbackSet;
    }

    public void setFeedbackSet(Set<Feedback> feedbackSet) {
        this.feedbackSet = feedbackSet;
    }

    @XmlTransient
    public Set<Answer> getAnswerSet() {
        return answerSet;
    }

    public void setAnswerSet(Set<Answer> answerSet) {
        this.answerSet = answerSet;
    }

    @XmlTransient
    public Set<ElectronicLocker> getElectronicLockerSet() {
        return electronicLockerSet;
    }

    public void setElectronicLockerSet(Set<ElectronicLocker> electronicLockerSet) {
        this.electronicLockerSet = electronicLockerSet;
    }

    @XmlTransient
    public Set<ResidentVisitor> getResidentVisitorSet() {
        return residentVisitorSet;
    }

    public void setResidentVisitorSet(Set<ResidentVisitor> residentVisitorSet) {
        this.residentVisitorSet = residentVisitorSet;
    }

    @XmlTransient
    public Set<Invoice> getInvoiceSet() {
        return invoiceSet;
    }

    public void setInvoiceSet(Set<Invoice> invoiceSet) {
        this.invoiceSet = invoiceSet;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Resident)) {
            return false;
        }
        Resident other = (Resident) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nhom13.pojo.Resident[ id=" + id + " ]";
    }
    
}
