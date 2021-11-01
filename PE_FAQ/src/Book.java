import java.util.*;
import java.lang.*;
import java.io.*;

public class Book implements Comparable<Book>{
    String id, name;
    int quantity;
    double price;

    public Book() {
    }

    public Book(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price;
    }

    @Override
    public int compareTo(Book o2) {
        // mac dinh khi mot doi tuong thuoc lop book duoc add vao mot TreeSet hoac collection ma co kieu duoc sorted 
        // thi se sap thu tu theo gia tang dan (ascending order of price)
        
        if (this.getPrice() > o2.getPrice()){
            return 1;
        }else if (this.getPrice() < o2.getPrice()){
            return -1;
        }else{
            // neu gia bang nhau thi sap xep theo so luong tang dan
            if (this.getQuantity() >= o2.getQuantity()){
                return 1;
            }else{
                return -1;
            }
        }
    }
    
    
}
