package tree.nodes;

/**
 * Created by itzhak on 04-Apr-18.
 */
public class DepthRestriction {

    Integer minDepth;
    Integer maxDepth;


    public DepthRestriction(Integer minValue, Integer maxValue) {
        this.minDepth = minValue;
        this.maxDepth = maxValue;
    }

    public DepthRestriction descend(){
        return new DepthRestriction(this.minDepth -1 , this.maxDepth -1);
    }

    public DepthRestriction descendMinDepth(Integer maybeNewMinDepth){
        return new DepthRestriction(Math.max(this.minDepth -1,maybeNewMinDepth -1) , this.maxDepth -1);

    }

    public Integer getMinDepth() {
        return minDepth;
    }

    public Integer getMaxDepth() {
        return maxDepth;
    }

    public String toString(){

        return "min depth: " + this.minDepth + "  max depth:"+this.maxDepth;

    }

}
