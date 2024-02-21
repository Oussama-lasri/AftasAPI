package com.example.aftasapi.DTOs.Response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class BooleanResponse {
    private boolean isExist;
}
