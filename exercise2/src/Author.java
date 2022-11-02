public class Author {
    private String name;
    private String address;
    private int phoneNumber;

    public Author(String name, String address, int phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", address: " + address + ", phone number: " + this.phoneNumber;
    }
}
