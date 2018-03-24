package tree.nodes.functionals.functions.arithmetic_functions;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class DivNode extends ArithmeticFunctionNode {

    @Override
    public Double parse() {
        Double den = this.parseChild(1);
        if(den == 0) return 1.0;
        return this.parseChild(0) / den ;
    }


    @Override
    public String nodeStr() {
        return "/";
    }
}
