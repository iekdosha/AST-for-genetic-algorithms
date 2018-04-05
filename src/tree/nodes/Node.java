package tree.nodes;

/**
 * Created by itzhak on 23-Mar-18.
 */
public interface Node {

    Double parse(Context context);

    String nodeStr();



    Node randomSubTree(DepthRestriction restriction);


}
