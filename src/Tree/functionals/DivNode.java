package Tree.functionals;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class DivNode extends FunctionalNode {
    public DivNode() {
        super(2);
    }

    @Override
    public Double parse() {
        Double den = this.parseChild(1);
        if(den == 0) return 1.0;
        return this.parseChild(0) / den ;
    }


    @Override
    public String nodeStr() {
        return "//";
    }
}
