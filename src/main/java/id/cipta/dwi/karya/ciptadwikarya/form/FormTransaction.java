package id.cipta.dwi.karya.ciptadwikarya.form;

import java.util.Date;

public class FormTransaction {
    private String deliveryDate;
    private int quantity;
    private int idInventory;
    private int idCustomer;
    private String note;

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
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
        return "FormTransaction{" + "deliveryDate=" + deliveryDate + ", quantity=" + quantity + ", idInventory=" + idInventory + ", idCustomer=" + idCustomer + ", note=" + note + '}';
    }

   
   
    
}
