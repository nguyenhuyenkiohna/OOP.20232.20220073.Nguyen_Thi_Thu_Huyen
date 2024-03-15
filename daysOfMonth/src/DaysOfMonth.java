import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a month: ");
        String strMonth = scanner.nextLine();
        System.out.print("Enter a year: ");
        int iYear = scanner.nextInt();
       while (!(strMonth.equals("January")||strMonth.equals("Jan.")||strMonth.equals("Jan")||strMonth.equals("1")||
            strMonth.equals("March")||strMonth.equals("Mar.")||strMonth.equals("Mar")||strMonth.equals("3")||
            strMonth.equals("May")||strMonth.equals("5")||
            strMonth.equals("July")||strMonth.equals("July")||strMonth.equals("Jul")||strMonth.equals("7")||
            strMonth.equals("August")||strMonth.equals("Aug.")||strMonth.equals("Aug")||strMonth.equals("8")||
            strMonth.equals("October")||strMonth.equals("Oct.")||strMonth.equals("Oct")||strMonth.equals("10")||
            strMonth.equals("December")||strMonth.equals("Dec.")||strMonth.equals("Dec")||strMonth.equals("12")||
            strMonth.equals("April")||strMonth.equals("Apr.")||strMonth.equals("Apr")||strMonth.equals("4")||
            strMonth.equals("June")||strMonth.equals("June")||strMonth.equals("Jun")||strMonth.equals("6")||
            strMonth.equals("September")||strMonth.equals("Sept.")||strMonth.equals("Sep")||strMonth.equals("9")||
            strMonth.equals("November")||strMonth.equals("Nov.")||strMonth.equals("Nov")||strMonth.equals("11")||
            strMonth.equals("February")||strMonth.equals("Feb.")||strMonth.equals("Feb")||strMonth.equals("2"))){
                scanner.nextLine();   
                System.out.print("Enter again a month: ");
                strMonth = scanner.nextLine();   
            }         
         while (iYear<0){
                System.out.print("Enter again a year: ");
                iYear = scanner.nextInt();
            }
        
        if(strMonth.equals("January")||strMonth.equals("Jan.")||strMonth.equals("Jan")||strMonth.equals("1")||
            strMonth.equals("March")||strMonth.equals("Mar.")||strMonth.equals("Mar")||strMonth.equals("3")||
            strMonth.equals("May")||strMonth.equals("5")||
            strMonth.equals("July")||strMonth.equals("July")||strMonth.equals("Jul")||strMonth.equals("7")||
            strMonth.equals("August")||strMonth.equals("Aug.")||strMonth.equals("Aug")||strMonth.equals("8")||
            strMonth.equals("October")||strMonth.equals("Oct.")||strMonth.equals("Oct")||strMonth.equals("10")||
            strMonth.equals("December")||strMonth.equals("Dec.")||strMonth.equals("Dec")||strMonth.equals("12")){
                System.out.println("Days of "+strMonth+" in "+ String.valueOf(iYear) + " :31.");
            }
        else if(strMonth.equals("April")||strMonth.equals("Apr.")||strMonth.equals("Apr")||strMonth.equals("4")||
            strMonth.equals("June")||strMonth.equals("June")||strMonth.equals("Jun")||strMonth.equals("6")||
            strMonth.equals("September")||strMonth.equals("Sept.")||strMonth.equals("Sep")||strMonth.equals("9")||
            strMonth.equals("November")||strMonth.equals("Nov.")||strMonth.equals("Nov")||strMonth.equals("11")){
                System.out.println("Days of "+strMonth+" in "+ String.valueOf(iYear) + " :30.");
            }
        else if (strMonth.equals("February")||strMonth.equals("Feb.")||strMonth.equals("Feb")||strMonth.equals("2")){
                if ((iYear % 4 == 0 && iYear % 100 != 0) || (iYear % 400 == 0)){
                    System.out.println("Days of "+strMonth+" in "+ String.valueOf(iYear) + " :29.");
                }
                else{
                    System.out.println("Days of "+strMonth+" in "+ String.valueOf(iYear) + " :28.");
                }
            }
        
        
        

    }
}
