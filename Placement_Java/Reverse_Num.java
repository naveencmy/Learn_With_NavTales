import java.util.*;
public class Reverse_Num{
    public static void main(String[] args) {
        int num=456;
        while(num>=10){
            int sum=0;
            while(num>0){
                int d=num%10;
                sum=sum+d;
                num=num/10;
            }
            num=sum;
        }
        System.err.println(num);
    }
}