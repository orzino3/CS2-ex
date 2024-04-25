public class Property {

    private City city;
    private String street;
    private int roomCapacity;
    private int price;
    private String type;
    private String status;
    private int houseNumber;
    private int floorNumber;
    private User user;

    public Property(City city, String street, int floorNumber, int roomCapacity, int price,
                    String type, String status, int houseNumber, User user) {//O(1)
        this.city = city;
        this.street = street;
        this.roomCapacity = roomCapacity;
        this.price = price;
        this.type = (type.equals("1") ? "Regular" : "Penthouse");
        this.status = status;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.user = user;
    }

    public Property(City city, String street, int roomCapacity, int price, String type, String status,
                    int houseNumber, User user) {//O(1)
        this.city = city;
        this.street = street;
        this.roomCapacity = roomCapacity;
        this.price = price;
        this.type = "Private Apartment";
        this.status = status;
        this.houseNumber = houseNumber;
        this.user = user;
    }

    public int getRoomCapacity() {//O(1)
        return roomCapacity;
    }


    public int getPrice() {//O(1)
        return price;
    }


    public String getType() {//O(1)
        return type;
    }

    public String getStatus() {//O(1)
        return status;
    }


    public User getUser() {//O(1)
        return user;
    }

    public String toString() {//O(1)
        return this.city + " - " + this.street + " " + this.houseNumber + "\n" + this.type + " - for " + this.status + ": " + this.roomCapacity + " rooms, floor " + this.floorNumber + ".\nprice: " + this.price + "$.\n"
                + "Contact info: " + this.user;
    }
}
