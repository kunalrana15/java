

interface Burger {
    void prepare();
}

class BasicBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty and ketchup!");
    }
}

class StandardBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettice");
    }
}

class PremiumBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing premium burger with gourmet bun, premium patty, cheese, lettice, and special sauces");
    }
}

class BurgerFactory {
    Burger createBurger(String type) {
        if(type == "basic") {
            return new BasicBurger();
        }
        else if(type == "standard") {
            return new StandardBurger();
        }
        else if(type == "premium"){
            return new PremiumBurger();
        }
        else {
            return null;
        }
    }
}

public class SimpleFactory {
    public static void main(String[] args) {
        String type = "standard";

        BurgerFactory myBurgerFactory = new BurgerFactory();
        Burger burger = myBurgerFactory.createBurger(type);

        burger.prepare();
    }
}
