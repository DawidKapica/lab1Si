package alghoritms;

import parser.Coordinate;
import parser.Coordinates;
import java.util.ArrayList;

public class TspGreedyAlgorithm {

    public Coordinates generateGreedyPath (Coordinates routeCoordinates, int startPointIndex) {
        if (routeCoordinates.getFileType() == 1) {
            return generateGreedyPath2D(routeCoordinates, startPointIndex);
        } else {
            return generateGreedyPath2D(routeCoordinates, startPointIndex);
        }
    }

    private Coordinates generateGreedyPath2D (Coordinates routeCoordinates, int startPointIndex) {
        Coordinate actualPoint = routeCoordinates.getCoordinatesArray().get(startPointIndex);

        ArrayList<Coordinate> coordinatesArray = new ArrayList<Coordinate>(routeCoordinates.getCoordinatesArray());

        ArrayList<Coordinate> greedyCoordinatesArray = new ArrayList<Coordinate>();
        Coordinate startPoint = actualPoint;
        int pointsize = coordinatesArray.size();


        for (int i = 0; i < pointsize; i++) {
            Coordinate nextPoint = nearestNeighbour(coordinatesArray, actualPoint);
            greedyCoordinatesArray.add(actualPoint);
            coordinatesArray.remove(actualPoint);
            actualPoint = nextPoint;
        }

        return new Coordinates(greedyCoordinatesArray, routeCoordinates.getFileType());


    }


    private Coordinate nearestNeighbour(ArrayList<Coordinate> coordinateArray, Coordinate point) {
        Coordinate nearest = coordinateArray.get(0);
        double nearestValue = -1.0;
        for(int i = 0; i < coordinateArray.size(); i++) {
            if (coordinateArray.get(i).getX() != point.getX() && coordinateArray.get(i).getY() != point.getY()) {
                double pathLength = calculateSinglePath(point, coordinateArray.get(i));
                if(pathLength < nearestValue || nearestValue == -1.0) {
                    nearestValue = pathLength;
                    nearest = coordinateArray.get(i);
                }
            }
        }
        return nearest;
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