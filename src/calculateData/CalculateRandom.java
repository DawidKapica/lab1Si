package calculateData;
import parser.Coordinates;
import alghoritms.TspRandomAlghoritm;
import alghoritms.CalculateAlghoritm;

import java.util.ArrayList;

public class CalculateRandom {

    public ArrayList calculateRandomData (Coordinates pathCoordinates, int iteration) {
        double sum = 0;
        double best = -1.0;
        double worst = -1.0;

        TspRandomAlghoritm random = new TspRandomAlghoritm();
        CalculateAlghoritm calculate = new CalculateAlghoritm();
        for (int i = 0; i < iteration; i++) {
            double lengthSinglePath = calculate.calculateLenght(random.generateRandomPath(pathCoordinates));
            sum = sum + lengthSinglePath;
            if (lengthSinglePath < best || best == -1.0) {
                best = lengthSinglePath;
            }
            if (lengthSinglePath > worst) {
                worst = lengthSinglePath;
            }
        }
        double avarage = sum/iteration;

        ArrayList data = new ArrayList();
        data.add(best);
        data.add(worst);
        data.add(avarage);

        return data;
    }
}
