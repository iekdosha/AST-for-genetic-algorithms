package Tree.functionals;

/**
 * Created by itzhak on 23-Mar-18.
 */
public class AddNode extends FunctionalNode {
    public AddNode() {
        super(2);
    }

    @Override
    public Double parse() {
        return this.parseChild(0) + this.parseChild(1);
    }

    @Override
    public String nodeStr() {
        return "+";
    }
}
