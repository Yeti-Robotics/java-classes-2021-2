import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        int num = 7;
        System.out.println(num);
        System.out.println(1 / 3);
        System.out.println(1.0 / 3.0);
        double num2 = 7.9;
        System.out.println(num2);
        boolean bool = 1 < 3;
        System.out.println(bool);
        char letter = 'o';
        System.out.println(letter);
        String message = "I am a Java programmer.";
        System.out.println(message);
        System.out.println(num + num2);
        System.out.println(message + num2);

        System.out.println(num - num2);
        System.out.println(num >= num2);
        System.out.println(num != num2);
        System.out.println(7.9 == num2);
        System.out.println(7 % 2 == 0);

        int[] integerArray = { 1, 7, 3, 5, 0, 4, 6, 99 };
        System.out.println(Arrays.toString(integerArray));
        System.out.println(integerArray[0]);
        integerArray[0] = integerArray[0] * 2;
        System.out.println(Arrays.toString(integerArray));
        for (int i = 0; i < integerArray.length; i++) {
            integerArray[i] = integerArray[i] * 2;
        }
        System.out.println(Arrays.toString(integerArray));
        for (int i = integerArray.length - 1; i >= 0; i--) {
            System.out.println(integerArray[i]);
            
        }
    }
}
