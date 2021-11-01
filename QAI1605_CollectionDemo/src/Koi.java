import java.lang.*;
import java.util.*;
import java.io.*;

public class Koi implements Comparable<Koi> {
    String id, name;
    double price;
    int length;

    public Koi() {
    }

    public Koi(String id, String name, double price, int length) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.length = length;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", price=" + price + ", length=" + length;
    }

    @Override
    public int compareTo(Koi o2) {
        //tieu chi de so sanh, sap xep ca koi la theo gia giam dan;
        if (this.price >= o2.price) return -1;
        return 1;
    }
    
    
}
