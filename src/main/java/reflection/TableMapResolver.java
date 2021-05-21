package reflection;

import anno.TableAnnotation;
import core.TableMap;
import io.github.classgraph.*;
import object.Table;

import java.lang.reflect.InvocationTargetException;

public class TableMapResolver {

   public void run(final TableMap tableMap) {
       try (ScanResult result = new ClassGraph().enableClassInfo().enableAnnotationInfo().scan()) {
           ClassInfoList classInfos = result.getClassesWithAnnotation(TableAnnotation.class.getName());
           for (ClassInfo classInfo : classInfos) {
               String tableName = this.resolveTableName(classInfo);
               try {
                   Table table = this.resolveTableObject(classInfo);
                   tableMap.register(tableName, table);
               } catch (Exception e) {
                   System.err.println(e.getMessage());
               }
           }
       }
    }

    private String resolveTableName(final ClassInfo classInfo) {
        AnnotationInfo annotationInfo = classInfo.getAnnotationInfo(TableAnnotation.class.getName());
        AnnotationParameterValueList paramValues = annotationInfo.getParameterValues();
        return (String) paramValues.get("name").getValue();
    }

    private Table resolveTableObject(final ClassInfo classInfo) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (!classInfo.extendsSuperclass(Table.class.getName())) {
            throw new ClassCastException(String.format("%s is not extend %s", classInfo.getName(), Table.class.getName()));
        }
        @SuppressWarnings("unchecked")
        Class<Table> tableClass = (Class<Table>)classInfo.loadClass();
        return tableClass.getDeclaredConstructor().newInstance();
    }
}
