import java.util.Arrays;
import java.util.List;

class RobortHazardAuditor {
    // Method to calculate risk
    public double calculateHazardRisk(double armPrecision, int workDensity, String machineryState) throws RobotSafetyException{
        // Validation of arm precision, work density, and machinery state
        validateArmPrecision(armPrecision);
        validateWorkDensity(workDensity);
        validateMachineryState(machineryState);

        // Calculate risk factor
        double machineRiskFactor=0.0;
        if(machineryState.equals("Worn")){
            machineRiskFactor=1.3;
        }
        if(machineryState.equals("Faulty")){
            machineRiskFactor=2.0;
        }
        if(machineryState.equals("Critical")){
            machineRiskFactor=3.0;
        }

        // Calculate risk and return
        double harzadRisk=((1.0-armPrecision)*15.0)+(workDensity*machineRiskFactor);
        return harzadRisk;
    }    

    // Validate arm precision
    public void validateArmPrecision(double armPrecision) throws RobotSafetyException{
        if(armPrecision<0 || armPrecision>1){
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }
    }

    // Validate work density
    public void validateWorkDensity(int workDensity) throws RobotSafetyException{
        if(workDensity<1 || workDensity>20){
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }
    }

    // Validate Machinery state
    public void validateMachineryState(String state) throws RobotSafetyException{
        List<String> validStates=Arrays.asList("Worn", "Faulty", "Critical");
        if(!validStates.contains(state)){
            throw new RobotSafetyException("Error: Unsupported machinery state");
        }
    }
}
