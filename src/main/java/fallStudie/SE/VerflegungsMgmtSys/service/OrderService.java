package fallStudie.SE.VerflegungsMgmtSys.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fallStudie.SE.VerflegungsMgmtSys.entity.Order;
import fallStudie.SE.VerflegungsMgmtSys.repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepo;
	
	@Autowired
	public OrderService(OrderRepository orderRepo) {
		this.orderRepo= orderRepo;
	}

	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public List<Order> getOrderList(){
		return orderRepo.findAll();
				
	}
	
	public Order getOrderbyID(Long id) {
		return orderRepo.findById(id).get();
	}
	
	public List<Order> orderbyDate(LocalDate date) {
		List<Order> orderList = getOrderList();
		List<Order> orderToday = new ArrayList<Order>();
		for(Order order:orderList ) {
			if(order.getDate().equals(date)) {
				orderToday.add(order);
			}
		}
		return orderToday;
	}
}
  