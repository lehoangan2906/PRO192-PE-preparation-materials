package StudentManagement;

import java.io.*;
import java.util.*;
import java.lang.*;

class Inputter {
    public static Scanner sc = new Scanner(System.in);
    
    public static String normalize(String S) {
        String delims = "#:,.|$!\t@*\b";
        StringTokenizer stk = new StringTokenizer(S, delims);
        String result = stk.nextToken();
        while(stk.hasMoreElements()) result += " " + stk.nextToken();
        return result;
    }
    
    public static String inputNonBlankStr(String msg) {
        String result;
        do{
            System.out.print(msg);
            result = normalize(sc.nextLine());
        }
        while(result.length()==0);
        return result;
    }
    //Get a string with pre-defined format using Regular Expression
    public static String getPatternStr(String msg, String regEx){
        String result;
        do{
            System.out.println(msg);
            result = normalize(sc.nextLine());
        }
        while(!result.matches(regEx));
        return result;
    }
    
    public static int getIntGreater(String msg, int min){
        int result;
        do{
            System.out.println(msg);
            result = Integer.parseInt(sc.nextLine());
        }
        while(result <= min);
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(normalize("my#name#is:khan@what*is|you!name  Bill"));
    }
    
    public static int getIntInrange(String msg, int min, int max){
        int result;
        do{
            System.out.println(msg);
            result = Integer.parseInt(sc.nextLine());
        }
        while(result < min || result > max);
        return result;
    }    
    
    public static String inputPattern(String msg, String pattern){
        String data;
        do{
            System.out.println(msg);
            data = sc.nextLine().trim();
        }
        while (!data.matches(pattern));
        return data;
    }
}
