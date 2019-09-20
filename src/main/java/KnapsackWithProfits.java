import java.util.ArrayList;
import java.util.List;

public class KnapsackWithProfits {

    private static int times;
    private static int[] weights =     {0,     2,    3,    1,     5,      7,     9};
    private static float[] profits =   {0, 0.10f, 0.5f, 0.3f, 0.13f, 0.145f, 0.25f};

    public static void main(String[] args){
        int itemPosition = weights.length - 1;
        int maxWeight = 10;
        List<Float> chosenProfits = new ArrayList<>();


        List<Float> maximumProfits = knapSack(itemPosition, maxWeight, chosenProfits);
        System.out.println(sumList(maximumProfits));
        System.out.println(times);
        for(float profit : maximumProfits){
            System.out.println(profit);
        }

    }

    private static List<Float> knapSack(int itemPosition, int maxWeight, List<Float> chosenProfits){

        times++;

        if(itemPosition == 0 || maxWeight <= 0){
            return new ArrayList<>();
        }

        //Does not fit in bag, try another position
        if(weights[itemPosition] > maxWeight){
            chosenProfits =  knapSack(itemPosition - 1, maxWeight, chosenProfits);

        }else{

            //Try not to put in the bag (test other combinations for optimal solution)
            List<Float> nextOptimalProfits = knapSack(itemPosition - 1, maxWeight, chosenProfits);
            //Try put in the bag, reduce the maxWeight allowed in the bag
            List<Float> currentOptimalProfits = knapSack(itemPosition - 1, maxWeight - weights[itemPosition], chosenProfits);
            currentOptimalProfits.add(profits[itemPosition]);

            chosenProfits = nextOptimalProfits;
            if(sumList(currentOptimalProfits) > sumList(nextOptimalProfits)){
                chosenProfits = currentOptimalProfits;
            }
        }

        return chosenProfits;
    }

    private static float sumList(List<Float> chosenProfits){
        float sum = 0;
        for(float profit : chosenProfits){
            sum += profit;
        }
        return sum;
    }


}
