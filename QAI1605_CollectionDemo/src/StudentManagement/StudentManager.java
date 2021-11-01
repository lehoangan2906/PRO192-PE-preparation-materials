
package StudentManagement;

import java.util.ArrayList;

public class StudentManager {
    public static void main(String[] args) {
        String[] options = {"Add new student", "Search a student", "Update name and mark", 
                            "Remove a student", "List all", "Get random students", "Quit"};
        int choice = 0;
        StudentList list = new StudentList();
        do{
            System.out.println("\nStudent managing Program");
            choice = Menu.getChoice2(options);
            switch(choice){
                case 1: list.addStudent(); break;
                case 2: list.searchStudent(); break;
                case 3: list.updateStudent(); break;
                case 4: list.removeStudent(); break;
                case 5: list.printAll(); break;
                case 6: list.initData(10); break;
                default: System.out.println("Bye!");
            }
        }
        while(choice > 0 && choice < 7);
    }
        
        
}

