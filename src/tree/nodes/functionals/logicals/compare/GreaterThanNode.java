package tree.nodes.functionals.logicals.compare;

import tree.nodes.Context;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class GreaterThanNode extends CompareNode {


    public GreaterThanNode() {
        super(2);
    }

    @Override
    public Double parse(Context context) {
        if(this.parseChild(0,context ) > this.parseChild(1,context )){
            return 1.0;
        }
        else{
            return 0.0;
        }
    }

    @Override
    public String nodeStr() {
        return "GT";
    }
}
