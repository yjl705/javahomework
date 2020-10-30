package q9_3;

import java.util.Date;

public class q9_3 {

    public static void main(String args[]){

        long add = 10000;
        for(int i = 4; i <= 11; i++){
            NewDate day = new NewDate();
            day.addDate(add);
            add *= 10;
        }

    }
}

