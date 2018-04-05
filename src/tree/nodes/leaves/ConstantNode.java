package tree.nodes.leaves;

import tree.nodes.Context;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by itzhak on 23-Mar-18.
 */

public class ConstantNode extends LeafNode  {


    private Double value;
    public static final Double maxValue = 5.0;
    public static final Double minValue = -5.0;

    public ConstantNode(Double value){
        this.value = value;
    }

    public ConstantNode(){
        this.value = minValue + (maxValue - minValue) * (new Random()).nextDouble();;
    }



    @Override
    public Double parse(Context context) {
        return value;
    }

    @Override
    public String nodeStr()
    {
        return String.format("%.3f", this.value);
    }

    public static ConstantNode getRandomConstantNode(){
        return new ConstantNode(ThreadLocalRandom.current().nextDouble(minValue, maxValue));
    }

}
