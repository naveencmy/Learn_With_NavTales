import java.util.*;
public class Enhanced_forLoop{
    public static void main(String[] nav){
        int[] a={1,3,9,3,5};
        int Sum=0;
        for(int num:a){
            Sum+=num;
        }
        System.out.println(Sum);
        System.out.println(nav[0]);
    }
}