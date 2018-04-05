package tree.nodes.factories.node_type_factories;


import tree.nodes.factories.node_factories.ArithmeticFunctionNodeFactory;
import tree.nodes.factories.node_factories.ConditionalFunctionNodeFactory;
import tree.nodes.factories.node_factories.LeafFactory;

/**
 * Created by itzhak on 03-Apr-18.
 */
public class FunctionNodeFactory extends RandomNodeTypeFactory {

    private static FunctionNodeFactory ourInstance = new FunctionNodeFactory();

    public static FunctionNodeFactory getInstance() {
        return ourInstance;
    }


    private FunctionNodeFactory() {
        this.put(ConditionalFunctionNodeFactory.getInstance(),1.0);
        this.put(ArithmeticFunctionNodeFactory.getInstance(),2.0);
        this.put(LeafFactory.getInstance() , 3.0);
    }

    protected String factoryName(){
        return "Function Node";
    }

}
