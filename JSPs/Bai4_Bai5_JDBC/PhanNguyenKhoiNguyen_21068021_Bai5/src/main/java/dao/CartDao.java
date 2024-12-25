package dao;

import entity.CartItem;
import entity.Order;

public interface CartDao {
  public void saveCart(CartItem cart);
  public void saveOrder(Order o);
  public int getOrderId();
}
