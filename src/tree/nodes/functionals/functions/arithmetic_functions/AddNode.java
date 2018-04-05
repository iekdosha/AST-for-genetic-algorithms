package tree.nodes.functionals.functions.arithmetic_functions;

import tree.nodes.Context;

/**
 * Created by itzhak on 23-Mar-18.
 */
public class AddNode extends ArithmeticFunctionNode {


    @Override
    public Double parse(Context context) {
        return this.parseChild(0,context ) + this.parseChild(1,context );
    }

    @Override
    public String nodeStr() {
        return "ADD";
    }


}
