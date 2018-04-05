package tree.nodes.factories.node_type_factories;

import tree.nodes.factories.node_factories.CompareNodeFactory;
import tree.nodes.factories.node_factories.LeafFactory;
import tree.nodes.factories.node_factories.LogicalOperatorNodeFactory;

/**
 * Created by itzhak on 31-Mar-18.
 */
public class LogicalNodeFactory extends RandomNodeTypeFactory {
    private static LogicalNodeFactory ourInstance = new LogicalNodeFactory();

    public static LogicalNodeFactory getInstance() {
        return ourInstance;
    }


    private LogicalNodeFactory() {
        this.put(CompareNodeFactory.getInstance(),2.0);
        this.put(LogicalOperatorNodeFactory.getInstance(),1.0);
        this.put(LeafFactory.getInstance() , 3.0);
    }


    protected String factoryName(){
        return "Logical Node";
    }


}
