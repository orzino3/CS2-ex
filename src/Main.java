import java.util.Scanner;

public class Main {//O(n^2)
    public static void main(String[] args) {
        RealEstate realEstate = new RealEstate();
        Scanner scanner = new Scanner(System.in);

        int userChoice;
        boolean stop = true;

        while (stop) {
            printMainMenu();
            System.out.println("\n\nPlease enter your Choice\n");
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 3 -> {
                    stop = false;
                }

                case 1 -> {
                    realEstate.createUser();
                }

                case 2 -> {
                    boolean logout = false;
                    User found = realEstate.userLogin();

                    if (found != null) {

                        while (!logout) {

                            printSecondaryMenu();
                            System.out.println("\n\nPlease enter your Choice\n");
                            userChoice = scanner.nextInt();

                            switch (userChoice) {
                                case 6 -> {
                                    logout = true;
                                }

                                case 1 -> {
                                    if (realEstate.postNewProperty(found))
                                        System.out.println("\nProperty Added Successfully to Database\n");

                                    else System.out.println("\nProperty not Added to Database\n");
                                }

                                case 2 -> {
                                    realEstate.removeProperty(found);
                                }

                                case 3 -> {
                                    realEstate.printAllProperties();
                                }

                                case 4 -> {
                                    realEstate.printProperties(found);
                                }

                                case 5 -> {
                                    Property[] filtered = realEstate.search();
                                    for (int i = 0; i < filtered.length; i++) {
                                        System.out.println(filtered[i]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void printMainMenu() {

        System.out.println("1 - Create account");
        System.out.println("2 - Log in to existing account");
        System.out.println("3 - Terminate program");

    }

    public static void printSecondaryMenu() {

        System.out.println("1 - Post new property");
        System.out.println("2 - Remove property post");
        System.out.println("3 - Show all properties");
        System.out.println("4 - Show my properties");
        System.out.println("5 - Search property by parameters");
        System.out.println("6 - Log out");

    }

}