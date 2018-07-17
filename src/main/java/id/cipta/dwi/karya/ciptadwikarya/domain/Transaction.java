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
    private String deliveryDate;
    
    @Column(name = "no_surat_jalan")
    private String noSuratJalan;
    
    @Column(name = "tgl_surat_jalan")
    private String tglSuratJalan;
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "total_harga")
    private int totalHarga;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private Users idUser;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inventory")
    private Inventory idInventory;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer")
    private Customers idCustomer;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_status")
    private Status idStatus;
    
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

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getNoSuratJalan() {
        return noSuratJalan;
    }

    public void setNoSuratJalan(String noSuratJalan) {
        this.noSuratJalan = noSuratJalan;
    }

    public String getTglSuratJalan() {
        return tglSuratJalan;
    }

    public void setTglSuratJalan(String tglSuratJalan) {
        this.tglSuratJalan = tglSuratJalan;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
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

    public Status getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Status idStatus) {
        this.idStatus = idStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Transaction{" + "idTransaction=" + idTransaction + ", transactionDate=" + transactionDate + ", deliveryDate=" + deliveryDate + ", noSuratJalan=" + noSuratJalan + ", tglSuratJalan=" + tglSuratJalan + ", quantity=" + quantity + ", total_harga=" + totalHarga + ", idUser=" + idUser + ", idInventory=" + idInventory + ", idCustomer=" + idCustomer + ", idStatus=" + idStatus + ", note=" + note + '}';
    }
}
