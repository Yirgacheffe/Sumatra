package cn.com.nsv.ejb.util;

import java.util.List;
import javax.persistence.Query;

public class EmTools
{
    private EmTools()
    {}

    private static EmTools emTools;

    public static synchronized EmTools getInstance()
    {
        if (emTools == null)
        {
            emTools = new EmTools();
        }
        return emTools;
    }

    private void setParametersSQL(List<Object> params, Query query)
    {
        if (params != null)
        {
            for (int i = 0; i < params.size(); i++)
            {
                query.setParameter(i + 1, params.get(i));
            }
        }
    }

    public Query querySQLByCriteria(Query query, List<Object> params, Integer pageSize, Integer startNum)
    {
        if (pageSize != null && startNum != null)
        {
            query.setMaxResults(pageSize);
            query.setFirstResult(startNum);
        }
        setParametersSQL(params, query);
        return query;
    }

    public Query querySQLByCriteria(Query query, List<Object> params)
    {
        return querySQLByCriteria(query, params, null, null);
    }

    public Query querySQLByCriteria(Query query, Integer pageSize, Integer startNum)
    {
        return querySQLByCriteria(query, null, pageSize, startNum);
    }

    public String setlikeValueAll(String paramValue)
    {
        return "%" + paramValue + "%";
    }

    public String setlikeValueLeft(String paramValue)
    {
        return "%" + paramValue;
    }

    public String setlikeValueRight(String paramValue)
    {
        return paramValue + "%";
    }
}
