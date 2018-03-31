package tree.nodes.functionals.functions.contidional_funcions;

import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.FunctionNode;
import tree.nodes.functionals.logicals.LogicalNode;
import tree.nodes.functionals.logicals.compare.CompareNode;
import tree.nodes.functionals.logicals.logical_operators.LogicalOperatorNode;
import utils.RandUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by itzhak on 31-Mar-18.
 */
public abstract class ConditionalFunctionNode extends FunctionNode {

    public static Double weight = 3.0;


    public ConditionalFunctionNode(int childrenNum) {
        super(childrenNum);
    }

    public static FunctionalNode randomNode(){

        return (FunctionalNode) RandUtils.randNodeInstance(IfElseNode.class);

    }


}
