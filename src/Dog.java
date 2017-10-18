import javax.xml.soap.SAAJResult;

/**
 * Created by Дмитрий on 14.10.2017.
 */
public class Dog {
    private String firstName;
    private Float age;
    private String country;

    public Dog(String firstName, Float age, String country) {
        this.firstName = firstName;
        this.age = age;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void firstMethodInDog(){}
    public void secondMethodInDog(){}



}
