import java.util.*;
import java.lang.*;
import java.io.*;

public class Menu {
    Scanner sc = new Scanner(System.in);
    
    public void makeOptions(ArrayList<String> options){
        options.add("================================================================");
        options.add("|                             Menu                             |");
        options.add("================================================================");
        options.add("|                                                              |");
        options.add("|  0. Exit Program                                             |");
        options.add("|  1. List all brands                                          |");
        options.add("|  2. Add a new brand                                          |");
        options.add("|  3. Search a brand based on its ID                           |");
        options.add("|  4. Update a brand                                           |");
        options.add("|  5. Save brands to the file, named brands.txt                |");
        options.add("|  6. List all cars in ascending order of brand names          |");
        options.add("|  7. List cars based on a part of an input brand name         |");
        options.add("|  8. Add a car                                                |");
        options.add("|  9. Remove a car based on its ID                             |");
        options.add("|  10. Update a car based on its ID                            |");
        options.add("|  11. Save cars to file                                       |");
        options.add("|                                                              |");
        options.add("================================================================");
    } 
    
    public <E> int int_getChoice(ArrayList<E> options){
        int response;
        for (int i = 0; i < options.size(); i++){
            System.out.println(options.get(i));
        }
        System.out.println("\nPlease choose an option: 0 -> " + (options.size()-7));
        System.out.print("\nEnter your choice: ");
        response = Integer.parseInt(sc.nextLine());
        return response;
    }
}// end of class
