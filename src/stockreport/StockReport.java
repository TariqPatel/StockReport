/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockreport;

import java.io.*;

/**
 *
 * @author Tariq
 */
public class StockReport {

    /**
     * @param args the command line arguments
     */
    public StockReport() {
    }

    public static void produceStockReport() {
        //initialising variables
        String area;
        String stockItem;
        String qty;
        String employee;
        String[] parts;
        String currentArea;
        String previousArea;
        int areaTransactionCount = 0;
        int areaItemQty = 0;
        String line = "";
        int transactionTotal = 0;
        int totalItemQty = 0;

        //Using print headings method
        printHeadings();


        try {


            RandomAccessFile raf = new RandomAccessFile("StockReport.txt", "rw");

            //reading file
            line = raf.readLine();

            //splitting strings
            parts = line.split(",");
            boolean eof = false;

            //putting splits into array
            area = parts[0];
            stockItem = parts[1];
            qty = parts[2];
            employee = parts[3];
            currentArea = area;
            previousArea = area;


            //while loop
            while (line != null) {

                parts = line.split(",");


                area = parts[0];
                stockItem = parts[1];
                qty = parts[2];
                employee = parts[3];
                currentArea = area;


                //if statement to print area totals
                if (!currentArea.equals(previousArea)) {

                    System.out.println("++++++++++++++++++++++++++");

                    System.out.println("Area: " + previousArea);

                    System.out.println("Area transaction count: " + areaTransactionCount);

                    System.out.println("Area item qty: " + areaItemQty);

                    System.out.println("++++++++++++++++++++++++++");

                    System.out.println("----------------------------------------------------------------------------------");


                    totalItemQty = totalItemQty + areaItemQty;

                    previousArea = area;
                    areaTransactionCount = 0;
                    areaItemQty = 0;

                }
                System.out.println("Area:" + area + ",\tStock item:" + stockItem + ",\tQty exchange:" + qty + ",\tEmployee:" + employee);




                ++areaTransactionCount;
                int itemQty = Integer.parseInt(qty);

                ++transactionTotal;
                areaItemQty += itemQty;

                //reading file
                line = raf.readLine();


            }

            System.out.println("++++++++++++++++++++++++++");


            System.out.println("Area: " + previousArea);

            System.out.println("Area transaction count: " + areaTransactionCount);
            System.out.println("Area item qty: " + areaItemQty);
            System.out.println("++++++++++++++++++++++++++");

            System.out.println("----------------------------------------------------------------------------------\n");

            totalItemQty = totalItemQty + areaItemQty;

            //printing grand totals
            System.out.println("----------------------------------------------------------------------------------");

            System.out.println("----------------------------------------------------------------------------------");


            System.out.println("Total transaction count: " + transactionTotal);

            System.out.println("Total item qty: " + totalItemQty);
            System.out.println("\n----------------------------------------------------------------------------------");

            System.out.println("----------------------------------------------------------------------------------");





        } catch (IOException io) {
            System.out.println("Error" + io.getMessage());
        }

    }

    
    public static void printHeadings() {
        //printing page heading
        System.out.println("----------------------------------------------------------------------------------");

        System.out.println("Stock report\nThis report shows the transactions of stock\n4/9/2011\n");
        System.out.println("----------------------------------------------------------------------------------");
    }
}