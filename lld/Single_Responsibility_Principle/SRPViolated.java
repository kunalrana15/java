
import java.util.ArrayList;
import java.util.List;

// Product class creation
class Product {
    public String name;
    public double price;

    public Product(String name,double price){
        this.name = name;
        this.price = price;
    }
}

// SRP Violated here because ShoppingCart is handling multiple reponsibilities
class ShoppingCart {
    private List<Product> products = new ArrayList<Product>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getProducts() {
        return products;
    }

    // calculate total price 
    public double calculateTotal() {
        double total = 0;
        for(Product p:products) {
            total += p.price;
        }
        return total;
    }

    // Violates SRP - Print invoice is in the seperate class
    public void printInvoice() {
        System.out.println("Shopping Cart Invoice:");
        for(Product p : products) {
            System.out.println(p.name + " - Rs "+p.price);
        }
        System.out.println("Total: Rs " + calculateTotal());
    }

    // Violates SRP - Saves to DB (Should be in seperate class)
    public void saveToDatabase() {
        System.out.println("Saving to DB....");
    }
}

public class SRPViolated {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Sugar",220));
        cart.addProduct(new Product("Milk",124));

        cart.printInvoice();
        cart.saveToDatabase();
    }
}