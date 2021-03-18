package GymSystem;

public class Over60Member extends DefaultMember {

    public Integer age;

    public int setAge() {return age;}
    public  void setAge(int age){this.age = age;}


    public Over60Member(String memberName, int memberNumber, String membershipStartDate, Integer age){
        super(memberName,memberNumber,membershipStartDate);
        this.age = age;
    }

    public int getAge() { //getter to get Age
        return age;
    }

}
