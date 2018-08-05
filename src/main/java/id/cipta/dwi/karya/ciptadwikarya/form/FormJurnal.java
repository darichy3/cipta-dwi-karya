package id.cipta.dwi.karya.ciptadwikarya.form;


public class FormJurnal {
    private String noTransaksi;
    private String tglJurnal;
    private String kodeAkun;
    private String namaAkun;
    private int debit;
    private int kredit;

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public String getTglJurnal() {
        return tglJurnal;
    }

    public void setTglJurnal(String tglJurnal) {
        this.tglJurnal = tglJurnal;
    }

    public String getKodeAkun() {
        return kodeAkun;
    }

    public void setKodeAkun(String kodeAkun) {
        this.kodeAkun = kodeAkun;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getKredit() {
        return kredit;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }

    @Override
    public String toString() {
        return "FormJurnal{" + "noTransaksi=" + noTransaksi + ", tglJurnal=" + tglJurnal + ", kodeAkun=" + kodeAkun + ", namaAkun=" + namaAkun + ", debit=" + debit + ", kredit=" + kredit + '}';
    }
}
