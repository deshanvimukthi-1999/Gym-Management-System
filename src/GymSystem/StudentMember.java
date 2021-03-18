package GymSystem;


public class StudentMember extends DefaultMember{
    public String SchoolName;

    public StudentMember(String memberName, int memberNumber, String membershipStartDate, String SchoolName){
        super( memberName,memberNumber,membershipStartDate);
        this.SchoolName = SchoolName;
    }
    public String getSchoolName() { //getter to get SchoolName
        return SchoolName;
    }

    public void setSchoolName(String Name) {  //setter for SchoolName
        this.SchoolName = Name;
    }

}


