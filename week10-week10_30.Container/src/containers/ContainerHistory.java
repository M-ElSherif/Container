package containers;

import java.util.*;

public class ContainerHistory {

    private List<Double> history;      // container history array

    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }

    // METHOD. Adds the parameter situation to the end of container history
    public void add(double situation) {
        this.history.add(situation);
    }

    // METHOD. Deletes the container history records
    public void reset() {
        this.history.clear();
    }

    // METHOD. Prints the history in an array format
    public String toString() {
        return this.history.toString();
    }

    // METHOD. reutrns the greatest value in the container history. 
    // If the history is empty, the method returns 0.
    public double maxValue() {
        if (this.history.isEmpty()) {
            return 0;
        }
        double max = 0;
        for (double value : this.history) {
            if (value >= max) {
                max = value;
            }
        }
        return max;
    }

    // METHOD. reutrns the smallest value in the container history. 
    // If the history is empty, the method returns 0.
    public double minValue() {
        if (this.history.isEmpty()) {
            return 0;
        }
        double min = this.history.get(0);
        for (double value : this.history) {
            if (value <= min) {
                min = value;
            }
        }
        return min;
    }

    // METHOD. reutrns the average of the values in the container history. 
    // If the history is empty, the method returns 0.
    public double average() {
        if (this.history.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double value : this.history) {
            sum += value;
        }
        return sum / this.history.size();
    }

    // METHOD. returns the absolute value of the single greatest fluctuation in the container history (attention: a fluctuation of -5 is greater than 4). \
    // If the history is empty or it contains one value, the method returns zero. 
    // Absolute value is the distance of a number from zero
    public double greatestFluctuation() {
        if (this.history.size() <= 1) {
            return 0;
        }
        double maxFluct = 0; // max fluctuation value
        double currFluct = 0;   // current fluctuation
        for (int i = 1; i <= this.history.size() - 1; i++) {
            currFluct = Math.abs(this.history.get(i) - this.history.get(i - 1));
            if (currFluct >= maxFluct) {
                maxFluct = currFluct;
            }
        }
        return maxFluct;
    }

    // METHOD. returns the sample variance of the container history values. 
    // If the history is empty or it contains only one value, the method returns zero.
    public double variance() {
        // first get the average
        double avg = this.average();
        // next calculate the variance
        double sum = 0;
        for (double num : this.history) {
            sum += (Math.pow((num - avg), 2));
        }
        double sampleSize = this.history.size() - 1;
        double var = sum / sampleSize;  // sample variance
        return var;
    }

}
