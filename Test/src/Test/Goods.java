package Test;

import java.util.Arrays;

/**
 * @author Mr.xu
 * @create 2022/03/17/13:30
 * Description:
 */
public class Goods implements Comparable{

 
    String name;
    int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {
    }


    
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods goods = (Goods) o;
            if (this.getPrice() > goods.getPrice()){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
               return  Double.compare(this.getPrice(),goods.getPrice());
            }
        }
        else{
            throw new RuntimeException("不是一类物品，不可以比较");
        }
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Goods[] good = new Goods[4];
       good[0] = new Goods("h",23);
       good[1] = new Goods("r",5);
       good[2] = new Goods("g",67);
       good[3] = new Goods("h",23);
        Arrays.sort(good);
        System.out.println(Arrays.toString(good));



    }


}