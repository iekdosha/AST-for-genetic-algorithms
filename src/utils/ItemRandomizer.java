package utils;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class ItemRandomizer {

    public static <T> T rand(HashMap<T,Integer> weightedObjects){
        Integer sum = 0;
        for(Integer i: weightedObjects.values()){
            sum += i;
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

        return null;

    }


}
