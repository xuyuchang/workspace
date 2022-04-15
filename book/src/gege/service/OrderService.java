package gege.service;

import gege.pojo.Cart;

/**
 * @author Mr.xu
 * @create 2022/04/02/16:47
 * Description:
 */
public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
