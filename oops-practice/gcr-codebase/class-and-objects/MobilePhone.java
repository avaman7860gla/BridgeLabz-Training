public class MobilePhone {
	//Declaring variable for entering the details
	String brand;
	String model;
	double price;
	
	//constructor
	MobilePhone(String brand,String model,double price){
		this.brand = brand;
		this.model = model;
		this.price = price;
	}
	
    //creating method to display mobile details
	public void diplayMobile() {
		System.out.println("Brand of mobile: "+brand);
		System.out.println("Model of mobile: "+model);
		System.out.println("Price of mobile: "+price);
		System.out.println("**********************");
	}
	public static void main(String[] args) {

        //creating objects and passing values
        MobilePhone mobile1=new MobilePhone("VIVO","VIVO V29" , 15999);
        MobilePhone mobile2=new MobilePhone("ONE PLUS","ONE PLUS Nord 5",49999);
        MobilePhone mobile3=new MobilePhone("APPLE","iPhone 17 Pro",129999);
        
        //method calling to display mobile details
        mobile1.diplayMobile();
        mobile2.diplayMobile();
        mobile3.diplayMobile();
	}
}
