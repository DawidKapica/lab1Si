package alghoritms.selection;

import alghoritms.CalculateAlghoritm;
import parser.Coordinates;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RouletteSelection implements SelectionAlghoritm{
    private final static int pressure = 6;
    @Override
    public Coordinates selection (ArrayList<Coordinates> pop) {
        CalculateAlghoritm calculateAlghoritm = new CalculateAlghoritm();

        ArrayList<Double> fitness = new ArrayList<Double>();
        ArrayList fitnessArrayToPrint = new ArrayList<>();

        double sumFitness = 0;

        double elementFitness = calculateAlghoritm.calculateLenght(pop.get(0));
//        List<Double> fitn = pop.stream().map(CalculateAlghoritm::calculateLenght).collect(Collectors.toList())
        double element = 1/Math.pow(elementFitness, pressure);


        fitness.add(element);
        sumFitness = sumFitness + element;
        fitnessArrayToPrint.add(elementFitness);


        for(int i = 1; i<pop.size(); i++) {
//            elementFitness = calculateAlghoritm.calculateLenght(pop.get(i));
            element = 1/Math.pow(elementFitness, pressure);
            sumFitness = sumFitness + element;
            fitness.add(element);
            fitnessArrayToPrint.add(elementFitness);
        }
        double rouletteNumber = Math.random();

        fitness.set(0, (fitness.get(0)/sumFitness));

        for(int i = 1; i < fitness.size(); i++) {
            fitness.set(i, (fitness.get(i)/sumFitness+fitness.get(i-1)));
        }



        if (rouletteNumber <= fitness.get(0)) {
            return new Coordinates(pop.get(0).getCoordinatesArray(), pop.get(0).getFileType());
        } else {
            for(int i = 1; i < fitness.size(); i++) {
                if (rouletteNumber < fitness.get(i) && rouletteNumber > fitness.get(i-1)) {
                    return new Coordinates(pop.get(i).getCoordinatesArray(), pop.get(i).getFileType());
                }
            }
        }

        return new Coordinates(pop.get(pop.size()-1).getCoordinatesArray(), pop.get(pop.size()-1).getFileType());
    }

}
