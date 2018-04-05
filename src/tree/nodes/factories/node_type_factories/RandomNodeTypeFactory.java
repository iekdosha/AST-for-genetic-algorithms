package tree.nodes.factories.node_type_factories;

import tree.nodes.DepthRestriction;
import tree.nodes.Node;
import tree.nodes.factories.node_factories.LeafFactory;
import tree.nodes.factories.NodeFactory;
import utils.RandUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by itzhak on 31-Mar-18.
 */


public abstract class RandomNodeTypeFactory extends NodeFactory<NodeFactory> {



    public Node createRandomNode(DepthRestriction restriction) {
        NodeFactory factory;

        if(restriction.getMaxDepth() <= 0){
            factory = LeafFactory.getInstance();
        }
        else if(restriction.getMinDepth() > 0){

            LinkedHashMap<NodeFactory,Double> noLeaves = (LinkedHashMap<NodeFactory,Double>)this.clone();
            noLeaves.remove(LeafFactory.getInstance());
            factory = RandUtils.<NodeFactory>randItem(noLeaves);

        }
        else {
            factory = RandUtils.<NodeFactory>randItem(this);
        }
//        if(factory instanceof LeafFactory){
//            System.out.println(restriction.getMinDepth() + " <<min  max>> " + restriction.getMaxDepth() + " "+ factory.getClass().getSimpleName());
//
//        }
        return factory.createRandomNode(restriction);
    }







}
