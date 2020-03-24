public class StringInverter implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        StringBuffer sb = new StringBuffer(drink.getText());
        drink.setText(sb.reverse().toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
