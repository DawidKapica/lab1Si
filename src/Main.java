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
        Coordinates coordinatesDataKroA100 = Parser.parse("kroA100.tsp");
        Coordinates coordinatesDataKroA200 = Parser.parse("kroA200.tsp");
        Coordinates coordinatesDatafl417 = Parser.parse("fl417.tsp");


        CalculateTsp calculateTspkroA100 = new CalculateTsp(coordinatesDataKroA100, 1000);
        CalculateTsp calculateTspkroA200 = new CalculateTsp(coordinatesDataKroA200, 1000);
        CalculateTsp calculateTspkrofl417 = new CalculateTsp(coordinatesDatafl417, 1000);



//        calculateTspkroA100.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(50));
//        calculateTspkroA100.setCsvFileName("N05kroA100.csv");                           //POWTORZYC
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(700);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(50));
//        calculateTspkroA200.setCsvFileName("N05kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(1000);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(250);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(50));
//        calculateTspkrofl417.setCsvFileName("N05fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(2000);
//
//        calculateTspkroA100.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(100));
//        calculateTspkroA100.setCsvFileName("N10kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(700);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(100));
//        calculateTspkroA200.setCsvFileName("N10kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(1000);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(250);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(100));
//        calculateTspkrofl417.setCsvFileName("N10fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(2000);
//
//
//        calculateTspkroA100.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(150));
//        calculateTspkroA100.setCsvFileName("N15kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(700);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(150));
//        calculateTspkroA200.setCsvFileName("N15kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(1000);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(250);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(150));
//        calculateTspkrofl417.setCsvFileName("N15fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(2000);
//
//        calculateTspkroA100.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(200));
//        calculateTspkroA100.setCsvFileName("N05kroA100.csv");                           //!!ZMIENIC NAZWE
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(700);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(200));
//        calculateTspkroA200.setCsvFileName("N20kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(1000);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(250);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(200));
//        calculateTspkrofl417.setCsvFileName("N20fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(2000);
//
//        calculateTspkroA100.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA100.setCsvFileName("N30kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(700);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA200.setCsvFileName("N30kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(1000);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(250);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkrofl417.setCsvFileName("N30fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(2000);
//
//        calculateTspkroA100.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(400));
//        calculateTspkroA100.setCsvFileName("N40kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(700);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(400));
//        calculateTspkroA200.setCsvFileName("N40kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(1000);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(250);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(400));
//        calculateTspkrofl417.setCsvFileName("N40fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(2000);
//
//        calculateTspkroA100.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(500));
//        calculateTspkroA100.setCsvFileName("N50kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(700);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(250);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(500));
//        calculateTspkroA200.setCsvFileName("N50kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(1000);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(250);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(500));
//        calculateTspkrofl417.setCsvFileName("N50fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(2000);



        //BADANIE NumberOfIndividualsForSelection

//        calculateTspkroA100.setNumberOfIndividualsForSelection(50);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA100.setCsvFileName("NODF50kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(400);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(50);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA200.setCsvFileName("NODF50kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(400);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(50);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkrofl417.setCsvFileName("NODF50fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(400);
//
//
//        calculateTspkroA100.setNumberOfIndividualsForSelection(100);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA100.setCsvFileName("NODF100kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(400);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(100);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA200.setCsvFileName("NODF100kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(400);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(100);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkrofl417.setCsvFileName("NODF100fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(400);
//
//        calculateTspkroA100.setNumberOfIndividualsForSelection(200);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA100.setCsvFileName("NODF200kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(400);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(200);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA200.setCsvFileName("NODF200kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(400);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(200);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkrofl417.setCsvFileName("NODF200fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(400);
//
//        calculateTspkroA100.setNumberOfIndividualsForSelection(300);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA100.setCsvFileName("NODF300kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(400);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(300);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA200.setCsvFileName("NODF300kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(400);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(300);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkrofl417.setCsvFileName("NODF300fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(400);
//
//        calculateTspkroA100.setNumberOfIndividualsForSelection(400);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA100.setCsvFileName("NODF400kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(400);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(400);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA200.setCsvFileName("NODF400kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(400);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(400);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkrofl417.setCsvFileName("NODF400fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(400);

