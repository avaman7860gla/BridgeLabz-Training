public class ItemsInventory {
	//declaring the variables for listing the items
	String[] itemCode;
	String[] itemName;
	double[] price;
	
	//constructor
	ItemsInventory(String[]itemName ,String[] itemCode,double[] price){
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
	}

	//creating method to display item details
	public void displayItems(int i) {
		System.out.println("itemCode : "+itemCode[i]);
		System.out.println("itemPrice : "+price[i]);
		System.out.println("itemName : "+itemName[i]);
		System.out.println("**********************");
	}
	public static void main(String[] args) {

		//creating object and passing values
		String[] itemName= {"Utensils","Rice","Projector"};
		String[] itemCode= {"01AA","01BB","02AA"};
		double[] price= {500,700,1000};
		ItemsInventory item1 = new ItemsInventory(itemName, itemCode,price );

		//method calling to display item details
		for (int i = 0; i < price.length; i++) {
			item1.displayItems(i);
		}
	}
}
