import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 * 依次选择最小（大）的值放到对应的位置
 * 算法复杂度为O（n^2）
 */
@SuppressWarnings("unused")
public class ChooseSort implements AlgorithmInGraph {


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

    /**
     * @param array 待排序的数组
     * 因为传进来的是数组，所以不需要返回，将数组排序好
     */
    private void sort(int [] array){
        for(int i = 0;i<array.length;i++){
            int min = array[i];
            int index = i;
            for(int j = i;j<array.length;j++){
                if(min > array[j]){
                    min = array[j];
                    index = j;
                }
            }
            if(i != index){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
    }
}
