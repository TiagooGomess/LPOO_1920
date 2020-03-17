public class AreaXMLOutputter {
    SumProvider sumProvider;
    AreaXMLOutputter(SumProvider sumProvider) {
        this.sumProvider = sumProvider;
    }

    public String output() {
        return "<area>" + this.sumProvider.sum() + "<area>";
    }
}
