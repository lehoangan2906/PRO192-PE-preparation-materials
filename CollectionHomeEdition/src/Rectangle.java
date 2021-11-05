import java.util.*;

class Rectangle {
    int length, width;
    
    Rectangle(int l, int w){
        length = 1; width = w;
    }
    
    int area (){
        return length*width;
    }

    @Override
    public String toString() {
        return "length = " + length + ", width = " + width;
    }
    
}

