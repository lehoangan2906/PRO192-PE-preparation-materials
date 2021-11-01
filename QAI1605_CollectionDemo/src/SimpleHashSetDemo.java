import java.lang.*;
import java.util.*;
import java.io.*;

public class SimpleHashSetDemo {
    public static void main(String[] args) {
        String a[] = {"5", "15", "10", "30", "20", "100", "80"};
        Set<String> s = new HashSet<String>();
        for (int i = 0; i < a.length; i++) {
            s.add(a[i]);          
        }
        System.out.println("Print in the simplest way: ");
        System.out.println(s);
        
        System.out.println("Print in traditional way");
        Iterator ite1 = s.iterator();
        while(ite1.hasNext())
            System.out.println(ite1.next());
        
        //Chuyen doi HashSet sang TreeSet
        System.out.println("Demo from HashSet to TreeSet");
        
        
        Set<String> s3 = new TreeSet<String>(s);
        System.out.println(s3);
        
        System.out.println("Print out TreeSet in the decending way");
        
        }
    }

