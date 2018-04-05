package tree.nodes.factories.node_factories;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.leaves.LeafNode;
import utils.RandUtils;

/**
 * Created by itzhak on 03-Apr-18.
 */
public class LeafFactory extends RandomNodeFactory {

    private static LeafFactory ourInstance = new LeafFactory();

    public static LeafFactory getInstance() {
        return ourInstance;
    }


    private LeafFactory() {
        fillExtendingClasses(LeafNode.class);

    }



    protected String factoryName(){
        return "Leaf Node";
    }

}
