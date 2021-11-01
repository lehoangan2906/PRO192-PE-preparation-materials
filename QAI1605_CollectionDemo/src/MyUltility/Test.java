
package MyUltility;


public class Test {
    public static void main(String[] args) {
        for (int i = 0; i< 10; i++) System.out.print(myLibs.getRandomInt() + " ");
        System.out.println("");
        System.out.println("================================");
        for (int i = 0; i< 10; i++) System.out.print(myLibs.getRandomInRange(1000, 5000) + " ");
        System.out.println("");
        System.out.println("================================");
        System.out.println(myLibs.getRandomChars(30) + " ");
        System.out.println("================================");
        String[] arrStrings = myLibs.getRandomWords(5);
        for (int i = 0; i < arrStrings.length; i++) System.out.println(arrStrings[i]+ " ");
        System.out.println("");
        System.out.println("================================");   
        System.out.println(myLibs.getRandomBo()+ " ");
        System.out.println("================================");
    }
}
