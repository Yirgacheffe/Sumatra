//: com.nsv.timentry.dto: FunctionDTO.java
package com.nsv.timentry.dto;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;


/**
 * Read only Data Transport Object for function module, build pattern recommended
 * 
 * @version 1.0.0 $ 2016-03-28 13:47 $
 */
public final class FunctionDTO implements Serializable {
    
    
    private static final long serialVersionUID = -7717160716088490061L;

    // ------------------------------------------------------------------------
    private final Integer id;
    private final String  permission;
    private final String  name;
    private final String  parent;
    private final String  url;
    
    private List<FunctionDTO> subFuncs = new ArrayList<>();
    
    
    private FunctionDTO( Builder builder ) {
        id         = builder.id;
        name       = builder.name;
        parent     = builder.parent;
        url        = builder.url;
        permission = builder.permission;
        subFuncs   = builder.subFuncs;
    }
    
    public Integer            id()         { return this.id;         }
    public String             name()       { return this.name;       }
    public String             parent()     { return this.parent;     }
    public String             url()        { return this.url;        }
    public String             permission() { return this.permission; }
    public List<FunctionDTO>  subFuncs()   { return this.subFuncs;   }
    
    
    // ------------------------------------------------------------------------
    public static class Builder {
        
        private Integer id;
        private String  permission;
        private String  name;
        private String  parent;
        private String  url;

        private List<FunctionDTO> subFuncs = new ArrayList<>();
        
        public Builder() {
            // keep this as default
        }
        
        // Call private constructor to create DTO
        public FunctionDTO build() {
            return new FunctionDTO( this );
        }
        
        public Builder id( Integer id ) {
            this.id = id;
            return this;
        }
        
        public Builder permission( String permission ) {
            this.permission = permission;
            return this;
        }
        
        public Builder name( String name ) {
            this.name = name;
            return this;
        }
        
        public Builder parent( String parent ) {
            this.parent = parent;
            return this;
        }
        
        public Builder url( String url ) {
            this.url = url;
            return this;
        }
        
        public Builder funList( List<FunctionDTO> subFuncs ) {
            this.subFuncs = subFuncs;
            return this;
        }

    }
    
    
} //:~
