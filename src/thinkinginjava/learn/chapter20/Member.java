package thinkinginjava.learn.chapter20;

@DBTable(name = "Member")
public class Member {

    @SQLString(30)
    String firstname;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    @SQLString(value = 30, constrains = @Constrains(primaryKey = true))
    String handle;

    static int memberCount;

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    @Override
    public String toString() {
        return "Member{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", handle='" + handle + '\'' +
                '}';
    }
}
