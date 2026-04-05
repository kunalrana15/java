
// Abstraction through abstract class
abstract class TV {
    abstract void turnOn();
    abstract void turnOff();
}


class TVRemote extends TV{

    @Override
    void turnOn(){
        System.out.println("TV is turned on");
    }

    @Override
    void turnOff(){
        System.out.println("TV is turned off");
    }
}

abstract class Shape{
    String color;

    // abstract methods
    abstract double area();
    public abstract String toString();

    // abstract class constructor
    public Shape(String color){
        System.out.println("Shape constructor called:");
        this.color = color;
    }

    // concrete method
    public String getColor(){
        return color;
    }
}

class Circle extends Shape{
    double radius;

    public Circle(String color,double radius){
        // calling the shape constructor defined in abstract class
        super(color);
        System.out.println("Circle constructor called");
        this.radius = radius;
    }

    @Override double area(){
        return Math.PI * Math.pow(radius, 2);
    }

    @Override public String toString(){
        return "Circle Color is:" + super.getColor() + "and area is: " + area();
    }
}

class Rectangle extends Shape{
    double length;
    double breadth;

    public Rectangle(String color,double length,double breadth){
        super(color);
        System.out.println("Rectangle Constructor called");
        this.length = length;
        this.breadth = breadth;
    }

    @Override double area(){
        return length*breadth;
    }

    @Override public String toString(){
        return "Rectangle Color is:" + super.getColor() + "and area is: " + area();
    }
}


// Abstraction through using interface
interface Payment {
    void processPayment();
    void getAmount();
}

class StripePayment implements Payment{

    double amount;

    public StripePayment(double amount){
        this.amount = amount;
    }

    public void processPayment(){
        System.out.println("Process Payment through Stripe Gateway");
    }

    public void getAmount(){
        System.out.println("Payable Amount is:" + amount);
    }
}

class PaypalPayment implements Payment{

    double amount;

    public PaypalPayment(double amount){
        this.amount = amount;
    }

    public void processPayment(){
        System.out.println("Process Payment through Paypal Gateway");
    }

    public void getAmount(){
        System.out.println("Payable Amount is:" + amount);
    }
}

class RazorpayPayment implements Payment{

    double amount;

    public RazorpayPayment(double amount){
        this.amount = amount;
    }

    public void processPayment(){
        System.out.println("Process Payment through Razorpay Gateway");
    }

    public void getAmount(){
        System.out.println("Payable Amount is:" + amount);
    }
}

public class AbstractionJava {
    public static void main(String[] args){
        TV remote = new TVRemote();
        remote.turnOff();
        remote.turnOn();

        Rectangle r = new Rectangle("Red",5.2,4.1);
        System.out.println(r.toString());

        Circle c = new Circle("White", 7);
        System.out.println(c.toString());

        Payment rz = new RazorpayPayment(45.50);
        rz.processPayment();
        rz.getAmount();

        Payment sp = new StripePayment(48.50);
        sp.processPayment();
        sp.getAmount();

        Payment pp = new PaypalPayment(47.55);
        pp.processPayment();
        pp.getAmount();
    }
}