package xyz.zao123.algorithm;

import java.util.Arrays;

/**
 * 打印数组中能拼接出的最小值
 * input  {3,32,321}
 * outout 321323
 */
public class ArrMinNum {
    public static void main(String[] args) {
//        int[] num={1,5,9,13,442,44,6,21,211};
        int[] num={3,32,321};
        qsort(num,0,num.length-1);
        System.out.println(Arrays.toString(num));
    }


    public static void qsort(int[] num,int left,int right){
        if(left<right){
            int partition = partition(num,left,right);
            qsort(num,left,partition-1);
            qsort(num,partition+1,right);
        }
    }

    public static int partition(int[] num,int left,int right){
        int partition = num[left];
        while(left<right){
            while((num[right]==partition || isMBigerThanN(num,num[right],partition)) && left<right){
                right--;
            }
            swap(num,left,right);
            while((num[left]==partition || isMBigerThanN(num,partition,num[left])) && left<right){
                left++;
            }
            swap(num,left,right);
        }

        return left;
    }

    public static void swap(int[] num,int m,int n){
        int temp = num[m];
        num[m]=num[n];
        num[n]=temp;
    }

    public static boolean isMBigerThanN(int[] num,int m,int n){
        String num1 = String.valueOf(m);
        String num2 = String.valueOf(n);

        int temp1 = Integer.parseInt(num1+num2);
        int temp2 = Integer.parseInt(num2+num1);

        if(temp1>temp2){
            return true;
        }
        else{
            return false;
        }
    }
}
