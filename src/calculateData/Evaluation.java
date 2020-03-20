package calculateData;

public class Evaluation {
    private double max;
    private double average;
    private double min;

    public Evaluation(double max, double average, double min) {
        this.max = max;
        this.average = average;
        this.min = min;
    }

    public double getMax() {
        return max;
    }
    public double getAverage() {
        return average;
    }
    public double getMin() {
        return min;
    }

    @Override
    public String toString() {
        String returnString = "";
        returnString = returnString + String.format("%-30s", " max=" + max) +
                String.format("%-30s", " average=" + average) +
                String.format("%-30s", " min=" + min);

        return returnString;
    }
}
