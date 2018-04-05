package tree;

import tree.nodes.Context;
import tree.nodes.DepthRestriction;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.factories.node_type_factories.FunctionNodeFactory;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class Tree {
    private Node root;
    //private Context context;
    private int tabCount;




//    public Tree(Context context){
//        this(null, context);
//    }

//    public Tree(Node root,Context context){
//        this.root = root;
//        this.context = context;
//    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void randomTree(Integer minDepth, Integer maxDepth){

        DepthRestriction restriction = new DepthRestriction(minDepth,maxDepth);

        minDepth = Math.min(minDepth,maxDepth);
        if(minDepth <= 0) {
            throw  new IllegalArgumentException("Arguments min/max depth must be at least 1");
        }
        this.root = ((FunctionalNode)(FunctionalNode) FunctionNodeFactory.getInstance().createRandomNode(restriction)).randomTree(restriction);
    }

    private String getTabs(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < tabCount ; i++){
            sb.append("\t|");
        }
        return sb.toString();
    }

    private String treeStr(Node root){
        tabCount ++;
        String str = getTabs() + root.nodeStr() + "\n";
        if(root instanceof FunctionalNode){
            FunctionalNode node = (FunctionalNode)root;
            for(int i = 0 ; i < node.getChildrenNum() ; i++){
                Node child = node.getChild(i);
                if(child != null){
                    str += treeStr(child);
                }
            }
        }
        tabCount--;
        return str;
    }

    public String toString(){

        System.out.println("");
        this.tabCount = 0;
        return treeStr(root);
    }

    public Double parse(Context context){
        return root.parse(context);
    }

}
