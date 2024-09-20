package com.upc.cargasinestres.companymanagement_service.CompanyManagement.service;

import com.upc.cargasinestres.companymanagement_service.CompanyManagement.model.dto.Servicio.request.ServicioRequestDto;
import com.upc.cargasinestres.companymanagement_service.CompanyManagement.model.dto.Servicio.response.ServicioResponseDto;

import java.util.List;

public interface IServicioService {
    //create service
    public abstract ServicioResponseDto createServicio(ServicioRequestDto servicioRequestDto);

    //get services
    public abstract List<ServicioResponseDto> getAllServices();

    public abstract List<ServicioResponseDto> getAllServicesByIds(List<Long> servicioIds);
}