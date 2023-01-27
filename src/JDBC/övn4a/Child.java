package JDBC.övn4a;

import java.util.List;
import java.util.stream.Collectors;

public class Child {
    private int id;
    private String name;
    private String address;
    private Country country;
    private List<Present> wishList;
    private List<Present> giftList;

    public Child(){}
    public Child(int id, String name, String address, Country country, List<Present> wishList, List<Present> giftList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.wishList=wishList;
        this.giftList=giftList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Present> getWishList() {
        return wishList;
    }

    public void setWishList(List<Present> wishList) {
        this.wishList = wishList;
    }

    public List<Present> getGiftList() {
        return giftList;
    }

    public void setGiftList(List<Present> giftList) {
        this.giftList = giftList;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Address: " + address + '\n' +
                "Country: " + country.getName() + '\n' +
                "Wishes: " + wishList.stream().map(Present::getName).toList() +'\n' +
                "Gifts: " + giftList.stream().map(Present::getName).toList();
    }

    public void print(){
        System.out.println(getName() +" "+ getAddress()+" "+getCountry().getName());
        System.out.println("Wishes: "+ wishList.stream().map(Present::getName).toList());
        System.out.println("Gifts: "+ giftList.stream().map(Present::getName).toList());
    }
}
