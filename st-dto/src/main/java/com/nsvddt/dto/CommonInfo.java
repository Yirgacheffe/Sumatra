package cn.com.nsv.ejb.dto;

import java.io.Serializable;
import java.util.Date;

public class CommonInfo  implements Serializable
{

    private static final long serialVersionUID = 1L;
    
    private int recordUpdater;
    
    private Date recordUpdatetime;
    
    private int recordVersion = 1;

    public int getRecordUpdater()
    {
        return recordUpdater;
    }

    public void setRecordUpdater(int recordUpdater)
    {
        this.recordUpdater = recordUpdater;
    }

    public Date getRecordUpdatetime()
    {
        return recordUpdatetime;
    }

    public void setRecordUpdatetime(Date recordUpdatetime)
    {
        this.recordUpdatetime = recordUpdatetime;
    }

    public int getRecordVersion()
    {
        return recordVersion;
    }

    public void setRecordVersion(int recordVersion)
    {
        this.recordVersion = recordVersion;
    }
}
