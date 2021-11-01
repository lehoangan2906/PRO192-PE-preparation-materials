import java.util.*;
import java.lang.*;
import java.io.*;

public class TreeSetBookDemo {
    public static void main(String[] args) {
        TreeSet<Book> lstBooks = new TreeSet<>();
        lstBooks.add(new Book("B0001", "Programming in Java", 50, 35.5));
        lstBooks.add(new Book("B0002", "Thinking in Java", 120, 29.99));
        lstBooks.add(new Book("B0003", "Java Bible", 10, 65.0));
        lstBooks.add(new Book("B0004", "101 poblems in Java", 30, 45.5));
        lstBooks.add(new Book("B0005", "thinking in Java", 120, 49.5));
        lstBooks.add(new Book("B0006", "How to get mark 10 in Practical Exam", 60, 49.5));
        
        for (Book b:lstBooks){
            System.out.println(b);
        }
    }
}
