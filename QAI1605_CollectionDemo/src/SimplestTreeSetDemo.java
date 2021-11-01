import java.lang.*;
import java.util.*;
import java.io.*;

public class SimplestTreeSetDemo {
    public static void main(String[] args) {
        String a[] = {"5", "15", "15", "30", "20", "100", "80", "11"};
        
        Set<String> s2 = new TreeSet<String>();
        for (int i = 0; i < a.length; i++) {
            boolean addResult = s2.add(a[i]);
            System.out.println("After add " + a[i] + "");
        }
        System.out.println("Print out in the simplest way: ");
        System.out.println(s2);
        
        System.out.println("Print out using Iterator way: ");
        Iterator<String> ite2 = s2.iterator();
        while(ite2.hasNext())
            System.out.println(ite2.next());
        
    //TreeSet<int> s5 = new TreeSet<int>() : sai vi chi truyen duoc kieu du lieu tham chieu
    TreeSet<Integer> s5 = new TreeSet<Integer>(); //Integer, Double, Character, String, Float,...
    TreeSet<Koi> s6 = new TreeSet<Koi>();
    s6.add(new Koi("K001", "Koi showa", 3000.5, 82));
    s6.add(new Koi("K002", "Koi showa", 3000, 82));
    s6.add(new Koi("K003", "Koi kohaku", 4100.5, 90));
    System.out.println(s6);
    
    //gia su TreeSet s6 chua tap hop ca koi duoc sap xep theo gia giam dan
    //ta muon thay doi thanh kich thuoc tang dan chi co the chinh tu lop Koi
    
    
    }
    

}
