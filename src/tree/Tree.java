package tree;

import tree.nodes.Context;
import tree.nodes.Node;
import tree.nodes.functionals.FunctionalNode;
import tree.nodes.functionals.functions.FunctionNode;

/**
 * Created by itzhak on 24-Mar-18.
 */
public class Tree {
    private Node root;
    private Context context;
    private int tabCount;

    public Tree(Context context){
        this(null, context);
    }

    public Tree(Node root,Context context){
        this.root = root;
        this.context = context;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void randomTree(Integer minDepth, Integer maxDepth){
        this.root = FunctionNode.randomFunctionNode().randomTree(minDepth,maxDepth,context);
    }

    private String getTabs(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < tabCount ; i++){
            sb.append("\t");
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
        this.tabCount = 0;
        return treeStr(root);
    }

    public Double parse(){
        return root.parse();
    }

}