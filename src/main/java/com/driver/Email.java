package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        String oldpassword=getPassword();


        if (!oldpassword.equals(oldPassword)) {
//            System.out.println("Old password is incorrect.");
            return;
        }

        if (newPassword.length() < 8) {
//            System.out.println("New password must be at least 8 characters long.");
            return;
        }

        boolean containsUpperCase = false;
        boolean containsLowerCase = false;
        boolean containsDigit = false;
        boolean containsSpecialCharacter = false;

        for (char c : newPassword.toCharArray()) {
            if (Character.isUpperCase(c)) {
                containsUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                containsLowerCase = true;
            } else if (Character.isDigit(c)) {
                containsDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                containsSpecialCharacter = true;
            }
        }

        if (!containsUpperCase) {
//            System.out.println("New password must contain at least one uppercase letter.");
            return;
        }

        if (!containsLowerCase) {
//            System.out.println("New password must contain at least one lowercase letter.");
            return;
        }

        if (!containsDigit) {
//            System.out.println("New password must contain at least one digit.");
            return;
        }

        if (!containsSpecialCharacter) {
//            System.out.println("New password must contain at least one special character.");
            return;

        }
        password=newPassword;
    }
}
