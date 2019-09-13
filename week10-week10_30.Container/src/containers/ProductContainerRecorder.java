package containers;

/**
 *
 * @author thesh
 */
public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory ch;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        super.addToTheContainer(initialVolume);
        this.ch = new ContainerHistory();
        this.ch.add(initialVolume);
    }

    // METHOD. Prints the history in an array format
    public String history() {
        return this.ch.toString();
    }

    // METHOD. Same as method in super class Container, but adds a new situation
    // to recorded history object
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        ch.add(super.getVolume());
    }

    // METHOD. Same as method in super class Container, but adds a new situation
    // to recorded history object
    public double takeFromTheContainer(double amount) {
        double value = super.takeFromTheContainer(amount);
        ch.add(super.getVolume());
        return value;
    }

    // METHOD. Prints the history information regarding the product
    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history());
        System.out.println("Greatest product amount: " + ch.maxValue());
        System.out.println("Smallest product amount: " + ch.minValue());
        System.out.println("Average: " + ch.average());
        System.out.println("Greatest change: " + ch.greatestFluctuation());
        System.out.println("Variance: " + ch.variance());
    }
}
