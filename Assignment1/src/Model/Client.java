package Model;

public class Client {
    private int clientId;
    private String name;
    private String CNP;
    private String address;

    public Client(){
    }

    public Client(String name, int id, String CNP, String address) {
        this.name = name;
        this.clientId = id;
        this.CNP = CNP;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return clientId;
    }

    public void setId(int id) {
        this.clientId = id;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
