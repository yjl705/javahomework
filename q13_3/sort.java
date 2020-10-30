package q13_3;

import java.util.ArrayList;

/*尝试快速排序*/
public class sort {
    public void sort(ArrayList<Integer> list){ //考虑整型数据
        quickSort(list, 0, list.size() - 1);
    }
    public void quickSort(ArrayList<Integer> list, int low, int high){
        int i,j,temp,t;
        if(low > high){
            return;
        }
        i = low;
        j = high;
        //temp是基准位
        temp = list.get(low);

        while(i < j){
            //from right to left
            while (temp <= list.get(j) && i < j){
                j--;
            }

            //from left to right
            while (temp >= list.get(i) && i < j){
                i++;
            }

            if (i < j){
                t = list.get(j);
                list.remove(j);
                list.add(j, list.get(i));
                list.remove(i);
                list.add(i, t);
            }
        }

        //change list[low] and list[i]
        list.remove(low);
        list.add(low, list.get(i));
        list.remove(i);
        list.add(i, temp);

        quickSort(list, low, j - 1);
        quickSort(list, j + 1, high);

    }
}
