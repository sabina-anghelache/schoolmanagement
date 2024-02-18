import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/student_management";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from student");

            List<Student> studentList = new ArrayList<>();

            int earnings = 0;
            int earningsNeeded = 0;

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                int phone = resultSet.getInt(4);
                String email = resultSet.getString(5);
                String address = resultSet.getString(6);
                int courses = resultSet.getInt(7);
                int fees = resultSet.getInt(8);

                studentList.add(new Student(id, name, surname, phone, email, address, courses, fees));
            }

            // now you can access each element of the list
            for (Student s : studentList) {
                System.out.println(s.getId() + " The student " + s.getName() +
                         " " +s.getSurname() + " with the contacts "
                        + s.getPhone() + ", " + s.getEmail() + ", "
                        + s.getAddress() + " has  " + s.getCourses() + " classes, and paid " + s.getFees());
                earnings += s.getFees();
                earningsNeeded += s.getCourses() * 100;
            }

            System.out.println("Total earnings: " + earnings);
            System.out.println("Total earnings needed by the end: " + earningsNeeded);

            studentList.stream()
                    .filter(student -> student.getFees() < student.getCourses() * 100)
                    .map(student -> {
                        int payment = student.getCourses() * 100 - student.getFees();
                        return "Payment left of " + student.getName() + " " + student.getSurname()
                                + "is "+ payment + " out of " + student.getCourses()*100;
                    })
                    .forEach(System.out::println);

            System.out.println("List of teachers: ");

            List<Teacher> teacherList = new ArrayList<>();
            ResultSet resultTeacher = statement.executeQuery("select * from teacher");

            int totalSalary = 0;

            while (resultTeacher.next()) {
                int id = resultTeacher.getInt(1);
                String name = resultTeacher.getString(2);
                String surname = resultTeacher.getString(3);
                int phone = resultTeacher.getInt(4);
                String email = resultTeacher.getString(5);
                String address = resultTeacher.getString(6);
                int courses = resultTeacher.getInt(7);
                int salary = resultTeacher.getInt(8);

                totalSalary += salary;

                teacherList.add(new Teacher(id, name, surname, phone, email, address, courses, salary));
            }

            // now you can access each element of the list
            for (Teacher t : teacherList) {
                System.out.println(t.getId() + " " + t.getName() + " " +t.getSurname() + " with contacts "
                        + t.getPhone() + ", " + t.getEmail() + ", " + t.getAddress() + " teaches "
                        + t.getCourses() + " classes, having the salary of " + t.getSalary());
            }

            System.out.println("Total salary: " + totalSalary);

            List<Courses> coursesList = new ArrayList<>();
            ResultSet resultCourses = statement.executeQuery("select * from classes");


            while (resultCourses.next()) {
                int id = resultCourses.getInt(1);
                String name = resultCourses.getString(2);
                String prof = resultCourses.getString(3);
                int room = resultCourses.getInt(4);


                coursesList.add(new Courses(id, name, prof, room));
            }

            // now you can access each element of the list
            for (Courses c : coursesList) {
                System.out.println(c.getId() + " The class of " + c.getName() + " is taught by " + c.getProf() + " in room " + c.getRoom());
            }


            connection.close();
        }

        catch (Exception e) {
            System.out.println(e);
        }


    }
}