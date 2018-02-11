package com.chocolatestore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;

import com.chocolatestore.delegate.PurchaseCandy;
import com.chocolatestore.delegate.PurchaseCandyImpl;
import com.chocolatestore.domain.CandyBag;

/**
 * Created by cbeasle on 2/10/18.
 */
public class ChocolateFeastChallenge {

    static public void main(String[] args) {
        Properties props = loadProps();

        List<CandyBag> candyBags = processOrders(props);
        writeOuputFile(props, candyBags);
    }

    static private Properties loadProps(){
        Properties props = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("resources/config.properties");
            props.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return props;
    }

    static private List<CandyBag> processOrders(Properties props){
        List<CandyBag> candyBags = new ArrayList<CandyBag>();

        try{
            System.out.println("Processing orders from: " + props.getProperty("inputFilePath") + "...");
            File file = new File(props.getProperty("inputFilePath"));
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            //skip headers in files
            int inputFileHeaderCount = Integer.parseInt(props.getProperty("inputFileHeaderCount"));
            for (int i=0; i<inputFileHeaderCount; i++){
                line = bufferedReader.readLine();
            }

            //process each line in the file and add to candyBags
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineParts = line.split(", ");
                String candyType = lineParts[3].replace("'","");
                PurchaseCandy purchaseDelegate = new PurchaseCandyImpl();

                purchaseDelegate.processPurchase(Double.parseDouble(lineParts[0]), Double.parseDouble(lineParts[1]), Integer.parseInt(lineParts[2]), candyType);
                candyBags.add(purchaseDelegate.getCandyBag());
            }

            fileReader.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return candyBags;
    }

    static private void writeOuputFile(Properties props, List<CandyBag> candyBags){
        try{
            System.out.println("Writing output to: " + props.getProperty("outputFilePath") + "...");
            File file = new File(props.getProperty("outputFilePath"));
            FileWriter fileWriter = new FileWriter(file);

            for (CandyBag candyBag : candyBags){
                fileWriter.write(candyBag.displayBag());
                fileWriter.write("\n");
            }
            fileWriter.close();
            System.out.println("Writing output Complete: " + props.getProperty("outputFilePath"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
