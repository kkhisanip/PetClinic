package com.mycompany.petclinic;

public class RuangPeriksa {
    private String namaRuangan;
    private int kapasitasMejaPeriksa;

    public RuangPeriksa(String namaRuangan, int kapasitasMejaPeriksa) {
        this.namaRuangan = namaRuangan;
        this.kapasitasMejaPeriksa = kapasitasMejaPeriksa;
    }

    public void bukaRuangan() {
        System.out.println("-> " + this.namaRuangan + " dibuka. Kapasitas: " 
                + this.kapasitasMejaPeriksa + " meja pemeriksaan.");
    }
}

