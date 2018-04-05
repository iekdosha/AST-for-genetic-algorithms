package tree.nodes.factories.node_factories;

import tree.nodes.functionals.functions.arithmetic_functions.*;


/**
 * Created by itzhak on 03-Apr-18.
 */
public class ArithmeticFunctionNodeFactory extends RandomNodeFactory {
    private static ArithmeticFunctionNodeFactory ourInstance = new ArithmeticFunctionNodeFactory();

    public static ArithmeticFunctionNodeFactory getInstance() {
        return ourInstance;
    }

    private ArithmeticFunctionNodeFactory() {
        super(ArithmeticFunctionNode.class);
    }

    protected String factoryName(){
        return "Arithmetic Node";
    }

}
