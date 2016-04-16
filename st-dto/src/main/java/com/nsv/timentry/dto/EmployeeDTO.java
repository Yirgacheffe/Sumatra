//: com.nsv.timentry.dto: EmployeeDTO.java
package com.nsv.timentry.dto;

import java.util.Date;
import java.io.Serializable;


/**
 * EmployeeDTO connect present layer and service layer, mapped field for table 'EMPLOYEES'
 * 
 * @version 1.0.0 $ 2016-03-28 18:38 $
 */
public final class EmployeeDTO implements Serializable {

    
    private static final long serialVersionUID = 3016420869023681223L;

    // ------------------------------------------------------------------------
    private final Short   id;
    private final String  name;
    private final char    gender;
    private final String  email;
    private final Date    onBoardDate;
    private final short   deptId;
    private final Date    probationEndDate;
    private final short   diplomaId;
    private final String  graduationYear;
    private final String  college;
    private final String  major;
    private final short   hrRoleId;
    private final String  position;
    private final String  nation;    
    private final boolean isMarried;
    private final char    politicalType;
    private final String  residence;
    private final boolean isAgricultural;
    private final String  idCardNum;
    private final Date    lastWorkingDay;
    private final String  archiveFile;
    private final String  memo;
    
    
    private EmployeeDTO( Builder builder ) {
        id               = builder.id;
        name             = builder.name;
        gender           = builder.gender;
        email            = builder.email;
        onBoardDate      = builder.onBoardDate;
        deptId           = builder.deptId;
        probationEndDate = builder.probationEndDate;
        diplomaId        = builder.diplomaId;
        graduationYear   = builder.graduationYear;
        college          = builder.college;
        major            = builder.major;
        hrRoleId         = builder.hrRoleId;
        position         = builder.position;
        nation           = builder.nation;
        isMarried        = builder.isMarried;
        politicalType    = builder.politicalType;
        residence        = builder.residence;
        isAgricultural   = builder.isAgricultural;
        idCardNum        = builder.idCardNum;
        lastWorkingDay   = builder.lastWorkingDay;
        archiveFile      = builder.archiveFile;
        memo             = builder.memo;
    }
    
    public Date    probationEndDate() { return this.probationEndDate; }
    public Short   id()               { return this.id;               }
    public String  name()             { return this.name;             }
    public char    gender()           { return this.gender;           }
    public String  email()            { return this.email;            }
    public Date    onBoardDate()      { return this.onBoardDate;      }
    public short   deptId()           { return this.deptId;           }
    public short   diplomaId()        { return this.diplomaId;        }
    public String  graduationYear()   { return this.graduationYear;   }
    public String  college()          { return this.college;          }
    public String  major()            { return this.major;            }
    public short   hrRoleId()         { return this.hrRoleId;         }
    public String  position()         { return this.position;         }
    public String  nation()           { return this.nation;           }
    public boolean isMarried()        { return this.isMarried;        }
    public char    politicalType()    { return this.politicalType;    }
    public String  residence()        { return this.residence;        }
    public boolean isArgicultural()   { return this.isAgricultural;   }
    public String  idCardNum()        { return this.idCardNum;        }
    public String  archiveFile()      { return this.archiveFile;      }
    public String  memo()             { return this.memo;             }
    public Date    lastWorkingDay()   { return this.lastWorkingDay;   }

    public Object[] asArrayInDBOrder() {
        return new Object[] {
                name, gender, email, onBoardDate, deptId, diplomaId,
                graduationYear,
                college,
                major,
                hrRoleId,
                position,
                nation,
                isMarried ? 1 : 0,
                politicalType,
                residence,
                isAgricultural ? 1 : 0,
                idCardNum, lastWorkingDay, archiveFile, memo
        };
    }


    // ------------------------------------------------------------------------
    public static class Builder {
     
        private Short   id;
        private String  name;
        private char    gender;
        private String  email;
        private Date    onBoardDate;
        private short   deptId;
        private Date    probationEndDate;
        private short   diplomaId;
        private String  graduationYear;
        private String  college;
        private String  major;
        private short   hrRoleId;
        private String  position;
        private String  nation;    
        private boolean isMarried;
        private char    politicalType;
        private String  residence;
        private boolean isAgricultural;
        private String  idCardNum;
        private Date    lastWorkingDay;
        private String  archiveFile;
        private String  memo;
        
        public Builder() {
            // Keep this as default
        }
        
        // Call private constructor to create DTO
        public EmployeeDTO build() {
            return new EmployeeDTO( this );
        }
        
        public Builder id( Short id ) {
            this.id = id;
            return this;
        }
        
        public Builder politicalType( char politicalType ) {
            this.politicalType = politicalType;
            return this;
        }

        public Builder position( String position ) {
            this.position = position;
            return this;
        }
        
        public Builder memo( String memo ) {
            this.memo = memo;
            return this;
        }
        
        public Builder residence( String residence ) {
            this.residence = residence;
            return this;
        }
        
        public Builder idCardNum( String idCardNum ) {
            this.idCardNum = idCardNum;
            return this;
        }
        
        public Builder archiveFile( String archiveFile ) {
            this.archiveFile = archiveFile;
            return this;
        }
        
        public Builder nation( String nation ) {
            this.nation = nation;
            return this;
        }
        
        public Builder hrRoleId( short hrRoleId ) {
            this.hrRoleId = hrRoleId;
            return this;
        }
        
        public Builder major( String major ) {
            this.major = major;
            return this;
        }
        
        public Builder isMarried( boolean isMarried ) {
            this.isMarried = isMarried;
            return this;
        }
        
        public Builder graduationYear( String graduationYear ) {
            this.graduationYear = graduationYear;
            return this;
        }
        
        public Builder college( String college ) {
            this.college = college;
            return this;
        }
        
        public Builder diplomaId( short diplomaId ) {
            this.diplomaId = diplomaId;
            return this;
        }
        
        public Builder deptId( short deptId ) {
            this.deptId = deptId;
            return this;
        }
        
        public Builder probationEndDate( Date probationEndDate ) {
            this.probationEndDate = probationEndDate;
            return this;
        }
        
        public Builder email( String email ) {
            this.email = email;
            return this;
        }
        
        public Builder name( String name ) {
            this.name = name;
            return this;
        }
        
        public Builder lastWorkingDate( Date lastWorkingDate ) {
            this.lastWorkingDay = lastWorkingDate;
            return this;
        }
        
        public Builder gender( char gender ) {
            this.gender = gender;
            return this;
        }
        
        public Builder onBoardDate( Date onBoardDate ) {
            this.onBoardDate = onBoardDate;
            return this;
        }
        
        public Builder isAgricultural( boolean isAgricultural ) {
            this.isAgricultural = isAgricultural;
            return this;
        }
        
    }
    // ------------------------------------------------------------------------
    
    
} //:~
