package Tree.functionals;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class MulNode extends FunctionalNode {
    public MulNode() {
        super(2);
    }

    @Override
    public Double parse() {
        return this.parseChild(0)  * this.parseChild(1);
    }

    @Override
    public String nodeStr() {
        return "*";
    }
}
