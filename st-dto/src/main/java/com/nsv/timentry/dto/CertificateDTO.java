//: com.nsv.timentry.dto: CertificateDTO.java
package com.nsv.timentry.dto;

import java.util.Date;
import java.io.Serializable;


/**
 * CertificateDTO connect present layer and service layer
 * mapped field for table 'CERTIFICATES'
 *
 * @version 1.0.0 $ 2016-04-14 22:19 $
 */
public final class CertificateDTO implements Serializable{


    private static final long serialVersionUID = -6778073080440908587L;

    private final Short  id;

    private final String certName;
    private final String issuer;

    private final Date   issueDate;
    private final Date   expireDate;
    private final Short  empId;

    private CertificateDTO( Builder builder ) {
        this.empId      = builder.empId;
        this.id         = builder.id;
        this.certName   = builder.certName;
        this.issuer     = builder.issuer;
        this.issueDate  = builder.issueDate;
        this.expireDate = builder.expireDate;
    }

    public Date   expireDate() { return this.expireDate; }
    public Short  id()         { return this.id;         }
    public Short  empId()      { return this.empId;      }
    public String certName()   { return this.certName;   }
    public String issuer()     { return this.issuer;     }
    public Date   issueDate()  { return this.issueDate;  }

    public Object[] asArrayInDBOrder() {
        return new Object[] {
                certName, empId, issuer, issueDate, expireDate };
    }

    // ----------------------------------------------------------------------------------
    public static class Builder {

        private Short  id;

        private String certName;
        private String issuer;

        private Date   issueDate;
        private Date   expireDate;
        private Short  empId;

        public Builder() {
            // Keep this as default constructor
        }

        public CertificateDTO build() {
            return new CertificateDTO( this );
        }

        public Builder id( Short id ) {
            this.id = id;
            return this;
        }

        public Builder certName( String certName ) {
            this.certName = certName;
            return this;
        }

        public Builder issuer( String issuer ) {
            this.issuer = issuer;
            return this;
        }

        public Builder empId( Short empId ) {
            this.empId = empId;
            return this;
        }

        public Builder issueDate( Date issueDate ) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder expireDate( Date expireDate ) {
            this.expireDate = expireDate;
            return this;
        }

    }
    // ----------------------------------------------------------------------------------


} //:~
