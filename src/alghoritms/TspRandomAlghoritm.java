package alghoritms;

import parser.Coordinate;
import parser.Coordinates;

import java.util.ArrayList;
import java.util.Random;

public class TspRandomAlghoritm {

    public Coordinates generateRandomPath(Coordinates routeCoordinates) {
        if(routeCoordinates.getFileType() == 1) {
            return generateRandomPath2D(routeCoordinates);
        }
        else {
            return generateRandomPath2D(routeCoordinates);
        }
    }

    private Coordinates generateRandomPath2D(Coordinates routeCoordinates) {
        ArrayList<Coordinate> coordinatesArray = new ArrayList<Coordinate>(routeCoordinates.getCoordinatesArray());
        ArrayList<Coordinate> randormCoordinatesArray = new ArrayList<Coordinate>();

        int initializePoint = getRandomInt(coordinatesArray.size());
        Coordinate startPoint = new Coordinate(coordinatesArray.get(initializePoint).getX(), coordinatesArray.get(initializePoint).getY());
        randormCoordinatesArray.add(coordinatesArray.get(initializePoint));
        coordinatesArray.remove(initializePoint);

        while(coordinatesArray.size() != 0) {
            int pointNumber = getRandomInt(coordinatesArray.size());
            randormCoordinatesArray.add(coordinatesArray.get(pointNumber));
            coordinatesArray.remove(pointNumber);
        }
//        randormCoordinatesArray.add(startPoint);
        return new Coordinates(randormCoordinatesArray, routeCoordinates.getFileType());
    }

    private int getRandomInt(int max) {
        return new Random().nextInt(max);
    }
}
