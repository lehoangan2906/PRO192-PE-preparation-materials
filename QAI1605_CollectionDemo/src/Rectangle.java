public class Rectangle {
    int length;
    int width;

    public Rectangle() {
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public int area(){
        return width*length;
    }

    @Override
    public String toString() {
        return  "length=" + length + ", width=" + width + ", area=" + area() ;
    }
    
    
}
