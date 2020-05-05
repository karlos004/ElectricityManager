package com.emApi.base.rowMapper;

import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DefaultEntityMapper<T> implements RowMapper<DefaultEntityMapper.MappedEntityContainer<T>> {

    private Class<T> tClass;

    public DefaultEntityMapper(Class<T> entityClass) {
        this.tClass = entityClass;
    }

    @Override
    public MappedEntityContainer<T> mapRow(ResultSet rs, int rowNum) throws SQLException {

        List<Field> fields = Arrays.asList(tClass.getDeclaredFields());
        if(fields.isEmpty()) {
            return new MappedEntityContainer(new ArrayList<T>());
        }

        while(rs.isBeforeFirst()) {
            rs.next();
        }

        List<T> resultList = new ArrayList<>();
        List<Class<?>> tFieldsTypes = new ArrayList<>();
        List<Object> args = new ArrayList<>();
        do {
            for (Field field : fields) {
                tFieldsTypes.add(field.getType());
                if (notNull(field.getAnnotation(Column.class))) {
                    args.add(rs.getObject(field.getAnnotation(Column.class).name()));
                } else {
                    args.add(null);
                }
            }

//            try {
//                resultList.add(tClass.getConstructor(tFieldsTypes.toArray(Class[]::new)).newInstance(args.toArray()));
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
        } while (rs.next());

        return new MappedEntityContainer(resultList);
    }

    private static boolean isNull(Object arg) {
        if(arg == null) {
            return true;
        }
        return false;
    }

    private static boolean notNull(Object arg) {
        if(arg == null) {
            return false;
        }
        return true;
    }

    public static class MappedEntityContainer<T> {
        List<T> entites;

        protected MappedEntityContainer(List<T> entites) {
            this.entites = entites;
        }

        public T getFirst() {
            if(isNull(entites)) {
                return null;
            } else if(entites.isEmpty()) {
                return null;
            }
            return entites.get(0);
        }

        public List<T> getList() {
            return entites;
        }
    }
}
