package ru.spbstu.application.configurator.model.validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.yaml.snakeyaml.Yaml;

public class YamlProperties {
	public static ArrayList<String>arrayList;
	public static String filePath;
    public static LinkedHashMap<String, Object> handler (LinkedHashMap<String, Object> prop, Map<String, Object>result,
                                                         String value, Set<String> key ){
        for (String k:key){
            try {
                if (result.get(k).getClass().getName().equals("java.lang.String")) {
                    String attr = (String) result.get(k);
                    if (attr.contains("$") && attr.contains("{") && attr.contains("}")) {
                        String keys;
                        if (!value.equals("")) {
                            keys = value + '.' + k;
                        } else {
                            keys = k;
                        }
                        prop.put(keys, attr);

                    }
                }else if (result.get(k).getClass().getName().equals("java.util.LinkedHashMap")){
                    LinkedHashMap<String,Object> attr = (LinkedHashMap) result.get(k);
                    Set<String> key_value = attr.keySet();
                    String _key;
                    if (!value.equals("")) {
                        _key = value + '.' + k;
                    }else{
                        _key=k;
                    }
                    handler(prop, attr, _key,  key_value);
                }
                }catch(NullPointerException e){
                    continue;
                }

            }
        return prop;
    }
    public static ArrayList<String> compare(LinkedHashMap<String, Object> attr, Properties properties){
        Set<String> keys = attr.keySet();
        ArrayList<String> arrayList = new ArrayList<>();
        for (String k:keys){
            if (properties.containsKey(k)){
                continue;
            }else {
                arrayList.add(".properties does not contain value: "+k);
            }
        }
        return arrayList;
    }
    public  ArrayList<String> mainFunction(IFile fileYaml, IFile fileProp) throws Exception {
    	   Yaml yaml = new Yaml();
           LinkedHashMap<String,Object> prop = new LinkedHashMap<String,Object>();
           filePath=fileProp.toString();
           try {
        	  InputStream ios = fileYaml.getContents();
               Map<String,Object> result = (Map<String,Object>)yaml.load(ios);
               Set<String> key  = result.keySet();
               YamlProperties.handler(prop,result,"",key);
               
           } catch (Exception e) {
               e.printStackTrace();
           }
       
           Properties properties = new Properties();
           InputStream pr = fileProp.getContents();
           try {
               properties.load(pr);
           } catch (IOException e) {
               e.printStackTrace();
           }
           arrayList = YamlProperties.compare(prop, properties);
           checkRightProperties(prop, properties);
           return arrayList;
       }
    public void checkRightProperties(LinkedHashMap<String, Object> attr, Properties properties) {
    	Set<Object> keys = properties.keySet();
    	for (Object k:keys){
            if (attr.containsKey((String)k)){
                continue;
            }else {
                arrayList.add("properties contain unknown value: "+k);
            }
        }
       
    }
}

