package gege.service.impl;

import gege.dao.BookDao;
import gege.dao.OrderDao;
import gege.dao.OrderItemDao;
import gege.dao.impl.BookDaoImpl;
import gege.dao.impl.OrderDaoImpl;
import gege.dao.impl.OrderItemDaoImpl;
import gege.pojo.*;
import gege.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author Mr.xu
 * @create 2022/04/02/16:48
 * Description:
 */
public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //创建唯一的订单号
        String orderId = System.currentTimeMillis() +""+userId;
        //创建订单
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //保存订单
        orderDao.saveOrder(order);
        //遍历购物车中的每一个商品转换为订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry:cart.getItems().entrySet()){
            //获取购物车中的每一个商品
            CartItem cartItem = entry.getValue();
            //转换为每一个订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookDao.queryById(cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(book);

        }
        //清空购物车
        cart.clear();

        return orderId;
    }
}
