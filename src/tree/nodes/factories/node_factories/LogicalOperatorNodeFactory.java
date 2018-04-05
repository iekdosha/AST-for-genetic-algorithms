package tree.nodes.factories.node_factories;

import tree.nodes.functionals.logicals.logical_operators.LogicalOperatorNode;

/**
 * Created by itzhak on 03-Apr-18.
 */
public class LogicalOperatorNodeFactory extends RandomNodeFactory {


    private static LogicalOperatorNodeFactory ourInstance = new LogicalOperatorNodeFactory();

    public static LogicalOperatorNodeFactory getInstance() {
        return ourInstance;
    }

    private LogicalOperatorNodeFactory() {
        super(LogicalOperatorNode.class);
    }

    protected String factoryName(){
        return "Logical Operator Node";
    }
}
