package lab_exam_preparation;

public class Monitor {
    private String manufacturer;
    private int screenSize; //in inches
    private int price;
    private int yearOfManufacture;
    private int maxRefreshRate; //in Hz

    public Monitor(String manufacturer, int screenSize, int price, int yearOfManufacture, int maxRefreshRate){
        this.manufacturer=manufacturer;
        this.screenSize=screenSize;
        this.price=price;
        this.yearOfManufacture=yearOfManufacture;
        this.maxRefreshRate=maxRefreshRate;

        if(price < 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
    }

    public int getMonitorAge(){
        return 2024 - yearOfManufacture;
    }

    public double getDiscountedPrice(){
        if(getMonitorAge()>3) {
            return price-(0.2 * price);
        }
        return price;
    }

    public boolean isPremium(){
        //Premium monitors are manufactured by Dell, are at least 27 inches in screen size and have a refresh rate of at least 120 Hz.
        if(manufacturer.equals("Dell") && screenSize>=27 && maxRefreshRate>=120){
            return true;
        }
        return false;
    }

    public boolean is4K(){
        if(screenSize>=32 && maxRefreshRate>=60){
            return true;
        }
        return false;
    }


}
