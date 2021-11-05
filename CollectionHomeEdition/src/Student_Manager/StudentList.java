package Student_Manager;

import java.util.*;

public class StudentList extends ArrayList<Student>{
    public StudentList(){
        super();
    }
    
    // Search a student based on student's code. Return the student found 
    // This method supports preventing code duplications
    public Student search(String code){
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++){
            if (this.get(i).getCode().equals(code)){
                return this.get(i);     // found
            }
        }
        return null;    // not found
    }
    
    
    // checking whether a code is duplicated or not?
    private boolean isCodeDuplicated(String code){
        code = code.trim().toUpperCase();
        return search(code)!= null;
    }
    
    // Add a new student
    public void addStudent(){
        // input data of new student
        String newCode, newName;
        int newMark;
        boolean codeDuplicated = false;
        
        do{
            newCode = Inputter.inputPattern("st. code $000: ", "[sS][\\d]{3}");
            newCode = newCode.trim().toUpperCase();
            
            codeDuplicated = isCodeDuplicated(newCode); // check code duplication
            if(codeDuplicated){
                System.out.println("Code is duplicated!");
            }
        }while(codeDuplicated == true);
        newName = Inputter.inputNonBlankStr("Name of new student: ");
        newName = newName.toUpperCase();
        newMark = Inputter.inputInt("Mark: ", 0, 10);
        // 0 <= mark <= 10
        
        // create new student
        Student st = new Student(newCode, newName, newMark);
        
        //add new student to the list
        this.add(st);
        System.out.println("Student "+ newCode + " has been added."); 
    }
    
    // search student based on inputted code
    public void searchStudent(){
        if(this.isEmpty()){
            System.out.println("Empty list. No search can be performed!");
            
        }else{
            String sCode = Inputter.inputStr("Input student code for search: ");
            Student st = this.search(sCode);    //search student ased on code
            if (st== null)
                System.out.println("Student "+ sCode + " doesn't exist");
            else System.out.println("Found: " + st);
        }
    }
    
    // update name and mark based on student's code
    public void updateStudent(){
        if (this.isEmpty())
            System.out.println("Empty list. No update can be performed!");
        else{
            String uCode = Inputter.inputStr("Input code of updated student: ");
            Student st = this.search(uCode);        // search student
            if(st == null)
                System.out.println("Student: "+ uCode + " doesn't exist");
            else{
                // update student's name
                String oldName = st.getName();
                String msg = "Old name: "+ oldName + ", new name: ";
                String newName = Inputter.inputNonBlankStr(msg);
                
                st.setName(newName);
                
                //update student's mark
                int oldMark = st.getMark();
                msg = "Old mark: " + oldMark + ", new mark 0..10:";
                int newMark = Inputter.inputInt(msg, 0, 10);
                st.setMark(newMark);
                System.out.println("Student "+ uCode + " has been updated.");
            }
        }
    }
    
    
    // remove a student based on student's code
    public void removeStudent(){
        if (this.isEmpty()){
            System.out.println("Empty list. No remove can be performed!");
            
        }else{
            String rCode = Inputter.inputStr("Input code of removed student");
            Student st = this.search(rCode);    // search student
            if (st == null)
                System.out.println("Student " + rCode + " doesn't exist");
            else{
                this.remove(st); // remove this student
                System.out.println("Student "+ rCode + " has been updated.");
            }
        }
    }
    
    
    // list all students
    
    public void printAll(){
        if (this.isEmpty()) System.out.println("Empty list");
        else{
            System.out.println("Student list: ");
            for (Student st: this) System.out.println(st);
            System.out.println("Total: " + this.size() + " student(s).");
        }
    }// studentList
    
    
    
    
}// end of class
