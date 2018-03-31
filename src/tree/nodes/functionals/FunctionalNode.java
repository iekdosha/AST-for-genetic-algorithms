package tree.nodes.functionals;

import sun.rmi.server.InactiveGroupException;
import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.non_functionals.LeafNode;
import utils.RandUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by itzhak on 23-Mar-18.
 */
public abstract class  FunctionalNode implements Node {

    public static Double weight = 1.0;
    private int minDepth;

    private List<Node> children;

    private final int childrenNum;

//    public FunctionalNode(){
//        this(0);
//    }

    public FunctionalNode(int childrenNum){
        this.childrenNum = childrenNum;
        this.minDepth = 0;
        this.children = new ArrayList<>(this.childrenNum);
        for(int i = 0 ; i < childrenNum ; i ++ ){
            this.children.add(null);
        }
    }

//    public List<Node> getChildren() {
//        return children;
//    }

    public int getChildrenNum() {
        return childrenNum;
    }

//    protected void setChildrenNum(int childrenNum) {
//        this.childrenNum = childrenNum;
//
//        this.children = new ArrayList<>(this.childrenNum);
//    }

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

    protected Double parseChild(int index){
        Node node = this.getChild(index);
        if(node != null){
            return node.parse();
        }
        return Double.NaN;

    }



    public abstract Node randomTree(Integer minDepth, Integer maxDepth, Context context);

    public Node maybeLeaf(Integer minDepth, Integer maxDepth, Context context){
        if((RandUtils.leafChance() && minDepth  <= 0) || maxDepth <= this.getMinDepth()){

            return LeafNode.randomNode(context);
        }

        return this.randomTree(minDepth,maxDepth,context);
    }

    protected int getMinDepth() {
        return minDepth;
    }

    protected void setMinDepth(int minDepth) {
        this.minDepth = minDepth;
    }
}
