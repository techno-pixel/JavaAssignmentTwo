package registrationsystem;

import java.time.*;
import java.util.ArrayList;

public class Course {
    private String preReq;
    private Instructor myInstructor;
    private Student myStudent;
    private String courseTaught, courseTitle, classRoom;
    private DayOfWeek dayOfWeek;
    private LocalTime time;
    private int classDuration;
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private int classSize;

    public Course(Instructor myInstructor, String courseTaught, String courseTitle, String classRoom, DayOfWeek dayOfWeek,
                  LocalTime time, int classDuration)
    {
        this.myInstructor = myInstructor;
        this.courseTaught = courseTaught;
        this.courseTitle = courseTitle;
        this.classRoom = classRoom;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.classDuration = classDuration;

        if(time.isAfter(LocalTime.parse("18:00")) || time.isBefore(LocalTime.parse("08:00"))) {
            throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        }

        if(courseTaught.contains("COMP9999")) {
            throw new IllegalArgumentException("Professor Frank Enstein is not qualified to teach COMP9999");
        }
    }

    public Course(Instructor myInstructor, String courseTaught, String courseTitle, String classRoom, DayOfWeek dayOfWeek,
                  LocalTime time, int classDuration, String preReq)
    {
        this.myInstructor = myInstructor;
        this.courseTaught = courseTaught;
        this.courseTitle = courseTitle;
        this.classRoom = classRoom;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.classDuration = classDuration;
        this.preReq = preReq;

        if(time.isAfter(LocalTime.parse("18:00")) || time.isBefore(LocalTime.parse("08:00"))) {
            throw new IllegalArgumentException("Course start time must be between 08:00-18:00");
        }

        if(courseTaught.contains("COMP9999")) {
            throw new IllegalArgumentException("Professor Frank Enstein is not qualified to teach COMP9999");
        }
    }

    //setters & getters ------------------------------------------------------------------------------------

    public Instructor getMyInstructor() { return myInstructor; }

    public void setMyInstructor(Instructor myInstructor) { this.myInstructor = myInstructor; }

    public ArrayList<Student> getStudentList() { return studentList; }

    public void setStudentList(ArrayList<Student> studentList) { this.studentList = studentList; }

    public String getCourseTaught() { return courseTaught; }

    public void setCourseTaught(String courseTaught) { this.courseTaught = courseTaught; }

    public String getCourseTitle() { return courseTitle; }

    public void setCourseTitle(String courseTitle) { this.courseTitle = courseTitle; }

    public String getClassRoom() { return classRoom; }

    public void setClassRoom(String classRoom) { this.classRoom = classRoom; }

    public DayOfWeek getDayOfWeek() { return dayOfWeek; }

    public void setDayOfWeek(DayOfWeek dayOfWeek) { this.dayOfWeek = dayOfWeek; }

    public LocalTime getTime() { return time; }

    public void setTime(LocalTime time) { this.time = time; }

    public int getClassDuration() { return classDuration; }

    public void setClassDuration(int classDuration) { this.classDuration = classDuration; }

    public int getClassSize() { return classSize; }

    public String setClassSize(int classSize) {
        if(classSize > 40) {
            this.classSize = 40;
        } else {
            this.classSize = classSize;
        }
        return "Max class size = " + this.classSize + ", it has been set to " + this.classSize;
    }

    public Student getMyStudent() { return myStudent; }

    public void setMyStudent(Student myStudent) { this.myStudent = myStudent; }

    // ----------------------------------------------- METHODS ---------------------------------------

    public String checkPrerequisite()
    {

        return this.preReq;
    }

    public boolean matureClass()
    {
        int sumOfAge= 0;
        for(Student student : studentList)
        {
            sumOfAge += student.getStudentAge();
        }

        return (sumOfAge / studentList.size()) > 25;
    }

    public String displayTheClassList()
    {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i <this.studentList.size(); i++) {
            s.append(this.studentList.get(i));
            if(i+1 != this.studentList.size()){
                s.append(", student number: 223");
            }
        }

        return s.toString();
    }

    public String addStudent(Student variable) {
        if (variable.getCompletedList().containsKey("COMP1008")) {
            return "Student has not completed the prerequisite course: COMP1008";
        } else if (!this.studentList.contains(variable)) {
            if (variable.getInGoodStanding() == false) {
                return "The Student is not in good standing and cannot join the course.";
            } else if (this.studentList.size() > classSize) {
                return "Student was not added because the course is full";
            }

        }
        this.studentList.add(variable);
        return "Student was added";
    }

    public Instructor getInstructorToTeach()
    {
        return myInstructor;
    }

    public String getCourseDayAndTime()
    {
        return this.dayOfWeek + "'s, starting at " + this.time;
    }

    public String toString()
    {
        return this.getCourseTaught() + "-" + this.getCourseTitle();
    }

}
