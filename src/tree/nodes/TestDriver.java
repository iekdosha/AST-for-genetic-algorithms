package tree.nodes;

import tree.Tree;
import tree.nodes.functionals.functions.arithmetic_functions.ArithmeticFunctionNode;
import tree.nodes.functionals.functions.arithmetic_functions.DivNode;
import tree.nodes.functionals.logicals.LogicalNode;
import utils.RandUtils;

import java.util.LinkedHashMap;

/**
 * Created by itzhak on 23-Mar-18.
 */
public class TestDriver {

    public static void main(String[] args){

        Context context = new Context(0.123 ,3.456, 6.789);
        Tree tree = new Tree(context);
        tree.randomTree(3,5);
        System.out.println(tree);
        System.out.println("value for test context: " + tree.parse());



    }


}
