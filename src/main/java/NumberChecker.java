public class NumberChecker {

    public boolean isEven(int number){
        return number % 2 == 0;
    }

    // Task1: Create an isPrime() method in the NumberChecker class that takes an input parameter n and returns whether the number is prime or not.
    // Afterwards, write a parameterized test for it for the values 2, 5, 17, 19, 211.

    public boolean isPrime(int number){
        if(number == 2){
            return true;
        }
        else if(number >2) {
            if (number % 2 == 0) {
                return false;
            } else {
                return true;
            }
        }
        return false; //for numbers smaller than 2 (1,0,-1,..)
    }

    public int square (int n){
        return n*n;
    }

    /* Task2: The given CSV file contains a list of first 10 numbers of the Fibonacci sequence.
       First of all, create a fibonacci() method in the NumberCheck class that takes an input parameter n, and returns the nth Fibonacci number.
       Next up, write a parameterized test for it using the provided CSV file. */

    public static int fibonacci(int n){ //n is index of desired fib number
        if(n<=0){
            throw new IllegalArgumentException("Input shall be a positive integer.");
        }
        else if(n==1 || n==2){
            return 1; //at index 1 is element 1
        }

        //else - from index 3 (3rd element of fibonacci sequence):
        int fibPrev=1, fibCurr=1;
        for(int i=3;i<=n;i++){
            int temp = fibCurr;
            fibCurr = fibPrev + fibCurr;
            fibPrev = temp;
        }
        return fibCurr;
    }



}
