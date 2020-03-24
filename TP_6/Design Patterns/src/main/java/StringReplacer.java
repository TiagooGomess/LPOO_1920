public class StringReplacer implements StringTransformer {
    private Character initialChar, finalChar;

    public StringReplacer(Character initialChar, Character finalChar) {
        this.initialChar = initialChar;
        this.finalChar = finalChar;
    }

    @Override
    public void execute(StringDrink drink) {
        drink.setText(drink.getText().replace(this.initialChar, this.finalChar));
    }

    @Override
    public void undo(StringDrink drink) {
        drink.setText(drink.getText().replace(this.finalChar, this.initialChar));
    }
}
