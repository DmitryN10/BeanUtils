/**
 * Created by Дмитрий on 14.10.2017.
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String nativeCity;

    public Person(String firstName, String lastName, int age, String nativeCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nativeCity = nativeCity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() { return age;}

    public void setAge(int age) {
        this.age = age;
    }

    public String getNativeCity() {
        return nativeCity;
    }

    public void setNativeCity(String nativeCity) {
        this.nativeCity = nativeCity;
    }

    public void firstMethodInPerson(){}

    public void secondMethodInPerson(){}
}
