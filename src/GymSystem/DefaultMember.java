package GymSystem;

public class DefaultMember {

    private String memberName;
    private int memberNumber;
    private String membershipStartDate;

    public DefaultMember(String memberName, int membershipNumber, String membershipStartDate){
        super();
        this.memberName = memberName;
        this.memberNumber = membershipNumber;
        this.membershipStartDate = membershipStartDate;
    }



    public String getMemberName() {//getter to getmembername

        return memberName;
    }

    public void setMemberName(String memberName) {//setter for  membername
        this.memberName = memberName;
    }

    public int getMembershipNumber() {//getter to get membershipnumber
        return memberNumber;
    }

    public void setMembershipNumber(int membershipNumber) {//setter for membershipnumber
        this.memberNumber = membershipNumber;
    }

    public String getMembershipStartDate() {//getter to get membershipstartdate
        return membershipStartDate;
    }

    public void setMembershipStartDate(String membershipStartDate) {//setter for membershipstartdate
        this.membershipStartDate = membershipStartDate;
    }
}



