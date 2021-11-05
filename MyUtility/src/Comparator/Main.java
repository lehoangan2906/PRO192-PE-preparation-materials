package Comparator;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;


class Student{
    int rollno;
    String name, address;
    
    // constructor
    public Student(int rollno, String name, String address){
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }
    
    // used to print student details in main()
    public String toString(){
        return this.rollno + " " + this.name + " " + this.address;
    }
}


class Sortbyroll implements Comparator<Student>{
    // used for sorting in ascending order of roll number
    public int compare(Student a, Student b){
        return a.rollno - b.rollno;
    }
}


class Sortbyname implements Comparator<Student>{
    //used for sorting in ascending order of name
    public int compare(Student a, Student b){
        return a.name.compareTo(b.name);
    }
}

// driver code
public class Main {
    public static void main(String[] args) {
        
        ArrayList<Student> arr = new ArrayList<Student>();
        arr.add(new Student(111, "bbbb", "london"));
        arr.add(new Student(13, "aaaa", "nyc"));
        arr.add(new Student(121, "cccc", "jaipur"));
        
        System.out.println("Unsorted: ");
        for (int i = 0; i < arr.size(); i++)
            System.out.println(arr.get(i));
        
        Collections.sort(arr, new Sortbyroll());
        System.out.println("\nSorted by rollno");
        for (int i = 0; i < arr.size(); i++)
            System.out.println(arr.get(i));
        
        Collections.sort(arr, new Sortbyname());
        System.out.println("\nSorted by name");
        for (int i = 0; i < arr.size(); i++)
            System.out.println(arr.get(i));
    }
    
}
