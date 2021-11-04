import java.util.*;
import java.lang.*;
import java.io.*;

public class BrandList {
    ArrayList<Brand> brandlist;
    Scanner sc ;
    
    public BrandList(){
        brandlist = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    
    String filename = "src/brands.txt";
    
    public boolean loadFromFile(String filename) throws FileNotFoundException, IOException{
        brandlist.removeAll(brandlist);
        File f = new File(filename);
        if (!f.exists()) {
            return false;
        } else {
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = "";
                while ((line = br.readLine()) != null) {
                    Brand brand = new Brand();
                    String datas[] = line.split(", ");
                    brand.setBrandID(datas[0]);
                    brand.setBrandName(datas[1]);
                    String sdata[] = datas[2].split(": ");
                    brand.setSoundBrand(sdata[0]);
                    brand.setPrice(Double.parseDouble(sdata[1]));
                    brandlist.add(brand);
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
            for (Brand i : brandlist) {
                line = i.getBrandID() + ", " + i.getBrandName() + ", "
                        + i.getSoundBrand() + ": " + i.getPrice();
                out.write(line + "\n");
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public void searchByID(String ID){
        int count = 0;
        for (int i = 0; i < brandlist.size(); i++){
            if (brandlist.get(i).getBrandID().equals(ID)){
                System.out.println("\n ----------------------------------------------------------------");
                System.out.println("| brandID|          brand name          |  sound brand  |  price |");
                System.out.println(" --------|------------------------------|---------------|--------");
                System.out.println("\n" + brandlist.get(i).screenString() + "\n");
                count++;
            }
        }
        if (count == 0){
            System.out.println("Brand with this ID does not exist.\n");
        }
    }
    
    
    public int searchID(String ID){
    
        for (int i = 0; i < brandlist.size(); i++){
            if (brandlist.get(i).getBrandID().equals(ID)){
                return i;
            }
        }return -1;
    }
    
    public void addBrand(){
        String ID, brandName, soundBrand;
        double price;
        
        while(true){
            // constraint. Input ID can not exist in the list
            System.out.print("Enter new ID: ");
            ID = sc.nextLine();
            if ("".equals(ID)){
                System.err.println("Brand ID cannot be blank, reEnter the ID: ");
            }else{
                if (searchID(ID) >= 0){
                    System.out.println("ID Existed! Enter new ID: ");
                }else{
                    break;
                }
            }
        }
        
        while (true){
            // The brand name is not blank
            System.out.print("Enter new brand name: ");
            brandName = sc.nextLine();
            if("".equals(brandName)){
                System.err.println("Brand name cannot be blank. reEnter new brand ID: ");
            }else{
                break;
            }
        }
        
        while (true){
            // The sound brand is not blank
            System.out.print("Enter new sound brand: ");
            soundBrand = sc.nextLine();
            if ("".equals(soundBrand)){
                System.err.println("Sound brand name cannot be blank, reEnter new sound brand: ");
            }else{
                break;
            }
        }
        
        while (true){
            // Price >0
            System.out.print("Enter new price: ");
            price = Double.parseDouble(sc.nextLine());
            if (price <= 0){
                System.err.println("Price cannot be negative or zero, please reEnter new price: ");
            }else{
                break;
            }
        }
        
        // Create a new brand from inputted data
        Brand newbrand = new Brand(ID, brandName, soundBrand, price);
        // Add a new brand to the list
        brandlist.add(newbrand);
        System.out.println("New brand added.\n");
        System.out.println("To view the updated list, please save all changes to file first.\n");
    }
    
    public void updateBrand(){
        String ID, brandName, soundBrand;
        double price;
        
        while (true){
            System.out.print("Enter brandID of the product to be updated: ");
            ID = sc.nextLine();
            if ("".equals(ID)) System.err.println("ID cannot be blanked!");
            else{
                int pos = searchID(ID);
                if (pos < 0){
                    System.out.println("Not found!");
                }else{


                    while (true){
                        // The brand name is not blank
                        System.out.print("Enter new brand name: ");
                        brandName = sc.nextLine();
                        if("".equals(brandName)){
                            System.err.println("Brand name cannot be blank. reEnter new brand name: ");
                        }else{
                            break;
                        }
                    }

                    while (true){
                        // The sound brand is not blank
                        System.out.print("Enter new sound brand: ");
                        soundBrand = sc.nextLine();
                        if ("".equals(soundBrand)){
                            System.err.println("Sound brand name cannot be blank, reEnter new sound brand: ");
                        }else{
                            break;
                        }
                    }

                    while (true){
                        // Price >0
                        System.out.print("Enter new price: ");
                        price = Double.parseDouble(sc.nextLine());
                        if (price <= 0){
                            System.err.println("Price cannot be negative or zero, please reEnter new price: ");
                        }else{
                            break;
                        }
                    }

                    brandlist.get(pos).setBrandName(brandName);
                    brandlist.get(pos).setSoundBrand(soundBrand);
                    brandlist.get(pos).setPrice(price);
                    System.out.println("Brand is updated.");
                    System.out.println("To view the updated list, please save all changes to file first.\n");
                    break;
                }
            }
        }
    }
    
    public void listBrands() throws IOException{
        System.out.println(" ----------------------------------------------------------------");
        System.out.println("| brandID|          brand name          |  sound brand  |  price |");
        System.out.println(" --------|------------------------------|---------------|--------");
        for (int i = 0; i < brandlist.size(); i++){
            System.out.println(brandlist.get(i).screenString());
        }
        System.out.println(" ---------------------------------------------------------------\n");
    }
    
}// end of class
