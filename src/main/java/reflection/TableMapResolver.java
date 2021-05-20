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
           classInfos.forEach(classInfo -> {
               AnnotationInfo annotationInfo = classInfo.getAnnotationInfo(TableAnnotation.class.getName());
               AnnotationParameterValueList paramValues = annotationInfo.getParameterValues();
               String tableName = (String) paramValues.get("name").getValue();
               // TODO 型のチェックをする
               @SuppressWarnings("unchecked")
               Class<Table> tableClass = (Class<Table>)classInfo.loadClass();
               Table table = null;
               try {
                   table = tableClass.getDeclaredConstructor().newInstance();
               } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                   // TODO 例外処理を考える
                   e.printStackTrace();
               }
               tableMap.register(tableName, table);
           });
       }
   }
}
