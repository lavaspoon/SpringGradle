package playground.moduletest.singleton;

public class StatefulService {
    private int price; //상태유지

    public void order(String name, int price){
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
}
