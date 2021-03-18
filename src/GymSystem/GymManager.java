package GymSystem;


import java.util.List;


public interface GymManager {

    public void addDefaultMember(DefaultMember memberName);

    public void addStudentMember(StudentMember memberName);

    public void addOver60Member(Over60Member memberName);

    public void deleteMember(int membershipNumber);


    public void viewList();


    public void sortMembers();

    public void save();

    public List<DefaultMember> getmemberList();
    public DefaultMember getmembershipNumber(int membershipNumber);
    public DefaultMember[] getmemberbyname(String memberName);

}

