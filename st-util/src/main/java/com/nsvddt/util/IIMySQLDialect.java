package cn.com.nsv.ejb.util;

import java.sql.Types;
import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQLDialect;

public class IIMySQLDialect extends MySQLDialect {

    public IIMySQLDialect () {
        super();
        registerHibernateType( Types.LONGVARCHAR, Hibernate.STRING.getName() );
     }
}
