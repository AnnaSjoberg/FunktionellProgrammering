package JDBC.övn4b;

import java.util.List;

public class Present {
    private int id;
    private String name;
    private List<Child> wantedBy;
    private List<Child> giftedTo;

    public Present(){}

    public Present(int id, String name,List<Child> wantedBy,List<Child> giftedTo) {
        this.id = id;
        this.name = name;
        this.wantedBy=wantedBy;
        this.giftedTo=giftedTo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Child> getWantedBy() {
        return wantedBy;
    }

    public void setWantedBy(List<Child> wantedBy) {
        this.wantedBy = wantedBy;
    }

    public List<Child> getGiftedTo() {
        return giftedTo;
    }

    public void setGiftedTo(List<Child> giftedTo) {
        this.giftedTo = giftedTo;
    }

    public void print(){
        System.out.println(getName().toUpperCase());
        System.out.println("Wanted by: " + wantedBy.stream().map(Child::getName).toList());
        System.out.println("Gifted to: " + giftedTo.stream().map(Child::getName).toList());
    }
}
