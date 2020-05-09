package solution;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Processor {
    private String inputFilePath;
    private String outFilePath;

    private int bestBuy = 0;
    //private int bestBuySize = 0;

    private int bestSell = 0;
    //private int bestSellSize = 0;

    private Map<Integer, Integer> allOffers = new HashMap<>(); // store all of the offers from file

    public Processor(String inputFilePath, String outFilePath) {
        this.inputFilePath = inputFilePath;
        this.outFilePath = outFilePath;
    }

    public void start() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), StandardCharsets.UTF_8))){

            String tempLine;
            while((tempLine = reader.readLine()) != null) {
                processor(tempLine);
            }

        } catch (Exception io){
            io.printStackTrace();
        }

    }

    private void processor(String inputString) {

        String[] updateInputs = inputString.split("[,]");

        if(inputString.charAt(0) == 'u'){
            update(updateInputs[1], updateInputs[2], updateInputs[3]);
        } else if (inputString.charAt(0) == 'q'){
            if(updateInputs.length == 2) {
                query(updateInputs[1], null);
            } else {
                query(updateInputs[1], updateInputs[2]);
            }
        } else if (inputString.charAt(0) == 'o'){
            operate(updateInputs[1], updateInputs[2]);
        } else {
            System.out.println("Unexpected identifier");
        }

    }

    private void printResult(String printString){

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outFilePath, true))){

            writer.write(printString);
            writer.newLine();

        } catch (Exception io){
            io.printStackTrace();
        }

    }

    /**This method catching best of bid and ask prices*/
    private void update(String price, String size, String ident){

        int tempPrice = Integer.parseInt(price);
        int tempSize = Integer.parseInt(size);

        allOffers.put(tempPrice, tempSize);

        if(ident.equals("bid")){
            if(tempPrice > bestBuy){
                bestBuy = tempPrice;
            }
        } else if (ident.equals("ask")) {
            if (bestSell == 0 || tempPrice < bestSell) {
                bestSell = tempPrice;
            }
        } else if (ident.equals("spread")){
            System.out.println("No operation for spread");
        } else System.out.println("Unexpected identifier at Processor.start.processor.update() ");
    }

    private void query(String query, String price){

        if(query.equals("best_bid")){
            printResult(bestBuy + "," + allOffers.get(bestBuy));
        } else if (query.equals("best_ask")){
            printResult(bestSell + "," + allOffers.get(bestSell));
        } else if (query.equals("size")){
            printResult("" + allOffers.get(Integer.parseInt(price)));
        } else System.out.println("Unexpected identifier at Processor.start.processor.query() ");

    }

    private void operate(String identifier, String price){

        int tempSize = Integer.parseInt(price);

        if(identifier.equals("sell")){
            if(tempSize > allOffers.get(bestBuy))
            {
                System.out.println("Warning! Input size bigger than best buy size. (All of best will be sold!)");
                allOffers.replace(bestBuy, 0);
            }

            allOffers.replace(bestBuy, (allOffers.get(bestBuy) - tempSize));
            //printResult("" + bestBuySize);
        } else if (identifier.equals("buy")){
            if(tempSize > allOffers.get(bestSell))
            {
                System.out.println("Warning! Input size bigger than best sell size. (All of best will be sold!)");
                allOffers.replace(bestSell, 0);
            }

            allOffers.replace(bestSell, (allOffers.get(bestSell) - tempSize));
            //printResult("" + bestSellSize);
        } else System.out.println("Unexpected identifier at Processor.start.processor.operate() ");
    }

}
