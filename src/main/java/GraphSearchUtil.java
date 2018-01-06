import java.util.Arrays;
import java.util.Random;

public class GraphSearchUtil {

    //生成无向图
    public static int[][] generateGraph(int point_num){
        if(point_num ==0){
            return null;
        }

        Random random = new Random();
        int [][] graph = new int[point_num][point_num];
        for(int i = 0;i<point_num;i++){
            for(int j = i + 1;j<point_num;j++){
                graph[i][j] = random.nextInt(5)>=3?1:0;
                graph[j][i] = graph[i][j];
            }
        }

        return graph;
    }

    //打印图
    public static void printGraph(int [][] graph){
        for(int i = 0;i<graph.length;i++){
            System.out.println(Arrays.toString(graph[i]));
        }
    }

}
