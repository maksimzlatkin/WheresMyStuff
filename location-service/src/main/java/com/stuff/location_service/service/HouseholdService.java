package com.stuff.location_service.service;

import com.stuff.location_service.dto.HouseholdCreateRequest;
import com.stuff.location_service.dto.HouseholdDto;
import com.stuff.location_service.dto.UserDto;
import com.stuff.location_service.mapper.HouseholdMapper;
import com.stuff.location_service.model.Household;
import com.stuff.location_service.model.User;
import com.stuff.location_service.repository.HouseholdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.stuff.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HouseholdService {

    private final HouseholdRepository householdRepository;
    HouseholdMapper mapper = new HouseholdMapper();

    public void CreateHousehold(HouseholdCreateRequest householdCreateRequest){
        householdRepository.CreateHousehold(mapper.toHousehold(householdCreateRequest, UUID.randomUUID().toString()));
    }

    public void AddUserToHousehold(String id, UserDto userDTO){
        GetHouseholdOrThrowException(id);
        householdRepository.AddUserToHousehold(id, mapper.MapToUser(userDTO));
    }

    public List<HouseholdDto> GetHouseholds(){
        List<HouseholdDto> households = new ArrayList<HouseholdDto>();
        for (Household household : householdRepository.FindAllHouseholds()) {
            households.add(mapper.toHouseholdDto(household));
        }
        return households;
    }

    public HouseholdDto GetHousehold(String id){
        Household household = GetHouseholdOrThrowException(id);
        return mapper.toHouseholdDto(household);
    }

    public List<UserDto> GetMembers(String id){
        List<UserDto> users = new ArrayList<UserDto>();
        if (householdRepository.FindAllUsers(id) == null) throw new EntityNotFoundException();
        for (User user : householdRepository.FindAllUsers(id)) {
            users.add(mapper.MapToUserDto(user));
        }
        return users;
    }

    private Household GetHouseholdOrThrowException(String id){
        Household household = householdRepository.FindHousehold(id);
        if (household == null) {
            throw new EntityNotFoundException(String.format("Customer with id='%s' not found", id));
        }
        return household;
    }
}
