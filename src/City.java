import java.util.Random;

public class City {

    private String cityName;
    private String district;
    private String streetName;

    final private String[] EILAT_STREET_BANK = {"Yerushalaim HaShlema", "Tsin", "Rimon", "Sheshet HaYamim", "Los Angeles"};
    final private String[] BEER_SHEVA_STREET_BANK = {"Wingate", "Rager", "Jabotinski", "Avigdor HaMeiri", "Rotschild"};
    final private String[] ASHKELON_STREET_BANK = {"Argaman", "Eli Cohen", "Yitzhak Ben Tzvi", "Shanin", "Begin"};
    final private String[] TEL_AVIV_STREET_BANK = {"Jabotinski", "Ibn Gabirol", "Rotschild", "Abba Hillel", "Yehuda HaLevi"};
    final private String[] HAIFA_STREET_BANK = {"Hadar", "Yerushalaim", "Tel Hai", "Hass", "Montifiory"};
    final private String[] SEFAD_STREET_BANK = {"Shazar", "Yoseftal", "HaGdud", "Bareket", "Sapir"};
    final private String[] NETANYA_STREET_BANK = {"Pier Kenig", "Ertzi Sherman", "Dizingoff", "King David", "Malievsky"};
    final private String[] KARMIEL_STREET_BANK = {"Baz", "Nesher", "Anafa", "Tor", "Zamir"};
    final private String[] ASHDOD_STREET_BANK = {"Elul", "Iyar", "Tamuz", "Sivan", "Nissan"};
    final private String[] JERUSALEM_STREET_BANK = {"Nativ HaMazalot", "Heil HaAvir", "Malkei Israel", "Yirmiyahu", "Mishmar HaGvul"};
    //------------------

    final private String[] CITY_NAME_BANK = {"Eilat", "Beer Sheva", "Ashkelon", "Tel Aviv", "Haifa", "Sefad", "Netanya", "Karmiel", "Ashdod", "Jerusalem"};
    final private String[] DISTRICT_NAME_BANK = {"Negev", "South", "Center", "North", "HaSharon"};


    public void showStreets(String input) { //O(n)
        if (input.equalsIgnoreCase("Eilat")) {
            for (int i = 0; i < EILAT_STREET_BANK.length; i++) {
                System.out.println(EILAT_STREET_BANK[i]);
            }
        } else if (input.equalsIgnoreCase("Beer Sheva")) {
            for (int i = 0; i < BEER_SHEVA_STREET_BANK.length; i++) {
                System.out.println(BEER_SHEVA_STREET_BANK[i]);
            }
        } else if (input.equalsIgnoreCase("Ashkelon")) {
            for (int i = 0; i < ASHKELON_STREET_BANK.length; i++) {
                System.out.println(ASHKELON_STREET_BANK[i]);
            }
        } else if (input.equalsIgnoreCase("Tel Aviv")) {
            for (int i = 0; i < TEL_AVIV_STREET_BANK.length; i++) {
                System.out.println(TEL_AVIV_STREET_BANK[i]);
            }
        } else if (input.equalsIgnoreCase("Haifa")) {
            for (int i = 0; i < HAIFA_STREET_BANK.length; i++) {
                System.out.println(HAIFA_STREET_BANK[i]);
            }
        } else if (input.equalsIgnoreCase("Sefad")) {
            for (int i = 0; i < SEFAD_STREET_BANK.length; i++) {
                System.out.println(SEFAD_STREET_BANK[i]);
            }
        } else if (input.equalsIgnoreCase("Netanya")) {
            for (int i = 0; i < NETANYA_STREET_BANK.length; i++) {
                System.out.println(NETANYA_STREET_BANK[i]);
            }
        } else if (input.equalsIgnoreCase("Karmiel")) {
            for (int i = 0; i < KARMIEL_STREET_BANK.length; i++) {
                System.out.println(KARMIEL_STREET_BANK[i]);
            }
        } else if (input.equalsIgnoreCase("Ashdod")) {
            for (int i = 0; i < ASHDOD_STREET_BANK.length; i++) {
                System.out.println(ASHDOD_STREET_BANK[i]);
            }
        } else if (input.equalsIgnoreCase("Jerusalem")) {
            for (int i = 0; i < JERUSALEM_STREET_BANK.length; i++) {
                System.out.println(JERUSALEM_STREET_BANK[i]);
            }
        }
    }

