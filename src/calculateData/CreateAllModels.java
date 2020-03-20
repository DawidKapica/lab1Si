package calculateData;

import alghoritms.TspEAInitializer;
import alghoritms.crossing.CrossingAlghoritm;
import alghoritms.crossing.OrderedCross;
import alghoritms.crossing.PartiallyMatchedCross;
import alghoritms.mutation.InversionMutation;
import alghoritms.mutation.MutationAlghoritm;
import alghoritms.mutation.SwapMutation;
import alghoritms.selection.RouletteSelection;
import alghoritms.selection.TournamentSelection;
import parser.Coordinates;
import parser.Parser;

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
    public void generate() {



    }
}
