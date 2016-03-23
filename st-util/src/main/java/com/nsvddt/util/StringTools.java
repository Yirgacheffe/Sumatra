package cn.com.nsv.ejb.util;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class StringTools {
    public static boolean isNotNull(String str) {
        if (str != null && str.trim().length() > 0)
            return true;
        else
            return false;
    }

    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }

    public static String listToString(List<?> list) {
        StringBuffer sb1 = new StringBuffer();
        if (list != null && list.size() > 0) {
            for (int j = 0; j < list.size(); j++) {
                sb1.append("'").append(list.get(j)).append("'").append(",");
            }
            sb1.deleteCharAt(sb1.length() - 1);
        }
        return sb1.toString();
    }
    
    public static <T> String setToString(Set<T> set){
    	StringBuffer sb1 = new StringBuffer();
    	if(set != null && set.size() > 0){
    		for(T t : set){
    			sb1.append("'").append(t).append("'").append(",");
    		}
    		sb1.deleteCharAt(sb1.length() - 1);
    	}
    	 return sb1.toString();
    }

    public static String logPackage(String temp, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            temp = temp.replaceAll("\\{" + i + "\\}", list.get(i));
        }
        return temp;
    }

    // param 消息编号
    // param 填充值
    public static String logPackage(String temp, String... arg) {
        for (int i = 0; i < arg.length; i++) {
            temp = temp.replaceFirst("\\{\\d+\\}", arg[i]);
        }
        return temp;
    }

    public static String addPercentSign(String temp) {
        temp = "%" + temp + "%";
        return temp;
    }
}
