package knapsack;

import java.util.List;

public class BoundClass {
    Node node;
    List<Item> items;
    int n;
    int capacity;

    public BoundClass(Node node, List<Item> items, int capacity) {
        this.node = node;
        this.items = items;
        this.n = items.size();
        this.capacity = capacity;
    }

    int bound() {
        if (node.weight >= capacity)
            return 0;
        int lowerBound = node.profit;
        int sumOfWeight = (int) node.weight;
        int level = node.level;
        while (level < n - 1 && sumOfWeight + node.weight <= capacity) {
            sumOfWeight += items.get(level + 1).weight;
            lowerBound += items.get(level + 1).profit;
            level++;
        }
        //To include the fractional part
        if (level < n - 1)
            lowerBound += (capacity - sumOfWeight) * (items.get(level + 1).profit / (items.get(level + 1).weight));
        return lowerBound;
    }
}