    public String matchStreetToCity() { //O(1)
        Random random = new Random();

        if (cityName.equalsIgnoreCase("Eilat")) {
            this.streetName = EILAT_STREET_BANK[random.nextInt(EILAT_STREET_BANK.length)];
        } else if (cityName.equalsIgnoreCase("Beer Sheva")) {
            this.streetName = BEER_SHEVA_STREET_BANK[random.nextInt(BEER_SHEVA_STREET_BANK.length)];
        } else if (cityName.equalsIgnoreCase("Ashkelon")) {
            this.streetName = ASHKELON_STREET_BANK[random.nextInt(ASHKELON_STREET_BANK.length)];
        } else if (cityName.equalsIgnoreCase("Tel Aviv")) {
            this.streetName = TEL_AVIV_STREET_BANK[random.nextInt(TEL_AVIV_STREET_BANK.length)];
        } else if (cityName.equalsIgnoreCase("Haifa")) {
            this.streetName = HAIFA_STREET_BANK[random.nextInt(HAIFA_STREET_BANK.length)];
        } else if (cityName.equalsIgnoreCase("Sefad")) {
            this.streetName = SEFAD_STREET_BANK[random.nextInt(SEFAD_STREET_BANK.length)];
        } else if (cityName.equalsIgnoreCase("Netanya")) {
            this.streetName = NETANYA_STREET_BANK[random.nextInt(NETANYA_STREET_BANK.length)];
        } else if (cityName.equalsIgnoreCase("Karmiel")) {
            this.streetName = KARMIEL_STREET_BANK[random.nextInt(KARMIEL_STREET_BANK.length)];
        } else if (cityName.equalsIgnoreCase("Ashdod")) {
            this.streetName = ASHDOD_STREET_BANK[random.nextInt(ASHDOD_STREET_BANK.length)];
        } else if (cityName.equalsIgnoreCase("Jerusalem")) {
            this.streetName = JERUSALEM_STREET_BANK[random.nextInt(JERUSALEM_STREET_BANK.length)];
        }

        return this.streetName;
    }

    public City(int index) {//O(1)
        this.cityName = CITY_NAME_BANK[index];
        this.district = matchDistrict();
        this.streetName = matchStreetToCity();
    }

    public String matchDistrict() { //O(1)
        if (this.cityName.equalsIgnoreCase("Beer Sheva")) {
            this.district = DISTRICT_NAME_BANK[0];
        } else if (this.cityName.equalsIgnoreCase("Eilat") || this.cityName.equalsIgnoreCase("Ashkelon") || this.cityName.equalsIgnoreCase("Ashdod")) {
            this.district = DISTRICT_NAME_BANK[1];
        } else if (this.cityName.equalsIgnoreCase("Tel Aviv") || this.cityName.equalsIgnoreCase("Jerusalem")) {
            this.district = DISTRICT_NAME_BANK[2];
        } else if (this.cityName.equalsIgnoreCase("Haifa") || this.cityName.equalsIgnoreCase("Sefad") || this.cityName.equalsIgnoreCase("Karmiel")) {
            this.district = DISTRICT_NAME_BANK[3];
        } else if (this.cityName.equalsIgnoreCase("Netanya")) {
            this.district = DISTRICT_NAME_BANK[4];
        }

        return this.district;
    }

    public String getCityName() { //O(1)
        return this.cityName;
    }

    public String toString() { //O(1)
        return this.cityName + ", " + this.district;
    }

    public String[] getStreets(String input) { //O(1)
        String[] relevantStreets = new String[0];

        if (input.equalsIgnoreCase("Eilat")) {
            relevantStreets = EILAT_STREET_BANK;
        } else if (input.equalsIgnoreCase("Beer Sheva")) {
            relevantStreets = BEER_SHEVA_STREET_BANK;
        } else if (input.equalsIgnoreCase("Ashkelon")) {
            relevantStreets = ASHKELON_STREET_BANK;
        } else if (input.equalsIgnoreCase("Tel Aviv")) {
            relevantStreets = TEL_AVIV_STREET_BANK;
        } else if (input.equalsIgnoreCase("Haifa")) {
            relevantStreets = HAIFA_STREET_BANK;
        } else if (input.equalsIgnoreCase("Sefad")) {
            relevantStreets = SEFAD_STREET_BANK;
        } else if (input.equalsIgnoreCase("Netanya")) {
            relevantStreets = NETANYA_STREET_BANK;
        } else if (input.equalsIgnoreCase("Karmiel")) {
            relevantStreets = KARMIEL_STREET_BANK;
        } else if (input.equalsIgnoreCase("Ashdod")) {
            relevantStreets = ASHDOD_STREET_BANK;
        } else if (input.equalsIgnoreCase("Jerusalem")) {
            relevantStreets = JERUSALEM_STREET_BANK;
        }
        return relevantStreets;
    }

}
