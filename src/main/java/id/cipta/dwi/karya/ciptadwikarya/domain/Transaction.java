package id.cipta.dwi.karya.ciptadwikarya.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaction")
    private int idTransaction;
    
    @Column(name = "transaction_date")
    private String transactionDate;
    
    @Column(name = "delivery_date")
    private Date deliveryDate;
    
    @Column(name = "quantity")
    private int quantity;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", referencedColumnName = "")
    private Users id;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inventory", referencedColumnName = "")
    private Inventory idInventory;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer", referencedColumnName = "")
    private Customers idCustomer;
    
    @Column(name = "note")
    private String note;

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Users getId() {
        return id;
    }

    public void setId(Users id) {
        this.id = id;
    }

    public Inventory getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(Inventory idInventory) {
        this.idInventory = idInventory;
    }

    public Customers getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customers idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Transaction{" + "idTransaction=" + idTransaction + ", transactionDate=" + transactionDate + ", deliveryDate=" + deliveryDate + ", quantity=" + quantity + ", id=" + id + ", idInventory=" + idInventory + ", idCustomer=" + idCustomer + ", note=" + note + '}';
    }

    

   
    
}
