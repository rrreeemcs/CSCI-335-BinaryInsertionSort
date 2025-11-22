/*
Sameer Ramkissoon
CSCI-335 H. Gu
Project Assignment 1: Binary Insertion Sort
Student Class: Creates Student objects from the unsorted_records.txt
*/

public class Student {
    private int student_id;
    private String student_first_name;
    private String student_last_name;
    private int student_age;
    private double student_gpa;

    /**
     * Creates a new Student object.
     * <p>
     *     Uses each line from the unsorted-records.txt (student record).
     *     Contains id, first and last name, age, and gpa.
     *     Creates the Student object with these fields.
     * </p>
     * @param s_id Unique identification for a student
     * @param s_first_name First name for the student
     * @param s_last_name Last name for the student
     * @param s_age Age of the student
     * @param s_gpa GPA of the student
     */
    public Student(int s_id, String s_first_name, String s_last_name, int s_age, double s_gpa) {
        this.student_id = s_id;
        this.student_first_name = s_first_name;
        this.student_last_name = s_last_name;
        this.student_age = s_age;
        this.student_gpa = s_gpa;
    }

    // Setter Methods (not used, just for class definition)
    public void set_student_id(int s_id) {this.student_id = s_id;}
    public void set_student_first_name(String s_first_name) {this.student_first_name = s_first_name;}
    public void set_student_last_name(String s_last_name) {this.student_last_name = s_last_name;}
    public void set_student_age(int s_age) {this.student_age = s_age;}
    public void set_student_gpa(double s_gpa) {this.student_gpa = s_gpa;}

    // Getter Methods (used for the toString method)
    public int get_student_id() {return this.student_id;}
    public String get_student_first_name() {return this.student_first_name;}
    public String get_student_last_name() {return this.student_last_name;}
    public int get_student_age() {return this.student_age;}
    public double get_student_gpa() {return this.student_gpa;}

    // toString method (used to print out each student info from the records then append to new records)
    public String toString() {
        String s = "";
        s += this.get_student_id() + ", ";
        s += this.get_student_first_name() + ", ";
        s += this.get_student_last_name() + ", ";
        s += this.get_student_age() + ", ";
        s += this.get_student_gpa() + "\n";
        return s;
    }
}