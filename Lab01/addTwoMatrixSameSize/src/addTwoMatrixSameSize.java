import java.util.Scanner;
public class addTwoMatrixSameSize {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the number of rows n: ");
        int n = scanner.nextInt();
        System.out.print("Input the number of columns m: ");
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        System.out.println("Start inputing the matrix 1:");
        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        System.out.println("Start inputing the matrix 2:");
        int[][] brr = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                brr[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        System.out.println("The sum of two matrices: ");
        int[][] crr = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                crr[i][j] = arr[i][j] + brr[i][j];
            System.out.print( String.valueOf(crr[i][j]) +" " );
            }
        System.out.println();
        }
    }
}