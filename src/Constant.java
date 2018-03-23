/**
 * Created by itzhak on 23-Mar-18.
 */

public class Constant implements Node {
    private Double value;

    public Constant(Double value){
        this.value = value;
    }

    @Override
    public Double parse() {
        return value;
    }

}
