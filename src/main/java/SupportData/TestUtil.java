package SupportData;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class TestUtil {

    public static List<Class<?>> getAllClassesByPackageName(String packageName){
        List<Class<?>> classes = new ArrayList<Class<?>>();
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageName);
            while(dirs.hasMoreElements()){
                URL url = dirs.nextElement();
                String filePath = URLDecoder.decode(url.getFile(),"UTF-8");
                classes.addAll(getAllClassesByFilePath(filePath));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;

    }

    private static List<Class<?>> getAllClassesByFilePath(String filePath){
        List<Class<?>> result = new ArrayList<Class<?>>();

        File file = new File(filePath);

        File [] files = file.listFiles();

        for(File childFile:files){
            if(childFile.isDirectory()){
                continue;
            }
            try {
                String fileName = childFile.getName();
                result.add(Class.forName(fileName.substring(0,fileName.length()-6)));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

}
