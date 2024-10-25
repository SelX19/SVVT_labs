import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DatabaseTest {

    private static Database db;

    @BeforeAll
    public static void setUpBeforeClass(){  //we want to set up a db connection(create a db object) before running all tests
        //firstly, we instantiate an object of Database class
        db = new Database();
        //then, we apply connect method to it
        db.connect();
    }

    @BeforeEach
    public void setUp() { //before each individual db test
        db.insert("Element 1");
        db.insert("Element 2"); //BeforeEach executing 2 times before each test
    }

    @Order(2)
    @Test
    public void testGetMethod(){
        assertEquals(db.get(1), "Element 2");
    }

    @Order(3)
    @Test
    public void testInsertMethod(){
        db.insert("Element 3");
        assertEquals(db.get(2), "Element 3");
        assertEquals(3, db.count());
    }

    @Order(1)
    @Test
    public void testGetOutOfBounds(){
        Exception e = assertThrows(IndexOutOfBoundsException.class, () -> {String element = db.get(10);});
        assertEquals( "Index 10 out of bounds for length 2", e.getMessage());
    }

    @AfterEach
    public void tearDown() {  //clean up changes we made after each test
        db.clear();
    }


    @AfterAll
    public static void TearDownAfterClass(){ //disconnect from db after all tests have finished
        //release used-up memory
        db.disconnect();

    }
}