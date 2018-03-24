package tree.nodes.non_functionals;

import tree.nodes.Node;

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

    @Override
    public Double parse() {
        return value;
    }

    @Override
    public String nodeStr() {
        return value.toString();
    }

    public static ConstantNode getRandomConstantNode(){
        return new ConstantNode(ThreadLocalRandom.current().nextDouble(minValue, maxValue));
    }

}
