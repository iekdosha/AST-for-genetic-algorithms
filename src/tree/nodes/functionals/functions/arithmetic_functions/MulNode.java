package tree.nodes.functionals.functions.arithmetic_functions;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class MulNode extends ArithmeticFunctionNode {


    @Override
    public Double parse() {
        return this.parseChild(0)  * this.parseChild(1);
    }

    @Override
    public String nodeStr() {
        return "*";
    }
}
