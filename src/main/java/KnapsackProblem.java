import java.util.ArrayList;
import java.util.Arrays;

/**
 * 贪心算法解决背包问题
 * 贪心算法原理,当前问题的最优解就是全局问题的最优解,所以找到当前最优解就好;
 * 对于背包问题而言,因为物品都是可以分割的,
 * 所以每次选择一定量当前还存在的单位价值最大的物品就好了
 *
 */
public class KnapsackProblem implements AlgorithmInGraph{


    public void showAlgorithm() {
        int [] weighs = {5,9,3,7,10,6};
        int [] value ={10,20,5,3,30,5};
        System.out.println("物品重量为:"+Arrays.toString(weighs));
        System.out.println("物品价值为:"+ Arrays.toString(value));

        int maxWeight = 16;

        System.out.println("背包容量为"+maxWeight);
        double maxValue = doKnapsack(weighs,value,maxWeight);
        System.out.println("这个背包能装入物品的最大价值为"+maxValue);
    }

    public double doKnapsack(int [] weighs,int [] value,int maxWeight ){
        for(int i = 0;i < weighs.length - 1;i++){
            for(int j = 0; j < weighs.length - i - 1 ;j++ ){
                if(weighs[j] /(double)value[j] > weighs[j+1]/(double)value[j+1] ){
                    swap(weighs,j,j+1);
                    swap(value,j,j+1);
                }
            }
        }

        double currentWeight = 0;
        int i = 0;
        double maxValue = 0;
        while(i<weighs.length){
            if(currentWeight + weighs[i] < maxWeight){
                currentWeight += weighs[i];
                maxValue += value[i];

            }else {
                maxValue += value[i] * (maxWeight - currentWeight) / weighs[i];
                break;
            }
            i++;
        }
        return maxValue;
    }

    public void swap(int [] array,int left,int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
