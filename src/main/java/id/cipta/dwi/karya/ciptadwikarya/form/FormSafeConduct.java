package id.cipta.dwi.karya.ciptadwikarya.form;

import java.util.Date;

public class FormSafeConduct {
    private Date transDate;
    private Date delivDate;
    private int quantity;
    private String admin;
    private String barang;
    private String custName;
    private String custAddress;
    private String custPhone;
    private String note;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Date getDelivDate() {
        return delivDate;
    }

    public void setDelivDate(Date delivDate) {
        this.delivDate = delivDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "FormSafeConduct{" + "transDate=" + transDate + ", delivDate=" + delivDate + ", quantity=" + quantity + ", admin=" + admin + ", barang=" + barang + ", custName=" + custName + ", custAddress=" + custAddress + ", custPhone=" + custPhone + ", note=" + note + '}';
    }
    
}
