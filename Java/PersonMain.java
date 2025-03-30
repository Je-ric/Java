public class PersonMain {
    public static void main(String[] args) {
        
        Staff staff = new Staff("Ejay Basinga", 20, "Munoz", "2003-02-14", 1001, 50000, "Dean", "MISO Office");
        Faculty faculty = new Faculty("Franz Eda", 19, "Maligaya", "2004-09-22", 2001, 70000, "Professor", "Engineering");
        Current currentStudent = new Current("Gwyneth Allen", 20, "Sto.Tomas", "2003-05-25", 3001, "Computer Science", 2023, "2-2");
        Alumni alumni = new Alumni("Jodilyn Sarmiento", 19, "San Jose", "2003-12-04", 4001, "Information Technology", 2021);

        System.out.println("---------------------------------");
        staff.displayData();
        System.out.println("---------------------------------");
        faculty.displayData();
        System.out.println("---------------------------------");
        currentStudent.displayData();
        System.out.println("---------------------------------");
        alumni.displayData();
        System.out.println("---------------------------------");
    }
}

class Person {
    protected String name;
    protected int age;
    protected String address;
    protected String birthdate;

    public Person(String name, int age, String address, String birthdate) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthdate = birthdate;
    }

    public void displayData() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Birthdate: " + birthdate);
    }
}

abstract class Employee extends Person {
    protected int employeeId;
    protected double salary;

    public Employee(String name, int age, String address, String birthdate, int employeeId, double salary) {
        super(name, age, address, birthdate);
        this.employeeId = employeeId;
        this.salary = salary;
    }
}

class Staff extends Employee {
    private String position;
    private String office;

    public Staff(String name, int age, String address, String birthdate, int employeeId, double salary, String position, String office) {
        super(name, age, address, birthdate, employeeId, salary);
        this.position = position;
        this.office = office;
    }

    public void displayData() {
        System.out.println("Staff: ");
        super.displayData();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
        System.out.println("Position: " + position);
        System.out.println("Office: " + office);
    }
}

class Faculty extends Employee {
    private String rank;
    private String department;

    public Faculty(String name, int age, String address, String birthdate, int employeeId, double salary, String rank, String department) {
        super(name, age, address, birthdate, employeeId, salary);
        this.rank = rank;
        this.department = department;
    }

    public void displayData() {
        System.out.println("Faculty: ");
        super.displayData();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + salary);
        System.out.println("Rank: " + rank);
        System.out.println("Department: " + department);
    }
}

class Student extends Person {
    protected int studentId;
    protected String course;

    public Student(String name, int age, String address, String birthdate, int studentId, String course) {
        super(name, age, address, birthdate);
        this.studentId = studentId;
        this.course = course;
    }

    public void displayData() {
        super.displayData();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
}

class Current extends Student {
    private int year;
    private String section;

    public Current(String name, int age, String address, String birthdate, int studentId, String course, int year, String section) {
        super(name, age, address, birthdate, studentId, course);
        this.year = year;
        this.section = section;
    }

    public void displayData() {
        System.out.println("Current: ");
        super.displayData();
        System.out.println("Year: " + year);
        System.out.println("Section: " + section);
    }
}

class Alumni extends Student {
    private int yearGraduated;

    public Alumni(String name, int age, String address, String birthdate, int studentId, String course, int yearGraduated) {
        super(name, age, address, birthdate, studentId, course);
        this.yearGraduated = yearGraduated;
    }

    public void displayData() {
        System.out.println("Alumni: ");
        super.displayData();
        System.out.println("Year Graduated: " + yearGraduated);
    }
}
