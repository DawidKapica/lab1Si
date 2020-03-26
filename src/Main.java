import alghoritms.CalculateAlghoritm;
import alghoritms.TspEAInitializer;
import alghoritms.crossing.OrderedCross;
import alghoritms.crossing.PartiallyMatchedCross;
import alghoritms.mutation.InversionMutation;
import alghoritms.mutation.SwapMutation;
import alghoritms.selection.RouletteSelection;
import alghoritms.selection.TournamentSelection;
import calculateData.CalculateGreedy;
import calculateData.CalculateRandom;
import calculateData.CalculateTsp;
import calculateData.CreateAllModels;
import parser.Coordinates;
import parser.Parser;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


//        CreateAllModels createAllModels = new CreateAllModels();
//        createAllModels.generate(new TournamentSelection(), new OrderedCross(), new InversionMutation());
//        createAllModels.generate(new TournamentSelection(), new PartiallyMatchedCross(), new InversionMutation());
//        createAllModels.generate(new TournamentSelection(), new OrderedCross(), new SwapMutation());
//        createAllModels.generate(new TournamentSelection(), new PartiallyMatchedCross(), new SwapMutation());



        Parser Parser = new Parser();

//        Coordinates coordinatesData = Parser.parse("berlin11_modified.tsp");
//        Coordinates coordinatesData = Parser.parse("berlin52.tsp");
        Coordinates coordinatesData = Parser.parse("kroA100.tsp");
//        Coordinates coordinatesData = Parser.parse("fl417.tsp");

        CalculateTsp calculateTsp = new CalculateTsp(coordinatesData, 140);
//        calculateTsp.setNumberOfIndividualsForSelection(150);
        calculateTsp.setMutationPM(0.9);
        calculateTsp.setCrossoverPx(0.15);
//        calculateTsp.setSelectionAlghoritm(new RouletteSelection());
        calculateTsp.setSelectionAlghoritm(new TournamentSelection(50));

        calculateTsp.setMutationAlghoritm(new InversionMutation());
        calculateTsp.setCrossingAlghoritm(new OrderedCross());
        calculateTsp.calculate(1000);




//        TspEAInitializer tspEAInitializer = new TspEAInitializer();
//        ArrayList<Coordinates> coordinatesArrayList = new ArrayList<Coordinates>();
//        coordinatesArrayList = tspEAInitializer.initialize(coordinatesData, 5);
//
//        System.out.println();
//        System.out.println(coordinatesArrayList.get(0));
//        System.out.println(coordinatesArrayList.get(1));
//        System.out.println();
//
//        PartiallyMatchedCross partiallyMatchedCross = new PartiallyMatchedCross();
//        ArrayList<Coordinates> x = partiallyMatchedCross.cross(coordinatesArrayList.get(0), coordinatesArrayList.get(1));
//
//        System.out.println(x.get(0).toString());
////        System.out.println(x.get(1).toString());
//        System.out.println();
//
//
////        System.out.println();
////        System.out.println();



    }
}
