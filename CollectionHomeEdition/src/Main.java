
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("==============================================================");
        System.out.println("ArrayList demo 01\\n");
        ArrayList list = new ArrayList(); // initialize an empty list
        list.add(5);
        list.add(10);
        list.add("Hello");
        
        Rectangle r = new Rectangle(3, 20); // create new rectangle
        list.add(r);                        // add rectangle to the list
        list.add(new Rectangle(4, 15));     // add rectangle to the list
        
        System.out.println(list);           // print the list, format: [ele1, ele2, ...]
        System.out.println("\nPosition of 10: " + list.indexOf(10));
        System.out.println("Position of the rectangle r: " + list.indexOf(r));
        
        list.remove(2);             // remove the second element from the list
        System.out.println("\nAfter removing the second element: ");   
        
        // traverse
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i) + ", ");
        }
        
        System.out.println();
        System.out.println("Area: " + ((Rectangle)list.get(2)).area());
        // We can not use the method area() for rectangles because all elements of 
        // the list have behaved as objects of the Objects class. The Object class 
        // does not contain the area() method. If we want to call the area() method 
        // for rectangles, class casts must be specified explicitly
            
        System.out.println("\n=============================================================");
        System.out.println("ArrayList demo 02: \n");
        
        ArrayList<Rectangle> list2 = new ArrayList();    // init empty list
        // we define the same-type list with class parameter (<Rectangle>) . 
        // Then, no class casting is needed because the Java compiler realized 
        // the type of elements.
        
        // add 4 rectangle
        list2.add(new Rectangle(5, 2));
        list2.add(new Rectangle(2, 1));
        list2.add(new Rectangle(4, 3));
        list2.add(new Rectangle(3, 2));
        
        // traverse the list
        for (int i = 0; i < list.size(); i++){
            System.out.println(list2.get(i).length + ", " + list2.get(i).width + ", " + list2.get(i).area());
        }
    }
    
}
