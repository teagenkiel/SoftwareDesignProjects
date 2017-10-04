/**
 * This class will create a one-dimensional object. Characteristics of every 1D object include
 * two vertices (defined by coordinates) that are connected. However, different objects of this class may take different
 * paths to get from vertex to vertex (i.e. straight line, arc, squiggly line, etc.). Subclasses of this class
 * can define the certain path to take, and how to compute the length of the line over that path.
 * Note that every OneDimensionalShape does indeed have a length, but we can't provide that instance variable here
 * since there is no way to compute it upon construction without knowing the path the line takes. Length must be defined
 * in a subclass of this class if needed.
 *
 */
public class OneDimensionalShape extends Shape {

    private Vertex vertex1;
    private Vertex vertex2;

    /**
     *The main constructor of the OneDimensionalShape class. Takes in two vertices both with
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    public OneDimensionalShape(Vertex vertex1, Vertex vertex2){

        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public void setNewCoordinates(Vertex vertex1, Vertex vertex2) {

        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    public Vertex getVertex1() {
        return vertex1;
    }

    public Vertex getVertex2() {
        return vertex2;
    }
}

