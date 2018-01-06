package SupportData;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    Graph(){
        points = new ArrayList<Point>();
        edges = new byte [MAX_POINT][MAX_POINT];
    }

    private  final int MAX_POINT = 10;


    private List<Point> points;


    private byte [][] edges;

    public void addPoint(Point point){
        if(points.contains(point)){
            return;
        }
        points.add(point);
    }

    public byte getEddes(Point point1,Point point2){
        int index1 = points.indexOf(point1);
        int index2 = points.indexOf(point2);
        if(index1 != -1 && index2 != -1){
            return edges[index1][index2];
        }
        return 0;
    }

    //根据节点增加边
    public void addEdges(Point point1,Point point2){
        int index1 = points.indexOf(point1);
        int index2 = points.indexOf(point2);
        if(index1 >=0 && index2 >= 0) {
            edges[index1][index2] = 1;
        }
    }



    //根据节点名称增加边
    public void addEdgs(String name1,String name2){
        Point point1 = null;
        Point point2 = null;
        for(Point point:points){
            if(point.name.equals(name1)){
                point1 = point;
            }
            else if(point.name.equals(name2)){
                point2 = point;
            }
        }
        if(point1 !=null && point2 != null){
            addEdges(point1,point2);
        }
    }

    public class Point{
        public String name;

        @Override
        public int hashCode() {
            if(name != null) {
                return name.hashCode();
            }
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Point && ((Point) obj).name.equals(this.name)){
                return true;
            }
            return false;
        }
    }
}
