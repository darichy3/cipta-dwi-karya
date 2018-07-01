package id.cipta.dwi.karya.ciptadwikarya.form;

public class FormInventory {
    private String name;
    private int priceBuy;
    private int priceSell;
    private int sumIn;
    private int sumOut;
    private int sumEnd;
    private String note;

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
