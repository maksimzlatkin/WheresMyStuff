package com.stuff.location_service.dto;

import com.stuff.location_service.model.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HouseholdDto {
    private String id;
    private String owner;
    private int sqft;
    private List<User> members;
}
