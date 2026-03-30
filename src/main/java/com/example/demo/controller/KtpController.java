package com.example.demo.controller;

import com.example.demo.dto.KtpDto;
import com.example.demo.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.IsolationLevelDataSourceAdapter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    // POST: Tambah KTP
    @PostMapping
    public ResponseEntity<?> createKtp(@RequestBody KtpDto ktpDto) {
        try {
            KtpDto savedKtp = ktpService.createKtp(ktpDto);
            return new ResponseEntity<>(savedKtp, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // GET: Ambil seluruh data
    @GetMapping
    public ResponseEntity<List<KtpDto>> getAllKtp() {
        return ResponseEntity.ok(ktpService.getAllKtp());
    }

    // GET: Ambil berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<KtpDto> getKtpById(@PathVariable Integer id) {
        return ResponseEntity.ok(ktpService.getKtpById(id));
    }
