import java.util.*;
public class Max_Num{
    public static void main(String[] Nav){
        int []a={2,1,6,13,14,11,2,53,22};
        int max= max_valuer(a);
        System.out.println(Nav[0] +max);
    }
    public static int max_valuer(int ...a){
        int max=a[0];
        for (int i: a){
            if (i>max){
                max=i;
            }
        }
        return max;
    }
}