package com.auto;

import com.auto.bean.User;
import com.auto.util.Column;
import com.auto.util.Table;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(1);
        user.setEmail("test@qq.com");
        user.setName("test");
        System.out.println(query(user));
    }

    public static String query(User user){
        StringBuffer sb = new StringBuffer();
        //1.获取class
        Class c = user.getClass();
        //2.获取到table的名字
        boolean isU = c.isAnnotationPresent(Table.class);
        if(!isU){
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append("select * from ").append(tableName).append(" where 1 = 1 ");
        //3.遍历所有的字段
        Field [] fArray = c.getDeclaredFields();
        boolean isC = false;
        for (Field f: fArray) {
            //4.处理每个字段对应的sql
            //4.1 拿到字段名字
            isC = f.isAnnotationPresent(Column.class);
            if(!isC){
                continue;
            }
            Column column = (Column)f.getAnnotation(Column.class);
            String columnName = column.value();
            //4.2 拿到字段的值
            String fileName = f.getName();
            String getMethonName = "get"+fileName.substring(0,1).toUpperCase()+fileName.substring(1);
            Object obj = null;
            try {
                Method method = c.getMethod(getMethonName);
                obj = method.invoke(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //4.3 拼装sql
            if(obj == null ||
                    (obj instanceof Integer && (Integer)obj == 0)){
                continue;
            }
            sb.append(" and ").append(fileName);
            if(obj instanceof Integer){
                sb.append(" = ").append(obj);
            }else if(obj instanceof String){
                sb.append(" = '").append(obj).append("'");
            }
        }
        return sb.toString();
    }
}
