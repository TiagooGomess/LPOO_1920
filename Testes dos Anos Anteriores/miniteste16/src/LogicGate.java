public abstract class LogicGate {

    private LogicVariable internalVariable;
    private LogicVariable[] inputs;


    public LogicVariable[] getInputs() {
        return this.inputs;
    }

    public LogicVariable getOutput() {
        return this.internalVariable;
    }

    public void setInternalVariable(LogicVariable internalVariable) {
        this.internalVariable = internalVariable;
    }

    public LogicVariable getInternalVariable() {
        return this.internalVariable;
    }

    public void addInputs(LogicVariable logicVariable1, LogicVariable logicVariable2) {
        inputs = new LogicVariable[]{logicVariable1, logicVariable2};
    }

    public void addInputs(LogicVariable logicVariable) {
        inputs = new LogicVariable[]{logicVariable};
    }

    public abstract String getSymbol();

    public String getFormula() {
        return this.internalVariable.getFormula();
    }

}
