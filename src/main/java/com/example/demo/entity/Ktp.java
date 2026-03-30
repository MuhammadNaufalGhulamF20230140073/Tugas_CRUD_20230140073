package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data // Anotasi ajaib dari Lombok
@Entity
@Table(name = "KTP")
public class Ktp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomorKtp", unique = true, nullable = false, length = 16)
    private String nomorKtp;

    @Column(name = "namaLengkap", nullable = false, length = 150)
    private String namaLengkap;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "tanggalLahir", nullable = false)
    private LocalDate tanggalLahir;

    @Column(name = "jenisKelamin", nullable = false, length = 20)
    private String jenisKelamin;
}