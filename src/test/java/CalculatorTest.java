import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    public static void setUpBeforeClass(){
        System.out.println("Before all Tests");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After each test");
    }

    @Test     //positive testing
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(10,5);
        assertEquals(5, result, "10 - 5 shall equal 5");
    }

    @Test     //negative testing
    public void testAdditionNegative() {
        Calculator calculator = new Calculator();
        int result = calculator.add(3,2);
        assertNotEquals (6, result, "2 + 3 shall not be 6");
    }

    @Test
    public void testFactorialPositive(){
        Calculator calculator = new Calculator();
        int result = calculator.factorial(5);
        assertEquals(120, result, "factorial of 5 shall be 120");
    }

    //Task1
    @Test
    public void testFactorialNegative(){
        Calculator calculator = new Calculator();
        int result = calculator.factorial(5);
        assertNotEquals(110, result, "factorial of 5 shall not be 110");
    }

    //Other tests - other assert methods - examples:

    @Test
    public void testArraysEquals(){
        String [] array1 = {"apple", "book", "glass"};
        String [] array2 = {"apple", "book", "glass"};
        assertArrayEquals(array1, array2);
    }

    @Test
    public void assertBooleans(){
        int num1 = 3;
        int num2 = 5;
        assertTrue(num1<num2);  //shall pass tests
        assertFalse(num1==num2);  //shall pass tests
    }

    @Test
    public void assertNullsAndNotNulls(){
        String s = null;
        assertNull(s); //shall pass tests

        String hi = "Hello";
        assertNotNull(hi); // shall pass tests
// tesst oush
    }

    //Task2 ddf
    @Test
    public void testReturnsNull(){
        Calculator arrayExample = new Calculator(); //creating an instance of CalculatorExample() class
        //then applying a method, we want to test, on it
        String [] words = arrayExample.arrayOfStrings("Selma jede jabuke");
        String [] noValue = arrayExample.arrayOfStrings(null);
        assertNull (noValue);
        assertNotNull(words);
    }

    //Task4
    @Test
    public void testArray(){
        Calculator newObject = new Calculator();
        int[] array_unsorted = {2,1,6,3,7,4};
        int[] array_gotten = newObject.sort(array_unsorted);
        int[] array_expected = {1,2,3,4,6,7};
        int[] null_array = newObject.sort(null);

        assertArrayEquals(array_expected, array_gotten, "expected array and one gotten by sort method shall be equal");
        assertNull(null_array);
    }

    @AfterAll
    public static void tearDownAfterClass(){
        System.out.println("After all Tests");
    }

}