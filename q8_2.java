import java.util.Scanner;

public class q8_2 {
    public static double averageMajorDiagonal(double[][] m){
        double avg = 0;
        double time = 0;
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if((j - i == 0) | (j + i == 3)){
                    avg += m[i][j];
                    time += 1;
                }
            }
        }
        return avg/time;
    }
    public static  void main(String[] args){
        double[][] array = new double[4][4];
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a 4−by−4 matrix row by row: ");
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                double num = input.nextDouble();
                array[i][j] = num;
            }
        }
        System.out.print("EAverage of the elements in the major diagonal is " + String.format("%.3f\n", averageMajorDiagonal(array)));

    }
}
