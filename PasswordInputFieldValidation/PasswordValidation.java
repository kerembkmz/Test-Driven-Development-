package PasswordInputFieldValidation;

public class PasswordValidation {
    public boolean check(String password) {
        boolean lengthCheck = minimumPasswordLengthCheck(password);
        boolean numberCheck = minimumPasswordNumberCheck(password);
        boolean capitalCheck = has1orMoreCapital(password);
        boolean specialCharCheck = hasSpecialChar(password);

        if (lengthCheck && numberCheck && capitalCheck && specialCharCheck)
            return true;
        else
            return false;
    }

    public boolean minimumPasswordLengthCheck(String password){
        if (password.length() < 8){
            System.out.println("Password must be at least 8 characters. \n");
            return false;
        }
        return true;
    }

    public boolean minimumPasswordNumberCheck(String password){
        int counter = 0;
        for (int i=0; i<password.length(); i++){
            if (Character.isDigit(password.charAt(i)))
                counter++;
        }

        if (counter < 2){
            System.out.println("The password must contain at least 2 numbers. \n");
            return false;
        }
        return true;
    }

    public boolean has1orMoreCapital(String password){
        int counter = 0;
        for (int i=0;i<password.length(); i++){
            if (Character.isUpperCase(password.charAt(i)))
                counter++;
        }

        if (counter < 1){
            System.out.println("The password must contain at least 1 capital letter \n");
            return false;
        }
        return true;
    }

    public boolean hasSpecialChar(String password){
        int counter = 0;
        for (int i=0;i<password.length(); i++){
            if (!Character.isLetterOrDigit(password.charAt(i)))
                counter++;
        }

        if (counter < 1){
            System.out.println("The password must contain at least 1 special character \n");
            return false;
        }
        return true;
    }
}