//        calculateTspkroA100.setNumberOfIndividualsForSelection(600);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA100.setCsvFileName("NODF600SkroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(400);

//        calculateTspkroA200.setNumberOfIndividualsForSelection(600);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA200.setCsvFileName("N5ODF600kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(400);

//        calculateTspkrofl417.setNumberOfIndividualsForSelection(600);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkrofl417.setCsvFileName("NODF600fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(400);


//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen10.csv");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(10);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen20.csv");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(20);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen30.csv");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(30);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen40.csv");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(40);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen50.csv");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(50);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen100");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(100);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen150");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(150);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen200");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(200);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen250");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(250);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen300");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(300);
//
//
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen350");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(350);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen400");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(400);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen450");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(450);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen500");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(500);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen600");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(600);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen700");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(700);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen800");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(800);
//
//        calculateTsp.setNumberOfIndividualsForSelection(250);
//        calculateTsp.setMutationPM(0.15);
//        calculateTsp.setCrossoverPx(0.75);
//        calculateTsp.setSelectionAlghoritm(new TournamentSelection(250));
//        calculateTsp.setCsvFileName("gen900");
//        calculateTsp.setMutationAlghoritm(new InversionMutation());
//        calculateTsp.setCrossingAlghoritm(new OrderedCross());
//        calculateTsp.calculate(900);


        calculateTspkroA100.setNumberOfIndividualsForSelection(800);
        calculateTspkroA100.setMutationPM(0.15);
        calculateTspkroA100.setCrossoverPx(0.75);
        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(300));
        calculateTspkroA100.setCsvFileName("NODF800kroA100.csv");
        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
        calculateTspkroA100.calculate(400);

//        calculateTspkroA200.setNumberOfIndividualsForSelection(700);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA200.setCsvFileName("NODF700kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(400);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(700);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkrofl417.setCsvFileName("NODF700fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(400);

//        calculateTspkroA100.setNumberOfIndividualsForSelection(900);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA100.setCsvFileName("NODF900kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(400);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(400);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA200.setCsvFileName("NODF900kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(400);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(400);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkrofl417.setCsvFileName("NODF900fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(400);
//
//        calculateTspkroA100.setNumberOfIndividualsForSelection(1000);
//        calculateTspkroA100.setMutationPM(0.15);
//        calculateTspkroA100.setCrossoverPx(0.75);
//        calculateTspkroA100.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA100.setCsvFileName("NODF1000kroA100.csv");
//        calculateTspkroA100.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA100.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA100.calculate(400);
//
//        calculateTspkroA200.setNumberOfIndividualsForSelection(1000);
//        calculateTspkroA200.setMutationPM(0.15);
//        calculateTspkroA200.setCrossoverPx(0.75);
//        calculateTspkroA200.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkroA200.setCsvFileName("NODF1000kroA200.csv");
//        calculateTspkroA200.setMutationAlghoritm(new InversionMutation());
//        calculateTspkroA200.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkroA200.calculate(400);
//
//        calculateTspkrofl417.setNumberOfIndividualsForSelection(1000);
//        calculateTspkrofl417.setMutationPM(0.15);
//        calculateTspkrofl417.setCrossoverPx(0.75);
//        calculateTspkrofl417.setSelectionAlghoritm(new TournamentSelection(300));
//        calculateTspkrofl417.setCsvFileName("NODF1000fl417.csv");
//        calculateTspkrofl417.setMutationAlghoritm(new InversionMutation());
//        calculateTspkrofl417.setCrossingAlghoritm(new OrderedCross());
//        calculateTspkrofl417.calculate(400);

//        calculateTsp.setSelectionAlghoritm(new RouletteSelection());

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
