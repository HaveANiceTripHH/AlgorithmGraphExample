import SupportData.GraphSearchUtil;
import SupportData.TestUtil;
import org.junit.Test;

public class GraphSearchUtilTest {

    @Test
    public void generateGraph() {
        int [][] graph = GraphSearchUtil.generateGraph(5);
        GraphSearchUtil.printGraph(graph);
    }

    @Test
    public void testTest(){
        TestUtil.getAllClassesByPackageName("");
    }

}