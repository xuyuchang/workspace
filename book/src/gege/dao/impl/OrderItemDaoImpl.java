package gege.dao.impl;

import gege.dao.OrderItemDao;
import gege.pojo.OrderItem;

/**
 * @author Mr.xu
 * @create 2022/04/02/16:29
 * Description:
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name,price,count,totalPrice,userId) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getPrice(),orderItem.getCount(), orderItem.getTotalPrice(),orderItem.getorderId());
    }
}
