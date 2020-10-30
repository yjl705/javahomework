import java.util.Random;

public class q7_7 {
    public static void Count(){
        Random r = new Random();
        int[] matrix = new int[10];
        for(int i = 0; i < 200; i++){
            int digit = r.nextInt(10);
            matrix[digit] += 1;
        }
        for(int i = 0; i < 10; i ++){
            System.out.println("The time of number " + (i) + " is " +  matrix[i]);
        }
    }
    public static  void main(String[] args){
        Count();
    }
}
