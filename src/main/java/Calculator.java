import java.util.Arrays;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public int factorial(int n){
        int product = 1;
        while(n>1){
            product *= n;
            n--;
        }
        return product;
    }

    public String[] arrayOfStrings(String input){
        if(input == null){
            return null;
        }
        else{
            return input.split(" ");
        }
    }

    //Task4
    public int[] sort (int[] input){
        if(input == null){
            return null;
        }
        else{
            Arrays.sort(input);
            return input;
        }
    }

}
