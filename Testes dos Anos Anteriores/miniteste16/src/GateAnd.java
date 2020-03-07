public class GateAnd extends LogicGate {

    GateAnd(LogicVariable w1, LogicVariable x1, LogicVariable x2) throws ColisionException {
        super.setInternalVariable(w1);
        super.addInputs(x1, x2);
        if (w1.getCalculatedBy() != null)
            throw new ColisionException();
        w1.setCalculatedBy(this);
        boolean value = x1.getValue() && x2.getValue();
        super.getInternalVariable().setValue(value);
    }

    public String getSymbol() {
        return "AND";
    }

}
