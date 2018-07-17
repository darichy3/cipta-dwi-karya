package id.cipta.dwi.karya.ciptadwikarya.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_inventory")
    private int idInventory;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "price_buy")
    private int priceBuy;
    
    @Column(name = "price_sell")
    private int priceSell;
    
    @Column(name = "sum_in")
    private int sumIn;
    
    @Column(name = "sum_out")
    private int sumOut;
    
    @Column(name = "sum_end")
    private int sumEnd;
    
    @Column(name = "date_in")
    private String dateIn;
    
    @Column(name = "note")
    private String note;

    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceBuy() {
        return priceBuy;
    }

    public void setPriceBuy(int priceBuy) {
        this.priceBuy = priceBuy;
    }

    public int getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(int priceSell) {
        this.priceSell = priceSell;
    }

    public int getSumIn() {
        return sumIn;
    }

    public void setSumIn(int sumIn) {
        this.sumIn = sumIn;
    }

    public int getSumOut() {
        return sumOut;
    }

    public void setSumOut(int sumOut) {
        this.sumOut = sumOut;
    }

    public int getSumEnd() {
        return sumEnd;
    }

    public void setSumEnd(int sumEnd) {
        this.sumEnd = sumEnd;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Inventory{" + "idInventory=" + idInventory + ", name=" + name + ", priceBuy=" + priceBuy + ", priceSell=" + priceSell + ", sumIn=" + sumIn + ", sumOut=" + sumOut + ", sumEnd=" + sumEnd + ", dateIn=" + dateIn + ", note=" + note + '}';
    }
}
