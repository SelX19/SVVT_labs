import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

//parameterized tests - lab:

class NumberCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 18, 28, 1142})
    public void testIsEven(int number) {
        NumberChecker nc = new NumberChecker();
        assertTrue(nc.isEven(number));
    }

    @ParameterizedTest
    @NullSource
    public void testNull(String n){
        assertNull(n);
    }


    @ParameterizedTest
    @EmptySource
    public void testEmpty(String[] n){
        assertArrayEquals(new String[0], n);
    }

    //P.S.: EmptySource annotation can be also used for testing strings if empty, not just arrays

    // Task1: Create an isPrime() method in the NumberChecker class that takes an input parameter n and returns whether the number is prime or not.
    // Afterwards, write a parameterized test for it for the values 2, 5, 17, 19, 211.

    @ParameterizedTest
    @ValueSource(ints = {2,5,17,19,211})
    public void testPrime(int n){
        NumberChecker nc = new NumberChecker();
        assertTrue(nc.isPrime(n));
    }

    @ParameterizedTest
    @CsvSource({"2,4", "3,9", "11,121", "15,225"})
    public void testSquare(int actual, int expected){
        NumberChecker nc = new NumberChecker();
        assertEquals(expected, nc.square(actual));
    }

    //using another separation regex (custom one):
    @ParameterizedTest
    @CsvSource(value={"2;4", "3;9", "11;121", "15;225"}, delimiter = ';')
    public void testSquareDelimiter(int actual, int expected){
        NumberChecker nc = new NumberChecker();
        assertEquals(expected, nc.square(actual));
    }

    @ParameterizedTest
    @CsvFileSource(resources="/data.csv", numLinesToSkip=1)
    public void testSquareCsvSource(int actual, int expected){
        NumberChecker nc = new NumberChecker();
        assertEquals(expected, nc.square(actual));

    }

    /* Task2: The given CSV file contains a list of first 10 numbers of the Fibonacci sequence.
       First of all, create a fibonacci() method in the NumberCheck class that takes an input parameter n, and returns the nth Fibonacci number.
       Next up, write a parameterized test for it using the provided CSV file. */

    @ParameterizedTest
    @CsvFileSource(resources= "/fibonacci.csv", numLinesToSkip=1)
    public void testFibonacci(int input, int fib){
        NumberChecker nc = new NumberChecker();
        assertEquals(fib, nc.fibonacci(input));
    }


}