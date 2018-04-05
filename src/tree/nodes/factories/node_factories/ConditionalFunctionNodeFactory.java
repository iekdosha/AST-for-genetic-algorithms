package tree.nodes.factories.node_factories;

import tree.nodes.functionals.functions.contidional_funcions.ConditionalFunctionNode;

/**
 * Created by itzhak on 03-Apr-18.
 */
public class ConditionalFunctionNodeFactory extends RandomNodeFactory{
    private static ConditionalFunctionNodeFactory ourInstance = new ConditionalFunctionNodeFactory();

    public static ConditionalFunctionNodeFactory getInstance() {
        return ourInstance;
    }

    private ConditionalFunctionNodeFactory() {
        super(ConditionalFunctionNode.class);
    }

    protected String factoryName(){
        return "Conditional Node";
    }

}
