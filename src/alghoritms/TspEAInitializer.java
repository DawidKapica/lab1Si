package alghoritms;

import parser.Coordinate;
import parser.Coordinates;

import java.util.ArrayList;

public class TspEAInitializer {

    public ArrayList<Coordinates> initialize(Coordinates routeCoordinates, int numberOfCoordinatesIndividual) {
        ArrayList<Coordinates> coordinatesArrayList = new ArrayList<Coordinates>();
        TspRandomAlghoritm tspRandomAlghoritm = new TspRandomAlghoritm();
        TspGreedyAlgorithm tspGreedyAlgorithm = new TspGreedyAlgorithm();
        for(int i = 0; i < numberOfCoordinatesIndividual; i++) {
            coordinatesArrayList.add(tspRandomAlghoritm.generateRandomPath(routeCoordinates));
        }
        return  coordinatesArrayList;
    }
}
