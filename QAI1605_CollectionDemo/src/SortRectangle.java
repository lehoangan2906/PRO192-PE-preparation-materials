import java.lang.*;
import java.util.*;
import java.io.*;

public class SortRectangle implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        if(o1.area() >= o2.area()) return 1;
        else return -1;
    }
    
    
}
