package lab_exam_preparation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

class MonitorTest {
    Monitor monitor = new Monitor("Dell", 32, 60, 2002, 120);

    @Test
    public void testConstructorIllegalArgument(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> new Monitor("Dell", 32, -1, 2002, 120));
        assertEquals("Price must be greater than 0.", exception.getMessage());
    }

    @Test
    public void testConstructorSuccess(){
        assertNotNull(monitor);
    }

    @ParameterizedTest
    @NullSource
    public void testConstructorNullValue(String n){
        Monitor monitor2 = null;
        assertEquals(n, monitor2);
    }

    @Test
    public void testMonitorAge1(){
        assertEquals(22, monitor.getMonitorAge());
    }

    @Test
    public void testMonitorAge2(){
        assertNotEquals(5, monitor.getMonitorAge());
    }

    @Test
    public void testDiscountedPrice1(){
        assertEquals(48, monitor.getDiscountedPrice());
    }

    @Test
    public void testDiscountedPrice2(){
        Monitor monitor3 = new Monitor("Dell", 32, 60, 2022, 120);
        assertNotEquals(48, monitor3.getDiscountedPrice());
    }

    @Test
    public void testDiscountedPrice3(){
        Monitor monitor4 = new Monitor("Dell", 32, 60, 2023, 120);
        assertEquals(1, monitor4.getMonitorAge());
    }

    @Test
    public void testIfPremium1(){
        assertTrue(monitor.isPremium());
    }

    @Test
    public void testIfPremium2(){
        Monitor monitor5 = new Monitor("Dell", 21, 60, 2002, 50);
        assertFalse(monitor5.isPremium());
    }

    @Test
    public void testIs4K1(){
        assertTrue(monitor.is4K());
    }

    @Test
    public void testIs4K2(){
        Monitor monitor6 = new Monitor("Dell", 21, 60, 2002, 50);
        assertFalse(monitor6.is4K());
    }

    @Test
    public void testIs4K3(){
        Monitor monitor8 = new Monitor("Dell", 33, 60, 2002, 120);
        assertTrue(monitor8.is4K());
    }

    @Test
    public void testIs4K4(){
        Monitor monitor7 = new Monitor("Dell", 33, 60, 2002, 50);
        assertFalse(monitor7.is4K());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/monitors.csv", numLinesToSkip = 1)
    public void testIfPremiumMonitor(String manufacturer, int screenSize, int price, int yearOfManufacture, int maxRefreshRate){
        Monitor monitor = new Monitor(manufacturer, screenSize, price, yearOfManufacture, maxRefreshRate);
        if(manufacturer.equals("Dell") && screenSize>=27 && maxRefreshRate>=120){
            assertTrue(monitor.isPremium());
        }
        else{
            assertFalse(monitor.isPremium());
        }
    }


}