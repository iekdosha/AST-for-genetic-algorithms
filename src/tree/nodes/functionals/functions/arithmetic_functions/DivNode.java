package tree.nodes.functionals.functions.arithmetic_functions;

import tree.nodes.Context;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class DivNode extends ArithmeticFunctionNode {



    @Override
    public Double parse(Context context) {
        Double den = this.parseChild(1, context);
        if(den == 0) return 1.0;
        return this.parseChild(0,context ) / den ;
    }


    @Override
    public String nodeStr() {
        return "DIV";
    }
}
