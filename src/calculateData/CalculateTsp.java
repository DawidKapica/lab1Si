package calculateData;

import alghoritms.CalculateAlghoritm;
import alghoritms.TspEAInitializer;
import alghoritms.crossing.CrossingAlghoritm;
import alghoritms.crossing.OrderedCross;
import alghoritms.mutation.InversionMutation;
import alghoritms.mutation.MutationAlghoritm;
import alghoritms.selection.SelectionAlghoritm;
import alghoritms.selection.TournamentSelection;
import parser.Coordinate;
import parser.Coordinates;

import java.util.ArrayList;

public class CalculateTsp {

    private TspEAInitializer tspEAInitializer;
    private CalculateAlghoritm calculateAlghoritm;
    private Coordinates mapCoordinate;

    private Coordinates bestCoordinates;
    private final double crossoverPx = 0.7;
    private final double mutationPM = 0.1;
    private int numberOfIndividualsForSelection = 40;
    private int populationSize;

    private CrossingAlghoritm crossingAlghoritm;
    private MutationAlghoritm mutationAlghoritm;
    private SelectionAlghoritm selectionAlghoritm;

    public CalculateTsp(Coordinates mapCoordinates, int populationSize) {
        tspEAInitializer = new TspEAInitializer();
        calculateAlghoritm = new CalculateAlghoritm();

        this.mapCoordinate = mapCoordinates;
        this.populationSize = populationSize;

        selectionAlghoritm = new TournamentSelection(numberOfIndividualsForSelection);
        crossingAlghoritm = new OrderedCross();
        mutationAlghoritm = new InversionMutation();
    }

    public void calculate(int numberOfIteration) {
        ArrayList<Coordinates> newPopulation = tspEAInitializer.initialize(mapCoordinate, populationSize);
        ArrayList<Coordinates> oldPopulation = new ArrayList<Coordinates>(newPopulation);

        ArrayList<Evaluation> evaluationArrayList = new ArrayList<Evaluation>();
        for (int i = 0; i < numberOfIteration; i++) {
//            ArrayList<Coordinates> selectedIndividuals = select(oldPopulation);
//            ArrayList<Coordinates> crossedIndividuals = cross(selectedIndividuals);
//            ArrayList<Coordinates> mutatedIndividuals = mutate(crossedIndividuals);

//            Evaluation evaluate = evaluate(mutatedIndividuals);
//            evaluationArrayList.add(evaluate);
//            initializePopulation = mutatedIndividuals;
//            newPopulation.addAll(mutatedIndividuals);
//            newPopulation.removeAll(selectedIndividuals);
//            mutatedIndividuals = fillPopulation(mutatedIndividuals, selectedIndividuals);
//            oldPopulation = newPopulation;
//            System.out.println(newPopulation.size());


            newPopulation = generateNewPopulation(oldPopulation);
            oldPopulation = newPopulation;

            Evaluation evaluate = evaluate(newPopulation);
            System.out.println(evaluate);


        }
    }

    private ArrayList<Coordinates> generateNewPopulation(ArrayList<Coordinates> oldPopulation) {
        ArrayList<Coordinates> coordinatesArrayList = new ArrayList<Coordinates>();
        ArrayList<Coordinates> selectedIndividuals = select(oldPopulation);
        ArrayList<Coordinates> crossedIndividuals = cross(selectedIndividuals);
//        ArrayList<Coordinates> mutatedIndividuals = mutate(crossedIndividuals);
        coordinatesArrayList.addAll(crossedIndividuals);
        ArrayList<Coordinates> correct = fillPopulationCorrect(coordinatesArrayList, oldPopulation);
        ArrayList<Coordinates> mutatedIndividuals = mutate(correct);


        return  mutatedIndividuals;

    }

    private ArrayList<Coordinates> fillPopulation(ArrayList<Coordinates> newPopulation, ArrayList<Coordinates> oldPopulation){
        ArrayList<Coordinates> fillArray = new ArrayList<Coordinates>(oldPopulation);

        while (fillArray.size() < populationSize){
//            fillArray.add(oldPopulation.get((int)(Math.random() * oldPopulation.size()-1)));
            fillArray.add(selectionAlghoritm.selection(oldPopulation));

        }
        return fillArray;
    }

    private ArrayList<Coordinates> fillPopulationCorrect(ArrayList<Coordinates> newPopulation, ArrayList<Coordinates> oldPopulation) {
        ArrayList<Coordinates> correct = new ArrayList<Coordinates>(newPopulation);
        while (newPopulation.size() < populationSize) {
            newPopulation.add(findBest(oldPopulation));
        }
        return correct;
    }

    private Coordinates findBest(ArrayList<Coordinates> population) {
        double length = calculateAlghoritm.calculateLenght(population.get(0));
        Coordinates best = population.get(0);

        for(int i = 1; i < population.size(); i++) {
            double lengthSearch = calculateAlghoritm.calculateLenght(population.get(i));
            if (lengthSearch < length) {
                length = lengthSearch;
                best = population.get(i);
            }
        }

        return best;
    }

    public ArrayList<Coordinates> select(ArrayList<Coordinates> population) {
        ArrayList<Coordinates> coordinatesArrayList = new ArrayList<Coordinates>();
        for (int i = 0; i < numberOfIndividualsForSelection; i++) {
            coordinatesArrayList.add(selectionAlghoritm.selection(population));
        }
        return coordinatesArrayList;
    }



    private ArrayList<Coordinates> cross(ArrayList<Coordinates> selectedIndividuals) {
        ArrayList<Coordinates> crossedIndividuals = new ArrayList<Coordinates>();
        for(int i = 0; i < selectedIndividuals.size() ; i++){
            int randomIndex = (int) (Math.random()*selectedIndividuals.size());
            if(Math.random() <= crossoverPx){
                crossedIndividuals.add(crossingAlghoritm.cross(selectedIndividuals.get(randomIndex), selectedIndividuals.get(i)));
            }else{
                crossedIndividuals.add(selectedIndividuals.get(i));
            }
        }
        return crossedIndividuals;
    }

    private ArrayList<Coordinates> mutate(ArrayList<Coordinates> population) {
        ArrayList<Coordinates> mutatedList = new ArrayList<Coordinates>();
        for (int i = 0; i < population.size(); i++) {
            if (Math.random() <= mutationPM)
                mutatedList.add(mutationAlghoritm.mutation(population.get(i)));
            else
                mutatedList.add(population.get(i));
        }
        return mutatedList;
    }

    private Evaluation evaluate(ArrayList<Coordinates> population) {
        double average = 0;
        double min = Double.MAX_VALUE;
        double max = 0;

        for (int i = 0; i < population.size() - 1; i++) {
            double route = calculateAlghoritm.calculateLenght(population.get(i));
            average = average + route;
            if (route < min) {
                min = route;
            }
            if (route > max) {
                max = route;
            }
        }


        average = average / populationSize;
        return new Evaluation(max, average, min);
    }
}
