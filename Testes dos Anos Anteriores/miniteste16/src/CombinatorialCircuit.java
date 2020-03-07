import java.util.ArrayList;
import java.util.List;

public class CombinatorialCircuit {
    List<LogicVariable> variables;
    CombinatorialCircuit() {
        this.variables = new ArrayList<>();
    }
    public boolean addVariable(LogicVariable logicVariable) {
        if (!existVariable(logicVariable)) {
            variables.add(logicVariable);
            return true;
        }
        return false;
    }
    private boolean existVariable(LogicVariable logicVariable) {
        for (LogicVariable variable: variables) {
            if (variable.getName() == logicVariable.getName())
                return true;
        }
        return false;
    }

    public LogicVariable getVariableByName(String name) {
        for (LogicVariable variable: variables) {
            if (variable.getName() == name)
                return variable;
        }
        return null;
    }
}
