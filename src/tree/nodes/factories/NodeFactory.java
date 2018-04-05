package tree.nodes.factories;

import tree.nodes.DepthRestriction;
import tree.nodes.Node;

import java.util.LinkedHashMap;

/**
 * Created by itzhak on 03-Apr-18.
 */
public abstract class NodeFactory<T> extends LinkedHashMap<T,Double> {
    public abstract Node createRandomNode(DepthRestriction restriction);

//    protected abstract String factoryTreeStr(Double probability);
    protected String factoryName(){
        return this.getClass().getSimpleName();
    }

    protected static int depth = 0;

    protected static String getTabs(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < depth ; i++){
            sb.append("\t|");
        }
        return sb.toString();
    }


    public Double getWeightSum(){
        Double sum = 0.0;
        for(Double d: this.values()){
            sum += d;
        }
        return sum;
    }



}
