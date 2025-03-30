public class StudentRecord {
    private String name;
    private int age;
    private String address;
    private String birthdate;

    public StudentRecord(String temp_name, int temp_age, String temp_address, String temp_birthdate) {
        this.name = temp_name;
        this.age = temp_age;
        this.address = temp_address;
        this.birthdate = temp_birthdate;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }
    public String getBirthdate() {
        return birthdate;
    }

    public void setName(String temp_name) {
        this.name = temp_name;
    }
    public void setAge(int temp_age) {
        this.age = temp_age;
    }
    public void setAddress(String temp_address) {
        this.address = temp_address;
    }
    public void setBirthdate(String temp_birthdate) {
        this.birthdate = temp_birthdate;
    }

public static void main(String[] args) {
        StudentRecord student1 = new StudentRecord("Allen", 20, "Sto.Tomas", "August 25, 2003");
        StudentRecord student2 = new StudentRecord("Jodilyn", 19, "Sibut", "December 15, 2004");
        StudentRecord student3 = new StudentRecord("Menard", 20, "Calisitan", "October 04, 2003");
        StudentRecord student4 = new StudentRecord("Kiel", 20, "Licaong", "March 24,2002");

        student1.setName("Gwyneth");

        System.out.println("Student 1:");
        System.out.println("Name: " + student1.getName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Address: " + student1.getAddress());
        System.out.println("Birthdate: " + student1.getBirthdate());

        System.out.println("Student 2:");
        System.out.println("Name: " + student2.getName());
        System.out.println("Age: " + student2.getAge());
        System.out.println("Address: " + student2.getAddress());
        System.out.println("Birthdate: " + student2.getBirthdate());

        System.out.println("Student 3:");
        System.out.println("Name: " + student3.getName());
        System.out.println("Age: " + student3.getAge());
        System.out.println("Address: " + student3.getAddress());
        System.out.println("Birthdate: " + student3.getBirthdate());

        System.out.println("Student 4:");
        System.out.println("Name: " + student4.getName());
        System.out.println("Age: " + student4.getAge());
        System.out.println("Address: " + student4.getAddress());
        System.out.println("Birthdate: " + student4.getBirthdate());
    }
}
