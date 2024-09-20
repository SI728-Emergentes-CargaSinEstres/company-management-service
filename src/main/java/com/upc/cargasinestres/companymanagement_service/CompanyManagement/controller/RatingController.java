package com.upc.cargasinestres.companymanagement_service.CompanyManagement.controller;

import com.upc.cargasinestres.companymanagement_service.CompanyManagement.model.dto.Rating.request.RatingRequestDto;
import com.upc.cargasinestres.companymanagement_service.CompanyManagement.model.dto.Rating.response.RatingResponseDto;
import com.upc.cargasinestres.companymanagement_service.CompanyManagement.service.IRatingService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Tag(name="Rating Controller")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class RatingController {
    private final IRatingService ratingService;

    public RatingController(IRatingService ratingService) {
        this.ratingService = ratingService;
    }

    @CircuitBreaker(name = "BusinessCB", fallbackMethod = "fallBackPostRating")
    @PostMapping("/ratings/{idCompany}")
    public ResponseEntity<RatingResponseDto> createRating(@PathVariable Long idCompany, @RequestBody RatingRequestDto ratingRequestDto){
        var res = ratingService.createRating(idCompany, ratingRequestDto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @CircuitBreaker(name = "BusinessCB", fallbackMethod = "fallBackGetRating")
    @GetMapping("/ratings/company/{idCompany}")
    public ResponseEntity<?> getRatingsByCompanyId(@PathVariable Long idCompany){
        var res = ratingService.getRatingsByCompanyId(idCompany);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    // Fallback method for createRating
    public ResponseEntity<RatingResponseDto> fallBackPostRating(Long idCompany, RatingRequestDto ratingRequestDto, Throwable throwable) {
        RatingResponseDto fallbackResponse = new RatingResponseDto();
        fallbackResponse.equals("Service temporarily unavailable. Please try again later.");
        return new ResponseEntity<>(fallbackResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }

    // Fallback method for getRatingsByCompanyId
    public ResponseEntity<?> fallBackGetRating(Long idCompany, Throwable throwable) {
        List<RatingResponseDto> fallbackResponse = Collections.emptyList();
        return new ResponseEntity<>(fallbackResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
