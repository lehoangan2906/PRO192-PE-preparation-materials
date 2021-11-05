
package Student_Manager;

import java.util.*;

public class Menu {
    public static int getChoice(ArrayList options){
        for (int i = 0; i < options.size(); i++){
            System.out.println((i + 1) + "-" + options.get(i));
        }
        System.out.println("Choose 1.." + options.size() + ": ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
    
    public static int getChoice(Object[] options){
        for (int i = 0; i < options.length; i++){
            System.out.println((i + 1) + "-" + options[i]);
        }
        System.out.println("Choose 1.." + options.length + ": ");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}
