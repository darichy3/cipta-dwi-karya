package id.cipta.dwi.karya.ciptadwikarya.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_customer")
    private int idCustomer;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "created_date")
    private String createdDate;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "jenis_pembayaran")
    private String jnsPmbyrn;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getJnsPmbyrn() {
        return jnsPmbyrn;
    }

    public void setJnsPmbyrn(String jnsPmbyrn) {
        this.jnsPmbyrn = jnsPmbyrn;
    }

    @Override
    public String toString() {
        return "Customers{" + "idCustomer=" + idCustomer + ", name=" + name + ", address=" + address + ", phone=" + phone + ", createdDate=" + createdDate + ", createdBy=" + createdBy + ", jnsPmbyrn=" + jnsPmbyrn + '}';
    }
}
