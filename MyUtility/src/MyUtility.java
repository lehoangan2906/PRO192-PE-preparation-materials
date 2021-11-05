
import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class MyUtility {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        // Check from 2 to n-1
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    
    public static int sumOfDigits(int n) {
        //tính tổng các chữ số có trong number
        //ví dụ: đầu vào là 3713 thì đầu ra là 14 (vì 3+7+1+3 = 14)
        int sum;
        
        /* Single line that calculates sum */
        for (sum = 0; n > 0; sum += n % 10, n /= 10);

        return sum;
    }

    
    public static String getCharsOnly(String str) {
        //đầu vào là 1 từ
        //đầu ra lọc bỏ các chữ số có trong từ
        //ví dụ đầu vào là H2ell0 thì đầu ra là Hell

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            // Check if the specified character is not digit
            // then add this character into result variable
            if (!Character.isDigit(str.charAt(i))) {
                result = result + str.charAt(i);
            }
        }
        return result;
    }

    
    public static String getDigitsOnly(String str) {
        //đầu vào là 1 từ
        //đầu ra lọc bỏ các chữ cái có trong từ, chỉ giữ lại các số
        //ví dụ đầu vào là H2ell0 thì đầu ra là 20
        String result = "";
        for (int i = 0; i < str.length(); i++) {

            // Check if the specified character is not digit
            // then add this character into result variable
            if (Character.isDigit(str.charAt(i))) {
                result = result + str.charAt(i);
            }
        }
        return result;
    }

    
    public static String reverseWord(String str) {
        //đầu vào là 1 từ
        //đầu ra là đảo ngược của từ đó (ví dụ input: Hanoi thì output là ionaH
        String nstr = "";
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i); //extracts each character
            nstr = ch + nstr; //adds each character in front of the existing string
        }
        return nstr;
    }

    
    public static double roundNumber(double value, int places) {
        //hàm làm tròn một số thực, lấy n chữ số ở phần thập phân
        //ví dụ input là roundNumber(3.1415, 3) thì output là 3.142
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    
    public static String StringNormalizer(String str) {
        String delims = "#:,.|$@!\t ";
        StringTokenizer st = new StringTokenizer(str, delims);
        String result = "";
        while (st.hasMoreTokens()) {
            result += st.nextToken() + " ";
        }
        return result.trim();
    }

    
    public static String swapFirstAndLast(String str) {
        if (str.length() < 2) {
            return str;
        }

        // convert a string into a character array
        char[] ch = str.toCharArray();

        // swapping first and last character of a string
        char temp = ch[0];
        ch[0] = ch[ch.length - 1];
        ch[ch.length - 1] = temp;

        // convert character to string and return it
        return String.valueOf(ch);
    }

    
    public static void splitingString(String str) {
        String[] arrOfStr = str.split("@", 5);
        // 5 = the maximum position to split
        // @ = regex to split

        for (String a : arrOfStr) {
            System.out.println(a);
        }
    }

    
    public static void convertArrayToString() {
        // output is a string containts a pair of brackets []
        boolean[] boolArr = new boolean[]{true, true, false, true};
        char[] charArray = new char[]{'g', 'e', 'e', 'k', 's'};
        double[] dbarr = new double[]{1, 2, 3, 4};
        int[] intarr = new int[]{1, 2, 3, 4};
        Object[] objarr = new Object[]{1, 2, 3, 4};
        System.out.println("Boolean array: " + Arrays.toString(boolArr));
        System.out.println("Character array: " + Arrays.toString(charArray));
        System.out.println("Double array: " + Arrays.toString(dbarr));
        System.out.println("Integer array: " + Arrays.toString(intarr));

    }

    
    public static void convertArrayToString2() {
        // StringBuilder được sử dụng để tạo chuỗi có thể thay đổi (mutable)

        // output is a string only
        StringBuilder stringbuilder = new StringBuilder("we are geeks ");
        System.out.println(stringbuilder);

        // char array
        char[] arrstr = new char[]{'G', 'E', 'E', 'K', 'S'};

        // appends string representation of char array to this string builder
        stringbuilder.append(arrstr);
        System.out.println("Result after" + " appending = " + stringbuilder);
        stringbuilder = new StringBuilder("We are -");

        // char array
        arrstr = new char[]{'a', 'b', 'c', 'd'};

        // appends tring representation of char arrya to this StringBuilder
        stringbuilder.append(arrstr);
        System.out.println("Result after appending = " + stringbuilder);
    }

    
    
    public static int findOccurances(String[] paragraph, String target){
        
        int index = 0, totalOccurances = 0;
        
        for (int lineNumber = 0; lineNumber < paragraph.length; lineNumber++){
            String line = paragraph[lineNumber];
            while(true){
                index = line.indexOf(target, index);    // line.indexof(String string, from index)
                if (index != -1){
                    System.out.println("Found at line number " + lineNumber + " at position " + index);
                    totalOccurances++;
                    index += target.length();
                }else{
                    break;
                }
            }
        }
        return totalOccurances;
    }
    
    
    public static boolean checkPalindrome(String string){
        int len = string.length();
        char[] charArr = string.toCharArray();
        for (int i = 0; i < charArr.length; i++)
            if (charArr[i] != charArr[string.length() - 1 - i]){
                return false;
            }
        return true;
    }
    
    
    public static int countFrequencyOfCharacter(String string){
        int count = 0;
        for (int i = 0; i < string.length(); i++){
            // this particular example count occurances of the whitespace character
            if (Character.isWhitespace(string.charAt(i))){
                count++;
            }
        }
        return count;
    }
    
    
    public static void valueOfDemo(){
        // Returns a new String object that contains data as the string 
        // representation of the passed argument
        char array[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        System.out.println(String.valueOf(array));
    }
    
    // modify the name of all instances of your variable
    public static void replace(String[] paragraph, String oldChar, String newChar){
        for (int linenumber = 0; linenumber < paragraph.length; ++linenumber){
            String line = paragraph[linenumber];
            line = line.replace(oldChar, newChar);
        }
        String paragraph2 = "";
        for (int i = 0; i < paragraph.length; i++){
            paragraph2 = paragraph2.concat(paragraph[i]);
        }
        System.out.println(paragraph2);
    }
    
    public static void main(String[] args) {
        int num = 90;
        System.out.println("\nCheck prime: " + isPrime(num));
        System.out.println("\nSum of digits" + sumOfDigits(num));
        String string = "hello0";
        System.out.println("\nRemove all digits: " + getCharsOnly(string));
        System.out.println("\nRemove all characters: " + getDigitsOnly(string));
        String string2 = "Le Hoang An";
        System.out.println("\nReverse word: " + reverseWord(string2));
        double num2 = 3.141592;
        System.out.println("\nRounding double: " + roundNumber(num2, 3));
        String string3 = "        Le Hoang @@An loves Phan Le    Tu Vien !  and vice versa #:\t!";
        System.out.println("\nString normalization: " + StringNormalizer(string3));
        String string4 = "GeeksForAn";
        System.out.println("\nSwap first and last characters of a string: " + swapFirstAndLast(string4));
        String string5 = "Le@hoang@Anh";
        System.out.println("\nSpliting string: ");
        splitingString(string5);
        System.out.println("");
        System.out.println("\nConvert array to string: ");
        convertArrayToString();
        System.out.println("\nConvert array to string 2: ");
        convertArrayToString2();
        String string6 = "abccba";
        System.out.println("\nCheck palindrome: " + checkPalindrome(string6));
        String string7 = "one, two, three, four, five, six, seven, eight, nine, nineandahalf";
        System.out.println("\nCount occurances of a character : " + countFrequencyOfCharacter(string7));
        String paragraph1[]  = {"Could music boost your coding performance?\n","Monotonous keyboard clicks can make you lose your train of thought.", "Our minds are tricky and given the opportunity will wander off to look for something a little more exciting."};
        
        System.out.println("\nReplacing word in a string: ");
        replace(paragraph1, "mind", "soul");
        
        System.out.println("\nFind occurances");
        findOccurances(paragraph1, "music");
        
        System.out.println("\nValue of demo: ");
        valueOfDemo();
    }
} // end of class