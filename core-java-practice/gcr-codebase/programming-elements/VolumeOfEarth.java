
public class VolumeOfEarth {

	public static void main(String[] args) {
		int radiusInKm=6375;
		double radiusInMiles=radiusInKm*1.6;
		double volumeInKm=(4/3)*Math.PI*Math.pow(radiusInKm,3);
		double volumeInMiles=(4/3)*Math.PI*Math.pow(radiusInMiles,3);
		
		System.out.println("The volume of earth in cubic kilometers is "+ volumeInKm +" and cubic miles is "+volumeInMiles);
		
		

	}

}
