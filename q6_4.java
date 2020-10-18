public class q6_4 {
    public static void reverse(int number){
        int res = 0;
        int index = 1;
        while(number > 0){
            res = res * 10 + number % 10;
            number /= 10;
        }
        System.out.println(res);
    }
    public static  void main(String[] args){
        int num = 3456;
        reverse(num);
    }
}
