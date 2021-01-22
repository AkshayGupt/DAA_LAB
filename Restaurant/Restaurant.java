import java.util.*;
class Restaurant{
   static int seating_capacity=10;
   static HashMap<Integer,Order> orders=new HashMap<>(); // Store Order object with key as Order no.
   static HashMap<String,Item> items =new HashMap<>(); // Store Item object with key as Item name.
   static HashMap<Long,Customer> customers=new HashMap<>(); // Store Customer object with key as mobile no.
   static HashMap<Long,Customer> premium_customers=new HashMap<>(); // Store Customer object with key as mobile no.
   	
   
   
   /*
    * This static block will run at the beginning of the Program 
    */
   static{
	   String ing1 []= {
			   "Salt",
			   "Chicken",
			   "Spices"
		};
	   Item Chicken =new Item(1,"Chicken",200.0,ing1);   
	   String ing2 [] = {
			   "Sugar",
			   "Milk",
			   "Coffee powder"
	   };
	   Item Coffee =new Item(2,"Coffee",50.0,ing2);
	   String ing3[]= {
			   "Paneer",
			   "Salt",
			   "Butter"
	   };
	   Item Paneer =new Item(3,"Paneer",45.0,ing3);
	   
	   items.put("Chicken",Chicken);
	   items.put("Coffee", Coffee);
	   items.put("Paneer", Paneer);
			   
   }
   
   static void showMenu(){
	   System.out.println("\t\tMENU");
	   System.out.println("--------------------------------------");
	   System.out.println("Sl. Name \t Price     Popularity");
	   int cnt=1;
	   for(Item item:items.values()) {
		   	System.out.println((cnt++)+".  "+item.name+"\t "+item.price+" \t\t"+item.popularity);
	   }	
   }
   
   static boolean bookASeat(){
	        if(seating_capacity>0){
	            --seating_capacity;
	            return true;
	        }
	        return false;
   }

    static void placeOrder(Customer customer,Order order){//TODO
    	
    	
       /*
        * 	@description:
        * 
        *   When an Order is Placed:
        *   1) order gets added in HashMap in Restaurant.
        *   
        *   2)order gets added in customer
        *          
        *  
        *   #) If finalBill >= 1000 add customer to premium customer
        */
    	
    	orders.put(orders.size()+1,order);
    	customer.addOrder(order);
    		
    }
    
   static Item searchForItem(String item_name) {
    	/*
    	 * @description:
    	 * 
    	 * Search in the hashMap
    	 */
    	if(items.containsKey(item_name)) {
    		return items.get(item_name);
    	}
    	else {
    		return null;
    	}
    }
    
   static void generateBill(Customer customer) { //TODO
    	/*
    	 * @description:
    	 * 
    	 *  generate bill of latest order
    	 */
	   System.out.println("\t\t           BILL");
	   System.out.println("-------------------------------------------------------------");
	   System.out.println("Customer Name: "+customer.name);
	   System.out.println("Customer Mobile: "+customer.mobile);
	   
	   System.out.println("-------------------------------------------------------------");
	   Order order =customer.order_history.get(customer.order_history.size()-1);
	   
	   ArrayList<Item_ordered> items =order.items_ordered;
	   System.out.println("Item Name       Quantity");
	   double cost =0;
	   for(Item_ordered x:items) {
		   System.out.println(x.item.name+"        "+x.quantity);
	   }
	   System.out.println("-------------------------------------------------------------");
	   System.out.println("Total  : "+order.finalBill);
	   System.out.println("18% GST : "+(order.finalBill*0.18));
	   System.out.println("Final Bill: "+(order.finalBill*1.18));
	   
	   System.out.println("------------------------THANK YOU----------------------------");
	   
	   if(order.finalBill >=1000) {
			premium_customers.put(customer.mobile,customer);
    		customers.remove(customer.mobile);
	   }
	   
    }
    
   static Customer findCustomer(Long mobile) {
    	/*
    	 * @description:
    	 * 
    	 * Search for customer
    	 */
    	if(customers.containsKey(mobile)) {
    		return customers.get(mobile);
    	}
    	else {
    		return null;
    	}
    }
    
   static Customer findPremiumCustomer(Long mobile) {
    	/*
    	 * @description:
    	 * 
    	 * Search for premium customer
    	 */
    	if(premium_customers.containsKey(mobile)) {
    		return customers.get(mobile);
    	}
    	else {
    		return null;
    	}
    }
    
   static Customer addCustomer(Long mobile,String name) {
    	/*
    	 * @description:
    	 * 
    	 * add customer to HashMap
    	 */
	   	Customer c=new Customer(name,mobile);
    	customers.put(mobile, c);
    	return c;
    }
    
    public static void main(String args[]) {
    	Scanner sc=new Scanner(System.in);
    	while(true) {
    		System.out.println("Enter your name");
    		String name=sc.next();
    		System.out.println("Enter your mobile no.");
        	long mobile = sc.nextLong();
        	
        	
        	System.out.println("WELCOME TO BABA KA DHABA!!");
        	
        	if(seating_capacity == 0) {
        		System.out.println("Sorry!! We are housefull!!");
        		continue;
        	}
        	else {
        		bookASeat();
        	}
        	
        	Customer current =findCustomer(mobile);
        	
        	if( current == null) {
        		current =addCustomer(mobile,name);
        	}
        	else {
        		
        	}
        	
        	showMenu(); // display all items
        	
        	
        	
        	
        	
        	Order newOrder= new Order(orders.size()+1);
        	
        	while(true) {
        		System.out.println("Item Name (type end to stop)");
        		String item_Name =sc.next();
        		if(item_Name.equalsIgnoreCase("end")) {
        			break;
        		}
        		System.out.println("Item Quantity");
        		int quantity=sc.nextInt();
        		Item item =searchForItem(item_Name);
        		if(item == null) {
        			System.out.println("Can't find this Item\n Please try again\n");
        			continue;
        		}
        		item.itemOrdered();
        		newOrder.addItem(item, quantity);
        		
        	}
        	placeOrder(current,newOrder);
        	generateBill(current);
        	System.out.println("New Customer? (y/n)");
        	char c=sc.next().charAt(0);
        	if(c == 'n' || c== 'N') {
        		System.out.println("Restaurant Closed!!");
        		break;
        	}
    	}
    }
    

}