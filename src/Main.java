import alghoritms.CalculateAlghoritm;
import alghoritms.TspEAInitializer;
import alghoritms.crossing.OrderedCross;
import alghoritms.crossing.PartiallyMatchedCross;
import alghoritms.mutation.InversionMutation;
import alghoritms.mutation.SwapMutation;
import alghoritms.selection.RouletteSelection;
import calculateData.CalculateGreedy;
import calculateData.CalculateRandom;
import calculateData.CalculateTsp;
import parser.Coordinates;
import parser.Parser;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Parser Parser = new Parser();

        Coordinates coordinatesData = Parser.parse("berlin11_modified.tsp");
//        Coordinates coordinatesData = Parser.parse("berlin52.tsp");
//        Coordinates coordinatesData = Parser.parse("kroA100.tsp");
//        Coordinates coordinatesData = Parser.parse("fl417.tsp");

//        CalculateTsp calculateTsp = new CalculateTsp(coordinatesData, 400);
//        calculateTsp.calculate(10000);


        TspEAInitializer tspEAInitializer = new TspEAInitializer();
        ArrayList<Coordinates> coordinatesArrayList = new ArrayList<Coordinates>();
        coordinatesArrayList = tspEAInitializer.initialize(coordinatesData, 5);

        System.out.println(coordinatesArrayList.get(0));
        System.out.println(coordinatesArrayList.get(1));

        PartiallyMatchedCross partiallyMatchedCross = new PartiallyMatchedCross();
        ArrayList<Coordinates> x = partiallyMatchedCross.cross(coordinatesArrayList.get(0), coordinatesArrayList.get(1));

        System.out.println(x.get(0).toString());
        System.out.println(x.get(1).toString());
        System.out.println();


        System.out.println();
        System.out.println();
//        for(int i = 0; i < coordinatesArrayList.size(); i++) {
//            System.out.println(coordinatesArrayList.get(i).getCoordinatesArray().size());
//        }


    }
}
