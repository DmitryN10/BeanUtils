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







//        Method[] methods = BeanUtils.saveAllMethods(person);
//        Map<String, Object> map = BeanUtils.createMapforFrom(methods, person);
//        System.out.println(map.keySet());
//        System.out.println(map.get("FirstName"));
//        System.out.println(map.get("LastName"));
//        System.out.println(map.get("Age"));

//        Dog dog = new Dog("dog", 11, "dwwefe");
//        Method[] methods1 = BeanUtils.saveAllMethods(dog);
//        Map<String, Method> map1 = BeanUtils.createMapforTo(methods1, dog);
//        System.out.println(map1.keySet());
//        System.out.println(map1.get("FirstName"));





    }
}
