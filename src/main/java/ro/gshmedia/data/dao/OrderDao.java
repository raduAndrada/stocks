package ro.gshmedia.data.dao;

import ro.gshmedia.data.model.Order;

public interface OrderDao {

    public Order addOrder(Order order);

    public Order updateOrder(Order order);

    public Order getOrder(int id);


}
