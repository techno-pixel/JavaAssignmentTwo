package registrationsystem;

import java.nio.channels.IllegalChannelGroupException;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseWithLab {
    private Instructor karenV, labGuy;
    private Student myStudent;
    private String labPreReq;
    private String courseCode;
    private String courseSubject;
    private String courseRoom;
    private DayOfWeek weekDay, labDay;
    private LocalTime classTime, labTimeStart;
    private int classDuration;
    private String labRoom;

    public CourseWithLab(Instructor karenV, String courseCode, String courseSubject,
                         String courseRoom, DayOfWeek weekDay, LocalTime classTime, int classDuration, String labPreReq,
                         Instructor labGuy, String labRoom, DayOfWeek labDay, LocalTime labTimeStart)
    {
        this.karenV = karenV;
        this.courseCode = courseCode;
        this.courseSubject = courseSubject;
        this.courseRoom = courseRoom;
        this.weekDay = weekDay;
        this.classTime = classTime;
        this.classDuration = classDuration;
        this.labGuy = labGuy; this.labRoom = labRoom;
        this.labDay = labDay;
        this.labTimeStart = labTimeStart;
        this.labPreReq = labPreReq;

        if(!karenV.getArrayList().contains(courseCode))
        {
            throw new IllegalArgumentException("Professor " + karenV.getFirstName() + " " + karenV.getLastName() +
                    " is not qualified to teach " + this.courseCode);
        } else if(!labGuy.getArrayList().contains(courseCode + "-LAB"))
        {
            throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        } else if(labTimeStart.isAfter(LocalTime.parse("18:00")) || labTimeStart.isBefore(LocalTime.parse("08:00")))
        {
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
    }

    public CourseWithLab(Instructor karenV, String courseCode, String courseSubject,
                         String courseRoom, DayOfWeek weekDay, LocalTime classTime, int classDuration,
                         Instructor labGuy, String labRoom, DayOfWeek labDay, LocalTime labTimeStart)
    {
        this.karenV = karenV;
        this.courseCode = courseCode;
        this.courseSubject = courseSubject;
        this.courseRoom = courseRoom;
        this.weekDay = weekDay;
        this.classTime = classTime;
        this.classDuration = classDuration;
        this.labGuy = labGuy; this.labRoom = labRoom;
        this.labDay = labDay;
        this.labTimeStart = labTimeStart;

        if(!karenV.getArrayList().contains(courseCode))
        {
            throw new IllegalArgumentException("Professor " + karenV.getFirstName() + " " + karenV.getLastName() +
                    " is not qualified to teach " + this.courseCode);
        } else if(!labGuy.getArrayList().contains(courseCode + "-LAB"))
        {
            throw new IllegalArgumentException("The Lab Tech is not qualified to host the lab");
        } else if(labTimeStart.isAfter(LocalTime.parse("18:00")) || labTimeStart.isBefore(LocalTime.parse("08:00")))
        {
            throw new IllegalArgumentException("The lab start time must be between 08:00-18:00");
        }
    }

    //setters & getters ------------------------------------------------------------------------------------

    public Instructor getKarenV() { return karenV; }

    public void setKarenV(Instructor karenV) { this.karenV = karenV; }

    public Instructor getLabGuy() { return labGuy; }

    public void setLabGuy(Instructor labGuy) { this.labGuy = labGuy; }

    public Student getMyStudent() { return myStudent; }

    public void setMyStudent(Student myStudent) { this.myStudent = myStudent; }

    public String getCourseCode() { return courseCode; }

    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }

    public String getCourseSubject() { return courseSubject; }

    public void setCourseSubject(String courseSubject) { this.courseSubject = courseSubject; }

    public String getCourseRoom() { return courseRoom; }

    public void setCourseRoom(String courseRoom) { this.courseRoom = courseRoom; }

    public DayOfWeek getWeekDay() { return weekDay; }

    public void setWeekDay(DayOfWeek weekDay) { this.weekDay = weekDay; }

    public DayOfWeek getLabDay() { return labDay; }

    public void setLabDay(DayOfWeek labDay) { this.labDay = labDay; }

    public LocalTime getClassTime() { return classTime; }

    public void setClassTime(LocalTime classTime) { this.classTime = classTime; }

    public int getClassDuration() { return classDuration; }

    public void setClassDuration(int classDuration) { this.classDuration = classDuration; }

    public LocalTime getLabTimeStart() { return labTimeStart; }

    public void setLabTimeStart(LocalTime labTimeStart) { this.labTimeStart = labTimeStart; }

    public String getLabRoom() { return labRoom; }

    public void setLabRoom(String labRoom) { this.labRoom = labRoom; }

    public String getLabPreReq() { return labPreReq; }

    public void setLabPreReq(String labPreReq) { this.labPreReq = labPreReq; }

    // methods -----------------------------------------------------------------------------------------

    public String checkPrerequisite()
    {
        return this.labPreReq;
    }

    public Instructor getLabTech()
    {
        return labGuy;
    }

    public Instructor getInstructorToTeach()
    {
        return karenV;
    }

    public String getLabClassAndTime()
    {
        return "room: " + this.labRoom + ", " + this.labDay + " starting at " + this.labTimeStart;
    }

    public String toString()
    {
        return this.courseCode + "-" + this.courseSubject + " with lab";
    }
}
