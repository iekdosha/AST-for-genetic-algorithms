package tree.nodes.leaves;

import tree.nodes.Context;
import tree.nodes.DepthRestriction;
import tree.nodes.Node;
import utils.RandUtils;

import java.util.HashMap;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class LeafNode implements Node {

    public static Double weight = 1.0;



    public Node randomSubTree(DepthRestriction restriction){
        return this;
    }

}
