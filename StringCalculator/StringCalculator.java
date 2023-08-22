package StringCalculator;

public class StringCalculator {

    int returnInteger = 0;
    boolean hasNegative = false;
    boolean delimiterError = false;
    String delimiterErrors = "Delimiters are not matching, Expected: ";
    String negativeNumbers = "\n Negative number(s) are not allowed:";
    
    public int add(String s) {

        String delimiter = ",";
        
        if (s.startsWith("//")) {
            int indexOfNewline = s.indexOf('\n');
            delimiter = s.substring(2, indexOfNewline);
            s = s.substring(indexOfNewline + 1);
        }

        delimiterErrors = delimiterErrors + delimiter + " found: ";

        s = s.replace("\n", delimiter);
        int len = s.length();

        if (len == 0){
            return 0;
        }
        else if(len == 1){
            if (Integer.parseInt(s) > 0)
                returnInteger += Integer.parseInt(s);
            else
                return -1;
            return returnInteger;
        }
        if (len > 1){
            if (s.charAt(len-1) == ','){
                return -1;
            }

            String[] parts = s.split(delimiter);

            for (int i=0; i<parts.length; i++){
                try {
                    int num = Integer.parseInt(parts[i]);




                    if (num > 0 && num < 1000)
                        returnInteger += num;
                    else if (num <0) {
                        hasNegative = true;
                        negativeNumbers = negativeNumbers + " " + num;
                    }

                }
                catch(Exception e){

                    delimiterError = true;
                    String problemPart = parts[i];


                    for (int j = 0; j < problemPart.length(); j++) {

                        if (!Character.isDigit(problemPart.charAt(j)) && !problemPart.equals(delimiter)) {
                            if (problemPart.charAt(j) == '-') {
                                for (int k = 0; k < s.length(); k++) {
                                    if (s.charAt(k) == '-' && k < s.length() - 1) {
                                        hasNegative = true;
                                        negativeNumbers = negativeNumbers + " " + s.charAt(k + 1);
                                        k++;
                                    }

                                }
                            }
                            else {delimiterErrors = delimiterErrors + " " + problemPart.charAt(j);}

                        }

                    }
                }
            }
        }



        if (delimiterError)
            System.out.println(delimiterErrors);

        if (hasNegative)
            System.out.println(negativeNumbers);

        if (delimiterError || hasNegative){
            return -1;
        }
        return returnInteger;
    }
}
