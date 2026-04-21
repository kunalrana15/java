import java.util.ArrayList;
import java.util.List;

interface Notification {
    void send(String message);
}

interface Payment {
    void processPayment(int amount);
}

interface Database {
    void saveOrder(Order order);
}

// ---------------- Notification ----------------
class EmailNotification implements Notification {
    private String emailAddress;

    public EmailNotification(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void send(String message) {
        System.out.println("Email sent to: " + emailAddress + " | " + message);
    }
}

// ---------------- Payment ----------------
class UPIPayment implements Payment {
    private String upiId;

    public UPIPayment(String upiId) {
        this.upiId = upiId;
    }

    public void processPayment(int amount) {
        System.out.println("Payment via UPI: " + upiId + " Amount: " + amount);
    }
}

// ---------------- DB ----------------
class MySqlDatabase implements Database {
    public void saveOrder(Order order) {
        System.out.println("Order saved for user: " + order.user.name + 
                           " | Amount: " + order.totalAmount);
    }
}

// ---------------- Models ----------------
class Item {
    String itemName;
    int price;

    public Item(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
    }
}

class Order {
    User user;
    List<Item> items;
    int totalAmount;

    public Order(User user, List<Item> items, int totalAmount) {
        this.user = user;
        this.items = items;
        this.totalAmount = totalAmount;
    }
}

class User {
    String name;
    String email;
    String address;
    String phoneNumber;

    public User(String name, String email, String address, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}

// ---------------- Cart ----------------
class ItemCart {
    List<Item> list = new ArrayList<>();

    public void addItem(String itemName, int price) {
        list.add(new Item(itemName, price));
    }

    public int getTotalAmount() {
        int total = 0;
        for (Item item : list) {
            total += item.price;
        }
        return total;
    }

    public List<Item> getItems() {
        return list;
    }
}

// ---------------- Service (Core Brain) ----------------
class OrderService {
    private Payment payment;
    private Notification notification;
    private Database database;

    public OrderService(Payment payment, Notification notification, Database database) {
        this.payment = payment;
        this.notification = notification;
        this.database = database;
    }

    public void placeOrder(User user, ItemCart cart) {
        int total = cart.getTotalAmount();

        // Create Order Object
        Order order = new Order(user, cart.getItems(), total);

        payment.processPayment(total);
        database.saveOrder(order);
        notification.send("Order placed successfully!");

        System.out.println("Order Completed ✅");
    }
}

// ---------------- Main ----------------
public class OrderProcessing {
    public static void main(String[] args) {

        User user = new User("Kunal", "kunal@gmail.com", "Delhi", "9999999999");

        ItemCart cart = new ItemCart();
        cart.addItem("Laptop", 50000);
        cart.addItem("Mouse", 1000);

        Payment payment = new UPIPayment("kunal@upi");
        Notification notification = new EmailNotification("kunal@gmail.com");
        Database database = new MySqlDatabase();

        OrderService orderService = new OrderService(payment, notification, database);

        orderService.placeOrder(user, cart);
    }
}