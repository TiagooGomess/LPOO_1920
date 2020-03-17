public class Application {
    public static void main(String[] args) {
        AreaShape circle1 = new Circle(1.5);
        AreaShape square = new Square(2.3);
        AreaShape circle2 = new Circle(4.3);
        AreaShape ellipse = new Ellipse(4.3, 2.7);
        AreaShape rectangle = new Rectangle(3.4, 2.5);
        AreaShape triangle = new Triangle(4.2, 6.4);

        ellipse.draw();

        AreaAggregator areaAggregator = new AreaAggregator();
        areaAggregator.addShape(circle1);
        areaAggregator.addShape(square);
        areaAggregator.addShape(circle2);
        areaAggregator.addShape(ellipse);
        areaAggregator.addShape(rectangle);
        areaAggregator.addShape(triangle);

        AreaStringOutputter stringOutputter = new AreaStringOutputter(areaAggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(areaAggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}
