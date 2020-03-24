public class SmartStrategy implements OrderingStrategy {
    StringRecipe recipe;
    StringDrink drink;

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        this.recipe = recipe;
        this.drink = drink;

        if (bar.isHappyHour())
            bar.order(drink, recipe);
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        this.wants(this.drink, this.recipe, bar);
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
