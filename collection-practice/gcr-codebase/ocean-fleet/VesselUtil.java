import java.util.List;
import java.util.ArrayList;

class VesselUtil{
    private List<Vessel> vesselList=new ArrayList<>();

    // Method to add vessel performance
    public void addVesselPerformance(Vessel vessel){
        vesselList.add(vessel);
    }

    // Method to get vessel by id
    public Vessel getVesselById(String vesselId){
        for(Vessel vessel:vesselList){
            if(vessel.getVesselId().equals(vesselId)){
                return vessel;
            }
        }
        return null;
    }

    // Method to get high performance vessels
    public List<Vessel> getHighPerformanceVessels(){
        List<Vessel> list=new ArrayList<>();

        if(vesselList.isEmpty()){
            return list;
        }
        double max=0;
        for(Vessel vessel:vesselList){
            if(vessel.getAverageSpeed()>max){
                max=vessel.getAverageSpeed();
            }
        }
        for(Vessel vessel:vesselList){
            if(vessel.getAverageSpeed()==max){
                list.add(vessel);
            }
        }
        return list;
    }
}