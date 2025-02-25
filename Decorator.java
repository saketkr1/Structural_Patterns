

/*
    * Decorator pattern is used to add new functionality to an existing object without altering its structure.
    * This pattern creates a decorator class that wraps the original class and provides additional functionality keeping class methods signature intact.
    * We use inheritance to implement this pattern.
 */

interface Pizza {
    String getDesc();
    double getPrice();
}

class BasePizza implements Pizza {
    @Override
    public String getDesc() {
        return "Base Pizza";
    }

    @Override
    public double getPrice() {
        return 100;
    }
}
abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

//    @Override
//    public String getDesc() {
//        return pizza.getDesc();
//    }
//
//    @Override
//    public double getPrice() {
//        return pizza.getPrice();
//    }
}

class Cheese extends ToppingDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDesc() {
        return pizza.getDesc() + ", Cheese (20)";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 20;
    }
}

class Tomato extends ToppingDecorator {
    public Tomato(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDesc() {
        return pizza.getDesc() + ", Tomato (10)";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 10;
    }
}



public class Decorator {

    public static void main(String[] args) {
        Pizza pizza = new BasePizza();
        pizza = new Cheese(pizza);
        pizza = new Tomato(pizza);
        System.out.println("Desc: " + pizza.getDesc() + " Price: " + pizza.getPrice());

    }
}
