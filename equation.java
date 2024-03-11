import javax.swing.JOptionPane;
import java.lang.Math;
import java.util.Scanner;
public class equation {
    /**
     * @param args
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String strChoice="0";
        String strNotification;
        while ((Integer.parseInt(strChoice)) != 3){
            JOptionPane.showMessageDialog(null,"1. The first-degree equation (linear system) with two variables." +
            "\n 2. The system of first-degree quations (linear system) with two variables." +
            "\n 3.The second-degree equation with one variable." + "\n Enter to make your choice: ","Menu", JOptionPane.INFORMATION_MESSAGE);
            strChoice = JOptionPane.showInputDialog(null, "Please make your choice:", 
                       "Your choice: ", JOptionPane.INFORMATION_MESSAGE);
            int Choice = Integer.parseInt(strChoice);
            switch (Choice){
                case (int) 1:
                String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Please input a:", 
                       "The first-degree equation (linear system) with two variables.", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        strNotification = strNum1 + "x = ";
        strNum2 =  JOptionPane.showInputDialog(null, "Please input b:", 
                       "The first-degree equation (linear system) with two variables.", JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);
        strNotification += strNum2;
        if (num1==0){
            if(num2==0){
                   strNotification += " has infinitely many solutions.";
                   JOptionPane.showMessageDialog(null,strNotification,"Result", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
           strNotification +=" has no solution.";
           JOptionPane.showMessageDialog(null,strNotification,"Result", JOptionPane.INFORMATION_MESSAGE);
           }
        }
        else{
        double x = (-num2)/num1;
        strNotification +=" has solution is: " + String.valueOf(x);
        JOptionPane.showMessageDialog(null,strNotification,"Result", JOptionPane.INFORMATION_MESSAGE);
        }
                   break;
                case (int) 2:
        String strA, strB, strC, strD, strE, strF;
            strA = JOptionPane.showInputDialog(null, "Please input a:", 
        "The system of first-degree quations (linear system) with two variables.", JOptionPane.INFORMATION_MESSAGE);
        strNotification = "{" + strA +"x1 + ";
        double a = Double.parseDouble(strA);
            strB = JOptionPane.showInputDialog(null, "Please input b:", 
        "The system of first-degree quations (linear system) with two variables.", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strB + "x2 = ";
        double b = Double.parseDouble(strB);
           strC = JOptionPane.showInputDialog(null, "Please input c:", 
        "The system of first-degree quations (linear system) with two variables.", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strC + " ";
        double c = Double.parseDouble(strC);
            strD = JOptionPane.showInputDialog(null, "Please input d:", 
        "The system of first-degree quations (linear system) with two variables.", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strD + "x1 + ";
        double d = Double.parseDouble(strD);
            strE = JOptionPane.showInputDialog(null, "Please input e:", 
        "The system of first-degree quations (linear system) with two variables.", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strE + "x2 = ";
        double e = Double.parseDouble(strE);
             strF = JOptionPane.showInputDialog(null, "Please input f:", 
        "The system of first-degree quations (linear system) with two variables.", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strF;
        double f = Double.parseDouble(strF);
            double det=Math.abs(a*e-b*d);
            if(det == 0){
                strNotification +="has no solution or has infinitely many solution.";
                JOptionPane.showMessageDialog(null,strNotification,"Result", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                double x1 = (c*e-b*f)/det;
                double x2 = (a*f-c*d)/det;
                strNotification += " has solution is " + "x1 = " + String.valueOf(x1) + " and " + "x2 = " +String.valueOf(x2);
                JOptionPane.showMessageDialog(null,strNotification,"Result", JOptionPane.INFORMATION_MESSAGE);
            }
                    break;
                case (int) 3:
                String strP, strQ, strR;
            strP = JOptionPane.showInputDialog(null, "Please input a:", 
        "The second-degree equation with one variable.", JOptionPane.INFORMATION_MESSAGE);
        strNotification = strP +"x^2 + ";
        double p = Double.parseDouble(strP);
            strQ = JOptionPane.showInputDialog(null, "Please input b:", 
        "The second-degree equation with one variable.", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strQ + "x + ";
        double q = Double.parseDouble(strQ);
           strR = JOptionPane.showInputDialog(null, "Please input c:", 
        "The second-degree equation with one variable.", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strR + " = 0";
        double r = Double.parseDouble(strR);
        double detal=q*q-4*p*r;
            if(p==0){
                if(q==0){
                    if(r!=0){
                        strNotification += " has no soluton.";
                        JOptionPane.showMessageDialog(null,strNotification,"Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        strNotification += " has  has infinitely many solution.";
                        JOptionPane.showMessageDialog(null,strNotification,"Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else{
                    double y=-r/q;
                    strNotification +=" has a solution is "+ String.valueOf(y);
                    JOptionPane.showMessageDialog(null,strNotification,"Result", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
            else{
                if(detal==0){
                    double x=-q/2*p;
                    strNotification +=" has a solution is "+ String.valueOf(x);
                    JOptionPane.showMessageDialog(null,strNotification,"Result", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(detal<0){
                    strNotification += " has no soluton.";
                    JOptionPane.showMessageDialog(null,strNotification,"Result", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    double x1=(-q+Math.sqrt(detal))/2*p;
                    double x2=(-q+Math.sqrt(detal))/2*p;
                    strNotification +=" has two solution is "+ String.valueOf(x1) + " and " + String.valueOf(x2);
                    JOptionPane.showMessageDialog(null,strNotification,"Result", JOptionPane.INFORMATION_MESSAGE);
                }
            }
                    break;

            }
        }
        System.exit(0);
}
}
