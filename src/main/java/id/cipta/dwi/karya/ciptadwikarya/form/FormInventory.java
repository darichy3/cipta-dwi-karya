package id.cipta.dwi.karya.ciptadwikarya.form;

public class FormInventory {
    private String name;
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
        return "FormInventory{" + "name=" + name + ", sumIn=" + sumIn + ", sumOut=" + sumOut + ", sumEnd=" + sumEnd + ", note=" + note + '}';
    }
   
    
}
