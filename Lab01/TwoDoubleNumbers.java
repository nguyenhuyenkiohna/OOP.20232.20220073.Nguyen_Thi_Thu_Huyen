import javax.swing.JOptionPane;
import java.lang.Math;
public class TwoDoubleNumbers {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null,
                     "Please input the first number: ","Input the first number",
                     JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null,
                   "Please input the second number: ","Input the second number",
                    JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        strNotification += strNum2;

        double sum = num1 + num2;
        double difference = Math.abs(num1 - num2);
        double product = num1*num2;
        double quotient = num1/num2;
        strNotification += "\n Sum " + String.valueOf(sum) +"\n Difference " + String.valueOf(difference) +"\n Product " + String.valueOf(product)+"\n Quotient " +String.valueOf(quotient);
        JOptionPane.showMessageDialog(null,strNotification,null, JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }   

}
