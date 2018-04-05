package tree.nodes.functionals.functions.arithmetic_functions;

import tree.nodes.Context;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class MinNode extends ArithmeticFunctionNode {


    @Override
    public Double parse(Context context) {
        return Math.max(this.parseChild(0,context ),this.parseChild(1, context));
    }

    @Override
    public String nodeStr() {
        return "MIN";
    }
}
