package PointOfSale;

import java.util.HashMap;

public class PointOfSale {
    HashMap<String, Double> BarcodeHashing;
    public PointOfSale(){
        BarcodeHashing = new HashMap<>();
        BarcodeHashing.put("12345" , 7.25);
        BarcodeHashing.put("23456" , 12.50);
    }

    public String scan(String number) {
        if (number.equals("")){
            return "Error: empty barcode";
        }
        else if (BarcodeHashing.containsKey(number)){
            Double price = BarcodeHashing.get(number);
            StringBuilder returnString = new StringBuilder();
            return returnString.append("$").append(price).toString();
        }
        else {
            return "Error: barcode not found";
        }
    }

    public String scanTotal(String[] barcodeList) {
        Double totalAmount = 0.0;
        for (String barcode : barcodeList){
            totalAmount += BarcodeHashing.get(barcode);
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Total Is: $").append(totalAmount).toString();
    }
}
