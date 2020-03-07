import java.util.ArrayList;
import java.util.List;

public class GateNot extends LogicGate {

    GateNot(LogicVariable y1, LogicVariable w1) throws ColisionException, CycleException {
        if (testDependency(y1, w1))
            throw new CycleException();
        super.setInternalVariable(y1);
        super.addInputs(w1);
        if (y1.getCalculatedBy() != null)
            throw new ColisionException();
        y1.setCalculatedBy(this);
        boolean value = !w1.getValue();
        super.getInternalVariable().setValue(value);
    }

    public String getSymbol() {
        return "NOT";
    }

    private boolean testDependency(LogicVariable y1, LogicVariable w1) {
        List<LogicVariable> variables = new ArrayList<>();
        if (w1.getCalculatedBy() != null) {
            LogicVariable[] inputs = w1.getCalculatedBy().getInputs();
            for (int i = 0; i < inputs.length; i++) {
                variables.add(inputs[i]);
            }
            for (LogicVariable variable: variables) {
                if (variable.equals(y1))
                    return true;
            }
            return false;
        }
        return false;
    }

}
