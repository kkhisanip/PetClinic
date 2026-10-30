package com.mycompany.petclinic;

public class Owner {
    private String idOwner;
    private String nama;

    public Owner(String idOwner, String nama) {
        this.idOwner = idOwner;
        this.nama = nama;
    }

    public String getIdOwner() {
        return this.idOwner;
    }

    public String getNama() {
        return this.nama;
    }
}
