package tree.nodes.functionals;

import tree.nodes.Context;
import tree.nodes.DepthRestriction;
import tree.nodes.Node;
import tree.nodes.factories.node_factories.LeafFactory;
import tree.nodes.functionals.logicals.logical_operators.LogicalOperatorNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by itzhak on 23-Mar-18.
 */
public abstract class  FunctionalNode implements Node {

    private int minDepth;

    private List<Node> children;

    private final int childrenNum;


    public FunctionalNode(int childrenNum){
        this.childrenNum = childrenNum;
        this.minDepth = 0;
        this.children = new ArrayList<>(this.childrenNum);
        for(int i = 0 ; i < childrenNum ; i ++ ){
            this.children.add(null);
        }
    }



    public int getChildrenNum() {
        return childrenNum;
    }



    public boolean setChild(int index, Node child){
        if(index < 0 ||  index >= childrenNum){
            return false;
        }

        children.set(index,child);
        return true;
    }

    public boolean addChild(Node child){
        for(int i = 0 ; i < children.size() ; i++){
            if(children.get(i) == null){
                children.set(i,child);
                return true;
            }
        }
        return false;
    }

    public Node getChild(int index){
        if(index < 0 ||  index >= childrenNum){
            return null;
        }
        return children.get(index);
    }

    protected Double parseChild(int index, Context context){
        Node node = this.getChild(index);
        if(node != null){
            return node.parse(context);
        }
        return Double.NaN;

    }



    public Node randomSubTree(DepthRestriction restriction){
        if( restriction.getMaxDepth() <= this.getMinDepth()){
            return LeafFactory.getInstance().createRandomNode(restriction);
        }
        return this.randomTree(restriction);
    }

    public abstract Node randomTree(DepthRestriction restriction);

    protected int getMinDepth() {
        return minDepth;
    }

    protected void setMinDepth(int minDepth) {
        this.minDepth = minDepth;
    }
}
