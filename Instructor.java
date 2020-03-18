package registrationsystem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Instructor {
    private String firstName, lastName, address, city, postalCode;
    private int empID;
    private LocalDate startedTeaching, DOB;
    private LocalDate currentDate = LocalDate.now();
    private ArrayList<String> list = new ArrayList<String>();

    //constructor ------------------------------------------------------------------------------------
    public Instructor(String firstName, String lastName, int empID, String address, String city,
                      String postalCode, LocalDate startedTeaching, LocalDate DOB)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.empID = empID;
        this.startedTeaching = startedTeaching;
        this.DOB = DOB;
        if(Period.between(DOB, LocalDate.now()).getYears() > 100)
        {
            throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old.");
        }

        if(Period.between(startedTeaching, LocalDate.now()).getYears() > 80)
        {
            throw new IllegalArgumentException(getStartedTeaching() + " as a hire date would mean " + this.getFirstName()
                    + " started working over 80 years ago");
        }
    }

    //1910-08-22 as a hire date would mean Anita started working over 80 years ago

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

    public int getEmpID() { return empID; }

    public void setEmpID(int empID) { this.empID = empID; }

    public LocalDate getStartedTeaching() { return startedTeaching; }

    public void setStartedTeaching(LocalDate startedTeaching) { this.startedTeaching = startedTeaching; }

    public LocalDate getDOB() { return DOB; }

    public void setDOB(LocalDate DOB) { this.DOB = DOB; }

    public LocalDate getCurrentDate() { return currentDate; }

    public void setCurrentDate(LocalDate currentDate) { this.currentDate = currentDate; }

    public ArrayList<String> getArrayList() { return list; }

    public void setArrayList(ArrayList<String> list) { this.list = list; }

    // methods -----------------------------------------------------------------------------------------

    public LocalDate setBirthday(LocalDate birthday)
    {
        if(Period.between(birthday, LocalDate.now()).getYears() > 100)
        {
            throw new IllegalArgumentException("Please check the year entered, instructor cannot be over 100 years old.");
        }
        return setBirthday(birthday);
    }

    public int getAgeInYears()
    {
        return Period.between(DOB, currentDate).getYears();
    }

    public int noOfYearsAtCollege()
    {
        return Period.between(startedTeaching, currentDate).getYears();
    }

    public String getInstructorAddress()
    {
        return getAddress() + ", " + getCity() + ", " + getPostalCode();
    }

    public String changeAddress(String address, String city, String postalCode)
    {
        setAddress(address);
        setCity(city);
        setPostalCode(postalCode);

        return getAddress() + ", " + getCity() + ", " + getPostalCode();
    }

    public String listOfSubjectsCertifiedToTeach()
    {
        if(this.list.size() == 0 ){
            return "not qualified to teach courses yet.";
        }

        StringBuilder s = new StringBuilder();
        for(int i = 0; i <this.list.size(); i++) {
            s.append(this.list.get(i));
            if(i+1 != this.list.size()){
                s.append(", ");
            }
        }

        return "[" + s.toString() + "]";
    }

    public void addCourseToInstructorAbilities(String course)
    {
        if(this.list.contains(course)) {
        } else {
            this.list.add(course);
        }
    }

    public boolean instructorCanTeach(String course)
    {
        return this.list.contains(course);
    }

    @Override
    public String toString()
    {
        return getFirstName() + " " + getLastName();
    }
}
