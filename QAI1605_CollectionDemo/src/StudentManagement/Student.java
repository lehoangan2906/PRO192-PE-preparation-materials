
package StudentManagement;

import static StudentManagement.Inputter.normalize;
import java.util.*;
import java.util.regex.Pattern;


public class Student {
    String code, name;
    double mark;
    
    Scanner sc = new Scanner(System.in);
    public Student() {
    }

    public Student(String code, String name, double mark) {
        code = normalize(code);
        while (!Pattern.matches("[sS][\\d]{3}", code)){
            System.out.print("Student code is invailid format (S000). Please enter a new value: ");
            code = sc.nextLine();
        }
        this.code = code.toUpperCase();
        name = normalize(name);
        while (name.trim().equals("")){
            System.out.println("Student name cannot be blank. Please enter a not null value!");
            Scanner sc = new Scanner(System.in);
            name = sc.nextLine();
        }
        this.name = name.toUpperCase();
        this.mark = (mark >=0 && mark<=10) ? mark : 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = normalize(name);
        if(name.length()>0) this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        if (mark >= 0 && mark < 10) this.mark = mark;
    }

    @Override
    public String toString() {
        return "code=" + code + ", name=" + name + ", mark=" + mark;
    }
    
    
}
