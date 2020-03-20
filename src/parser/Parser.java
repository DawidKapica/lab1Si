package parser;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Parser {

    private int fileType = 0;
    private static final int EUC_2D = 1;
    private static final int GEO = 2;

    public Coordinates parse(String fileName) {

        ArrayList<Coordinate> coordinatesArray = new ArrayList<>();
        try {
            InputStream resourceAsStream = Parser.class.getClassLoader().getResourceAsStream("dane/TSP/" + fileName);
            BufferedReader in = new BufferedReader(new InputStreamReader(resourceAsStream));
            String line;
            boolean NODE_COORD_SECTION = false;

            while ((line = in.readLine()) != null) {
                if (!line.equalsIgnoreCase("EOF") && !line.equalsIgnoreCase(" EOF") && !line.equals("")) {
                    if (!line.equalsIgnoreCase("NODE_COORD_SECTION") && !NODE_COORD_SECTION) {
                        if (line.replace(" ", "").equalsIgnoreCase("EDGE_WEIGHT_TYPE:EUC_2D"))
                            fileType = EUC_2D;
                        else if (line.replace(" ", "").equalsIgnoreCase("EDGE_WEIGHT_TYPE:GEO"))
                            fileType = GEO;
                    } else if (line.equalsIgnoreCase("NODE_COORD_SECTION")) {
                        NODE_COORD_SECTION = true;
                    } else {
                        StringTokenizer stringTokenizer = new StringTokenizer(line, " \t");
                        try {
                            stringTokenizer.nextToken();
                                double x = Double.valueOf(stringTokenizer.nextToken()).doubleValue();
                                double y = Double.valueOf(stringTokenizer.nextToken()).doubleValue();
                                coordinatesArray.add(new Coordinate(x, y));
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Coordinates(coordinatesArray, fileType);
    }
}
