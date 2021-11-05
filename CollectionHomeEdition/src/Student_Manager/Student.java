package Student_Manager;

public class Student {
    String code = "";
    String name = "";
    int mark = 0;

    // constructors
    
    public Student() {
    }
    
    
    public Student(String code, String name, int mark) {
        this.code = code.toUpperCase();
        this.name = name.toUpperCase();
        this.mark = (mark >= 0 && mark <= 10)? mark: 0;
    }
    
    
    // get data as a string for printing
    @Override
    public String toString(){
        return code + ", " + name + ", " + mark;
    }
    
    
    public void setName(String name){
        name = name.trim().toUpperCase();
        if (name.length() > 0){
            this.name  = name;  // check validity
        }
    }
    
    
    public void setMark(int mark){
        if (mark >= 0 && mark <= 10){
            this.mark = mark;   // check validity
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getMark() {
        return mark;
    }
    
}
