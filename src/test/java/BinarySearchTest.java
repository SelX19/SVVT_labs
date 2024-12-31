import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    //P.S.: for the binary search to work, the array must be sorted

    //case1: array is empty:
    @Test
    public void testEmptyArray() {
        int[] array = {};
        int key = 1;
        assertEquals(-1, BinarySearch.search(array, key));
    }

    //case2: array has a single matching element (element=key)
    @Test
    public void testOneElementArrayFound() {
        int[] array = {1};
        int key = 1;
        assertEquals(0, BinarySearch.search(array, key));
    }

    //case3: array has a single non-matching element (element!=key)
    @Test
    public void testOneElementArrayNotFound() {
        int[] array = {1};
        int key = 3;
        assertEquals(-1, BinarySearch.search(array, key));
    }

    //case4: array has multiple elements, key found in the right half of it
    @Test
    public void testArrayRightFound(){
        int[] array = {1,2,3,5,8};
        int key = 8;
        assertEquals(4, BinarySearch.search(array, key));
    }

    //case5: array has multiple elements, key not found in the right half of it
    @Test
    public void testArrayRightNotFound(){
        int[] array = {1,2,3,5,7};
        int key = 8;
        assertEquals(-1, BinarySearch.search(array, key));
    }

    //case6: array has multiple elements, key found in the left half of it
    @Test
    public void testArrayLeftFound(){
        int[] array = {1,2,3,5,8};
        int key = 2;
        assertEquals(1, BinarySearch.search(array, key));
    }

    //case7: array has multiple elements, key not found in the left half of it
    @Test
    public void testArrayLeftNotFound(){
        int[] array = {1,3,5,8,10,11};
        int key = 2;
        assertEquals(-1, BinarySearch.search(array, key));
    }

}