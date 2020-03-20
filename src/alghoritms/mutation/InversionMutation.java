package alghoritms.mutation;

import parser.Coordinate;
import parser.Coordinates;

import java.util.Collections;
import java.util.List;

public class InversionMutation implements MutationAlghoritm {

    public Coordinates mutation(Coordinates coordinates) {
        int indexFirstElement= (int)(Math.random() * (coordinates.getCoordinatesArray().size()));
        int indexSecondElement= (int)(Math.random() * (coordinates.getCoordinatesArray().size()));

        if (indexFirstElement > indexSecondElement) {
            int temp = indexFirstElement;
            indexFirstElement = indexSecondElement;
            indexSecondElement = temp;
        }

//        try {
//            Coordinates copy = coordinates.clone();
//            List<Coordinate> subList = coordinates.getCoordinatesArray().subList(indexFirstElement, indexSecondElement);
//            copy.getCoordinatesArray().removeAll(subList);
//            Collections.reverse(subList);
//            copy.getCoordinatesArray().addAll(indexFirstElement, subList);
//            return copy;
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }

        Coordinates copy = null;
        try {
            copy = coordinates.clone();
            Coordinate temp;
            while (indexFirstElement <= indexSecondElement){
                temp = copy.getCoordinatesArray().get(indexFirstElement);
                copy.getCoordinatesArray().set(indexFirstElement, copy.getCoordinatesArray().get(indexSecondElement));
                copy.getCoordinatesArray().set(indexSecondElement, temp);
                indexFirstElement++;
                indexSecondElement--;
            }


//            //zamieniane są w pętli indexy first z second dlatego w if second odpowiada first i odwrotnie
//            if (indexSecondElement == 0) {
//                copy.getCoordinatesArray().set(coordinates.getCoordinatesArray().size()-1, copy.getCoordinatesArray().get(0));
//            }
//            if (indexFirstElement == coordinates.getCoordinatesArray().size() - 1) {
//                copy.getCoordinatesArray().set(0, copy.getCoordinatesArray().get(coordinates.getCoordinatesArray().size()-1));
//            }

            return copy;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
