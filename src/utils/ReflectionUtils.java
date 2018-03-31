package utils;

import tree.nodes.Node;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by itzhak on 31-Mar-18.
 */
public abstract class ReflectionUtils {

    public static Object invokeStaticNoArgsMethod(Class cls, String methodName){
        try{
            Method method = cls.getMethod(methodName, null);
            return method.invoke(null, null);
        }catch (NoSuchMethodException e){

            e.printStackTrace();
        }
        catch (IllegalAccessException e){

            e.printStackTrace();
        }
        catch (InvocationTargetException e){

            e.printStackTrace();
        }
        return null;
    }

    public static Node invokeRandomNode(Class cls){
        return (Node)invokeStaticNoArgsMethod(cls,"randomNode");
    }

    public static Object newInstance(Class cls){
        try{

            return cls.newInstance();
        }
        catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Node newNodeInstance(Class cls){
        return (Node)newInstance(cls);
    }

    public static HashMap<Class,Double> getClassWeightMap(Class... args ) {
        HashMap<Class, Double> map = new HashMap<>();

        for (Class cls : args) {
            try {
                Field myField = cls.getDeclaredField("weight");
                map.put(cls, (Double) myField.get(null));
            }catch(NoSuchFieldException|IllegalAccessException e){
                System.err.println(cls.getSimpleName()+" has no Static field 'weight' or the field is not accessible, weight set to 1.0 ");
                map.put(cls, 1.0);
            }

        }

        return map;

    }

    public static Double sumClassWeights(Class... args ) {
        Double sum = 0.0;

        for (Class cls : args) {
            try {
                Field myField = cls.getDeclaredField("weight");
                sum += (Double) myField.get(null);
            }catch(NoSuchFieldException|IllegalAccessException e){
                System.err.println(cls.getSimpleName()+" has no Static field 'weight' or the field is not accessible, weight set to 1.0 ");
                sum+= 1.0;
            }
        }

        return sum;

    }


}
