public class StringCaseChanger implements StringTransformer {

    @Override
    public void execute(StringDrink drink) {
        String text = drink.getText();
        StringBuffer sb = new StringBuffer(text);
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLowerCase(text.charAt(i))) {
                sb.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
            else if (Character.isUpperCase(text.charAt(i))) {
                sb.setCharAt(i, Character.toLowerCase(text.charAt(i)));
            }
        }
        drink.setText(sb.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        String text = drink.getText();
        StringBuffer sb = new StringBuffer(text);
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLowerCase(text.charAt(i))) {
                sb.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
            else if (Character.isUpperCase(text.charAt(i))) {
                sb.setCharAt(i, Character.toLowerCase(text.charAt(i)));
            }
        }
        drink.setText(sb.toString());
    }
}
