package com.stuff.location_service.mapper;

import com.stuff.location_service.dto.HouseholdCreateRequest;
import com.stuff.location_service.dto.HouseholdDto;
import com.stuff.location_service.dto.UserDto;
import com.stuff.location_service.model.Household;
import com.stuff.location_service.model.User;

public class HouseholdMapper {
    public HouseholdDto toHouseholdDto(Household household){
        return HouseholdDto.builder()
                .id(household.getId())
                .owner(household.getOwner())
                .sqft(household.getSqft())
                .build();
    }

    public Household toHousehold(HouseholdDto householdDTO){
        return Household.builder()
                .id(householdDTO.getId())
                .owner(householdDTO.getOwner())
                .sqft(householdDTO.getSqft()).build();
    }

    public Household toHousehold(HouseholdCreateRequest householdCreateRequest, String houseHoldId){
        return Household.builder()
                .id(houseHoldId)
                .owner(householdCreateRequest.getOwner())
                .sqft(householdCreateRequest.getSqft()).build();
    }

    public User MapToUser(UserDto userDTO){
        return new User(userDTO.getEmail(), userDTO.getName());
    }

    public UserDto MapToUserDto(User user){
        return new UserDto(user.getEmail(), user.getName());
    }
}
