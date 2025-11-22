/*
Sameer Ramkissoon
CSCI-335 H. Gu
Project Assignment 1: Binary Insertion Sort
FileReader Class: Reads the input file (unsorted-records.txt), makes a Student from each line
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private File file;
    private Student[] students;

    /**
     * Creates a new FileReader object.
     * <p>
     *     Is created using a file (in this case the unsorted-records.txt).
     *     Makes an empty array of 20 Student objects (for this project).
     *     Calls the makeStudents() method to read the file and put the students in the array.
     * </p>
     * @param file File used for reading, unsorted-records.txt
     */
    public FileReader(File file) {
        this.file = file;
        this.students = new Student[20];
        this.makeStudents();
    }

    /**
     * In charge of making all the students for Student[] array.
     * Reads each line of unsorted-records.txt and parses each field for Student constructor.
     * Splits each line via regex into a String[] array info
     * info[0] = student id
     * info[1] = first name
     * info[2] = last name
     * info[3] = age
     * info[4] = gpa
     * Handles FileNotFoundException
     */
    public void makeStudents() {
        // Creates a Scanner to read the file
        try (Scanner sc = new Scanner(this.file)) {
            int i = 0;
            // while-loop to continue reading until end of file
            while (sc.hasNextLine() && i < this.students.length) {
                String l = sc.nextLine();
                // Splits lines by regex into String[] info (holds each field for student record)
                String[] info =  l.split(", ");
                this.students[i] = new Student(Integer.parseInt(info[0]), info[1], info[2], Integer.parseInt(info[3]), Double.parseDouble(info[4]));
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    // Returns all the students from FileReader
    public Student[] getStudents() {
        return this.students;
    }
}