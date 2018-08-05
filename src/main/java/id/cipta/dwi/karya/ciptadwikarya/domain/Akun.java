package id.cipta.dwi.karya.ciptadwikarya.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "akun")
public class Akun {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_akun")
    private int idAkun;
    
    @Column(name = "nama_akun")
    private String namaAkun;
    
    @Column(name = "keterangan")
    private String keterangan;

    public int getIdAkun() {
        return idAkun;
    }

    public void setIdAkun(int idAkun) {
        this.idAkun = idAkun;
    }

    public String getNamaAkun() {
        return namaAkun;
    }

    public void setNamaAkun(String namaAkun) {
        this.namaAkun = namaAkun;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return "Akun{" + "idAkun=" + idAkun + ", namaAkun=" + namaAkun + ", keterangan=" + keterangan + '}';
    }
}
