import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дмитрий on 14.10.2017.
 */
public class BeanUtils {
    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        Method[] methodsInTo = saveAllMethods(to);
        Method[] methodsInFrom = saveAllMethods(from);

        Map<String, Object> mapFrom = createMapforFrom(methodsInFrom, from);
        Map<String, Method> mapTo = createMapforTo(methodsInTo, to);

        for (String fieldInFromClass : mapFrom.keySet()) {
            if (mapTo.keySet().contains(fieldInFromClass)) {
                if (checkForSuperClass(mapFrom.get(fieldInFromClass).getClass(), mapTo.get(fieldInFromClass))) {
                    mapTo.get(fieldInFromClass).invoke(to, mapFrom.get(fieldInFromClass));
                } else checkFloatInt(mapFrom.get(fieldInFromClass), mapTo.get(fieldInFromClass), to);
            }
        }
    }

    public static Method[] saveAllMethods(Object o) {
        Class clazz = o.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        return methods;
    }

    public static Map<String, Object> createMapforFrom(Method[] methods, Object from) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> fieldsInObject = new HashMap<>();
        for (Method method : methods) {
            if (method.getName().substring(0, 3).equals("get")) {
                fieldsInObject.put(method.getName().substring(3), method.invoke(from));
            }
        }
        return fieldsInObject;
    }

    public static Map<String, Method> createMapforTo(Method[] methods, Object to) throws InvocationTargetException, IllegalAccessException {
        Map<String, Method> fieldsInObject = new HashMap<>();
        for (Method method : methods) {
            if (method.getName().substring(0, 3).equals("set")) {
                fieldsInObject.put(method.getName().substring(3), method);
            }
        }
        return fieldsInObject;
    }

    public static boolean checkForSuperClass(Class from, Method setTo) {
        String to = setTo.getParameterTypes()[0].getName();
        while (from.getSuperclass() != null) {
            if (from.getName().equals(to)) return true;
            else from = from.getSuperclass();
        }
        return false;
    }

    public static void checkFloatInt(Object from, Method setTo, Object to) throws InvocationTargetException, IllegalAccessException {
        String setTypeName = setTo.getParameterTypes()[0].getName();

        if (from instanceof Integer) {
            Integer integerInt = (Integer) from;
            if (setTypeName == "float" || setTypeName == "Float") {
                float resultSet = integerInt.floatValue();
                setTo.invoke(to, resultSet);
            }
            if (setTypeName == "int" || setTypeName == "Integer") {
                int resultSet = integerInt.intValue();
                setTo.invoke(to, resultSet);
            }
        }
        if (from instanceof Float) {
            Float floatFloat = (Float) from;
            if (setTypeName == "float" || setTypeName == "Float") {
                float resultSet = floatFloat.floatValue();
                setTo.invoke(to, resultSet);
            }
        }

    }


}

