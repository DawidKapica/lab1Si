package alghoritms.selection;

import alghoritms.CalculateAlghoritm;
import parser.Coordinates;

import java.util.ArrayList;

public class RouletteSelection implements SelectionAlghoritm{
    private final static int pressure = 13;
    @Override
    public Coordinates selection (ArrayList<Coordinates> pop) {
        CalculateAlghoritm calculateAlghoritm = new CalculateAlghoritm();

        ArrayList<Double> fitness = new ArrayList<Double>();
        ArrayList fitnessArrayToPrint = new ArrayList<>();

        double sumFitness = 0;

        for(int i = 0; i<pop.size(); i++) {
            double elementFitness = calculateAlghoritm.calculateLenght(pop.get(i));
            sumFitness = sumFitness + 1/(Math.pow(elementFitness, pressure));
            fitness.add(1/Math.pow(elementFitness, pressure));
            fitnessArrayToPrint.add(elementFitness);
        }
        double rouletteNumber = Math.random();

        fitness.set(0, (fitness.get(0)/sumFitness));

        for(int i = 1; i < fitness.size(); i++) {
            fitness.set(i, (fitness.get(i)/sumFitness+fitness.get(i-1)));
        }
        if (rouletteNumber <= fitness.get(0)) {

//            System.out.println(rouletteNumber);
//            System.out.println(fitness.toString());
//            System.out.println(fitnessArrayToPrint.toString());

            return new Coordinates(pop.get(0).getCoordinatesArray(), pop.get(0).getFileType());
        } else {
            for(int i = 1; i < fitness.size(); i++) {
                if (rouletteNumber < fitness.get(i) && rouletteNumber > fitness.get(i-1)) {

//                    System.out.println(rouletteNumber);
//                    System.out.println(fitness.toString());
//                    System.out.println(fitnessArrayToPrint.toString());

                    return new Coordinates(pop.get(i).getCoordinatesArray(), pop.get(i).getFileType());
                }
            }
        }

//        System.out.println(rouletteNumber);
//        System.out.println(fitness.toString());
//        System.out.println(fitnessArrayToPrint.toString());

        return new Coordinates(pop.get(pop.size()-1).getCoordinatesArray(), pop.get(pop.size()-1).getFileType());
    }

}
