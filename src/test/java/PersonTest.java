import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonTest {

    @BeforeAll
    public static void setUpBeforeClass(){
        System.out.println("Before all tests");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Before each test");
    }

    //Task3 & Task6

    @Order(1)
    @Test
    public void testPerson1() {
        Person adult = new Person(19);
        Person child = new Person(5);

        assertTrue(adult.getAge()>18, "an adult");
        assertTrue(child.getAge()<=18, "a child");
    }

    @Order(2)
    @Test
    public void testPerson2() {
        Person adult = new Person(19);
        Person child = new Person(5);

        assertTrue(adult.getAge()>=6, "can go to school");
        assertTrue(child.getAge()<6, "cannot go to school");
    }

    //Task 7
    @Order(3)
    @Test
    public void testIllegalArgument(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Person(-1));
        assertEquals("A person’s age cannot be less than 0", e.getMessage());
    }


    @AfterEach
    public void tearDown() {
        System.out.println("After each test");
    }

    @AfterAll
    public static void tearDownAfterClass(){
        System.out.println("After all tests");
    }

}