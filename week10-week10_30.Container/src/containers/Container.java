package containers;

public class Container {

    private double capacity;
    private double volume;

    public Container(double tilavuus) {
        if (tilavuus > 0.0) {
            this.capacity = tilavuus;
        } else {
            this.capacity = 0.0;
        }

        volume = 0.0;
    }

    public double getVolume() {
        return volume;
    }

    public double getOriginalCapacity() {
        return capacity;
    }

    //GETTER. Returns the capacity after subtracting product volume
    public double getCurrentCapacity() {
        return capacity - volume;
    }

    // METHOD. It adds the specified amount of things to the container. 
    // If the amount is negative, nothing changes; if a part of that amount fits but not the whole of it, 
    // the container is filled up and the left over is thrown away.
    public void addToTheContainer(double amount) {
        if (amount < 0) {
            return;
        }
        if (amount <= getCurrentCapacity()) {
            volume = volume + amount;
        } else {
            volume = capacity;
        }
    }

    // METHOD.  take the specified amount form the container, the method returns what we receive. 
    // If the specified amount is negative, nothing happens and zero is returned. 
    // If we ask for more than what there is in the container, the method returns all the contents.
    public double takeFromTheContainer(double amount) {
        if (amount < 0) {
            return 0.0;
        }
        if (amount > volume) {
            double everything = volume;
            volume = 0.0;
            return everything;
        }

        volume = volume - amount;
        return amount;
    }

    @Override
    public String toString() {
        return "volume = " + volume + ", free space " + getCurrentCapacity();
    }
}
