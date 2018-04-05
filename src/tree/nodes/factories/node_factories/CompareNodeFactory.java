package tree.nodes.factories.node_factories;

import tree.nodes.functionals.logicals.compare.CompareNode;

/**
 * Created by itzhak on 31-Mar-18.
 */
public class CompareNodeFactory extends RandomNodeFactory {
    private static CompareNodeFactory ourInstance = new CompareNodeFactory();

    public static CompareNodeFactory getInstance() {
        return ourInstance;
    }

    private CompareNodeFactory() {
        super(CompareNode.class);
    }

    protected String factoryName(){
        return "Compare Node";
    }
}
