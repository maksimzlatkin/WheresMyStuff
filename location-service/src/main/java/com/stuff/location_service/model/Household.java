package com.stuff.location_service.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
//@Document(value =  "Household")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Household {
    private String id;
    private String owner;
    private int sqft;

    private List<User> members;
}