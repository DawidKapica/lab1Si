package calculateData;

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
import parser.Coordinates;
import parser.Parser;
import parser.WriterToCsv;

import java.io.IOException;
import java.util.ArrayList;

public class CreateAllModels {

    OrderedCross orderedCross = new OrderedCross();
    PartiallyMatchedCross partiallyMatchedCross = new PartiallyMatchedCross();
    InversionMutation inversionMutation = new InversionMutation();
    SwapMutation swapMutation = new SwapMutation();
    RouletteSelection rouletteSelection = new RouletteSelection();


    Parser Parser = new Parser();
    Coordinates coordinatesBerlin11 = Parser.parse("berlin11_modified.tsp");
    Coordinates coordinatesBerlin52 = Parser.parse("berlin52.tsp");
    Coordinates coordinatesKroA100 = Parser.parse("kroA100.tsp");
    Coordinates coordinatesKroA150 = Parser.parse("kroA150.tsp");
    Coordinates coordinatesKroA200 = Parser.parse("kroA200.tsp");


    TspEAInitializer tspEAInitializer = new TspEAInitializer();
    public void generate(SelectionAlghoritm selectionAlghoritm, CrossingAlghoritm crossingAlghoritm, MutationAlghoritm mutationAlghoritm) {

        ArrayList<Coordinates> parseCoordinatesArray = new ArrayList<Coordinates>();
//        parseCoordinatesArray.add(coordinatesBerlin11);
//        parseCoordinatesArray.add(coordinatesBerlin52);
        parseCoordinatesArray.add(coordinatesKroA100);
//        parseCoordinatesArray.add(coordinatesKroA150);
//        parseCoordinatesArray.add(coordinatesKroA200);
        WriterToCsv writerToCsvBest = new WriterToCsv("Wyniki najlesze");

        //for dla parseCoordinatesArray
        for(int i = 0; i< parseCoordinatesArray.size(); i++) {
            WriterToCsv writerToCsv = new WriterToCsv("Wyniki dla " + i);


            double min = Double.MAX_VALUE;
            int popSizeBest = Integer.MAX_VALUE;
            int NBest = Integer.MAX_VALUE;
            double PmBest = Integer.MAX_VALUE;
            double PxBest = Integer.MAX_VALUE;
            int numberIterationBest = Integer.MAX_VALUE;
            Evaluation evaluationBest = null;

            //for dla population Size
            for (int popSize = 20; popSize < 1200; popSize = popSize + 150) {
                //for dla numberOfIndividualsTournament
//                for (double N = popSize*0.1; N < 0.3 * popSize; N = N + 0.1 * popSize) {
                double N = 0.3*popSize;
                    if (N < popSize/2 && N != 0) {
//                    for dla PX
                        for (double Pm = 0.05; Pm < 0.21; Pm = Pm + 0.05) {
                            //for dla PM
                            for (double Px = 0.6; Px < 0.91; Px = Px + 0.1) {
                                //for dla numberIteration
//                                for (int numberIteration = 500; numberIteration < 5000; numberIteration = numberIteration + 850) {
                                int numberIteration = 1000;
                                    CalculateTsp calculateTsp = new CalculateTsp(parseCoordinatesArray.get(i), popSize);
                                    calculateTsp.setCsvFileName("OrderedCross;InversionMutation;TournamentSelection;" + i + ";popSize=" + popSize + ";N=" + N + ";Px=" + ".csv");
                                    calculateTsp.setSelectionAlghoritm(new TournamentSelection((int)N));
                                    calculateTsp.setCrossingAlghoritm(crossingAlghoritm);

                                    calculateTsp.setMutationAlghoritm(mutationAlghoritm);
                                    calculateTsp.setCrossoverPx(Px);
                                    calculateTsp.setMutationPM(Pm);
                                    calculateTsp.setNumberOfIndividualsForSelection((int)N);
                                    Evaluation evaluation = calculateTsp.calculate(numberIteration).get(numberIteration - 1);
                                    String wynik = String.format("%-18s", "plik:" + i) +
                                            String.format("%-15s", ", popSize:" + popSize) +
                                            String.format("%-17s", ", N:" + N) +
                                            String.format("%-35s", ", Pm:" + Pm) +
                                            String.format("%-35s", ", Px: " + Px) +
                                            String.format("%-17s", ", gen:" + numberIteration) +
                                            String.format("%-40s", ", evalLast:" + evaluation);
                                    writerToCsv.addTextToConvert(wynik);
                                    if (evaluation.getMin() < min) {
                                        min = evaluation.getMin();
                                        popSizeBest = popSize;
                                        NBest = (int)N;
                                        PmBest = Pm;
                                        PxBest = Px;
                                        numberIterationBest = numberIteration;
                                        evaluationBest = evaluation;
                                        writerToCsvBest.addTextToConvert(wynik);
                                        System.out.println(wynik);
                                    }
//                                System.out.println(wynik);
//                                }
                            }
                            System.out.println("PROCENT WYKONANIA N: " + N + " PROCENT WYKONANIA POPSIZE " + popSize + " PROCENT WYKONANIA PM " + Pm);
                        }
                        System.out.println("PROCENT WYKONANIA N: " + N + "PROCENT WYKONANIA POPSIZE" + popSize );
                    } else {
                        System.out.println("POMINIETE N: " + N + "POMINIETE POPSIZE" + popSize );
//                    }

                }
            }
            System.out.println("Zakończono plik 1");
            writerToCsvBest.addTextToConvert("NAJLEPSZY");
            String wynik = String.format("%-18s", "plik:" + i) +
                    String.format("%-15s", ", popSizeBest:" + popSizeBest) +
                    String.format("%-17s", ", NBest:" + NBest) +
                    String.format("%-10s", ", PmBest:" + PmBest) +
                    String.format("%-35s", ", PxBest: " + PxBest) +
                    String.format("%-17s", ", genBest:" + numberIterationBest) +
                    String.format("%-40s", ", evalLastBest:" + evaluationBest);
            writerToCsvBest.addTextToConvert(wynik);
            System.out.println(wynik);

            try {
                writerToCsv.createCsv();
                writerToCsvBest.createCsv();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
