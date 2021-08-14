package factory;

import java.io.*;
import java.lang.reflect.Proxy;
import java.util.Properties;

public class init {
    public static Properties getPro() throws IOException {
        Properties properties = new Properties();
        File f = new File("Fruit.properties");
        if(f.exists()){
            properties.load(new FileInputStream(f));
        }else {
            properties.setProperty("apple","factory.impl.Apple");
            properties.setProperty("orange","factory.impl.Orange");
            properties.store(new FileOutputStream(f),"FRUIT CLASS");
        }
        return properties;
    }
}
