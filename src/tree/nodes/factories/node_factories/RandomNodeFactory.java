package tree.nodes.factories.node_factories;

import tree.nodes.DepthRestriction;
import tree.nodes.Node;
import tree.nodes.factories.NodeFactory;
import tree.nodes.factories.node_type_factories.RandomNodeTypeFactory;
import utils.RandUtils;
import utils.ReflectionUtils;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by itzhak on 03-Apr-18.
 */


public abstract class RandomNodeFactory extends  NodeFactory<Class> {

    private Class nodeCls;

    public RandomNodeFactory(){
        super();
    }

    public RandomNodeFactory(Class cls){
        this.nodeCls = cls;
        fillExtendingClasses(cls);
    }

    public Node createRandomNode(DepthRestriction restriction){

        Node node = RandUtils.randNodeInstance(this);
        if(node != null){
            return node;
        }
        throw new NullPointerException("No classes extending the core node type of this factory");
    }

    protected void fillExtendingClasses(Class cls){

        Set<Class> extending = ReflectionUtils.getExtendingClasses(cls);
        for(Class c: extending){
            this.put(c,1.0);
        }

    }

    public Class getNodeCls() {
        return nodeCls;
    }
}

