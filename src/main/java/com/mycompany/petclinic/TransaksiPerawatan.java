package com.mycompany.petclinic;

public class TransaksiPerawatan {
    public static void prosesPerawatan(Owner owner, Pasien pasien) {
        System.out.println("\n=================================");
        System.out.println("Pemilik  : " + owner.getNama() + " (" + owner.getIdOwner() + ")");
        System.out.println("Pasien   : " + pasien.getNama() + " (" + pasien.getJenis() + ")");
        System.out.println("Status   : Berhasil dicatat di sistem");

        pasien.caraPerawatan();
        pasien.biayaPenangananLanjut();

        if (pasien instanceof TindakanLanjut) {
            ((TindakanLanjut) pasien).prosesVaksinasi();
            ((TindakanLanjut) pasien).prosesOperasi();
        }
        
        System.out.println("=================================");
    }
}
