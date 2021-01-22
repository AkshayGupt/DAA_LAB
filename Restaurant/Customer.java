import java.util.*;

class Customer{
    String name;
    long mobile;
    ArrayList<Order> order_history=new ArrayList<>();// Store Order Object
    
    Customer(){
    	this.name="";
    	this.mobile=0;
    	order_history =new ArrayList<Order>();
    }
    
    Customer(String name,Long mobile){
    	this.name=name;
    	this.mobile=mobile;
    }
    
    void addOrder(Order order) {    	
    	this.order_history.add(order);
    }
    
}