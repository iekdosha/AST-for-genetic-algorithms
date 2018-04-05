package utils;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.leaves.LeafNode;

import java.util.*;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class  RandUtils {


    public static boolean randChance(Double chance){
        if(chance > 1 || chance < 0){
            throw new IllegalArgumentException("Chance must be in range[0,1]");
        }

        return Math.random() < chance;
    }


    public static <T> T randItem(HashMap<T,Double> weightedObjects){
        Double sum = 0.0;

        for(Map.Entry<T,Double> entry: weightedObjects.entrySet()){
            if(entry.getValue() < 0){
                throw new IllegalArgumentException("Weight can not be negatice. for item" + entry.getKey().toString() + " weight=" +entry.getValue());
            }
            sum += entry.getValue();

        }

        Set<T> keys = weightedObjects.keySet();
        Double rand = Math.random();
        Double track = 0.0;

        for(T key: keys){
            track = track +  weightedObjects.get(key).doubleValue()/sum;
            if(track > rand){
                return key;
            }
        }
        T obj = null;
        Iterator<T> iterator = keys.iterator();
        while(iterator.hasNext()){
            obj = iterator.next();
        }
        return obj;

    }

    public static <T> T randItem(Set<T> objects){

        HashMap<T,Double> map = new HashMap<>();

        for(T object: objects){
            map.put(object,1.0);
        }

        return RandUtils.<T>randItem(map);

    }

    public static Node randNodeClass( HashMap<Class,Double> map){

        Class c = RandUtils.<Class>randItem(map);
        return ReflectionUtils.invokeRandomNode(c);

    }


    public static Node randNodeInstance( HashMap<Class,Double> map){

        Class c = RandUtils.<Class>randItem(map);
        return ReflectionUtils.newNodeInstance(c);

    }





}
