import java.io.*;
import java.util.*;
import java.lang.*;



public class Main {

    public static void main(String[] args) {
        
        ArrayList<Book> lstBooks = new ArrayList<>();
        
        lstBooks.add(new Book("B0001", "Programming in Java", 50, 35.5));
        lstBooks.add(new Book("B0002", "Thinking in Java", 120, 29.99));
        lstBooks.add(new Book("B0003", "Java Bible", 10, 65.0));
        lstBooks.add(new Book("B0004", "101 poblems in Java", 30, 45.5));
        
        for (Book b: lstBooks){
            System.out.println(b);
        }
        
        // yeu cau hien thi cac sach theo thu tu giam dan ve gia (descending price)
        // B0003, B0004, B0001, B0002
        
        lstBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2){
                if (o1.getPrice() >= o2.getPrice()){
                    return -1;
                }else{
                    return 1;
                }
            }
        });
        System.out.println("=====================================================");
        System.out.println("\nAfter sorted in descending order of price, we have: \n");
        for (Book b: lstBooks){
            System.out.println(b);
        }
        
        
        // yeu cau hien thi cac sach theo thu tu tang dan ve so luong (ascending order of quantity)
        // B0003, B0004, B0001, B0002
        lstBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2){
                if (o1.getQuantity() >= o2.getQuantity()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        System.out.println("=====================================================");
        System.out.println("\nAfter sorted in ascending order of quantity, we have: \n");
        for (Book b: lstBooks){
            System.out.println(b);
        }
        
        // yeu cau 3: sap xep theo so luuong giam dan, neu cung so luong thi theo gia tang dan
        lstBooks.add(new Book("B0005", "thinking in Java", 120, 49.5));
        //B0002, B0005, B0001, B0004, B0003
        lstBooks.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if(o1.getQuantity() > o2.getQuantity()){
                    return -1;
                }else if (o1.getQuantity() < o2.getQuantity()){
                    return 1;
                }
                else{ // truong hop so luuong bang nhau
                    if (o1.getPrice() >= o2.getPrice()){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        });
        System.out.println("=====================================================");
        System.out.println("\nAfter sorted in descending order of quantity and ascending order of price, we have: \n");
        for (Book b: lstBooks){
            System.out.println(b);
        }
        
    }// end of main
    
}
