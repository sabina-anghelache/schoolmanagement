public class Teacher {
    private int id;
    private String name;
    private String surname;
    private int phone;
    private String email;
    private String address;
    private int courses;
    private int salary;


    public Teacher(int id, String name, String surname, int phone, String email, String address, int courses, int salary) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.courses = courses;
        this.salary = salary;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getCourses() {
        return courses;
    }

    public int getSalary() {
        return salary;
    }

    public void setId() {
        this.id = id;
    }

    public void setName() {
        this.name = name;
    }

    public void setSurname() {
        this.surname = surname;
    }

    public void setPhone() {
        this.phone = phone;
    }

    public void setEmail() {
        this.email = email;
    }

    public void setAddress() {
        this.address = address;
    }

    public void setCourses() {
        this.courses = courses;
    }

    public void setSalary() {
        this.salary = salary;
    }
}
