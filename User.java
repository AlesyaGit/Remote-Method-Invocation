import java.io.Serializable;
import java.util.Date;

// Enum for Gender
enum Gender {
    MALE, FEMALE, OTHER;
}

public class User implements Serializable {
    private int id;
    private String firstname;
    private String lastname;
    private Date birthday;
    private double salary;
    private Gender gender;  // Enum for gender
    private String division;
    private String workPosition;
    private String email;

    // Constructor
    public User(int id, String firstname, String lastname, Date birthday, double salary, Gender gender, String division, String workPosition, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.salary = salary;
        this.gender = gender;
        this.division = division;
        this.workPosition = workPosition;
        this.email = email;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    public String getEmail() {
        return email;   // Getter for email
    }

    public void setEmail(String email) {
        this.email = email;  // Setter for email
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                ", gender=" + gender +
                ", division='" + division + '\'' +
                ", workPosition='" + workPosition + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


