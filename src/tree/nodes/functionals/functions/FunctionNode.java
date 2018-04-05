package tree.nodes.functionals.functions;

import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.arithmetic_functions.ArithmeticFunctionNode;
import tree.nodes.functionals.functions.contidional_funcions.ConditionalFunctionNode;
import tree.nodes.functionals.functions.contidional_funcions.IfElseNode;
import utils.RandUtils;

import java.util.HashMap;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class FunctionNode extends FunctionalNode {
    public FunctionNode(int childrenNum) {
        super(childrenNum);
    }

    public static Double weight = 3.0;





}
