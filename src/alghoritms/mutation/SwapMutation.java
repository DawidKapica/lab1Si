package alghoritms.mutation;

import parser.Coordinate;
import parser.Coordinates;

public class SwapMutation implements MutationAlghoritm {

    public Coordinates mutation (Coordinates coordinates) {
        int indexFirstElement = (int) (Math.random() * (coordinates.getCoordinatesArray().size()));
        int indexSecondElement = (int) (Math.random() * (coordinates.getCoordinatesArray().size()));

        if (indexFirstElement > indexSecondElement) {
            int temp = indexFirstElement;
            indexFirstElement = indexSecondElement;
            indexSecondElement = temp;
        }

        Coordinates copy = null;
        try {
            copy = coordinates.clone();
            Coordinate temp = coordinates.getCoordinatesArray().get(indexFirstElement);
            copy.getCoordinatesArray().set(indexFirstElement, copy.getCoordinatesArray().get(indexSecondElement));
            copy.getCoordinatesArray().set(indexSecondElement, temp);

            return copy;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return copy;
    }
}