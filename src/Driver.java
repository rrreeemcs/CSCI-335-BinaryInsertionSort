/*
Sameer Ramkissoon
CSCI-335 H. Gu
Project Assignment 1: Binary Insertion Sort
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {
    /**
     * Sorts the input Student[] array through BinaryInsertionSort by their ids
     * Uses helper static method BinarySearch to find the correct position for the current Student
     * @param arr Array of unsorted student records
     * @return The sorted Student array by their student ids
     */
    public static Student[] BinaryInsertionSort(Student[] arr) {
        // Looping through arr[1] to arr[length-1]
        for (int i = 1; i < arr.length; i++) {
            // Saving current Student as temp variable
            Student temp = arr[i];
            int j = i - 1;
            // Performing the BinarySearch and returning the new position for the Student
            int new_position = BinarySearch(arr, temp.get_student_id(), 0, i - 1);
            // Shifting values from A[0] ≤ A[i-1]
            while (j >= new_position) {
                arr[j + 1] = arr[j];
                j--;
            }
            // Placing current student in its correct position
            arr[new_position] = temp;
        }
        return arr;
    }

    /**
     * Performs the recursive BinarySearch algorithm on the given sorted subarray arr[0] to arr[i-1]
     * @param arr Sorted array from arr[0] to arr[i-1]
     * @param key The current student id
     * @param low Low bound of the sorted array (used for recursion)
     * @param high High bound of the sorted array (used for recursion)
     * @return The new index position for the student
     */
    private static int BinarySearch(Student[] arr, int key, int low, int high) {
        // Base Case
        if (low > high) {return low;}

        // Recursive Case
        int mid = (low + high)/2;
        if (arr[mid].get_student_id() == key) {return mid+1;}
        else if (arr[mid].get_student_id() < key) {return BinarySearch(arr, key, mid+1, high);}
        return BinarySearch(arr, key, low, mid-1);
    }

    /**
     * Prints out all the student info given an array of Students. Used for showing the unsorted and sorted order.
     * @param students Array of student records (id, first name, last name, age, gpa)
     */
    private static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.print(student.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Program Starting..." + "\n");

        // Creating FileReader object with unsorted-records.txt and getting the students form it
        FileReader fr = new FileReader(new File("unsorted-records.txt"));
        Student[] unsorted_students = fr.getStudents();

        // Showing the unsorted order of the students
        System.out.println("Unsorted Student Order (By Student ID):");
        printStudents(unsorted_students);

        System.out.println("Binary Insertion Sort Starting...");
        // Sorting these students using static BinaryInsertionSort method
        Student[] sorted_students = BinaryInsertionSort(unsorted_students);

        // Creating new sorted-records.txt file for the sorted students
        try {
            File sorted_file = new File("sorted-records.txt");
            // if file creation successful, return name of file
            if (sorted_file.createNewFile()) {
                System.out.println("File created: " + sorted_file.getName());
            }
            // otherwise, state file already exists
            else {
                System.out.println("File already exists.");
            }
            // catching exception
        } catch (IOException e) {
            System.out.println("Unable to create file");
        }

        // Writing the sorted students to the file -> trying to make FileWriter
        try (FileWriter fw = new FileWriter("sorted-records.txt")) {
            // looping through each student in sorted_students and calling its toString() method -> writes line to sorted-records.txt
            for (Student s : sorted_students) {
                String new_student = s.toString();
                fw.write(new_student);
                System.out.println("-- Updated file with new student: " + s.get_student_id() + " --");
            }
            System.out.println("Finished writing into sorted-records.txt" + "\n");
            // catching exception
        } catch (IOException e) {
            System.out.println("Unable to write file");
        }

        // Printing out the order of the students in sorted order
        System.out.println("Sorted Student Order (By Student ID):");
        printStudents(sorted_students);
    }
}