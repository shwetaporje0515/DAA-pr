import java.util.*;

class Item{
    int profit;
    int weight;

    public Item(int _profit, int _weight){
        this.profit = _profit;
        this.weight = _weight;
    }
}

public class pr3 {
    public static double fractionalKnapsack(int capacity, ArrayList<Item> array) {

        double finalValue = 0.0;

        Collections.sort(array,new Comparator<Item> () {
            @Override
            public int compare(Item o1,Item o2){
                double r1 = o1.profit / o1.weight;
                double r2 = o2.profit / o2.weight;
                return Double.compare(r1,r2);
            }
        });

        for(Item item : array){
            if(item.weight <= capacity){
                finalValue = finalValue + item.profit;
                capacity = capacity - item.weight;
            } else {
                finalValue = finalValue + item.profit * ((double) capacity / item.weight);
                break;
            }
        }
        return finalValue;
    }

    public static void main(String args[]){
        ArrayList<Item> array = new ArrayList<Item>();

        array.add(new Item(25,18));
        array.add(new Item(24,15));
        array.add(new Item(15,10));

        int capacityOfKnapsack = 20;

        double maxValue = fractionalKnapsack(capacityOfKnapsack,array);

        System.out.println("Max Profit of the Knapsack : " + maxValue);
    }
}