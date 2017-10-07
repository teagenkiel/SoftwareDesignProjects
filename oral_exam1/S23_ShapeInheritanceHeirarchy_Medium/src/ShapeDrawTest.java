/**
 *
 *
 */

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import java.util.Scanner;

public class ShapeDrawTest {

    public static void main(String[] args){


        JFrame shapeDrawFrame = new JFrame("Let's draw some shapes!");
        shapeDrawFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ShapeDrawCanvas myShapeDrawCanvas = new ShapeDrawCanvas();
        myShapeDrawCanvas.setBackground(Color.WHITE);

        shapeDrawFrame.setSize(500,500);
        shapeDrawFrame.setVisible(false);

        Scanner myScanner = new Scanner(System.in);

        boolean exceptionFlag = true;
        int scannedInteger = 0;

        System.out.println("Shape Hierarchy Test");

        while(scannedInteger != 16) {
            System.out.println("" +
                    "1. Straight Line \n " +
                    "2. Triangle\n " +
                    "3. Equilateral Triangle\n" +
                    "4. Isosceles Triangle\n" +
                    "5. Scalene Triangle\n" +
                    "6. Quadrilateral\n" +
                    "7. Simple Quadrilateral\n" +
                    "8. Complex Quadrilateral\n" +
                    "9. Parallelogram\n" +
                    "10. Rhombus\n" +
                    "11. Rectangle\n" +
                    "12. Square\n" +
                    "13. Rectangular Prism\n" +
                    "14. Triangular Prism\n" +
                    "15. Cube\n" +
                    "16. Exit program" +
                    "\n Please enter an integer");

            scannedInteger = myScanner.nextInt();
            exceptionFlag = true;
            switch (scannedInteger) {


                case (1):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the X and Y coordinates of the first point" +
                                    "and the X and Y coordinates of the second point one by one");
                            Vertex vertex1 = new Vertex(myScanner.nextDouble(), myScanner.nextDouble());
                            Vertex vertex2 = new Vertex(myScanner.nextDouble(), myScanner.nextDouble());
                            StraightLine myStraightLine = new StraightLine(vertex1, vertex2);
                            System.out.println(myStraightLine);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine(); //absorbs previous /n
                    myScanner.nextLine(); //waits for another /n
                    break;

                case (2):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the base length, the left side length, and the" +
                                    " right side length one by one");
                            Triangle myTriangle = new Triangle(myScanner.nextDouble(), myScanner.nextDouble(),
                                    myScanner.nextDouble());
                            System.out.println(myTriangle);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (3):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the length of a side");
                            EquilateralTriangle myETriangle = new EquilateralTriangle(myScanner.nextDouble());
                            System.out.println(myETriangle);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (4):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the length of the base, and the length " +
                                    "of the two sides one by one");
                            IsoscelesTriangle myITriangle = new IsoscelesTriangle(myScanner.nextDouble(),
                                    myScanner.nextDouble());
                            System.out.println(myITriangle);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (5):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the length of the three sides, one by one");
                            ScaleneTriangle mySTriangle = new ScaleneTriangle(myScanner.nextDouble(), myScanner.nextDouble(),
                                    myScanner.nextDouble());
                            System.out.println(mySTriangle);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (6):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the length of the base, the length of the left side," +
                                    "the length of the right side, the interior angle between the left side and the base, " +
                                    "and the interior angle between the right side and the base in degrees one by one");
                            Quadrilateral myQuadrilateral = new Quadrilateral(myScanner.nextDouble(), myScanner.nextDouble(),
                                    myScanner.nextDouble(), myScanner.nextDouble(), myScanner.nextDouble());
                            System.out.println(myQuadrilateral);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (7):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the length of the base, the length of the left side," +
                                    "the length of the right side, the interior angle between the left side and the base, " +
                                    "and the interior angle between the right side and the base in degrees one by one");
                            SimpleQuadrilateral mySQuadrilateral = new SimpleQuadrilateral(myScanner.nextDouble(), myScanner.nextDouble(),
                                    myScanner.nextDouble(), myScanner.nextDouble(), myScanner.nextDouble());
                            System.out.println(mySQuadrilateral);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (8):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the length of the base, the length of the left side," +
                                    "the length of the right side, the interior angle between the left side and the base, " +
                                    "and the interior angle between the right side and the base in degrees one by one");
                            ComplexQuadrilateral myCQuadrilateral = new ComplexQuadrilateral(myScanner.nextDouble(), myScanner.nextDouble(),
                                    myScanner.nextDouble(), myScanner.nextDouble(), myScanner.nextDouble());
                            System.out.println(myCQuadrilateral);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (9):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the length of the base, the length of the sides," +
                                    "and the interior angle between the left side and base in degrees");
                            Parallelogram myParallelogram = new Parallelogram(myScanner.nextDouble(),
                                    myScanner.nextDouble(), myScanner.nextDouble());
                            System.out.println(myParallelogram);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (10):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the length of the side and one interior angle" +
                                    "one by one");
                            Rhombus myRhombus = new Rhombus(myScanner.nextDouble(), myScanner.nextDouble());
                            System.out.println(myRhombus);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (11):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the length of the base, and the length of the" +
                                    "sides one by one");
                            Rectangle myRectangle = new Rectangle(myScanner.nextDouble(), myScanner.nextDouble());
                            System.out.println(myRectangle);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (12):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter the length of one side");
                            Square mySquare = new Square(myScanner.nextDouble());
                            System.out.println(mySquare);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (13):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter a base and side length for the rectangle, and" +
                                    "the height of the prism one by one");
                            RightPrism myRightPrism = new RightPrism(new Rectangle(myScanner.nextDouble(),
                                    myScanner.nextDouble()), myScanner.nextDouble());
                            System.out.println(myRightPrism);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (14):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter a base and side lengths for the triangle, and" +
                                    "the height of the prism one by one");
                            RightPrism myRightPrism = new RightPrism(new Triangle(myScanner.nextDouble(),
                                    myScanner.nextDouble(), myScanner.nextDouble()), myScanner.nextDouble());
                            System.out.println(myRightPrism);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;

                case (15):
                    while (exceptionFlag) {
                        try {
                            System.out.println("Please enter a side length for the square and" +
                                    "the height of the prism one by one");
                            RightPrism myRightPrism = new RightPrism(new Square(myScanner.nextDouble()),
                                    myScanner.nextDouble());
                            System.out.println(myRightPrism);
                            exceptionFlag = false;
                        } catch (Exception exception) {
                            System.out.printf("Exception: %s%n", exception.getMessage());
                        }
                    }
                    System.out.println("Press enter to continue");
                    myScanner.nextLine();
                    myScanner.nextLine();
                    break;
            }
        }

    }

}
