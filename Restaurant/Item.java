class Item{
	int itemNo;
    String name;
    double price;
    int popularity;
    String ingredients[];
    
    Item(){
    	this.itemNo =0;
    	this.name ="";
    	this.price=0.0;;
    	this.ingredients =new String[10];
    }
    Item(int no,String name,double price,String ingredients[]){
    	this.itemNo =no;
    	this.name =name;
    	this.price=price;;
    	this.ingredients =ingredients;
    }
    void itemOrdered() {
    	this.popularity++;
    }
}