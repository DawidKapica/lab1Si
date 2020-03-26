package alghoritms.selection;

import alghoritms.CalculateAlghoritm;
import parser.Coordinates;

import java.util.ArrayList;

public class TournamentSelection implements SelectionAlghoritm {

    private int N;
    CalculateAlghoritm calculateAlghoritm;

    public TournamentSelection(int N) {
        this.N = N;
        calculateAlghoritm = new CalculateAlghoritm();
    }

//    public TournamentSelection() {
//
//    }

    public Coordinates selection(ArrayList<Coordinates> pop) {
        ArrayList<Coordinates> nCoordinates = new ArrayList<Coordinates>();
        ArrayList<Coordinates> copy = new ArrayList<Coordinates>(pop);
        for(int i = 0; i < N; i++) {
            int index = (int)(Math.random()*(copy.size()));
            nCoordinates.add(copy.get(index));
            copy.remove(index);
        }

        Coordinates bestCoordinates = nCoordinates.get(0);
        double bestRoute = calculateAlghoritm.calculateLenght(bestCoordinates);

        for(int i = 1; i < nCoordinates.size()-1; i++) {
            double length = calculateAlghoritm.calculateLenght(nCoordinates.get(i));
            if (length < bestRoute) {
                bestCoordinates = nCoordinates.get(i);
                bestRoute = length;
            }
        }

        return bestCoordinates;
    }

    public int getN () {
        return N;
    }

    public void setN (int n) {
        N = n;
    }
}
