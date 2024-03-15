import java.util.Scanner;
public class arrayElements {
    /**
     * @param args
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("The number of elements of array: ");
        int n = scanner.nextInt();
        int sum=0;
        double average;
        int[] arr = new int[n];
        System.out.print("The elements of the array are: ");
        for(int i=0; i<n; i++){
        arr[i]= scanner.nextInt();
        sum+=arr[i];
        }
        average = sum/n;
        System.out.print("The sum off array: " + String.valueOf(sum) +"\n");
        System.out.print("The average off array: " + String.valueOf(average));
    }

}

