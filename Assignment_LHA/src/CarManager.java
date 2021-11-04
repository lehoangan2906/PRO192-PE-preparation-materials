import java.util.*;
import java.lang.*;
import java.io.*;

public class CarManager {
    public static void main(String[] args) throws IOException {
        
        BrandList brandlist = new BrandList();
        CarList carlist = new CarList();
        Menu menu = new Menu();
        ArrayList<String> options;
        Scanner sc = new Scanner(System.in);
        
        String brandFileName = "src/brands.txt";
        String carFileName = "src/cars.txt";
        brandlist.loadFromFile(brandFileName);
        carlist.loadFromFile(carFileName);
        
        while (true){
            options = new ArrayList<>();
            menu.makeOptions(options);
            int choice = menu.int_getChoice(options);
            switch(choice){
                case 0:
                    System.out.println("\n ===================== Creator's Information ====================");
                    System.out.println("||                                                              ||");
                    System.out.println("|| Name:           Le Hoang An                                  ||");
                    System.out.println("|| Student code:   HE163613                                     ||");
                    System.out.println("|| Class:          AI1605                                       ||");
                    System.out.println("||                                                              ||");
                    System.out.println(" ================================================================\n");
                    System.out.println("----------------Thanks for using our production.----------------\n");
                    return;
                case 1:
                    System.out.println("================================================================\n");
                    System.out.println("                        List all brands:\n");
                    brandlist.listBrands();
                    break;
                case 2: 
                    System.out.println("\n                      Add a new brand: \n");
                    brandlist.addBrand();
                    break;
                case 3: 
                    System.out.println("\n                Search a brand based on its ID\n");
                    while (true){
                        System.out.print("Enter the ID of the brand you want to search: ");
                        String ID = sc.nextLine();
                        if ("".equals(ID)){
                            System.out.println("ID cannot be blanked.");
                        }else{
                            brandlist.searchByID(ID);
                            break;
                        }
                    }
                    break;
                case 4: 
                    System.out.println("\n                       Update a brand\n");
                    brandlist.updateBrand();
                    break;
                case 5:
                    System.out.println("\n                Save brands to the file, named brands.txt\n");
                    brandlist.saveToFile(brandFileName);
                    break;
                case 6:
                    System.out.println("\n                List all cars in ascending order of brand names\n");
                    carlist.listCarsByBrandID();
                    break;
                case 7: 
                    System.out.println("\n                List cars based on a part of an input brand name\n");
                    carlist.printBasedBrandName();
                    break;
                case 8:
                    System.out.println("\n                               Add a car\n");
                    carlist.addCar();
                    break;
                case 9:
                    System.out.println("\n                 Remove a car based on its ID\n");
                    carlist.removeCar();
                    break;
                case 10:
                    System.out.println("\n                 Update a car based on its ID\n");
                    carlist.updateCar();
                    break;
                case 11:
                    System.out.println("\n             Save cars to file, named cars.txt\n");
                    carlist.saveToFile(carFileName);
                    break;
            }
        }
    }
}// end of class
