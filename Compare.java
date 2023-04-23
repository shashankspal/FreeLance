package knapsack;

import java.util.Comparator;

class Compare implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        double a = -1 * o1.profit / (o1.weight);
        double b = -1 * o2.profit / (o2.weight);
        if (a == b)
            return Double.compare(o1.weight, o2.weight);
        return Double.compare(a, b);
    }
}
