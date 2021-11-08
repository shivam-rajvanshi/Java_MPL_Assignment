import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Operations {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc_assign?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Sql@41297";

    private static final String INSERT_QUERY = "INSERT INTO employee(fullname, email, phone, salary, dob, password) VALUES(?,?,?,?,?,?)";
    private static final String GET_ALLEMPLYOEE = "SELECT * FROM employee";
    private static final String GET_EMPLOYEE_DETAILS = "SELECT * FROM employee WHERE id = ?";
    private static final String GET_EMPLOYEE_DOBWISE = "SELECT fullname,dob FROM employee WHERE YEAR(dob) BETWEEN ? AND ?";
    private static final String FORGOT_PASSWORD = "UPDATE employee SET password = ? WHERE id = ?";

    protected Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.jdbcUrl, this.jdbcUsername, this.jdbcPassword);
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        } catch (Exception e) {

        }

        return con;
    }

    public void addEmployee(Employee newEmp) throws SQLException {
        try (Connection con = this.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_QUERY)) {
            ps.setString(1, newEmp.getFullname());
            ps.setString(2, newEmp.getEmail());
            ps.setString(3, newEmp.getPhone());
            ps.setInt(4, newEmp.getSalary());
            ps.setString(5, newEmp.getDob());
            ps.setString(6, newEmp.getPassword());

            ps.executeUpdate();
            System.out.println("Employee Added Successfully");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Employee> getAllEmployees() throws SQLException {
        ArrayList<Employee> allEmployees = new ArrayList<>();
        try (Connection con = this.getConnection(); PreparedStatement ps = con.prepareStatement(GET_ALLEMPLYOEE)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int salary = rs.getInt("salary");
                String dob = rs.getString("dob");
                String password = rs.getString("password");
                Employee tempEmployee = new Employee(id, fullname, email, phone, salary, dob, password);
                allEmployees.add(tempEmployee);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return allEmployees;
    }

    public ArrayList<Employee> getEmployeeDeatils(int employeeId) throws SQLException {
        ArrayList<Employee> employeeDetails = new ArrayList<>();
        try (Connection con = this.getConnection(); PreparedStatement ps = con.prepareStatement(GET_EMPLOYEE_DETAILS)) {
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                int salary = rs.getInt("salary");
                String dob = rs.getString("dob");
                String password = rs.getString("password");

                Employee empDeatilsById = new Employee(id, fullname, email, phone, salary, dob, password);
                employeeDetails.add(empDeatilsById);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return employeeDetails;
    }

    public ArrayList<Employee> getEmployeeDobWise(String fromDate, String toDate) throws SQLException {
        ArrayList<Employee> employeeDetailsDobWise = new ArrayList<>();
        try (Connection con = this.getConnection(); PreparedStatement ps = con.prepareStatement(GET_EMPLOYEE_DOBWISE)) {
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String fullname = rs.getString("fullname");
                String dob = rs.getString("dob");

                Employee empDetailsDobWise = new Employee(fullname, dob);
                employeeDetailsDobWise.add(empDetailsDobWise);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employeeDetailsDobWise;
    }

    public ArrayList<Employee> getEmployeeSalaryWise(char sign, int amount) throws SQLException {
        ArrayList<Employee> employeeSalaryWise = new ArrayList<>();
        try (Connection con = this.getConnection();
                PreparedStatement ps = con.prepareStatement(
                        "SELECT fullname,salary FROM employee WHERE salary" + " " + sign + " " + amount)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String fullname = rs.getString("fullname");
                int salary = rs.getInt("salary");

                Employee empSalaryWise = new Employee(fullname, salary);
                employeeSalaryWise.add(empSalaryWise);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employeeSalaryWise;
    }

    public void ForgetPassword(String newPassword, int id) {
        try (Connection con = this.getConnection(); PreparedStatement ps = con.prepareStatement(FORGOT_PASSWORD)) {
            ps.setString(1, newPassword);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Password changed successfully");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
