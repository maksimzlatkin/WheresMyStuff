package com.stuff.location_service.repository;

import com.stuff.location_service.model.Household;
import com.stuff.location_service.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class HouseholdRepositoryImpl implements HouseholdRepository {

    private List<Household> list;
    public HouseholdRepositoryImpl() {
        list = new ArrayList<Household>();
        list.add(Household.builder()
                .id(UUID.randomUUID().toString())
                .owner("somegmail@gmail.com")
                .sqft(1200)
                .members(new ArrayList<User>()).build());
        list.add(Household.builder()
                .id(UUID.randomUUID().toString())
                .owner("random@gmail.com")
                .sqft(1500)
                .members(new ArrayList<User>()).build());
    }

    public List<Household> FindAllHouseholds(){
        return list;
    }

    public Household FindHousehold(String id){
        for (Household household : list){
            if (household.getId().equals(id)) {
                return household;
            }
        }
        return null;
    }

    public List<User> FindAllUsers(String id) {
        for (Household household : list) {
            if (id.equals(household.getId())){
                return household.getMembers();
            }
        }
        return null;
    }

    public void CreateHousehold(Household household){
        list.add(household);
    }

    public void AddUserToHousehold(String id, User user){
        FindHousehold(id).getMembers().add(user);
    }
}
