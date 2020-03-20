package alghoritms;
import parser.Coordinate;
import parser.Coordinates;


public class CalculateAlghoritm {
    public double calculateLenght(Coordinates routeCoordinates) {
        double lenght = 0;
        for(int i = 0; i < routeCoordinates.getCoordinatesArray().size() -1; i++) {
            double pathLength = calculateSinglePath(routeCoordinates.getCoordinatesArray().get(i), routeCoordinates.getCoordinatesArray().get(i+1));
            lenght = lenght+pathLength;

        }

        double pathLength = calculateSinglePath(routeCoordinates.getCoordinatesArray().get(routeCoordinates.getCoordinatesArray().size()-1),
                routeCoordinates.getCoordinatesArray().get(0));

        lenght = lenght+pathLength;

        return lenght;

    }

    private double calculateSinglePath(Coordinate start, Coordinate end) {
        double xStart = start.getX();
        double yStart = start.getY();

        double xEnd = end.getX();
        double yEnd = end.getY();

        double lengthX = xStart - xEnd;
        double lengthY = yStart - yEnd;

        double pathLength = Math.sqrt(lengthX*lengthX + lengthY*lengthY);

        return pathLength;
    }
}
