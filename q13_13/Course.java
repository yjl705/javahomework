package q13_13;

public class Course {
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName){
        this.courseName = courseName;
    }

    public void addStudent(String student){
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents(){
        return students;
    }

    public int getNumberOfStudents(){
        return numberOfStudents;
    }

    public String getCourseName(){
        return courseName;
    }

    public void dropStudents(String student){
        students[numberOfStudents] = "";
        numberOfStudents--;
    }

    public String[] clone(){
        String[] studnetsCopy = students.clone();
        return studnetsCopy;
    }

}
