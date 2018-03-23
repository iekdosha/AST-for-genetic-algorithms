package Tree.functionals.logicals;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class OrNode extends LogicalNode{
    public OrNode() {
        super(2);
    }

    @Override
    public Double parse() {
        if(this.parseChild(0) == 1.0 || this.parseChild(1) == 1.0){
            return 1.0;
        }
        else{
            return 0.0;
        }
    }
    @Override
    public String nodeStr() {
        return "OR";
    }
}
