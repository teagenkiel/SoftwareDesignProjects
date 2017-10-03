/**
 * This class's main purpose is to build objects that represent a vertex, or point, on a plane with given x and y
 * coordinates. This class can be added to with ease in order to be used to implement 3D-shapes.
 *
 */
public class Vertex extends Shape{

    private double x_coordinate;
    private double y_coordinate;

    /**
     * Main constructor for class Vertex.
     * @param x_coordinate the x-coordinate of the vertex
     * @param y_coordinate the y-coordinate of the vertex
     */
    public Vertex(double x_coordinate, double y_coordinate){

        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    /**
     * @return the vertex's x-coordinate
     */
    public double getX() {
        return x_coordinate;
    }

    /**
     * @return the vertex's y-coordinate
     */
    public double getY(){
        return y_coordinate;
    }

    /**
     * Sets a new coordinate pair for the vertex.
     * @param x_coordinate the x-coordinate to be set
     * @param y_coordinate the y-coordinate to be set
     */
    public void setNewCoordinates(double x_coordinate, double y_coordinate){

        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    /**
     * @param x_coordinate the x-coordinate to be set
     */
    public void setX(double x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    /**
     * @param y_coordinate the y-coordinate to be set
     */
    public void setY(double y_coordinate) {
        this.y_coordinate = y_coordinate;
    }
}
