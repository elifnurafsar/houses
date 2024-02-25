package Houses;

public class Yazlik implements House{
    private int num_rooms;
    private int num_halls;
    private double m2;
    private int price;
    private String type = "Yazlik";

    public Yazlik(){
        num_halls = 0;
        num_rooms = 0;
        m2 = 0.0;
        price =0;
    }

    public Yazlik(int num_rooms, int num_halls, double m2, int price){
        this.num_halls = num_halls;
        this.num_rooms = num_rooms;
        this.m2 = m2;
        this.price = price;
    }

    @Override
    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public int getNum_halls() {
        return num_halls;
    }

    public void setNum_halls(int num_halls) {
        this.num_halls = num_halls;
    }

    public int getNum_rooms() {
        return num_rooms;
    }

    public void setNum_rooms(int num_rooms) {
        this.num_rooms = num_rooms;
    }
}
