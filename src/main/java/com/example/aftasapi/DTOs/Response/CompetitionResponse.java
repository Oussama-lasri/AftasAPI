package com.example.aftasapi.DTOs.Response;

import com.example.aftasapi.DTOs.CompetitionDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionResponse {
    List<CompetitionDTO> competitions ;
    private int pageNumber ;
    private int pageSize ;
    private long totalElement ;
    private int totalPage ;
    private boolean last ;

}
