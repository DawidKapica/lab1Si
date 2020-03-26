package calculateData;

import alghoritms.CalculateAlghoritm;
import alghoritms.TspEAInitializer;
import alghoritms.crossing.CrossingAlghoritm;
import alghoritms.crossing.OrderedCross;
import alghoritms.crossing.PartiallyMatchedCross;
import alghoritms.mutation.InversionMutation;
import alghoritms.mutation.MutationAlghoritm;
import alghoritms.mutation.SwapMutation;
import alghoritms.selection.RouletteSelection;
import alghoritms.selection.SelectionAlghoritm;
import alghoritms.selection.TournamentSelection;
import parser.Coordinate;
import parser.Coordinates;
import parser.WriterToCsv;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;

public class CalculateTsp {

    private TspEAInitializer tspEAInitializer;
    private CalculateAlghoritm calculateAlghoritm;
    private Coordinates mapCoordinate;

    private double crossoverPx = 0.7;

    private double mutationPM = 0.55;
    private int numberOfIndividualsForSelection = 60;
    private int populationSize;

    private CrossingAlghoritm crossingAlghoritm;
    private MutationAlghoritm mutationAlghoritm;
    private SelectionAlghoritm selectionAlghoritm;

    private String csvFileName = "ExampleFileName.csv";

    private WriterToCsv writer;

    public CalculateTsp(Coordinates mapCoordinates, int populationSize) {
        tspEAInitializer = new TspEAInitializer();
        calculateAlghoritm = new CalculateAlghoritm();

        this.mapCoordinate = mapCoordinates;
        this.populationSize = populationSize;

//        selectionAlghoritm = new TournamentSelection(numberOfIndividualsForSelection);
        selectionAlghoritm = new RouletteSelection();
//        crossingAlghoritm = new OrderedCross();
        crossingAlghoritm = new PartiallyMatchedCross();
        mutationAlghoritm = new InversionMutation();

        this.writer = new WriterToCsv();
    }



    public ArrayList<Evaluation> calculate(int numberOfIteration) {
        ArrayList<Coordinates> newPopulation = tspEAInitializer.initialize(mapCoordinate, populationSize);
//        System.out.println(mapCoordinate.getCoordinatesArray().size());
        ArrayList<Coordinates> oldPopulation = new ArrayList<Coordinates>(newPopulation);

        ArrayList<Evaluation> evaluationArrayList = new ArrayList<Evaluation>();
        for (int i = 0; i < numberOfIteration; i++) {

            newPopulation = generateNewPopulation(oldPopulation);
            oldPopulation = newPopulation;

            Evaluation evaluate = evaluate(newPopulation);
            String toPrint = String.format("%-10s", i) + ";" + String.format("%-20s", evaluate.getMax()) + ";" + String.format("%-20s", evaluate.getAverage()) + ";" + String.format("%-20s", evaluate.getMin());
            writer.addTextToConvert(i + ";" + evaluate.getMax() + ";" + evaluate.getAverage() + ";" + evaluate.getMin());
            evaluationArrayList.add(evaluate);
            System.out.println(evaluate);
        }

        try{
            writer.createCsv();
        } catch (IOException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        return evaluationArrayList;
    }

    private ArrayList<Coordinates> generateNewPopulation(ArrayList<Coordinates> oldPopulation) {
        ArrayList<Coordinates> coordinatesArrayList = new ArrayList<Coordinates>();
        ArrayList<Coordinates> selectedIndividuals = select(oldPopulation);
        ArrayList<Coordinates> crossedIndividuals = cross(selectedIndividuals);
        ArrayList<Coordinates> mutatedIndividuals = mutate(crossedIndividuals);
        coordinatesArrayList.addAll(mutatedIndividuals);
        ArrayList<Coordinates> correct = fillPopulationCorrect(coordinatesArrayList, oldPopulation);

        return  correct;
    }

    private ArrayList<Coordinates> fillPopulationCorrect(ArrayList<Coordinates> newPopulation, ArrayList<Coordinates> oldPopulation) {
        ArrayList<Coordinates> correct = new ArrayList<Coordinates>(newPopulation);
        while (correct.size() < populationSize) {
            correct.add(findBest(oldPopulation));
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
        ArrayList<Coordinates> copy = new ArrayList<Coordinates>(population);
        for (int i = 0; i < numberOfIndividualsForSelection; i++) {
            Coordinates coords = selectionAlghoritm.selection(copy);
            coordinatesArrayList.add(coords);
            copy.remove(coords);
        }
        return coordinatesArrayList;
    }

    private ArrayList<Coordinates> cross(ArrayList<Coordinates> selectedIndividuals) {
        ArrayList<Coordinates> crossedIndividuals = new ArrayList<Coordinates>();
        for(int i = 0; i < selectedIndividuals.size() ; i++){
            int randomIndex = 0;
            while (randomIndex == i) {
                randomIndex = (int) (Math.random()*selectedIndividuals.size());
            }
            if(Math.random() <= crossoverPx) {
                ArrayList<Coordinates> coords = new ArrayList<Coordinates>(crossingAlghoritm.cross(selectedIndividuals.get(randomIndex), selectedIndividuals.get(i)));
                crossedIndividuals.addAll(coords);

            } else {
                crossedIndividuals.addAll(selectedIndividuals);
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

        for (int i = 0; i < population.size(); i++) {
            double route = calculateAlghoritm.calculateLenght(population.get(i));
            average = average + route;
            if (route < min) {
                min = route;
            }
            if (route > max) {
                max = route;
            }
        }
        System.out.println(population.size());
        average = average / population.size();
        return new Evaluation(max, average, min);
    }

    public void setCsvFileName(String fileName) {
        this.csvFileName = fileName;
    }

    public Coordinates getMapCoordinate () {
        return mapCoordinate;
    }

    public void setMapCoordinate (Coordinates mapCoordinate) {
        this.mapCoordinate = mapCoordinate;
    }

    public double getCrossoverPx () {
        return crossoverPx;
    }

    public double getMutationPM () {
        return mutationPM;
    }

    public int getNumberOfIndividualsForSelection () {
        return numberOfIndividualsForSelection;
    }

    public void setNumberOfIndividualsForSelection (int numberOfIndividualsForSelection) {
        this.numberOfIndividualsForSelection = numberOfIndividualsForSelection;
    }

    public int getPopulationSize () {
        return populationSize;
    }

    public void setPopulationSize (int populationSize) {
        this.populationSize = populationSize;
    }

    public CrossingAlghoritm getCrossingAlghoritm () {
        return crossingAlghoritm;
    }

    public void setCrossingAlghoritm (CrossingAlghoritm crossingAlghoritm) {
        this.crossingAlghoritm = crossingAlghoritm;
    }

    public MutationAlghoritm getMutationAlghoritm () {
        return mutationAlghoritm;
    }

    public void setMutationAlghoritm (MutationAlghoritm mutationAlghoritm) {
        this.mutationAlghoritm = mutationAlghoritm;
    }

    public SelectionAlghoritm getSelectionAlghoritm () {
        return selectionAlghoritm;
    }

    public void setSelectionAlghoritm (SelectionAlghoritm selectionAlghoritm) {
        this.selectionAlghoritm = selectionAlghoritm;
    }

    public void setCrossoverPx (double crossoverPx) {
        this.crossoverPx = crossoverPx;
    }

    public void setMutationPM (double mutationPM) {
        this.mutationPM = mutationPM;
    }

}
