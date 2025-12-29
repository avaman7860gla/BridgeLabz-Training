public class Circle {
	
	double radius;
	
	//constructors
	Circle(double radius){
		this.radius=radius;
	}
	
	//Creating method for calculating area of circle
	public void areaCircle() {
		System.out.printf("Area of circle: %.4f",(Math.PI*radius*radius));
        System.out.println();
	}
	
	//Creating method for calculating circumference of circle
	public void circumferenceCircle() {
		System.out.printf("Circumference of circle: %.4f ",(2*Math.PI*radius)); 
        System.out.println();
	}
	
	public static void main(String[] args) {
	Circle circle1 = new Circle(2.5);
    Circle circle2 = new Circle(4.5);
	
    // Method calling for circle1 and circle2
    System.out.println("For Circle with radius 2.5:");
	circle1.areaCircle();
	circle1.circumferenceCircle();


    System.out.println("For Circle with radius 4.5:");
    circle2.areaCircle();
	circle2.circumferenceCircle();
	}
}
