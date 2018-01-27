import SupportData.GraphSearchUtil;

import java.util.Arrays;

/**
 * 01背包：
 * 动态规划问题的核心是当前问题的最优解包含在小规模的最优解中，或者说大规模问题可以由小规模问题推导出来，也就是状态转移；
 * 具体到0，1背包；状态转移为：对于第i件物品，在背包容量限定为weight的情况下，其最大价值在放这件物品与不放这件物品之间选择一个：
 * a：如果放的话，那么价值为当前背包容量减去该物品重量后能放置物品的最高价值与当前物品的价值累加；就是数组中a[i-1][weight-weighs[i]]
 * b: 如果不放的话，那么价值就应该是当前背包容量下不考虑这个物品，也就是上个物品在该背包容量的最大价值：也就是数组中a[i-1][weight]
 *  a与b的最大值就是当前规模的最优值
 */
public class ZeroOneKnapsack implements AlgorithmInGraph {

    public void showAlgorithm() {
        int [] weighs = {5,9,1
                ,7,10,6,7};

        int [] value ={10,20,5,3,30,5,5};
        int maxWeight = 16;

        int maxValue = doZeroOneKnapsack(weighs,value,maxWeight);
        System.out.println("物品重量为:"+ Arrays.toString(weighs));
        System.out.println("物品价值为:"+ Arrays.toString(value));
        System.out.println("背包容量为"+maxWeight);

        System.out.println("这个背包能装入物品的最大价值为"+maxValue);
    }

    public int doZeroOneKnapsack(int [] weighs ,int [] value,int maxWeight){
        maxWeight = maxWeight + 1;
        int [][] currentState = new int [weighs.length][maxWeight];
        int maxResult = 0;
        for(int i=0;i<weighs.length;i++){
            for(int j=0;j<maxWeight;j++){
                //初始化
                if(i==0){
                    if(j >= weighs[0]){
                        currentState[i][j] = value[0];
                    }
                }else if(j >= weighs[i] ){
                    if(currentState[i-1][j-weighs[i]]+value[i] > currentState[i-1][j]){
                        currentState[i][j] = currentState[i-1][j-weighs[i]]+value[i];
                    }else{
                        currentState[i][j] = currentState[i-1][j];
                    }
                }
                else{
                    currentState[i][j] = currentState[i-1][j];
                }
                if(maxResult < currentState[i][j]){
                    maxResult = currentState[i][j];
                }
            }
        }

        GraphSearchUtil.printGraph(currentState);
        return maxResult;
    }
}
