package com.stuff.location_service.repository;

import com.stuff.location_service.model.Household;
import com.stuff.location_service.model.User;

import java.util.List;

public interface HouseholdRepository {
    List<Household> FindAllHouseholds();

    Household FindHousehold(String id);

    List<User> FindAllUsers(String id);

    void CreateHousehold(Household household);

    void AddUserToHousehold(String id, User user);
}
