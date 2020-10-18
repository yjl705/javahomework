import java.util.Scanner;

public class q7_10 {
    public static int indexOfLargestElement(double[] array){
        int index = 0;
        double maximum = -10000;
        for(int i = 0; i < 10; i++){
            if (array[i] > maximum){
                index = i;
                maximum = array[i];
            }
        }
        return index;
    }
    public static  void main(String[] args){
        double[] array = new double[10];
        Scanner input=new Scanner(System.in);
        System.out.print("Enter ten numbers: ");
        for(int i = 1; i <= 10; i++){
            double num = input.nextDouble();
            array[i - 1] = num;
        }
        System.out.print(indexOfLargestElement(array));
    }
}
