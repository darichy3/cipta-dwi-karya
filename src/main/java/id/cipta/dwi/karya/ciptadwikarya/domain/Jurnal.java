package id.cipta.dwi.karya.ciptadwikarya.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jurnal")
public class Jurnal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_jurnal")
    private int idJurnal;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_transaksi")
    private Transaction idTransaction;
    
    @Column(name = "tgl_jurnal")
    private String tglJurnal;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "kode_akun")
    private Akun kodeAkun;
    
    @Column(name = "debit")
    private int debit;
    
    @Column(name = "kredit")
    private int kredit;

    public int getIdJurnal() {
        return idJurnal;
    }

    public void setIdJurnal(int idJurnal) {
        this.idJurnal = idJurnal;
    }

    public Transaction getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Transaction idTransaction) {
        this.idTransaction = idTransaction;
    }
    
    public String getTglJurnal() {
        return tglJurnal;
    }

    public void setTglJurnal(String tglJurnal) {
        this.tglJurnal = tglJurnal;
    }

    public Akun getKodeAkun() {
        return kodeAkun;
    }

    public void setKodeAkun(Akun kodeAkun) {
        this.kodeAkun = kodeAkun;
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
        return "Jurnal{" + "idJurnal=" + idJurnal + ", idTransaction=" + idTransaction + ", tglJurnal=" + tglJurnal + ", kodeAkun=" + kodeAkun + ", debit=" + debit + ", kredit=" + kredit + '}';
    }
}
