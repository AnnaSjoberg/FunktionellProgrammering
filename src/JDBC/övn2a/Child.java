package JDBC.övn2a;

public class Child {
    protected int id;
    protected String name;
    protected int niceNumber;

    public Child(int id, String name,int niceNumber) {
        this.id = id;
        this.name = name;
        this.niceNumber = niceNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNiceNumber() {
        return niceNumber;
    }

    public void setNiceNumber(int niceNumber) {
        this.niceNumber = niceNumber;
    }

    public void printOut(){
        if (getNiceNumber()>2){
            System.out.println(this.name + " is a sweetie pie");
        }
        else {
            System.out.println(this.name + " is a little monster");
        }
    }
}
