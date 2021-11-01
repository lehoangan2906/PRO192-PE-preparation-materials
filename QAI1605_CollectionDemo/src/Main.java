
import java.util.*;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        list1.add(5);
        list1.add(10);
        list1.add(new Rectangle(20,5));
        list1.add(new String("Hanoi mua thu"));
        System.out.println("Number of elements of list1: " + list1.size());
        list1.add(new Rectangle(25,15));
        list1.add(new String("Hanoi mua thu"));
        System.out.println("Number of elements in list1: " + list1.size());
        //Cach 1 de print out list1
        System.out.println(list1); //The simplest way to print out the list
        //mot doi tuong thuoc arraylist co ther chua nhieu doi tuong thuoc nhieu kieu du lieu khac nhau
        //no duy tri thu tu ta da add vao (orded)
        //no cho phep cac phan tu trung nhau
        
        //Remove Ha noi mua thu
        System.out.println("===================================");
        System.out.println("Remove the last element in list1");
        list1.remove(list1.size()-1);
        
        //Cach 2 de in ra list1
        System.out.println("===================================");
        Iterator ite1 = list1.iterator();
        while(ite1.hasNext()) System.out.println(ite1.next().toString());
        //Neu chi in ra thuoc kieu rectangle
        System.out.println("===================================");
        System.out.println("Display rectangle objects only:");
        ite1 = list1.iterator();
        while(ite1.hasNext()){
            Object obj = ite1.next();
            if (obj instanceof Rectangle)
                System.out.println(obj);
        }
        
        //======================================================================
        //Cach nua de in rectangle la su dung kieu du lieu khai quat hoa Generics
        ArrayList<Rectangle> lstRects = new ArrayList<Rectangle>();
        lstRects.add(new Rectangle(7,7));
        lstRects.add(new Rectangle(5,5));
        lstRects.add(new Rectangle(10,10));
        Iterator<Rectangle> ite2 = lstRects.iterator();
        for(int i = 0; i<lstRects.size(); i++){
            Rectangle rect1 = lstRects.get(i);
            System.out.println(rect1);
        }
         
        //Demo Comparator
        //vi du voi lstRectangle o tren ta muon hien thi dien tich giam dan
        lstRects.sort(new Comparator<Rectangle>() {
            @Override
            public int compare(Rectangle o1, Rectangle o2) {
                if(o1.area() >= o2.area()) return -1;
                else return 1;
            }
        });
        System.out.println("");
        System.out.println("After sorted in descending order we have:");
        for(int i = 0; i<lstRects.size(); i++){
            Rectangle rect1 = lstRects.get(i);
            System.out.println(rect1);
        }   
        lstRects.sort(new SortRectangle());
        System.out.println("");
        System.out.println("After sorted in descending order we have:");
        for(int i = 0; i<lstRects.size(); i++){
            Rectangle rect1 = lstRects.get(i);
            System.out.println(rect1);
        }          
    }
    
}
