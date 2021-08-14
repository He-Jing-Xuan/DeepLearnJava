package factory;

import factory.impl.Apple;
import factory.impl.Orange;

public class Factory {
    public static Fruit getIntance1(String fruitName){
        Fruit fruit = null;
        if(fruitName.equals("Apple")){
            fruit = new Apple();
        }else if(fruitName.equals("Orange")){
            fruit = new Orange();
        }
        return fruit;
    }
    public static Fruit getIntance2(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return (Fruit) Class.forName(classPath).newInstance();
    }
    public static Fruit getIntance3(String className){
        Fruit fruit = null;
        try{
            fruit = (Fruit) Class.forName(className).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return fruit;
    }

}
