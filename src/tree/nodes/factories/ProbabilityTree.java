package tree.nodes.factories;

import tree.nodes.factories.node_factories.RandomNodeFactory;
import tree.nodes.factories.node_type_factories.RandomNodeTypeFactory;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by itzhak on 05-Apr-18.
 */
public class ProbabilityTree {

    private NodeFactory root;

    public ProbabilityTree(NodeFactory root) {
        this.root = root;
    }

    public NodeFactory getRoot() {
        return root;
    }

    int depth = 0;

    public void printProbabilityTree(){
        depth = 0;
        System.out.println(treeStr(root,null));

    }

    private String treeStr(NodeFactory factory , Double probability){
        String probabilityStr = "" ;
        String name;
        String subTree = "";
        Double sum = factory.getWeightSum();

        depth ++;
        if(probability != null){
            probabilityStr = String.format("%.3f",probability);
        }
        name = getTabs(depth) + "{"+probabilityStr+"}"+factory.factoryName() + "\n";

        StringBuilder sb = new StringBuilder();
        sb.append(name);


        Iterator entries = factory.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            Double prob = ((Double)entry.getValue())/sum;
            if(entry.getKey() instanceof NodeFactory){
                sb.append(treeStr((NodeFactory) entry.getKey(), prob));
            }
            if(entry.getKey() instanceof Class){
                sb.append(treeStr((Class) entry.getKey(), prob));
            }
        }


        depth--;
        return sb.toString();

    }

    private String treeStr(Class cls , Double probability){
        String probabilityStr = "" ;
        String name;

        depth ++;
        if(probability != null){
            probabilityStr = String.format("%.3f",probability);
        }
        name = getTabs(depth) + "{"+probabilityStr+"}"+cls.getSimpleName() + "\n";
        depth--;
        return name;

    }

    private static String getTabs(int depth){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < depth ; i++){
            sb.append("\t");
        }
        return sb.toString();
    }



}
