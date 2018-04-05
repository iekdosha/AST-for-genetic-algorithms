package tree.nodes;

import tree.Tree;
import tree.nodes.factories.ProbabilityTree;
import tree.nodes.factories.node_factories.ArithmeticFunctionNodeFactory;
import tree.nodes.factories.node_factories.LeafFactory;
import tree.nodes.factories.node_factories.LogicalOperatorNodeFactory;
import tree.nodes.factories.node_type_factories.FunctionNodeFactory;
import tree.nodes.factories.node_type_factories.LogicalNodeFactory;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.arithmetic_functions.ArithmeticFunctionNode;
import tree.nodes.functionals.functions.arithmetic_functions.DivNode;
import tree.nodes.functionals.functions.arithmetic_functions.SubNode;
import tree.nodes.functionals.functions.contidional_funcions.ConditionalFunctionNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by itzhak on 23-Mar-18.
 */
public class TestDriver {

    public static void main(String[] args){

        Tree tree = new Tree();
        tree.randomTree(3,5);
        System.out.println(tree);
        Context context = new Context(0.123 ,3.456, 6.789);
        System.out.println("value for test context: " + tree.parse(context));

        System.out.println("\nFunction nodes probability tree");
        ProbabilityTree probabilityTree = new ProbabilityTree(FunctionNodeFactory.getInstance());
        probabilityTree.printProbabilityTree();


        System.out.println("\nLogical nodes probability tree");
        probabilityTree = new ProbabilityTree(LogicalNodeFactory.getInstance());
        probabilityTree.printProbabilityTree();


    }


}
