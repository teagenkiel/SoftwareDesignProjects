/**
 *
 *A right prism is a prism in which the joining edges and faces are perpendicular to the base faces.
 * This applies if the joining faces are rectangular.
 */
public class RightPrism extends ThreeDimensionalShape{

    private Polygon baseShape;
    private double height;

    public RightPrism(Polygon baseShape, double height){

        super(computeSurfaceArea(baseShape, height), computeArea(baseShape, height));

        this.baseShape = new Polygon(baseShape);
        this.height = height;

    }

    public static double computeArea(Polygon baseShape, double height){

       return baseShape.getArea() * height;
    }

    public static double computeSurfaceArea(Polygon baseShape, double height){

        return 2 * (baseShape.getArea() + baseShape.getPerimeter()) * height;
    }

    @Override
    public String toString() {
        return "RightPrism{" +
                "Surface Area = " + this.getSurfaceArea() +
                ", Volume = " + this.getVolume() +
                "}";
    }
}
