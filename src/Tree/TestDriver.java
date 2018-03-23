package Tree;

import java.util.LinkedHashMap;

/**
 * Created by itzhak on 23-Mar-18.
 */
public class TestDriver {

    public static void main(String[] args){

        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);

        LinkedHashMap<Integer,String> map = new LinkedHashMap<>();

        map.put(i1,"i1");
        map.put(i2,"i2");


        System.out.println(map);

        Context context = new Context(3.3,4.3, 432.55);

        System.out.println(context.getVarValue(2));





    }


}
