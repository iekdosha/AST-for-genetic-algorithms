package Tree.functionals;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class MinNode extends FunctionalNode{
    public MinNode() {
        super(2);
    }

    @Override
    public Double parse() {
        return Math.max(this.parseChild(0),this.parseChild(1));
    }

    @Override
    public String nodeStr() {
        return "MIN";
    }
}
