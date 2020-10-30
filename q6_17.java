import java.util.Random;

public class q6_17 {
    public static void printMatrix(int n){
        Random r = new Random();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int digit = r.nextInt(2);
                matrix[i][j] = digit;
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    public static  void main(String[] args){
        int n = 3;
        printMatrix(n);
    }
}
