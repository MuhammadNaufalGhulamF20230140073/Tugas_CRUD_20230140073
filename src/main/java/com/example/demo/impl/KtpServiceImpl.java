package com.example.demo.impl;

import com.example.demo.dto.KtpDto;
import com.example.demo.entity.Ktp;
import com.example.demo.mapper.KtpMapper;
import com.example.demo.repository.KtpRepository;
import com.example.demo.service.KtpService;
import com.example.demo.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Override
    public KtpDto createKtp(KtpDto ktpDto) {
        // Error Handling: Validasi nomor KTP ganda
        if(ktpRepository.existsByNomorKtp(ktpDto.getNomorKtp())) {
            throw new RuntimeException("Error: Nomor KTP sudah terdaftar!");
        }
        Ktp ktp = KtpMapper.mapToEntity(ktpDto);
        Ktp savedKtp = ktpRepository.save(ktp);
        return KtpMapper.mapToDto(savedKtp);
    }

    @Override
    public List<KtpDto> getAllKtp() {
        List<Ktp> ktps = ktpRepository.findAll();
        return ktps.stream().map(KtpMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public KtpDto getKtpById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("KTP tidak ditemukan dengan id: " + id));
        return KtpMapper.mapToDto(ktp);
    }

    @Override
    public KtpDto updateKtp(Integer id, KtpDto ktpDto) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("KTP tidak ditemukan dengan id: " + id));

        ktp.setNomorKtp(ktpDto.getNomorKtp());
        ktp.setNamaLengkap(ktpDto.getNamaLengkap());
        ktp.setAlamat(ktpDto.getAlamat());
        ktp.setTanggalLahir(ktpDto.getTanggalLahir());
        ktp.setJenisKelamin(ktpDto.getJenisKelamin());

        Ktp updatedKtp = ktpRepository.save(ktp);
        return KtpMapper.mapToDto(updatedKtp);
    }

    @Override
    public void deleteKtp(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("KTP tidak ditemukan dengan id: " + id));
        ktpRepository.delete(ktp);
    }
}