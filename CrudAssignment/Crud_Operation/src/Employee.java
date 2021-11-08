public class Employee {

    private int id, salary;
    private String fullname, email, phone, dob, password;

    public Employee(String fullname, String email, String phone, int salary, String dob, String password) {
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.dob = dob;
        this.password = password;
    }

    public Employee(String fullname) {
        this.fullname = fullname;
    }

    public Employee(int id, String fullname, String email, String phone, int salary, String dob, String password) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.dob = dob;
        this.password = password;
    }

    public Employee(String fullname, String dob) {
        this.fullname = fullname;
        this.dob = dob;
    }

    public Employee(String fullname, int salary) {
        this.fullname = fullname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String employees() {
        return "ID: " + this.id + "\nFull Name: " + this.fullname + "\nEmail: " + this.email + "\nPhone: " + this.phone
                + "\nSalary: " + this.salary + "\nDOB: " + this.dob + "\nPassword: " + this.password;
    }

    public String employeeDetails() {
        return "ID: " + this.id + "\nFull Name: " + this.fullname + "\nEmail: " + this.email + "\nPhone: " + this.phone
                + "\nSalary: " + this.salary + "\nDOB: " + this.dob + "\nPassword: " + this.password;
    }

    public String employeesDobWise() {
        return this.fullname + " : " + this.dob;
    }

    public String employeesSalaryWise() {
        return this.fullname + " : " + this.salary;
    }

}
