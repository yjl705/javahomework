package q9_3;


import java.util.Date;

public class NewDate{
    private Date date = new Date();
    public void addDate(long add){
        long time = date.getTime() + add;
        date.setTime(time);
        System.out.println("After "+add+" ms, date is "+ date.toString());
    }

}
