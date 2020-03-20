package parser;

import java.util.ArrayList;

public class Coordinates implements Cloneable {
    private ArrayList<Coordinate> coordinatesArray = new ArrayList<Coordinate>();
    private int fileType = 0;

    public Coordinates (ArrayList<Coordinate> coordinatesArray, int fileType) {
        this.coordinatesArray = coordinatesArray;
        this.fileType = fileType;
    }

    public ArrayList<Coordinate> getCoordinatesArray() {
        return coordinatesArray;
    }

    public void setCoordinatesArray(ArrayList<Coordinate> coordinatesArray) {
        this.coordinatesArray = new ArrayList<Coordinate>(coordinatesArray);
    }
    public int getFileType() {
        return fileType;
    }

    @Override
    public Coordinates clone() throws CloneNotSupportedException {
        Coordinates coordinates = new Coordinates(coordinatesArray, fileType);
        coordinates.setCoordinatesArray(coordinatesArray);
        return coordinates;
    }

    @Override
    public String toString() {
        String arrayString = "";
        for (int i = 0; i < coordinatesArray.size(); i++) {
            String text = String.format("%-15s", coordinatesArray.get(i).toString());
            arrayString = arrayString + text;
        }
        return  arrayString;
    }
}
