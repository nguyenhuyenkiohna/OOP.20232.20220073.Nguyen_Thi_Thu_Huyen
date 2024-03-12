import java.util.Scanner;
public class displayATriangle {
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("n = ");
        int n = keyboard.nextInt();
        System.out.println("A triangle with a height of n stars(*):");
        for(int i=1; i<=n; i++){
            for(int j=1; j<2*n; j++){
                if(((0<j)&&(j<n-i+1))||((n+i-1<j)&&(j<2*n))){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
