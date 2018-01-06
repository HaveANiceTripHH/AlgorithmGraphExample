import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序
 * 分治算法,选准一个基准值(一般选择数组中第一个值),将数组分成两部分,前一部分比基准值小,后一部分比基准值大.
 * 然后将分割后的两个数组继续分割,一直到不能分割为止,那么所有子数组都是排序好的,最后汇总起来也是排序好的数组
 * 算法时间复杂度:O(nLogn),最差为O(n^2)
 */
@SuppressWarnings("unused")
public class QuickSort implements  AlgorithmInGraph{

    @SuppressWarnings("Duplicates")
    public void showAlgorithm() {
        int [] array = new int[10];
        Random random = new Random();
        for(int i = 0;i<10;i++){
            array[i] = random.nextInt(100);
        }
        System.out.println("排序前生成的数组的顺序是: \t" + Arrays.toString(array));
        sort(array);
        System.out.println("排序后的数组的顺序是: \t" +  Arrays.toString(array));
    }

    private void sort(int [] array){
        quickSort(array,0,array.length-1);

    }

    private void quickSort(int [] array,int start,int end){
        if(start >= end){
            return;
        }
        int left = start;
        int right = end;
        int value = array[start];
        while(left < right){
            while(array[right] > value && left < right)
                right--;
            array[left] = array[right];
            while(array[left] < value && left < right)
                left++;
            array[right] = array[left];
        }
        array[left] = value;
        quickSort(array,left+1,end);
        quickSort(array,start,left-1);

    }
}
