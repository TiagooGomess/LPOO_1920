public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();

        aggregator.addArea(new Square(10));
        aggregator.addArea(new Circle(5));
        aggregator.addArea(new Circle(2));
        aggregator.addArea(new Ellipse(2, 3));
        aggregator.addArea(new Rectangle(10, 5));
        aggregator.addArea(new Triangle(10, 2));
        aggregator.addArea(new House(100));

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());

        City city = new City();
        city.addHouse(new House(50));
        city.addHouse(new House(150));

        AreaStringOutputter cityStringOutputter = new AreaStringOutputter(city);
        AreaXMLOutputter cityXmlOutputter = new AreaXMLOutputter(city);

        System.out.println(cityStringOutputter.output());
        System.out.println(cityXmlOutputter.output());
    }
}
