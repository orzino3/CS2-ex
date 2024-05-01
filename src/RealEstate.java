import java.util.Scanner;

public class RealEstate {

    private User[] users;
    private Property[] properties;
    private City[] cities;

    final private int LIMIT_FOR_REALTOR = 5;
    final private int LIMIT_FOR_REGULAR = 2;
    final private int INITIAL_CITY_VALUE = 10;
    final private int NULL_VALUE = -999;

    public RealEstate() { //O(n)
        this.users = new User[0];
        this.properties = new Property[0];
        this.cities = new City[INITIAL_CITY_VALUE];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new City(i);
        }
    }
    public void createUser() {//O(n)
        //--------------------------הגדרת משתנים------------------------
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        User[] temp = new User[this.users.length + 1];
        String input;
        //-----------------------קלט שם משתמש---------------------------
        System.out.println("Enter a username");
        input = user.setUserName(scanner.nextLine());

        for (int i = 0; i < users.length; i++) {
            if (input.equals(users[i].getUserName())) {
                while (input.equals((users[i].getUserName()))) {
                    System.out.println("Username is taken. Please Enter a username");
                    input = user.setUserName(scanner.nextLine());
                }
            }
        }
        //----------------------------קלט סיסמא-------------------------
        System.out.println("Enter a password");
        input = user.setPassword(scanner.nextLine());

        while (!user.isStrongPassword(user.setPassword(input))) {
            System.out.println("Password is weak. Please try again");
            input = user.setPassword(scanner.nextLine());
        }
        //----------------------------קלט טלפון----------------------
        System.out.println("Enter a phone number");
        input = user.setPhoneNumber(scanner.nextLine());


        while (!user.isValidPhone(user.setPhoneNumber(input))) {
            System.out.println("Phone not met conditions. Please re-enter phone number");
            input = user.setPhoneNumber(scanner.nextLine());
        }
        //-------------------------קלט מתווך-------------------------
        System.out.println("Are you a realtor or not? (Y/N)");
        user.setRealtor(scanner.nextLine());
        addUser(user); // הוספת היוזר אל מערך המשתמשים

    }

    private void addUser(User user) {//O(n)
        User[] temp = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            temp[i] = this.users[i];
        }
        temp[temp.length - 1] = user;
        this.users = temp;
    }

    public User userLogin() {//O(n)
        User user = new User();
        Scanner login = new Scanner(System.in);
        String username, password;
        User found = null;

        System.out.println("Enter username");
        username = user.setUserName(login.nextLine());
        System.out.println("Enter password");
        password = user.setUserName(login.nextLine());

        for (int i = 0; i < this.users.length; i++) {
            if (users[i].getUserName().equals(username) && users[i].getPassword().equals(password)) {
                found = users[i];
                break;
            }
        }

        if (found == null)
            System.out.println("Sorry, you entered incorrect credentials.\n");

        return found;
    }

    public boolean postNewProperty(User user) {//O(n)
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        boolean success = false;
        boolean foundStreet = false;
        String input1, input2;
        int index = 0;
        String type;

        if (!this.userHasLimit(user)) {
            showCities();
        } else {
            System.out.println("You've reached your limit.\n");
            return success;
        }

        System.out.println("Enter a city\n");
        input1 = scanner.nextLine();

        for (int i = 0; i < this.cities.length; i++) {
            City current = this.cities[i];
            if (current.getCityName().equalsIgnoreCase(input1)) {
                found = true;
                index = i;
                break;
            }
        }

        if (!found) {
            System.out.println("Sorry. city entry didn't match\n");
            return success;
        } else {
            cities[index].showStreets(input1);

            System.out.println("Enter a street\n");
            input2 = scanner.nextLine();

            for (int i = 0; i < cities[index].getStreets(input1).length; i++) {
                if (cities[index].getStreets(input1)[i].equalsIgnoreCase(input2)) {
                    foundStreet = true;
                    break;
                }
            }

            if (!foundStreet) {
                System.out.println("Sorry. street entry didn't match\n");
                return success;
            } else {
                int floorNumber = 0;

                System.out.println("Enter type of apartment - 1 for regular, 2 - for penthouse, 3 - for private");
                type = scanner.nextLine();
                if (type.equals("1") || type.equals("2")) {
                    success = true;
                    Property toAdd = new Property(cities[index], input2, askFloor(), askRooms(), askPrice(), type, askStatus(), askAddressNum(), user);
                    this.addProperty(toAdd);
                    user.addPostCount();

                } else if (type.equals("3")) {
                    success = true;
                    Property toAdd = new Property(cities[index], input2, askRooms(), askPrice(), type, askStatus(), askAddressNum(), user);
                    this.addProperty(toAdd);
                    user.addPostCount();
                } else {
                    System.out.println("You've entered wrong input.\n");
                }

            }
        }

        return success;
    }

    public void addProperty(Property property) {//O(n)

        Property[] temp = new Property[this.properties.length + 1];
        for (int i = 0; i < this.properties.length; i++) {
            temp[i] = this.properties[i];
        }
        temp[this.properties.length] = property;
        this.properties = temp;

    }

    public void printAllProperties() {//O(n)
        if (this.properties.length == 0) {
            System.out.println("There is no properties in the system yet.");
            return;
        } else {
            for (int i = 0; i < this.properties.length; i++) {
                System.out.println("[" + (i/*+1*/) + "]\n");
                System.out.println(this.properties[i]);
            }
        }
    }

    public void printProperties(User user) {//O(n)

        if (user.getPostCount() == 0) {
            System.out.println("You didn't post any property");
        } else {
            for (int i = 0; i < this.properties.length; i++) {
                if (this.properties[i].getUser().equals(user)) {
                    System.out.println("\n[" + (i/*+1*/) + "]");
                    System.out.println(this.properties[i]);
                }
            }
        }


    }

    public void removeProperty(User user) {//O(n)
        if (user.getPostCount() != 0) {
            this.printProperties(user);
            System.out.println("Please enter property number to remove");
            int choice = (new Scanner(System.in).nextInt()) /*- 1*/;
            this.removeUserChoice(choice, user);
            user.subPostCount();
            System.out.println("\nProperty Removed Successfully!\n");
        } else {
            System.out.println("There is nothing to remove");
        }

    }

    public void removeUserChoice(int choice, User user) {//O(n)
        Property[] tempProp = new Property[this.properties.length - 1];
        if (!user.equals(this.properties[choice].getUser())) {
            System.out.println("User mismatch. You tried to remove property that you didn't published");
            return;
        } else {
            for (int i = 0, index = 0; i < this.properties.length; i++) {
                if (i != choice) {
                    tempProp[index] = this.properties[i];
                    index++;
                }
            }

            this.properties = tempProp;
        }

    }

    public boolean userHasLimit(User user) {//O(1)
        return ((user.isRealtor() && user.getPostCount() == LIMIT_FOR_REALTOR)) ||
                (!user.isRealtor() && user.getPostCount() == LIMIT_FOR_REGULAR);
    }

    public void showCities() {//O(n)
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }
    }

    public Property[] search() {//O(n)
        System.out.println("DataBase property search:\n\n" +
                "Please enter your preferences. If you don't want to filter any characteristic, enter -999.\n");

        System.out.println("Enter Sale or Rent (Letter case doesn't matter)");
        String status = new Scanner(System.in).nextLine();
        System.out.println("What kind of property you are looking for? (Regular/Penthouse/Private)");
        String type = new Scanner(System.in).nextLine();
        System.out.println("Room Capacity?");
        int roomCapacity = new Scanner(System.in).nextInt();
        System.out.println("What is your price range?");
        System.out.println("Minimum:");
        double min = new Scanner(System.in).nextDouble();
        System.out.println("Maximum:");
        double max = new Scanner(System.in).nextDouble();
        Property[] filtered = this.properties;
        if (!status.equals(String.valueOf(NULL_VALUE))) {
            filtered = this.searchStatus(filtered, status);
        }
        if (!type.equals(String.valueOf(NULL_VALUE))) {
            filtered = this.searchType(filtered, type);
        }
        if (roomCapacity != NULL_VALUE) {
            filtered = this.searchRoomCapacity(filtered, roomCapacity);
        }
        if (max != NULL_VALUE && min != NULL_VALUE) {
            filtered = this.searchPrice(filtered, min, max);
        }
        return filtered;
    }

    public Property[] searchStatus(Property[] toFilter, String status) {//O(n)
        int size = 0;
        for (int i = 0; i < toFilter.length; i++) {
            if (toFilter[i].getStatus().equalsIgnoreCase(status)) {
                size++;
            }
        }
        Property[] filtered = new Property[size];

        for (int i = 0,j = 0; i < toFilter.length; i++) {
            if (toFilter[i].getStatus().equalsIgnoreCase(status)) {
                filtered[j] = toFilter[i];
                j++;
            }
        }
        return filtered;
    }

    public Property[] searchType(Property[] toFilter, String type) {//O(n)
        int size = 0;
        for (int i = 0; i < toFilter.length; i++) {
            if (toFilter[i].getType().equalsIgnoreCase(type)) {
                size++;
            }
        }
        Property[] filtered = new Property[size];

        for (int i = 0,j = 0; i < toFilter.length; i++) {
            if (toFilter[i].getType().equalsIgnoreCase(type)) {
                filtered[j] = toFilter[i];
                j++;
            }
        }
        return filtered;
    }

    public Property[] searchRoomCapacity(Property[] toFilter, int roomCapacity) {//O(n)
        int size = 0;
        for (int i = 0; i < toFilter.length; i++) {
            if (toFilter[i].getRoomCapacity() == roomCapacity) {
                size++;
            }
        }
        Property[] filtered = new Property[size];
        for (int i = 0, j = 0; i < toFilter.length; i++) {
            if (toFilter[i].getRoomCapacity() == roomCapacity) {
                filtered[j] = toFilter[i];
                j++;
            }
        }
        return filtered;
    }

    public Property[] searchPrice(Property[] toFilter, double min, double max) {//O(n)
        int count = 0;
        for (int i = 0; i < toFilter.length; i++) {
            if (toFilter[i].getPrice() >= min && toFilter[i].getPrice() <= max) {
                count++;
            }
        }
        Property[] filtered = new Property[count];

        for (int i = 0,j = 0; i < toFilter.length; i++) {
            if (toFilter[i].getPrice() >= min && toFilter[i].getPrice() <= max) {
                filtered[j] = toFilter[i];
                j++;
            }
        }
        return filtered;
    }

    public int askFloor() {//O(1)
        System.out.println("Enter floor number");
        return new Scanner(System.in).nextInt();
    }

    public int askRooms() {//O(1)

        System.out.println("Enter rooms number");
        return new Scanner(System.in).nextInt();
    }

    public int askAddressNum() {//O(1)

        System.out.println("Enter address number");
        return new Scanner(System.in).nextInt();
    }

    public int askPrice() {//O(1)

        System.out.println("Enter price");
        return new Scanner(System.in).nextInt();
    }

    public String askStatus() {//O(1)
        System.out.println("Enter Property Status - Rent / Sale");
        return new Scanner(System.in).nextLine();
    }


    @Override
    public String toString() {//O(n)
        String output = "";

        for (int i = 0; i < users.length; i++) {
            output += users[i];
        }

        for (int i = 0; i < cities.length; i++) {
            output += cities[i];
        }

        return output;
    }
}

