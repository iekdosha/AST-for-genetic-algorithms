package Tree.functionals;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class IfElseNode extends FunctionalNode{
    public IfElseNode() {
        super(3);
    }

    @Override
    public Double parse() {
        if(this.parseChild(0) == 1.0){
            return this.parseChild(1);
        }
        else{
            return this.parseChild(2);
        }

    }

    @Override
    public String nodeStr() {
        return "IF_ELSE";
    }



}
