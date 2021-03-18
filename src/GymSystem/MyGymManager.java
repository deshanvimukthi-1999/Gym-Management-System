package GymSystem;


import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import java.util.List;
import java.util.Scanner;

public class MyGymManager implements  GymManager {
    int count = 100; //max count

    private static Scanner input = new Scanner(System.in);


    MongoClient mongoClient = new MongoClient("localhost", 27017);
    MongoDatabase mongoDatabase = mongoClient.getDatabase("GymDatabase");
    MongoCollection< Document > collection = mongoDatabase.getCollection("Members");


    @Override
    public void addDefaultMember(DefaultMember memberName) {
        MongoCollection< Document > collection = mongoDatabase.getCollection("Members");
        System.out.println("Here the collection was successful!!");

        Document document = new Document()
                .append("Member Name", memberName.getMemberName())
                .append("Membership Number", memberName.getMembershipNumber())
                .append("Membership Start Date", memberName.getMembershipStartDate())
                .append("Type", "Default Member");
        collection.insertOne(document);
        System.out.println("The document is included");
        long count = collection.count();
        System.out.println("----------------------------------------------");
        System.out.println(count + " number of spaces are used out of 100");
        System.out.println("Therefore Available Space Is: " + (this.count - count));
    }

    @Override
    public void addStudentMember(StudentMember memberName) {

        MongoCollection< Document > collection = mongoDatabase.getCollection("Members");
        System.out.println("Here the collection was successful!!");

        Document document = new Document()
                .append("Member Name", memberName.getMemberName())
                .append("Membership Number", memberName.getMembershipNumber())
                .append("Membership Start Date", memberName.getMembershipStartDate())
                .append("School Name", memberName.getSchoolName())
                .append("Type", "Student Member");
        collection.insertOne(document);
        System.out.println("The document is included");
        long count = collection.count();
        System.out.println("----------------------------------------------");
        System.out.println(count + " number of spaces are used out of 100");
        System.out.println("Therefore Available Space Is: " + (this.count - count));
    }

    @Override
    public void addOver60Member(Over60Member memberName) {

        MongoCollection< org.bson.Document > collection = mongoDatabase.getCollection("Members");
        System.out.println("Here the collection was successful!!");

        Document document = new Document()
                .append("Member Name", memberName.getMemberName())
                .append("Membership Number", memberName.getMembershipNumber())
                .append("Membership Start Date", memberName.getMembershipStartDate())
                .append("Age", memberName.getAge())
                .append("Type", "Over 60 Member");
        collection.insertOne(document);
        System.out.println("The document is included");
        long count = collection.count();
        System.out.println("----------------------------------------------");
        System.out.println(count + " number of spaces are used out of 100");
        System.out.println("Therefore the Available Space Is: " + (this.count - count));
    }


    @Override
    public void deleteMember(int membershipNumber) {

        MongoCollection<Document> collection = mongoDatabase.getCollection("Members");
        System.out.println("Here the collection was successful!!");
        try {
            DeleteResult deleteResult = collection.deleteOne(Filters.eq("Membership Number", membershipNumber));
            if (deleteResult.getDeletedCount() > 0) {
                System.out.println("Deleted Member with Membership Number" + membershipNumber + " successfully");
            } else {
                System.out.println("Number not found,Access denied! ");
            }

        } catch (Exception e) {
            System.out.println("Unfortunately, the delete was unsuccessful ");
        }
        long count = collection.count();
        System.out.println("----------------------------------------------");
        System.out.println(count + " number of spaces are used out of 100");
        System.out.println("Therefore is Available Space Is: " + (this.count - count));

    }


    @Override
    public void viewList() {

        MongoCollection<Document> collection = mongoDatabase.getCollection("Members");
        System.out.println("Here the collection was successful!!");
        System.out.println("Print List of Members!!");
        System.out.println();
        for (Document viewList : collection.find()) {
            System.out.println("Member Name : " + viewList.get("Member Name"));
            System.out.println("Membership Number : " + viewList.get("Membership Number"));
            System.out.println("Membership Start Date : " + viewList.get("Membership Start Date"));
            System.out.println("Type: " + viewList.get("Type"));
            System.out.println();
        }
    }


    @Override
    public void sortMembers() {

        MongoCollection< Document > collection = mongoDatabase.getCollection("Members");
        System.out.println("Here the collection was successful!!");
        System.out.println();
        System.out.println("Sort Members in Ascending Order!!");
        FindIterable<Document> sortMembers = collection.find().sort(new BasicDBObject("Member Name", 1));
        for (Document sort : sortMembers ){
            System.out.println(sort.get("Member Name") + " : " + sort.get("Membership Number" ));
        }

    }


    @Override
    public void save() {

    }


    @Override
    public List< DefaultMember > getmemberList() {
        return null;
    }

    @Override
    public DefaultMember getmembershipNumber(int membershipNumber) {
        return null;
    }

    @Override
    public DefaultMember[] getmemberbyname(String memberName) {
        return new DefaultMember[0];
    }
}
