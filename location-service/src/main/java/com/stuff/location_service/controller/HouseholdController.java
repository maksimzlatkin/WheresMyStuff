package com.stuff.location_service.controller;

import com.stuff.location_service.dto.HouseholdCreateRequest;
import com.stuff.location_service.dto.HouseholdDto;
import com.stuff.location_service.dto.UserDto;
import com.stuff.location_service.service.HouseholdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/households"})
@RequiredArgsConstructor
public class HouseholdController {

    private final HouseholdService householdService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void CreateHousehold(@RequestBody HouseholdCreateRequest householdCreateRequest){
        householdService.CreateHousehold(householdCreateRequest);
    }

    @PostMapping({"/{id}/members"})
    @ResponseStatus(HttpStatus.CREATED)
    public void AddUserToHousehold(@PathVariable String id, @RequestBody UserDto userDTO){
        householdService.AddUserToHousehold(id, userDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HouseholdDto> GetHouseholds(){
        return householdService.GetHouseholds();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public HouseholdDto GetHousehold(@PathVariable String id){
        HouseholdDto householdDto = householdService.GetHousehold(id);
//        if (householdDto == null) throw new HouseholdNotFoundException();
        return householdDto;
    }

    @GetMapping({"/{id}/members"})
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> GetMembers(@PathVariable String id){
        return householdService.GetMembers(id);
    }
}