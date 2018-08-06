package id.cipta.dwi.karya.ciptadwikarya.form;

public class FormCustomers {
    private String name;
    private String address;
    private String phone;
    private String jnsPmbyrn;

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

    public String getJnsPmbyrn() {
        return jnsPmbyrn;
    }

    public void setJnsPmbyrn(String jnsPmbyrn) {
        this.jnsPmbyrn = jnsPmbyrn;
    }

    @Override
    public String toString() {
        return "FormCustomers{" + "name=" + name + ", address=" + address + ", phone=" + phone + ", jnsPmbyrn=" + jnsPmbyrn + '}';
    }
}
