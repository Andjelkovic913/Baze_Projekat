package model;

public class Psihoterapeut {
    private int id;
    private String ime;
    private String prezime;
    private String email;

    public Psihoterapeut(int id, String ime, String prezime, String email) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
    }

    public String toString() {
        return ime + " " + prezime;
    }

    // Getteri
    public int getId() { return id; }
    public String getEmail() { return email; }
}
