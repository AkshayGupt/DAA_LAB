import java.util.*;
class Order{
	 
	int order_no;
	Customer customer;
	ArrayList<Item_ordered> items_ordered=new ArrayList<>();
	double finalBill;
	Order(){
		this.order_no=0;
		customer=null;
		finalBill = 0.0;
		items_ordered=new ArrayList<>();
	}
	Order(int sl){
	
		this.order_no=sl;
	}
	void addItem(Item item,double quantity) {
		   this.items_ordered.add(new Item_ordered(item,quantity));
		   finalBill +=(item.price * quantity);
	}
	void setOrderNo(int sl) {
		   this.order_no =sl;
	}
	void setCustomer(Customer c) {
		   this.customer=c;
	}
  
}