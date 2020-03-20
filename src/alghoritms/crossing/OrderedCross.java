package alghoritms.crossing;

import parser.Coordinate;
import parser.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class OrderedCross implements CrossingAlghoritm {

    public Coordinates cross(Coordinates firstParent, Coordinates secondParent) {
        int indexFirstElement= (int)(Math.random() * (firstParent.getCoordinatesArray().size()));
        int indexSecondElement= (int)(Math.random() * (firstParent.getCoordinatesArray().size()));

        if (indexFirstElement > indexSecondElement) {
            int temp = indexFirstElement;
            indexFirstElement = indexSecondElement;
            indexSecondElement = temp;
        }

        try {
            Coordinates copyFirst = firstParent.clone();
            Coordinates copySecond = secondParent.clone();
            List<Coordinate> subList = copyFirst.getCoordinatesArray().subList(indexFirstElement, indexSecondElement);
            copySecond.getCoordinatesArray().removeAll(subList);

            for(int i = 0; i < indexFirstElement; i++) {
                subList.add(i, copySecond.getCoordinatesArray().get(0));
                copySecond.getCoordinatesArray().remove(0);
            }
            subList.addAll(copySecond.getCoordinatesArray());

            ArrayList<Coordinate> doZwrotu = new ArrayList<Coordinate>(subList);
            Coordinates crossCoordinates = new Coordinates(doZwrotu, firstParent.getFileType());
            return  crossCoordinates;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        return null;
    }
}
