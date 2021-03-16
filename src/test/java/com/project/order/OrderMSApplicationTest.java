package com.project.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.project.order.dto.OrderDetailsDTO;
import com.project.order.entity.OrderDetails;
import com.project.order.repository.OrderRepository;
import com.project.order.service.OrderService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderMSApplicationTest {
	
	@Mock
	 OrderRepository orderRepo;
	 
	 @InjectMocks
	 OrderService service= new OrderService();
	 
	 @Test
     public void getAllOrdersValid() throws Exception{
    	 OrderDetails order=new OrderDetails(1,11,12345.00,LocalDate.parse("2020-01-28"),"HYD","ORDER PLACED");
    	 OrderDetails order2=new OrderDetails(2,12,999.0,LocalDate.parse("2020-02-28"),"Delhi","ORDER PLACED");
    	 
    	 List<OrderDetails> orders = new ArrayList<>();
 		 orders.add(order);
 		 orders.add(order2);
 		 
 		 Mockito.when(orderRepo.findAll()).thenReturn(orders);
		 List<OrderDetailsDTO> actual = service.getAllOrders();
		 Assertions.assertEquals(orders.isEmpty(), actual.isEmpty());
    	 
     }
	 
	 @Test
	 public void getOrderByIdValid() throws Exception{
	    int orderid=1;
	    orderRepo.findById(orderid);
	    verify(orderRepo,times(1)).findById(1);
	 }

}


