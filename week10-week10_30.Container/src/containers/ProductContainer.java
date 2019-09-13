
package containers;

/**
 *
 * @author thesh
 */
public class ProductContainer extends Container  {
    
    private String productName;     // product's name
    
    public ProductContainer(String productName, double capacity) {
        super(capacity);
        this.productName = productName;
    }

    // GETTER
    public String getName() {
        return this.productName;
    }
    
    // SETTER
    public void setName(String newName) {
        this.productName = newName;
    }
    
    public String toString() {
        return this.productName + ": " + super.toString();
    }
    
}
