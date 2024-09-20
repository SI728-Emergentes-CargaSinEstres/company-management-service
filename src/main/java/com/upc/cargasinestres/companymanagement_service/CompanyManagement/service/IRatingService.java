package com.upc.cargasinestres.companymanagement_service.CompanyManagement.service;


import com.upc.cargasinestres.companymanagement_service.CompanyManagement.model.dto.Rating.request.RatingRequestDto;
import com.upc.cargasinestres.companymanagement_service.CompanyManagement.model.dto.Rating.response.RatingResponseDto;

import java.util.List;

public interface IRatingService {
    //create rating
    public abstract RatingResponseDto createRating(Long idCompany, RatingRequestDto rating);

    //get rating by company
    public abstract List<RatingResponseDto> getRatingsByCompanyId(Long idCompany);




}
