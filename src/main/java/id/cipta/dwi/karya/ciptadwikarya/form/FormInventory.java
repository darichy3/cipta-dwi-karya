package id.cipta.dwi.karya.ciptadwikarya.form;

public class FormInventory {
    private int idInventory;
    private String name;
    private int priceBuy;
    private int priceSell;
    private int sumIn;
    private int sumOut;
    private int sumEnd;
    private String note;
    private String dateIn;
    private boolean enable;

    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "FormInventory{" + "name=" + name + ", priceBuy=" + priceBuy + ", priceSell=" + priceSell + ", sumIn=" + sumIn + ", sumOut=" + sumOut + ", sumEnd=" + sumEnd + ", note=" + note + '}';
    }
}
