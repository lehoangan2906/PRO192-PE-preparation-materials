
package MyUltility;

import StudentManagement.Student;
import java.util.Random;


public class myLibs {
    public static int getRandomInt(){
        Random rand = new Random();
        return rand.nextInt(Integer.MAX_VALUE);
    }
    public static int getRandomInRange(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
    public static String getRandomInRange2(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        if (0<=randomNum && randomNum< 10) return "00" + randomNum;
        if (10<=randomNum && randomNum< 100) return "0" + randomNum;
        return "" + randomNum;
    }

    public static boolean getRandomBo(){
        Random rand = new Random();
        return rand.nextBoolean();
    }    
//    public  static  int gerRandomIntInRange2(int min, int max){
//        
//    }
    public static String getRandomChars(int numChars){
        final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        final int N = alphabet.length();
        String result = "";
        Random random = new Random();
        for (int i = 0; i < numChars; i++){
          result += alphabet.charAt(random.nextInt(N));
        }
        return result;
    }
    
    public static String[] getRandomWords(int numberOfWords){
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++){
            char[] word = new char[random.nextInt(8)+3];
            for (int j = 0; j < word.length; j++){
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }
    
    public static String getRandomColor(){
        final String[] listColors = {"Black", "White", "Gray", "Silver", "Maroon", "Red", "Purple", "Fushsia", "Green", "Lime", "Olive", "Yellow", "Navy", "Blue", "Teal", "Aqua"};
        return listColors[getRandomInRange(0, listColors.length-1)];
    }
    
    public static String getRandomMaterial(){
        final String[] listMaterials = {"Ceramics", "Glass", "Aluminium", "Brass", "Bronze", "Wood"};
        return listMaterials[getRandomInRange(0, listMaterials.length-1)];
    }
    
    public static String getRandomFirstName(){
        final String[] FirstNames = {"Le", "Dao", "Pham", "Tran", "Nguyen", "Hoang", "An", "Chu", "Bui"};
        return FirstNames[getRandomInRange(0, FirstNames.length-1)];
    }
    
    public static String getRandomLastName(){
        final String[] LastNames = {"Trong", "Hung", "Viet", "Trang", "Hoa", "Nga", "Ha", "Huy", "Anh"};
        return LastNames[getRandomInRange(0, LastNames.length-1)];
    }
    
    public static String getRandomName(){
        return getRandomFirstName() + " " + getRandomLastName();
    }
    
    public static String getRandomID(String S, int n){
        return S.toUpperCase() + getRandomInRange2(0, n);
    }
    
    public static String getRandomTV(){
        String[] str = {"Sony", "LG", "Samsung", "TCL", "Tosiba", "Sharp", "Xiaomi"};
        String[] inchs = {"32", "40", "43", "50", "55", "60", "70"};
        String brand = str[getRandomInRange(0, 6)];
        String inch = inchs[getRandomInRange(0, 6)];
        return brand + " TV " + inch;
    }
    
    public static String getRandomSounddock(){
        String[] str = {"30 III", "20 II", "10 II", "40 II", "10 III", "20 IV", "30 I"};
        String brand = str[getRandomInRange(0, 6)];
        return "Bose sounddock " + brand;
    }

    public static String getRandomSoundbar(){
        String[] str = {"Sony", "LG", "Samsung", "Denon", "Bose", "JBL", "Harman"};
        String brand = str[getRandomInRange(0, 6)];
        return brand + " soundbar";
    }    
    

}
