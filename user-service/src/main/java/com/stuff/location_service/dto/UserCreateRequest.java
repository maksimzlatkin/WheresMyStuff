package com.stuff.location_service.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserCreateRequest {
    private String email;
    private String name;
}
