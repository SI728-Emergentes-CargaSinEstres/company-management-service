package com.upc.cargasinestres.companymanagement_service.Shared.dto.response;

import com.upc.cargasinestres.companymanagement_service.Shared.dto.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class that represents a response from the API
 * @param <T> type of data returned in the response
 * @author Grupo1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private EStatus status;
    private T data;
}
