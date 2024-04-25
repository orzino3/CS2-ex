public class User {

    private String userName;
    private String password;
    private String phoneNumber;
    private boolean realtor;
    private int postCount;

    private Property[] postedProperties;

    public User() {//O(1)
        this.postCount = 0;
        this.postedProperties = new Property[0];
    }

    public void addPostCount() {//O(1)
        this.postCount++;
    }

    public void subPostCount() {//O(1)
        this.postCount--;
    }

    public int getPostCount() {//O(1)
        return this.postCount;
    }

    public String getUserName() {//O(1)
        return this.userName;
    }

    public String setUserName(String userName) {//O(1)
        return this.userName = userName;
    }

    public String getPassword() {//O(1)
        return this.password;
    }

    public String setPassword(String password) {//O(1)
        return this.password = password;
    }

    public String setPhoneNumber(String phoneNumber) {//O(1)
        return this.phoneNumber = phoneNumber;
    }

    public boolean isRealtor() {//O(1)
        return realtor;
    }

    public boolean setRealtor(String input) {//O(1)
        return realtor = input.equalsIgnoreCase("Y") ? true : false;
    }

    public boolean isStrongPassword(String password) {//O(1)
        boolean isStrong = false;

        if (password.length() >= 5) {
            if (password.contains("0") || password.contains("1") || password.contains("2") || password.contains("3") ||
                    password.contains("4") || password.contains("5") || password.contains("6") || password.contains("7") ||
                    password.contains("8") || password.contains("9")) {
                if (password.contains("$") || password.contains("_") || password.contains("%")) {
                    isStrong = true;
                }
            }
        }
        return isStrong;
    }

    public boolean isValidPhone(String phoneNumber) {//O(1)
        boolean isValid = false;
        int count = 0;

        if (phoneNumber.length() == 10) {
            if (phoneNumber.startsWith("05")) {
                for (int i = 2; i < phoneNumber.length(); i++) {
                    if (phoneNumber.charAt(i) == '0' || phoneNumber.charAt(i) == '1' || phoneNumber.charAt(i) == '2' ||
                            phoneNumber.charAt(i) == '3' || phoneNumber.charAt(i) == '4' || phoneNumber.charAt(i) == '5' ||
                            phoneNumber.charAt(i) == '6' || phoneNumber.charAt(i) == '7' || phoneNumber.charAt(i) == '8' ||
                            phoneNumber.charAt(i) == '9') {
                        count++;
                    }
                }
                if (count == 8)
                    isValid = true;
            }
        }
        return isValid;
    }

    public String toString() {//O(1)
        return this.userName + " " + this.phoneNumber + (isRealtor() ? " (Real estate Broker)\n" : "");
    }


}
