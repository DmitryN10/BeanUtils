import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Дмитрий on 14.10.2017.
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person person = new Person("Dmitry", "Nikiforov", 23, "Cheboksary");
        Dog dog = new Dog("dog",12f, "dwwefe");
        BeanUtils.assign(dog,person);
        System.out.println(dog.getFirstName());
        System.out.println(dog.getAge());
        System.out.println(dog.getCountry());
    }
}
