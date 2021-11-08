import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Operations op = new Operations();

        Scanner sc = new Scanner(System.in);

        System.out.println("Operations availabe are : ");

        System.out.println(
                "1. Add Employee \n2. Get All Employees \n3. Get Employee Details \n4. Get Employees DOB Wise \n5. Get Employees Salary Wise \n6. Forget Password");
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
        System.out.println("Enter Your Choice: ");
        int choice = sc.nextInt();
        switch (choice) {
        case 1:
            System.out.println("Your choice is Add Employee");
            System.out.println("-----------------------------");
            try {
                System.out.println("Enter Full Name: ");
                String name = sc.next();
                System.out.println("Enter Email: ");
                String email = sc.next();
                System.out.println("Enter phone: ");
                String phone = sc.next();
                System.out.println("Enter Salary: ");
                int salary = sc.nextInt();
                System.out.println("Enter DOB: ");
                String dob = sc.next();
                System.out.println("Enter password: ");
                String password = sc.next();
                Employee e = new Employee(name, email, phone, salary, dob, password);
                op.addEmployee(e);
            } catch (SQLException e) {

            }
            break;

        case 2:
            System.out.println("Your choice is Get All Empployees");
            System.out.println("-------------------------------------");
            try {
                ArrayList<Employee> fetchedEmployee = op.getAllEmployees();

                for (Employee allEmployees : fetchedEmployee) {
                    System.out.println(allEmployees.employees());
                }
            } catch (SQLException e) {

            }
            break;

        case 3:
            System.out.println("Your choice is Get Employee Details");
            System.out.println("-------------------------------------");
            try {
                System.out.println("Enter Employee Id for Details: ");
                int id = sc.nextInt();
                ArrayList<Employee> fetchEmployeeById = op.getEmployeeDeatils(id);

                for (Employee employeeDetails : fetchEmployeeById) {
                    System.out.println(employeeDetails.employeeDetails());
                }
            } catch (SQLException e) {

            }
            break;

        case 4:
            System.out.println("Your choice is Get Employees DOB Wise");
            System.out.println("---------------------------------------");
            try {
                System.out.println("Enter From Date: ");
                String fromDate = sc.next();
                System.out.println("Enter To Date: ");
                String toDate = sc.next();

                ArrayList<Employee> fetchEmployeeDobWise = op.getEmployeeDobWise(fromDate, toDate);

                for (Employee employeeDetailsDobWise : fetchEmployeeDobWise) {
                    System.out.println(employeeDetailsDobWise.employeesDobWise());
                }
            } catch (SQLException e) {

            }
            break;

        case 5:
            System.out.println("Your choice is Get Employess Salary Wise");
            System.out.println("-------------------------------------------");
            try {
                System.out.println("Enter Sign Like (<),(>),(=): ");
                char sign_ = sc.next().charAt(0);
                System.out.println("Enter Salary: ");
                int salary = sc.nextInt();

                ArrayList<Employee> fetchEmployeeSalaryWise = op.getEmployeeSalaryWise(sign_, salary);
                for (Employee employeeSalaryWise : fetchEmployeeSalaryWise) {
                    System.out.println(employeeSalaryWise.employeesSalaryWise());
                }

            } catch (SQLException e) {

            }
            break;

        case 6:
            System.out.println("Your choice is Forget Password");
            System.out.println("--------------------------------");
            try {
                System.out.println("Enter New Password: ");
                String newPass = sc.next();
                System.out.println("Enter ID: ");
                int id = sc.nextInt();
                op.ForgetPassword(newPass, id);
            } catch (Exception e) {

            }
        default:
            System.out.println("Please Enter Correct Choice");
        }
    }
}
