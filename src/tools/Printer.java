package tools;
import java.lang.reflect.Field;
public class Printer {
    public static String WholeObjectToString(Object object) throws IllegalAccessException {
        if(object == null){ return "null";}

        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder s = new StringBuilder();
        s.append("{");

        for(Field field : fields){
            //noinspection deprecation
            if(field.isAccessible()){
                s.append(field.getClass());
                s.append(": ");
                s.append(field.getName());
                s.append(" = ");
                s.append(field.get(object));
                s.append(", ");
            } else{
                s.append("field unaccessible, ");
            }
        }

        s.append("}");
        return s.toString();
    }
}
