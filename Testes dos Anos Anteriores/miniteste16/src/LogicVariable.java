import java.util.Objects;

public class LogicVariable {
    private String name;
    private boolean value;
    private LogicGate calculatedBy;

    LogicVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
        this.calculatedBy = null;
    }
    LogicVariable(String name) {
        this.name = name;
        this.value = false;
        this.calculatedBy = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getValue() {
        if (this.calculatedBy == null)
            return this.value;
        if (this.calculatedBy instanceof GateNot) {
            return !calculatedBy.getInputs()[0].getValue();
        }
        if (this.calculatedBy instanceof GateAnd) {
            return calculatedBy.getInputs()[0].getValue() && calculatedBy.getInputs()[1].getValue();
        }
        if (this.calculatedBy instanceof GateOr) {
            return calculatedBy.getInputs()[0].getValue() || calculatedBy.getInputs()[1].getValue();
        }
        return false;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogicVariable that = (LogicVariable) o;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public LogicGate getCalculatedBy() {
        return calculatedBy;
    }

    public void setCalculatedBy(LogicGate logicGate) {
        this.calculatedBy = logicGate;
    }

    public String getFormula() {
        if (this.calculatedBy == null)
            return this.name;
        else {
            if (calculatedBy instanceof GateNot) {
                return calculatedBy.getSymbol() + "(" + calculatedBy.getInputs()[0].getFormula() + ")";
            }
            else {
                return calculatedBy.getSymbol() + "(" + calculatedBy.getInputs()[0].getFormula() + "," + calculatedBy.getInputs()[1].getFormula() + ")";
            }
        }
    }
}
