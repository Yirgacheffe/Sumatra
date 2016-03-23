package cn.com.nsv.ejb.conn;

import java.util.Date;

import cn.com.nsv.ejb.util.DateUtils;
import cn.com.nsv.ejb.util.PropertiesReader;

public class Config {
    private static PropertiesReader reader = PropertiesReader.getReader("nsvims-config.properties");
    public static String INNERINFO_IP = reader.getProperty("innerInfo.ip").trim();
    public static String INNERINFO_HTTP_PORT = reader.getProperty("innerInfo.http.port").trim();
    public static String INNERINFO_JNDI_PORT = reader.getProperty("innerInfo.jndi.port").trim();
    public static String pass_word = reader.getProperty("innerInfo.password").trim();
    public static Integer INNERINFO_WEEKDAYOVERFOODHOUR = Integer.valueOf(reader.getProperty("innerInfo.weekDayOverFoodHour").trim());
    public static Integer INNERINFO_WORKDAYOVERFOODHOUR = Integer.valueOf(reader.getProperty("innerInfo.workDayOverFoodHour").trim());
    public static Integer INNERINFO_WORKDAYNOMALFOODHOUR = Integer.valueOf(reader.getProperty("innerInfo.workDayNomalFoodHour").trim());
    public static Float INNERINFO_NOMALWORKDAY_MEALSUPPLEMENT = Float.valueOf(reader.getProperty("innerInfo.nomalWorkDay.mealSupplement").trim());
    public static Float INNERINFO_OVERWORKDAY_MEALSUPPLEMENT = Float.valueOf(reader.getProperty("innerInfo.overWorkDay.mealSupplement").trim());
    public static Float INNERINFO_OVERWEEKDAY_MEALSUPPLEMENT = Float.valueOf(reader.getProperty("innerInfo.overWeekDay.mealSupplement").trim());
    public static String INNERINFO_WEBADDRESS = reader.getProperty("innerInfo.webAddress").trim();
    public static Date INNERINFO_STARTMAILTIME =  DateUtils.parseDate(reader.getProperty("innerInfo.startMailTime").trim(),"HH:mm");
    public static Date INNERINFO_ENDMAILTIME =  DateUtils.parseDate(reader.getProperty("innerInfo.endMailTime").trim(), "HH:mm");
    public static Date INNERINFO_STARTWORKTIME =  DateUtils.parseDate(reader.getProperty("innerInfo.startWorkTime").trim(),"HH:mm");
    public static Date INNERINFO_ENDWORKTIME =  DateUtils.parseDate(reader.getProperty("innerInfo.endWorkTime"),"HH:mm");
    public static float MAILTIMEHOUR = DateUtils.getHourMinDiff(INNERINFO_STARTMAILTIME, INNERINFO_ENDMAILTIME);
    public static float WORKTIMEHOUR = DateUtils.getHourMinDiff(INNERINFO_STARTWORKTIME, INNERINFO_ENDWORKTIME) - MAILTIMEHOUR;   
    public static String INNERINFO_DATESPLITPARTTEN = reader.getProperty("innerInfo.dateSplitPartten").trim();
    public static Integer INNERINFO_SUBMITLOGWEEKDAY = Integer.valueOf(reader.getProperty("innerInfo.submitLogWeekDay").trim());
    public static Integer INNERINFO_CHECKED_WEEKNUM = Integer.valueOf(reader.getProperty("innerInfo.checked.weeknum").trim());
    public static Date SYSTEM_ENABLE_DATE =  DateUtils.parseDate(reader.getProperty("system.enable.date"));
}
