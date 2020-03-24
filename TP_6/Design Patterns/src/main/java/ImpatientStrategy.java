public class ImpatientStrategy implements OrderingStrategy {
    StringRecipe recipe;

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.recipe = recipe;
        bar.order(drink, recipe);
    }

    @Override
    public void happyHourStarted(StringBar bar) {

    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
