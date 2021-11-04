public class Car implements Comparable<Car>{
    String carID, color, frameID, engineID;
    Brand brand;
    
    public Car(){}

    public Car(String carID, String color, String frameID, String engineID, Brand brand) {
        this.carID = carID;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
        this.brand = brand;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "carID=" + carID + ", color=" + color + ", frameID=" + frameID + ", engineID=" + engineID + ", brand=" + brand ;
    }
    
    public String screenString(){
        System.out.printf("|%6s|%9s|%9s|%9s|%9s|", carID, brand.getBrandID(), color, frameID, engineID);
        return "";
    }

    @Override
    public int compareTo(Car o2) {
        int d = this.brand.brandName.compareTo(o2.brand.brandName);
        if (d!=0) 
            return d;
        // they are in the same brand, comparing based on their ID
        return this.carID.compareTo(o2.carID);
    }
    
    
} // end of lass
