import java.util.*;
import java.lang.*;
import java.io.*;

public class CarList {
    // brand list must be existed in advance
    BrandList brandList;
    Scanner sc ;
    Brand brand;
    Car car;
    List<Car> carlist;
    
    public CarList(){
        carlist = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    
    String filename = "src/cars.txt";
    
    public boolean loadFromFile(String filename){
        carlist.removeAll(carlist);
        File f = new File(filename);
        if (!f.exists()) {
            return false;
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = "";
                BrandList bl = new BrandList();
                String file1 = "src/brands.txt";
                bl.loadFromFile(file1);
                ArrayList<Brand> lb = bl.brandlist;
                while ((line = br.readLine()) != null) {
                    Car c = new Car();
                    String[] s = line.trim().split(", ");
                    c.setCarID(s[0]);
                    for (Brand b : lb) {
                        if (b.getBrandID().equals(s[1].trim())) {
                            c.setBrand(b);
                        }
                    }
                    c.setColor(s[2]);
                    c.setFrameID(s[3]);
                    c.setEngineID(s[4]);
                    carlist.add(c);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
                return false;
            } catch (IOException e) {
                System.out.println(e);
                return false;
            }
        }
        return true;
    }
    
    public boolean saveToFile(String filename){
        PrintWriter out;
        try {
            out = new PrintWriter(filename);
            String line = "";
            for (Car i : carlist) {
                line = i.getCarID() + ", " + i.getBrand().getBrandID() + ", "
                        + i.getColor() + ", " + i.getFrameID()
                        + ", " + i.getEngineID();
                out.write(line + "\n");
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public int searchID(String carID){
        for (int i = 0; i < carlist.size(); i++){
            if (carlist.get(i).getCarID().equals(carID)){
                return i;
            }
        }
        return -1;
    }
    
    public int searchFrame(String fID){
        for (int i = 0; i < carlist.size(); i++){
            if (carlist.get(i).getFrameID().equals(fID))
                return i;
        }
        return -1;
    }
    
    public int searchEngine(String eID){
        for (int i = 0; i < carlist.size(); i++){
            if (carlist.get(i).getEngineID().equals(eID))
                return i;
        }
        return -1;
    }
    
    public int searchByBrandID(String brandid) throws IOException{
        BrandList brandlist = new BrandList();
        String filename = "src/brands.txt";
        brandlist.loadFromFile(filename);
        ArrayList<Brand> bl = brandlist.brandlist;
        for (int i = 0; i < bl.size(); i++){
            if (bl.get(i).getBrandID().equals(brandid)){
                return i;
            }
        }
        return -1;
    }
    
    public void BrandIDMenu() throws IOException{
        BrandList brandlist = new BrandList();
        String filename = "src/brands.txt";
        brandlist.loadFromFile(filename);
        ArrayList<Brand> bl = brandlist.brandlist;
        System.out.println("\n---- select one of the following brandID ----");
        for (int i = 0; i < bl.size(); i++){
            String id = bl.get(i).getBrandID();
            System.out.println("               " + i + ". " + id);
        }
        System.out.println("----------------------------------------------\n");
    }
    
    public void addCar() throws IOException{
        Car newcar = new Car();
        String carID, color, frameID, engineID, brandID;
        
        while (true){
            System.out.print("Enter new carID: ");
            carID = sc.nextLine();
            int pos = searchID(carID);
            if("".equals(carID)){
                System.out.println("Car ID cannot be blanked. reEnter new Car ID: ");
            }else{
                if(pos >= 0){
                    System.err.print("Car ID existed.\n");
                }else{
                    newcar.setCarID(carID);
                    break;
                }
            }
        }
        
        
        while (true){
            BrandList bl = new BrandList();
            String filename = "src/brands.txt";
            bl.loadFromFile(filename);
            ArrayList<Brand> arrlbr = bl.brandlist;
            BrandIDMenu();
            System.out.print("Enter new brand ID: ");
            brandID = sc.nextLine();
            
            int n = searchByBrandID(brandID); //  the position of the brand if exist, else -1
            if(n < 0){
                System.err.println("Brand ID not found.\n");
            }else{
                newcar.setBrand(arrlbr.get(n));
                break;
            }
        }
        
        while (true){
            System.out.print("Enter new car color: ");
            color = sc.nextLine();
            if("".equals(color)){
                System.err.print("Car color cannot be blanked. reEnter new Car color: ");
            }else{
                newcar.setColor(color);
                break;
                
            }
        }
        
        while (true){
            System.out.print("Enter new frame ID: ");
            frameID = sc.nextLine();
            if("".equals(frameID)){
                System.err.print("frame ID cannot be blanked. reEnter new frame ID: \n");
            }else{
                if(searchID(frameID) > 0){
                    System.out.print("frame ID existed.\n");
                }else{
                    newcar.setFrameID(frameID);
                    break;
                }
            }
        }
        
        while (true){
            System.out.print("Enter new engine ID: ");
            engineID = sc.nextLine();
            if("".equals(engineID)){
                System.err.print("Engine ID cannot be blanked. reEnter new engine ID: ");
            }else{
                if(searchID(engineID) > 0){
                    System.out.print("Engine ID existed.\n");
                }else{
                    newcar.setEngineID(engineID);
                    break;
                }
            }
        }
        carlist.add(newcar);
        System.out.println("\nCar added!\n");
        System.out.println("To view the updated list, please save all changes to file first.\n");
    }
    
    public void printBasedBrandName(){
        int count = 0;
        System.out.print("Enter Brand name you desire to find: ");
        String brandpart = sc.nextLine();
        
        for (int i = 0; i < carlist.size(); i++){
            Car c = carlist.get(i);
            if (c.brand.brandName.contains(brandpart)){
                System.out.println(" ----------------------------------------------");
                System.out.println("| carID| brandID | color   | frameID | engineID|");
                System.out.println(" ------|---------|---------|---------|---------");
                System.out.println(c.screenString());
                System.out.println(" ----------------------------------------------\n");
                count++;
            }
        }
        if (count == 0)
            System.out.println("No car is detected.\n");
    }
    
    public boolean removeCar(){
        System.out.print("Enter ID of the car you want to remove: ");
        String carID = sc.nextLine();
        int pos = searchID(carID);
        if(pos < 0){
            System.out.println("No car detected\n");
            return false;
        }else{
            carlist.remove(pos);
            System.out.println("\nRemove car successfully!\n");
            System.out.println("To view the updated list, please save all changes to file first.\n");
        }
        return true;
    }
    
    public void updateCar() throws IOException{
        String carID, color, frameID, engineID, brandID;
        
        System.out.print("Enter ID of the car you want to update: ");
        carID = sc.nextLine();
        int pos = searchID(carID);
        
        if (pos < 0){
            System.err.println("Car not detected.\n");
        }else{
            Car newcar = carlist.get(pos);
            while (true){
                BrandList brandlist = new BrandList();
                brandlist.loadFromFile(filename);
                ArrayList<Brand> arrlbr = brandlist.brandlist;
                
                BrandIDMenu();
                
                System.out.print("Enter new brand ID: ");
                brandID = sc.nextLine();

                if("".equals(brandID)){
                    System.out.print("brand ID cannot be blanked. reEnter new brand ID: ");
                }else{
                    if(searchByBrandID(brandID) < 0){
                        System.out.println("Brand ID not found.");
                    }else{
                        newcar.setBrand(arrlbr.get(searchByBrandID(brandID)));
                        break;
                    }
                }
            }

            while (true){
                System.out.print("Enter new car color: ");
                color = sc.nextLine();
                if("".equals(color)){
                    System.out.print("Car color cannot be blanked. reEnter new Car color: ");
                }else{
                    newcar.setColor(color);
                    break;

                }
            }

            while (true){
                System.out.print("Enter new frame ID: ");
                frameID = sc.nextLine();
                if("".equals(frameID)){
                    System.out.print("frame ID cannot be blanked. reEnter new frame ID: ");
                }else{
                    if(searchID(frameID) > 0){
                        System.out.println("frame ID existed.");
                    }else{
                        newcar.setFrameID(frameID);
                        break;
                    }
                }
            }

            while (true){
                System.out.print("Enter new engine ID: ");
                engineID = sc.nextLine();
                if("".equals(engineID)){
                    System.out.print("Engine ID cannot be blanked. reEnter new engine ID: ");
                }else{
                    if(searchID(engineID) > 0){
                        System.out.println("Engine ID existed.");
                    }else{
                        newcar.setEngineID(engineID);
                        break;
                    }
                }
            }

            System.out.println("\nUpdated successfully\n");
            System.out.println("To view the updated list, please save all changes to file first.\n");
        }
        
    }
    
    public void listCarsByBrandID(){
        Collections.sort(carlist, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return(o1.getBrand().getBrandID().compareTo(o2.getBrand().getBrandID()));
            }
        });
        System.out.println(" ----------------------------------------------");
        System.out.println("| carID| brandID | color   | frameID | engineID|");
        System.out.println(" ------|---------|---------|---------|---------");
        for(Car i: carlist){
            System.out.println(i.screenString());
        }
        System.out.println(" ----------------------------------------------\n");
    }
        
} // end of class