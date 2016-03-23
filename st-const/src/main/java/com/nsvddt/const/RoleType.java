package cn.com.nsv.ejb.conn;

public class RoleType {
	
	public final static String ADMIN = "A";//admin用户，不可修改角色及权限，不可见
	public final static String BOSS = "B"; //老板，不可修改，可见，角色权限固定，无日志填报，可见所有信息
	public final static String HR = "H"; //人力资源经理，可见所有信息，无日志填报
	public final static String EXECUTIVE = "E"; //高管，可见其下属信息，无日志填报
	public final static String LEADER = "L";//领导，可见其下属信息
	public final static String COMUSER = "C";//普通员工，只可见自己信息
}
