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

        CalculateTsp calculateTsp = new CalculateTsp(coordinatesData, 400);
        calculateTsp.calculate(10000);



    }
}
