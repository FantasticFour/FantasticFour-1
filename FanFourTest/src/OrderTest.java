import java.util.ArrayList;

import com.example.fanfourproject.Order;
import com.example.fanfourproject.Pizza;
import com.example.fanfourproject.Pop;

import junit.framework.TestCase;


public class OrderTest extends TestCase {
	Pizza a, b, c, d;
	Pop m, n, p, q;
	
	public void setUp(){
		ArrayList<String> topping = new ArrayList<String>();  
		topping.add("cheese");
		topping.add("sausage");
		topping.add("mushrooms");
		a = new Pizza("Large", topping);
		b = new Pizza("Small", topping);
		c = new Pizza("Large", topping);
		d = new Pizza("Medium", topping);
		m = new Pop("Can", "coke");
		n = new Pop("Liter", "coke");
		p = new Pop("Liter", "coke");
		q = new Pop("Can", "coke");
		
	}
	
	public void testEmptyCase(){
		Order order = new Order();
		String price = order.getInitialPrice();
		assertEquals("price should be 0", price, "0.00");
	}
	
	public void testAddPizza(){
		Order order = new Order();
		String price = order.getInitialPrice();
		assertEquals("price should be 0", price, "0.00");
		order.addPizza(a);
		price = order.getInitialPrice();
		assertEquals("price should be 21.99", price, "21.99");
		order.addPizza(b);
		price = order.getInitialPrice();
		assertEquals("price should be 33.98", price, "33.98");
		order.addPizza(d);
		price = order.getInitialPrice();
		assertEquals("price should be 50.97", price, "50.97");
	}
	
	public void testClearPizza(){
		Order order = new Order();
		order.addPizza(a);
		order.addPop(m);
		String price = order.getInitialPrice();
		assertEquals("price should be 22.98", price, "22.98");
		order.clearPizzas();
		price = order.getInitialPrice();
		assertEquals("price should be 0.99", price, "0.99");
	}
	
	public void testAddPop(){
		Order order = new Order();
		order.addPop(m);
		String price = order.getInitialPrice();
		assertEquals("price should be 0.99", price, "0.99");
		order.addPop(n);
		price = order.getInitialPrice();
		assertEquals("price should be 3.98", price, "3.98");
	}
	
	public void testClearpop(){
		Order order = new Order();
		order.addPizza(a);
		order.addPop(m);
		String price = order.getInitialPrice();
		assertEquals("price should be 22.98", price, "22.98");
		order.clearPops();
		price = order.getInitialPrice();
		assertEquals("price should be 21.99", price, "21.99");
	}
	
	public void testTax(){
		Order order = new Order();
		order.addPizza(a);
		String price = order.getInitialPrice();
		assertEquals("price should be 21.99", price, "21.99");
		String tax = order.getTax();
		assertEquals("Tax should be 1.65", tax, "1.65");
	}
	
	public void testDiscount(){
		Order order = new Order();
		order.addPizza(a);
		String price = order.getInitialPrice();
		assertEquals("price should be 21.99", price, "21.99");
		String discount = order.getDiscounts();
		assertEquals("Discount should be 3.30", discount, "3.30");
	}
	
	public void testFinalPrice(){
		Order order = new Order();
		order.addPizza(a);
		String finalprice = order.getFinalPrice();
		assertEquals("The final price should be 20.34", finalprice, "20.34");
	}
	
	public void testGetPizza(){
		Order order = new Order();
		order.addPizza(a);
		order.addPizza(b);
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		pizzas = order.getPizzas();
		assertEquals("The first pizza should be pizza", pizzas.get(0), a);
		assertEquals("The first pizza should be pizza", pizzas.get(1), b);
	}
	
	public void testGetPop(){
		Order order = new Order();
		order.addPop(m);
		order.addPop(n);
		ArrayList<Pop> pops = new ArrayList<Pop>();
		pops = order.getPop();
		assertEquals("The first pizza should be pizza", pops.get(0), m);
		assertEquals("The first pizza should be pizza", pops.get(1), n);
	}
}
	