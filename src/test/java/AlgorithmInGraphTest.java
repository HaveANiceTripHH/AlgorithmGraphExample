import SupportData.TestUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AlgorithmInGraphTest {

    @Test
    public void showAlgorithm() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<Class<?>> classes = TestUtil.getAllClassesByPackageName("");
        for(Class<?> theClass:classes){
            if(!theClass.isInterface()){
                try {
                    Object object = theClass.newInstance();
                    if(object instanceof AlgorithmInGraph) {
                        System.out.println("当前测试类为：" + theClass.getName()+":\n");
                        AlgorithmInGraph algorithm = (AlgorithmInGraph) object;
                        algorithm.showAlgorithm();
                        System.out.println("========================================================\n");
                    }
                }catch (InstantiationException ex){
                    ex.printStackTrace();
                }
            }

        }



    }
}