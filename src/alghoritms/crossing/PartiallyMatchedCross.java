package alghoritms.crossing;

import javafx.scene.Parent;
import parser.Coordinate;
import parser.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class PartiallyMatchedCross implements CrossingAlghoritm {
//    @Override
//    public ArrayList<Coordinates> cross (Coordinates firstParent, Coordinates secondParent) {
//        return null;
//    }

    //METODA DO POPRAWIENIA

    @Override
    public ArrayList<Coordinates> cross (Coordinates firstParent, Coordinates secondParent) {
        int indexFirstElement= (int)(Math.random() * (firstParent.getCoordinatesArray().size()));
        int indexSecondElement= (int)(Math.random() * (firstParent.getCoordinatesArray().size()));


        if (indexFirstElement > indexSecondElement) {
            int temp = indexFirstElement;
            indexFirstElement = indexSecondElement;
            indexSecondElement = temp;
        }

        System.out.println(indexFirstElement);
        System.out.println(indexSecondElement);

        List<Coordinate> sublistFirst = firstParent.getCoordinatesArray().subList(indexFirstElement, indexSecondElement);
        List<Coordinate> sublistSecond = secondParent.getCoordinatesArray().subList(indexFirstElement, indexSecondElement);
        System.out.println(sublistFirst.toString());
        System.out.println(sublistSecond.toString());

        Coordinates firstParentCopy = null;
        Coordinates secondParentCopy = null;


        try {
            firstParentCopy = firstParent.clone();
            secondParentCopy = secondParent.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

//        for(int i = indexFirstElement; i < indexSecondElement; i++) {
////            Coordinate temp = new Coordinate(firstParent.getCoordinatesArray().get(i).getX(), firstParent.getCoordinatesArray().get(i).getY());
//
//            int ind = 0;
//            for (int j = 0; j < firstParentCopy.getCoordinatesArray().size(); j++) {
//                if (sublistSecond.get(i-indexFirstElement).getX() == firstParentCopy.getCoordinatesArray().get(j).getX()) {
//                    if(sublistSecond.get(i-indexFirstElement).getY() == firstParentCopy.getCoordinatesArray().get(j).getY()) {
//                        ind = j;
//                    }
//                }
//            }
//            Coordinate temp = new Coordinate(firstParent.getCoordinatesArray().get(i).getX(), firstParent.getCoordinatesArray().get(i).getY());
//            firstParentCopy.getCoordinatesArray().set(i, sublistSecond.get(i-indexFirstElement));
//
//            firstParentCopy.getCoordinatesArray().set(ind, temp);
//        }

        for (int i = 0; i < sublistFirst.size(); i++) {
//            Coordinate temp = new Coordinate(firstParent.getCoordinatesArray().get(i+sublistFirst.size()).getX(), firstParent.getCoordinatesArray().get(i+sublistFirst.size()).getY());
            int index = firstParent.getCoordinatesArray().indexOf(sublistSecond.get(i));
            System.out.println("index" + index);
            System.out.println("i+indexFirstElement" + i+indexFirstElement);

            firstParentCopy.getCoordinatesArray().set(index, sublistFirst.get(i));
            firstParentCopy.getCoordinatesArray().set(i+indexFirstElement, sublistSecond.get(i));

        }

        for (int i = 0; i < sublistSecond.size(); i++) {
//            Coordinate temp = new Coordinate(secondParent.getCoordinatesArray().get(i+sublistSecond.size()).getX(), secondParent.getCoordinatesArray().get(i+sublistSecond.size()).getY());
            int index = secondParent.getCoordinatesArray().indexOf(sublistSecond.get(i));

            secondParentCopy.getCoordinatesArray().set(index, sublistSecond.get(i));
            secondParentCopy.getCoordinatesArray().set(i+indexFirstElement, sublistFirst.get(i));

        }

//        for(int i = indexFirstElement; i < indexSecondElement; i++) {
//            Coordinate temp = new Coordinate(secondParent.getCoordinatesArray().get(i).getX(), secondParent.getCoordinatesArray().get(i).getY());
//            int ind = 0;
//            for (int j = 0; j < secondParentCopy.getCoordinatesArray().size(); j++) {
//                if (sublistFirst.get(i-indexFirstElement).getX() == secondParentCopy.getCoordinatesArray().get(j).getX()) {
//                    if(sublistFirst.get(i-indexFirstElement).getY() == secondParentCopy.getCoordinatesArray().get(j).getY()) {
//                        ind = j;
//                    }
//                }
//            }
//            secondParentCopy.getCoordinatesArray().set(i, sublistFirst.get(i-indexFirstElement));
//            secondParentCopy.getCoordinatesArray().set(ind, temp);
//        }

        ArrayList<Coordinates> coords = new ArrayList<Coordinates>();
        coords.add(firstParentCopy);
        coords.add(secondParentCopy);

        return  coords;
    }
}
