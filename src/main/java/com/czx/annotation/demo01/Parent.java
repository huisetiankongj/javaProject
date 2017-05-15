package com.czx.annotation.demo01;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Parent<T> {

	private Class<T> entity; 
	
	 public Parent() {  
	    init();  
	 }  

	 public List<SortableField> init(){  
		 List<SortableField> list = new ArrayList<SortableField>();  
		 entity = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass())  
	                .getActualTypeArguments()[0];  
		 
		 if(this.entity!=null){  
			 Field[] fields = entity.getDeclaredFields();  
			 for(Field f : fields){  
				//��ȡ�ֶ��а���fieldMeta��ע��  
	            FieldMeta meta = f.getAnnotation(FieldMeta.class);  
	            if(meta!=null){  
                    SortableField sf = new SortableField(meta, f);  
                    list.add(sf);  
                }
			 }	 
			 
			//���ض�������ʾ�����ӿڵ����пɷ��ʹ�������  
	        Method[] methods = entity.getMethods();  
	        for(Method m:methods){  
                FieldMeta meta = m.getAnnotation(FieldMeta.class);  
                if(meta!=null){  
                    SortableField sf = new SortableField(meta,m.getName(),m.getReturnType());  
                    list.add(sf);  
                }  
            }  
	        
	        Collections.sort(list, new Comparator<SortableField>() {  
                public int compare(SortableField s1,SortableField s2) {  
                    return s1.getMeta().order()-s2.getMeta().order();  
//                  return s1.getName().compareTo(s2.getName());//Ҳ������compare���Ƚ�  
                }  
            });  
		 }	 
		 
		 return list; 
	 }
}
