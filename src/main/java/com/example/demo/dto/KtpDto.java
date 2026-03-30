package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDate;

@Data // Anotasi ini otomatis membuatkan Getter, Setter, dll di latar belakang
public class KtpDto {
    private Integer id;
    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private LocalDate tanggalLahir;
    private String jenisKelamin;
}