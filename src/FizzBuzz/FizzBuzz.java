package FizzBuzz;

public class FizzBuzz {
    private int size = 0;
    private String returnString;
    public String add(int number) {
        returnString = "";
        if (number % 3 == 0 && number % 5 == 0){
            returnString = returnString + "FizzBuzz";
        }
        else if (number % 3 == 0){
            returnString = returnString + "Fizz";
        }
        else if(number % 5 == 0){
            returnString = returnString + "Buzz";
        }
        else {
            returnString = returnString + number;
        }
        size++;
        return returnString;
    }

    public boolean isEmpty() {
        if(size == 0)
            return true;
        else
            return false;
    }
}
