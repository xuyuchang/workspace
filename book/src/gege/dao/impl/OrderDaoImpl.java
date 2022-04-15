package gege.dao.impl;

import gege.dao.OrderDao;
import gege.pojo.Order;

/**
 * @author Mr.xu
 * @create 2022/04/02/16:29
 * Description:
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(orderId,createTime,price,status,userId) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
