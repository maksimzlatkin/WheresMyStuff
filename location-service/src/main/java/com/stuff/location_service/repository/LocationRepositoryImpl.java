package com.stuff.location_service.repository;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import com.stuff.location_service.mapper.HouseholdMapper;
import com.stuff.location_service.model.Household;
import com.stuff.location_service.model.User;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class LocationRepositoryImpl implements HouseholdRepository {
    ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
    ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .serverApi(serverApi).build();

    MongoClient mongoClient = MongoClients.create(settings);
    MongoDatabase database = mongoClient.getDatabase("wheresmystuff");
    MongoCollection collection = database.getCollection("locations");
    public List<Household> FindAllHouseholds(){
        ArrayList<Household> list = new ArrayList<Household>();
        FindIterable<Document> iterable = collection.find();
        for (Document document : iterable) {
            list.add(new HouseholdMapper().toHousehold(document));
        }
        return list;
    }

    public Household FindHousehold(String id){
        Document found = (Document) collection.find(new Document("id", id)).first();
        if (found != null) {
            return new HouseholdMapper().toHousehold(found);
        }
        return null;
    }

    public List<User> FindAllUsers(String id) {
//        for (Household household : list) {
//            if (id.equals(household.getId())){
//                return household.getMembers();
//            }
//        }
        return null;
    }

    public void CreateHousehold(Household household){
        Document document = new HouseholdMapper().toDocument(household);
        collection.insertOne(document);
    }

    public void AddUserToHousehold(String id, User user){
        FindHousehold(id).getMembers().add(user);
    }
}
