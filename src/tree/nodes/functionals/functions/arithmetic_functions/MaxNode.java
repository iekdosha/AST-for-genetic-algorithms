package tree.nodes.functionals.functions.arithmetic_functions;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class MaxNode extends ArithmeticFunctionNode {

    public static Double weight = 1.0;

    @Override
    public Double parse() {
        return Math.max(this.parseChild(0),this.parseChild(1));
    }

    @Override
    public String nodeStr() {
        return "MAX";
    }

}
