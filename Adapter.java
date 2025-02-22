
/*
    * Adapter pattern is a structural design pattern that allows objects with incompatible interfaces to collaborate.
    * In other words, it allows objects with incompatible interfaces to work together.
    * The Adapter pattern acts as a bridge between two incompatible interfaces.
    * It is useful when you want to use a class that doesn't have the interface you need.
 */


interface WeightInKg {
    double getWeight();
}

interface WeightInPounds {
    double getWeight();
}

class WeightInPoundsImpl implements WeightInPounds {
    private double weight;

    public WeightInPoundsImpl(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

class WeightInKGImpl implements WeightInKg {
    private double weight;

    public WeightInKGImpl(double weight) {
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}

class WeightInPoundAdapter {
    private WeightInKg weightInKg;

    public WeightInPoundAdapter(WeightInKg weightInKg) {
        this.weightInKg = weightInKg;
    }

    public double getWeight() {
        return weightInKg.getWeight() * 2.20462;
    }
}



public class Adapter {
    public static void main(String[] args) {
        WeightInKg weightInKg = new WeightInKGImpl(100);
        System.out.println(weightInKg.getWeight());
//        WeightInPounds weightInPounds = new WeightInPoundsImpl(220.462);
//        System.out.println(weightInPounds.getWeight());
        WeightInPoundAdapter weightInPoundAdapter = new WeightInPoundAdapter(weightInKg);
        System.out.println(weightInPoundAdapter.getWeight());
    }
}
