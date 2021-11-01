package StudentManagement;

import MyUltility.myLibs;
import static StudentManagement.Inputter.normalize;
import java.util.*;

public class StudentList extends ArrayList<Student>{
//    //without array list
//    Student[] list;
//    int numOfStudent;//luu so sinh vien hien thoi co trong mang list
//    final int MAX = 100; // qui dinh so phan tu toi da mang list[]
    Scanner sc = new Scanner(System.in);
    public StudentList(){
        super();
    }
    
    public Student search(String code){
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).getCode().equals(code)) 
                return this.get(i);
        }
        return null;
    }
    
    public boolean isCodeDuplicated(String code){
        code = code.trim().toUpperCase();
        return search(code) != null;
    }
    
    public void addStudent(){
        String newCode, newName;
        int newMark;
        boolean codeDuplicated = false;
        do{
            newCode = Inputter.inputPattern("St. code S000", "[sS][\\d]{3}");
            newCode = normalize(newCode).toUpperCase();
            codeDuplicated = isCodeDuplicated(newCode);
            if (codeDuplicated) System.out.println("Code is duplicated");
            
        }
        while(codeDuplicated);
//        newName = Inputter.inputNonBlankStr("Name of new student: ").toUpperCase();
        System.out.print("Enter the name of new student: "); newName = sc.nextLine();
        newMark = Inputter.getIntInrange("Mark: ", 0, 10);
        Student st = new Student(newCode, newName, newMark);
        this.add(st);
        System.out.println("Student " + newCode + " has been added.");
    }
    
    public void searchStudent(){
        if(this.isEmpty()) System.out.println("Empty list. No search can be performed!");
        else{
            String sCode = Inputter.inputNonBlankStr("Input student code for search: ");
            Student st = this.search(sCode);
            if (st == null) System.out.println("Student " + sCode + " doesn't exist!");
            else System.out.println("Found: " + st);
        }
    }
    
    public void updateStudent(){
        if(this.isEmpty())
            System.out.println("Empty list. No update can be performed!");
        else{
            String uCode = Inputter.inputNonBlankStr("Input code of updated student: ");
            Student st = this.search(uCode);
            if (st == null) System.out.println("Student " + uCode + " doesn't exist!");
            else{
                String newName = Inputter.inputNonBlankStr("Old name: " + st.name + ", new name: "); st.setName(newName);
                int newMark = Inputter.getIntInrange("Old mark: " + st.mark+ ", new mark 0..10: ", 0 , 10); st.setMark(newMark);
                System.out.println("Student " + uCode + " has been updated!");                
            }
        }
    }
    
    public void removeStudent(){
        if (this.isEmpty()) System.out.println("Empty list. No remove can be performed!");
        else{
            String rCode = Inputter.inputNonBlankStr("Input code of removed student: ");
            Student st = this.search(rCode);
            if (st == null) System.out.println("Student " + rCode + " doesn't exist!");
            else{
                this.remove(st);
                System.out.println("Student " + rCode + " has been removed!");
            }
        }
    }
    
    public void printAll(){
        if (this.isEmpty()) System.out.println("Empty list!");
        else{
            System.out.println("Student list:");
            for (Student st: this) System.out.println(st);
            System.out.println("Total: " + this.size() + " student(s)");
        }
    }
    
    public void initData(int numOfStudent){
        Student s;
        for (int i = 0; i < numOfStudent; i++) {
            do{
                s = new Student(myLibs.getRandomID("S", 999), myLibs.getRandomName(), myLibs.getRandomInRange(0, 10));
            } 
            while(search(s.name) != null);
            this.add(s);
        }
        System.out.println("Added " + numOfStudent + " students in the list!");
        
    }
}
