package dynamicProgramming.canSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanSum {

    private static Boolean canSum(int reminder, List<Integer> arr){
        if(reminder < 0) return false;
        else if(reminder == 0 ) return true;
        for(Integer item : arr){
            int newRem = reminder - item;
            if(canSum(newRem, arr)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] arg){
        List<Integer> nos = new ArrayList<>(Arrays.asList(2,4));
        System.out.println(canSum(3, nos));
        nos.add(3);
        System.out.println(canSum(7, nos));
        System.out.println(canSum(8, nos));
        System.out.println(canSum(1, nos));
    }

}
