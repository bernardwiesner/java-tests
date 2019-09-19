public class Knapsack {

    private static int times;
    public static void main(String[] args){
        int[] weights =     {0,     2,    3,    1,     5,      7,     9};
        float[] profits =   {0, 0.10f, 0.5f, 0.3f, 0.13f, 0.145f, 0.25f};
        int itemPosition = weights.length - 1;
        int maxWeight = 100;

        float maximumProfit = knapSack(itemPosition, maxWeight, weights, profits);
        System.out.println(maximumProfit);
        System.out.println(times);
    }

    private static float knapSack(int itemPosition, int maxWeight, int[] weights, float[] profits){
        times++;
        if(itemPosition == 0 || maxWeight <= 0){
            return 0;
        }

        //Does not fit in bag, try another position
        if(weights[itemPosition] > maxWeight){
            return knapSack(itemPosition - 1, maxWeight, weights, profits);
        }

        //Try not to put in the bag (test other combinations for optimal solution)
        float nextOptimalProfit = knapSack(itemPosition - 1, maxWeight, weights, profits);
        //Try put in the bag, reduce the maxWeight allowed in the bag
        float currentOptimalProfit = profits[itemPosition] + knapSack(itemPosition - 1, maxWeight - weights[itemPosition], weights, profits);


        return Math.max(nextOptimalProfit, currentOptimalProfit);
    }

}
