package com.github.uraven0107.reflection;

import com.github.uraven0107.anno.TableAnnotation;
import com.github.uraven0107.core.TableMap;
import com.github.uraven0107.object.Table;
import io.github.classgraph.*;

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
                   tableMap.register(tableName, null);
               }
           }
       }
    }

    private String resolveTableName(final ClassInfo classInfo) {
        AnnotationInfo annotationInfo = classInfo.getAnnotationInfo(TableAnnotation.class.getName());
        AnnotationParameterValueList paramValues = annotationInfo.getParameterValues();
        return (String) paramValues.get("name").getValue();
    }

    private Table resolveTableObject(final ClassInfo classInfo) throws Exception {
        try {
            if (!classInfo.extendsSuperclass(Table.class.getName())) {
                throw new ClassCastException(String.format("%s is not extend %s", classInfo.getName(), Table.class.getName()));
            }
            @SuppressWarnings("unchecked")
            Class<Table> tableClass = (Class<Table>)classInfo.loadClass();
            return tableClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
           throw e;
        }
    }
}
