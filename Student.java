package registrationsystem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student {
    // personal notes: no abstract or interface, inheritance and class as variable though
    private String firstName, lastName, address, city, postalCode, program;
    private int studentNumber;
    private LocalDate dateEnrolled, DOB;
    private LocalDate currentDate = LocalDate.now();
    public boolean inGoodStanding = true;
    private ArrayList<String> list = new ArrayList<String>();
    private boolean hasPassed = true;
    private HashMap<Course, Integer> completedList = new HashMap<>();


    //constructor ------------------------------------------------------------------------------------
    public Student(String firstName, String lastName, String address, String city, String postalCode,
                   String program, int studentNumber, LocalDate dateEnrolled, LocalDate DOB)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.program = program;
        this.studentNumber = studentNumber;
        this.dateEnrolled = dateEnrolled;
        this.DOB = DOB;
        if(Period.between(DOB, LocalDate.now()).getYears() > 100)
        {
            throw new IllegalArgumentException("Please check the year entered, student cannot be over 100 years old");
        }
    }

    //setters & getters ------------------------------------------------------------------------------------
    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getPostalCode() { return postalCode; }

    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getProgram() { return program; }

    public void setProgram(String program) { this.program = program; }

    public int getStudentNumber() { return studentNumber; }

    public void setStudentNumber(int courseCode) { this.studentNumber = studentNumber; }

    public LocalDate getDateEnrolled() { return dateEnrolled; }

    public void setDateEnrolled(LocalDate dateEnrolled) { this.dateEnrolled = dateEnrolled; }

    public LocalDate getDOB() { return DOB; }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public LocalDate getCurrentDate() { return currentDate; }

    public void setCurrentDate(LocalDate currentDate) { this.currentDate = currentDate; }

    public boolean getInGoodStanding() { return inGoodStanding; }

    public void setInGoodStanding(boolean inGoodStanding) { this.inGoodStanding = inGoodStanding; }

    public ArrayList<String> getArrayList() { return list; }

    public void setArrayList(ArrayList<String> list) { this.list = list; }

    public Boolean getHasPassed() { return hasPassed; }

    public void setHasPassed(boolean hasPassed) { this.hasPassed = hasPassed; }

    public HashMap<Course, Integer> getCompletedList() { return completedList; }

    public void setCompletedList(HashMap<Course, Integer> completedList) { this.completedList = completedList; }


    // methods -----------------------------------------------------------------------------------------

    public boolean hasCompleted(String course)
    {
        return hasPassed;
    }

    public String getCoursesCompleted()
    {
        ArrayList<String> newList = new ArrayList<String>();

        for(Map.Entry<Course, Integer> entry : completedList.entrySet())
        {
            newList.add(entry.getKey().getCourseTaught() + "-" + entry.getKey().getCourseTitle() + " grade=" + entry.getValue());
        }
        return "[" + String.join(",", newList) + "]";
    }

    public void addCompletedCourse(Course courseName, int grade)
    {
        if (grade > 50 && grade < 100) {
            completedList.put(courseName, grade);
            hasPassed = true;
        } else if(grade < 0 || grade > 100) {
            throw new IllegalArgumentException("grade must be 0-100 inclusive");
        } else {
            hasPassed = false;
        }
    }

    public void setBirthday(LocalDate birthday)
    {
        setDOB(birthday);
    }

    public int getNoOfYearEnrolled()
    {
        return dateEnrolled.getYear();
    }

    public LocalDate getStudentBirthday()
    {
        return DOB;
    }

    public int getStudentAge()
    {
        return Period.between(DOB, currentDate).getYears();
    }

    public String getStudentAddress()
    {
        return getAddress() + " " + getCity() + " " + getPostalCode();
    }

    public String changeAddress(String address, String city, String postalCode)
    {
        setAddress(address);
        setCity(city);
        setPostalCode(postalCode);
        return getAddress() + getCity() + getPostalCode();
    }

    public boolean studentInGoodStanding()
    {
        if(inGoodStanding == true)
        {
            reinstateStudent();
        } else {
            suspendStudent();
        }

        return inGoodStanding;
    }

    public boolean suspendStudent()
    {

        setInGoodStanding(false);
        return inGoodStanding;
    }

    public boolean reinstateStudent()
    {
        setInGoodStanding(true);
        return inGoodStanding;
    }


    @Override
    public String toString()
    {
        return (getFirstName() + " " + getLastName()) + ", student number: " + this.getStudentNumber();
    }
}
