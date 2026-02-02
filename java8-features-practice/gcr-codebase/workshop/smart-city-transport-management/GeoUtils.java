// Interface
interface GeoUtils {
    // Method to calculate distance 
    static double calculateDistance(double x1, double y1, double x2, double y2){
        double distance=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2))*111;
        return distance;
    }
}
