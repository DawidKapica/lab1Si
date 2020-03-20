package calculateData;
import parser.Coordinates;
import alghoritms.TspGreedyAlgorithm;
import alghoritms.CalculateAlghoritm;

import java.util.ArrayList;

public class CalculateGreedy {
    public ArrayList calculateGreedyData(Coordinates pathCoordinates) {
        double sum = 0;
        double best = -1.0;
        double worst = -1.0;

        TspGreedyAlgorithm greedy = new TspGreedyAlgorithm();
        CalculateAlghoritm calculate = new CalculateAlghoritm();
        for (int i = 0; i < pathCoordinates.getCoordinatesArray().size(); i++) {
            double lengthSinglePath = calculate.calculateLenght(greedy.generateGreedyPath(pathCoordinates, i));
            sum = sum + lengthSinglePath;
            if (lengthSinglePath < best || best == -1.0) {
                best = lengthSinglePath;
            }
            if (lengthSinglePath > worst) {
                worst = lengthSinglePath;
            }
        }
        double avarage = sum/pathCoordinates.getCoordinatesArray().size();

        ArrayList data = new ArrayList();
        data.add(best);
        data.add(worst);
        data.add(avarage);

        return data;
    }
}
