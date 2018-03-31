package tree.nodes.functionals.logicals;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.*;
import tree.nodes.functionals.logicals.compare.CompareNode;
import tree.nodes.functionals.logicals.compare.GreaterThanNode;
import tree.nodes.functionals.logicals.compare.LessThanNode;
import tree.nodes.functionals.logicals.logical_operators.AndNode;
import tree.nodes.functionals.logicals.logical_operators.LogicalOperatorNode;
import tree.nodes.functionals.logicals.logical_operators.OrNode;
import tree.nodes.non_functionals.LeafNode;
import utils.RandUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by itzhak on 24-Mar-18.
 */
public abstract class LogicalNode extends FunctionalNode {

    public static Double weight = 2.0;


    public LogicalNode(int childrenNum) {
        super(childrenNum);
    }

    public static FunctionalNode randomNode(){


        return (FunctionalNode) RandUtils.randNodeClass(
                LogicalOperatorNode.class,
                CompareNode.class
        );

    }



}
