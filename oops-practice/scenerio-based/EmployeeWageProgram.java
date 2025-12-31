public class EmployeeWageProgram {
    
    // constants
    static final int wagePerHour = 20;
    static final int partTime = 1;
    static final int fullTime = 2;
    static final int maxWorkDays = 20;
    static final int maxWorkHour = 100;

    public static void main(String[] args){

        // welcome statement
        System.out.println("Welcome to Employee Wages Computational System");

        int totalWorkHour = 0;
        int totalWorkDays = 0;

        // UC6:calculate wages till max hours or days condition is met
        while(totalWorkHour < maxWorkHour && totalWorkDays < maxWorkDays){
            totalWorkDays++;

            // UC1:check employee attendance using random
            int attendenceCheck = (int)(Math.random()*3);
            int dailyHour = 0;

            //UC4:switch case for employee type
            switch(attendenceCheck){
                case fullTime:
                    dailyHour = 8;
                    break;
                case partTime:
                    dailyHour = 4;
                    break;
                default:
                    dailyHour = 0;
                    break;
            }

            // UC2 & UC3:calculate daily wages
            int dailyWage = dailyHour * wagePerHour;
            totalWorkHour += dailyHour;

            System.out.println("Daily Summary");
            System.out.println("Total work days = "+totalWorkDays);
            System.out.println("Daily Hours = "+dailyHour);
            System.out.println("Daily Wages = "+dailyWage);

            // UC5:calculate monthly wages
            int monthlyWage = totalWorkHour * wagePerHour;

            System.out.println("Monthly Summary");
            System.out.println("Total work days = "+totalWorkDays);
            System.out.println("Total work Hours = "+totalWorkHour);
            System.out.println("Monthly Wages = "+monthlyWage);

            
        }
    }

}
