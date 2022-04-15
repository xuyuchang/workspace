package gege.pojo;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Mr.xu
 * @create 2022/04/01/16:43
 * Description:
 */
public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();


    /**
     * 添加购物城商品
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        //产看购物车中是否存在该商品
        CartItem item = items.get(cartItem.getId());
        if (item == null){
            //之前没有添加商品
            items.put(cartItem.getId(),cartItem);
        }else{
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }

    /**
     * 删除购物车商品
     * @param
     */
    public void deleteItem(Integer id){
        items.remove(id);

    }

    /**
     * 清空购物车
     * @param
     */
    public void clear(){
        items.clear();

    }

    /**
     * 修改商品数量
     * @param
     */
    public void updateCount(Integer id ,Integer count){

        CartItem item = items.get(id);
        if (item != null){
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }


    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer,CartItem> entry:items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem> entry:items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
