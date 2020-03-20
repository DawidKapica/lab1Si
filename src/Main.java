import alghoritms.TspEAInitializer;
import alghoritms.crossing.OrderedCross;
import alghoritms.mutation.InversionMutation;
import calculateData.CalculateGreedy;
import calculateData.CalculateRandom;
import calculateData.CalculateTsp;
import parser.Coordinates;
import parser.Parser;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Parser Parser = new Parser();
//        Coordinates coordinatesData = Parser.parse("berlin11_modified.tsp");
//        Coordinates coordinatesData = Parser.parse("kroA150.tsp");
        Coordinates coordinatesData = Parser.parse("berlin52.tsp");


//        CalculateGreedy calculateGreedyArray = new CalculateGreedy();
//        CalculateRandom calculateRandomArray = new CalculateRandom();
//        ArrayList greedyArray = calculateGreedyArray.calculateGreedyData(coordinatesData);
//        ArrayList randomArray = calculateRandomArray.calculateRandomData(coordinatesData, 10000);
//        System.out.println("GREEDY ALGORTHM");
//        System.out.println("best: " + greedyArray.get(0) + ", worst: " + greedyArray.get(1) + ", avg: " + greedyArray.get(2));
//        System.out.println("RANDOM ALGORTHM");
//        System.out.println("best: " + randomArray.get(0) + ", worst: " + randomArray.get(1) + ", avg: " + randomArray.get(2));



        CalculateTsp calculateTsp = new CalculateTsp(coordinatesData, 200);
        calculateTsp.calculate(100000);

        TspEAInitializer tspEAInitializer = new TspEAInitializer();
        ArrayList<Coordinates> coordinatesArrayList = new ArrayList<Coordinates>();
        coordinatesArrayList = tspEAInitializer.initialize(coordinatesData, 100);




//        for (int i = 0; i < coordinatesArrayList.size(); i++) {
//            System.out.print(coordinatesArrayList.get(i).toString());
//            System.out.print("__");
//
//        }
//        System.out.println(coordinatesArrayList.get(0));
//        System.out.println();
//        System.out.println();
//        System.out.println(coordinatesArrayList.get(1));
//        System.out.println();
//        System.out.println("_______");







//        OrderedCross orderedCross = new OrderedCross();
//        Coordinates x = orderedCross.cross(coordinatesArrayList.get(0), coordinatesArrayList.get(1));
//        System.out.println(coordinatesArrayList.get(0));
//        System.out.println();
//        System.out.println();
//        System.out.println(coordinatesArrayList.get(1));
//        System.out.println();
//        System.out.println();
////        for(int i = 0; i < coordinatesArrayList.size(); i++) {
////            System.out.println(coordinatesArrayList.get(i).getCoordinatesArray().size());
////        }
//        System.out.print(x);

//        InversionMutation inversionMutation = new InversionMutation();
//        System.out.println(coordinatesArrayList.get(0));
//
//        Coordinates x = inversionMutation.mutation(coordinatesArrayList.get(0));
//        System.out.println(x);
    }
}
