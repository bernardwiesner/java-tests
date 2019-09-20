public class Knapsack {

    private static int times;
    private static float[][] calculated;
    public static void main(String[] args){
        int[] weights =     {0, 2, 3, 1, 5, 7, 9, 0, 2, 3, 1, 5, 7, 9, 0, 2, 3, 1, 5, 7, 9, 0, 2, 3, 1, 5, 7, 9, 0, 2, 3, 1, 5, 7, 9, 0, 2, 3, 1, 5, 7, 9, 0, 2, 3, 1, 5, 7, 9};
        float[] profits =   {0, 2, 3, 1, 5, 7, 9, 0, 2, 3, 1, 5, 7, 9, 0, 2, 3, 1, 5, 7, 9, 0, 2, 3, 1, 5, 7, 9, 0, 2, 3, 1, 5, 7, 9, 0, 2, 3, 1, 5, 7, 15, 0, 2, 3, 1, 5, 7, 8};
        int itemPosition = weights.length - 1;
        int maxWeight = 100;
        calculated = new float[weights.length][maxWeight + 1];

        float maximumProfit = knapSack(itemPosition, maxWeight, weights, profits);
        System.out.println(maximumProfit);
        System.out.println(times);
    }

    private static float knapSack(int itemPosition, int maxWeight, int[] weights, float[] profits){
        if(calculated[itemPosition][maxWeight] != 0){
            return calculated[itemPosition][maxWeight];
        }
        times++;

        if(itemPosition == 0 || maxWeight <= 0){
            return 0;
        }

        float result = 0;
        //Does not fit in bag, try another position
        if(weights[itemPosition] > maxWeight){
            result = knapSack(itemPosition - 1, maxWeight, weights, profits);
        }else{

            //Try not to put in the bag (test other combinations for optimal solution)
            float nextOptimalProfit = knapSack(itemPosition - 1, maxWeight, weights, profits);
            //Try put in the bag, reduce the maxWeight allowed in the bag
            float currentOptimalProfit = profits[itemPosition] + knapSack(itemPosition - 1, maxWeight - weights[itemPosition], weights, profits);
            result = Math.max(nextOptimalProfit, currentOptimalProfit);
        }

        calculated[itemPosition][maxWeight] = result;
        return result;
    }

}
