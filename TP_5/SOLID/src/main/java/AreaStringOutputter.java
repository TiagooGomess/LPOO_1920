public class AreaStringOutputter {
    AreaAggregator areaAggregator;
    AreaStringOutputter(AreaAggregator areaAggregator) {
        this.areaAggregator = areaAggregator;
    }

    public String output() {
        return "Sum of areas: " + areaAggregator.sum();
    }

}
