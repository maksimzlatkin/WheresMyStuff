package com.stuff.location_service.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HouseholdCreateRequest {
    @Setter
    private String owner;
    @Setter
    private int sqft;
}
