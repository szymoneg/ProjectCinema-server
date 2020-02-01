package com.cinema.service;

import com.cinema.domain.dto.FileData;
import com.cinema.domain.dto.ReservationDto;

import java.util.List;

public interface FileService {

    FileData createFile(ReservationDto reservationDto,String path);

    List<FileData> findAll(String path);
}
