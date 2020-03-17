public class AreaStringOutputter {
    SumProvider sumProvider;
    AreaStringOutputter(SumProvider sumProvider) {
        this.sumProvider = sumProvider;
    }

    public String output() {
        return "Sum of areas: " + this.sumProvider.sum();
    }

}
