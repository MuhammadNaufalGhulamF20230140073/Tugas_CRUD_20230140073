package com.example.demo.repository;

import com.example.demo.entity.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KtpRepository extends JpaRepository<Ktp, Integer> {
    boolean existsByNomorKtp(String nomorKtp); // Untuk validasi nomor KTP ganda
}