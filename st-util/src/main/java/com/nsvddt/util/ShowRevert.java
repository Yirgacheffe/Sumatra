package cn.com.nsv.ejb.util;

import cn.com.nsv.ejb.conn.ProjectType;
import cn.com.nsv.ejb.conn.RoleType;
import cn.com.nsv.ejb.conn.WorkLogRecordStatus;
import cn.com.nsv.ejb.conn.WorkPart;
import cn.com.nsv.ejb.conn.WorkPlace;
import cn.com.nsv.ejb.conn.WorklogStatus;
import cn.com.nsv.ejb.conn.LevelOrOvertime;

public class ShowRevert {
	
	public static String logStatus(String stauts){
		if(WorklogStatus.ADD.equals(stauts)){
			return "填报中";
		}else if(WorklogStatus.BACK.equals(stauts)){
			return "退回修改";
		}else if(WorklogStatus.SUBMIT.equals(stauts)){
			return "待审批";
		}else if(WorklogStatus.PASS.equals(stauts)){
			return "审批通过";
		}else{
			return null;
		}
	}
	
	public static String recordStatus(String status){
		if(WorkLogRecordStatus.NOT_REVIEW.equals(status)){
			return "未审批";
		}else if(WorkLogRecordStatus.BACK.equals(status)){
			return "退回";
		}else if(WorkLogRecordStatus.PASS.equals(status)){
			return "通过";
		}else{
			return null;
		}
	}
	
	public static String workPlace(String workPlace){
		if(WorkPlace.SOHO.equals(workPlace)){
			return "SOHO";
		}else if(WorkPlace.COMPANY.equals(workPlace)){
			return "公司";
		}else{
			return null;
		}
	}
	
	public static String workPart(String workPart){
		if(WorkPart.Business.equals(workPart)){
			return "商务";
		}else if(WorkPart.CustomerService.equals(workPart)){
			return "售后";
		}else if(WorkPart.Development.equals(workPart)){
			return "开发";
		}else if(WorkPart.Management.equals(workPart)){
			return "管理";
		}else if(WorkPart.PreSale.equals(workPart)){
			return "售前";
		}else if(WorkPart.Test.equals(workPart)){
			return "测试";
		}else{
			return null;
		}
	}
	
	public static String levelOrOvertime(String islevel){
		if(LevelOrOvertime.leveltime.equals(islevel)){
			return "请假";
		}else if(LevelOrOvertime.Overtime.equals(islevel)){
			return "加班";
		}else if(LevelOrOvertime.normal.equals(islevel)){
			return "出勤";
		}else{
			return null;
		}
	}
	
	public static String weekDay(Integer weekDay){
		if(weekDay == 1){
			return "星期日";
		}else if(weekDay == 2){
			return "星期一";
		}else if(weekDay == 3){
			return "星期二";
		}else if(weekDay == 4){
			return "星期三";
		}else if(weekDay == 5){
			return "星期四";
		}else if(weekDay == 6){
			return "星期五";
		}else if(weekDay == 7){
			return "星期六";
		}else{
			return null;
		}
	}
	
	public static String roleType(String roleType){
		if(RoleType.ADMIN.equals(roleType)){
			return "系统管理员";
		}else if(RoleType.BOSS.equals(roleType)){
			return "老板";
		}else if(RoleType.EXECUTIVE.equals(roleType)){
			return "高管";
		}else if(RoleType.HR.equals(roleType)){
			return "人力资源经理";
		}else if(RoleType.COMUSER.equals(roleType)){
			return "员工";
		}else{
			return null;
		}
	}
	
	public static String projectType(String projectType){
		if(ProjectType.NOPROJECT.equals(projectType)){
			return "非项目";
		}else if(ProjectType.PROJECT.equals(projectType)){
			return "项目";
		}else{
			return null;
		}
	}

}
