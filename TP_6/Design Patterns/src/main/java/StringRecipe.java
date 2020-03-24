import java.util.ArrayList;
import java.util.List;

public class StringRecipe {
    List<StringTransformer> stringTransformers;
    public StringRecipe(List<StringTransformer> stringTransformers) {
        this.stringTransformers = stringTransformers;
    }
    public void mix(StringDrink drink) {
        for (StringTransformer stringTransformer: stringTransformers) {
            stringTransformer.execute(drink);
        }
    }
}
