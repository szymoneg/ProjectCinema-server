package com.cinema.service.impl;

import com.cinema.domain.dto.FileData;
import com.cinema.domain.dto.ReservationDto;
import com.cinema.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public FileData createFile(ReservationDto reservationDto, String path) {
        return null;
    }

    @Override
    public List<FileData> findAll(String path) {
        return null;
    }
}
