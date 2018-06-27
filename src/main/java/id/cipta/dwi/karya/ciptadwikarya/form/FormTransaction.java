package id.cipta.dwi.karya.ciptadwikarya.form;

import java.util.Date;

public class FormTransaction {
    private Date deliveryDate;
    private int quantity;
    private int idUser;
    private int idBarang;
    private int idCustomer;
    private String note;

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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
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
        return "FormTransaction{" + "deliveryDate=" + deliveryDate + ", quantity=" + quantity + ", idUser=" + idUser + ", idBarang=" + idBarang + ", idCustomer=" + idCustomer + ", note=" + note + '}';
    }

   
   
    
}
