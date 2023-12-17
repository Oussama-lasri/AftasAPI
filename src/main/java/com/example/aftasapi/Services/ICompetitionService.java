package com.example.aftasapi.Services;

import com.example.aftasapi.DTOs.CompetitionDTO;
import com.example.aftasapi.BaseInterfaces.IBaseService;
import com.example.aftasapi.DTOs.Response.CompetitionResponse;

public interface ICompetitionService extends IBaseService<CompetitionDTO> {
    public CompetitionResponse allCompetitionWithPagination(int pageNumber , int pageSize);

}
