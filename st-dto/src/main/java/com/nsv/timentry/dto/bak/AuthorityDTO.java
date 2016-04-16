//: com.nsv.timentry.dto: AuthorityDTO.java
package com.nsv.timentry.dto.bak;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;


/**
 * Read only Data Transport Object for Authority module, build pattern recommended
 * 
 * @version 1.0.0 $ 2016-03-28 16:07 $
 */
public final class AuthorityDTO implements Serializable{

    
    private static final long serialVersionUID = 7961066123283445889L;
    
    // ------------------------------------------------------------------------
    private final Integer id;
    private final String  funcMode;
    private final String  name;
    private final String  type;
    
    private List<FunctionDTO> funcs = new ArrayList<>();
    
    private AuthorityDTO( Builder builder ) {
        id       = builder.id;
        name     = builder.name;
        type     = builder.type;
        funcMode = builder.funcMode;
        funcs    = builder.funcs;
    }
    
    public Integer           id()       { return this.id;       }
    public String            funcMode() { return this.funcMode; }
    public String            name()     { return this.name;     }
    public String            type()     { return this.type;     }
    public List<FunctionDTO> funcs()    { return this.funcs;    }
    
    
    // ------------------------------------------------------------------------
    public static class Builder {
        
        private Integer id;
        private String  name;
        private String  type;
        private String  funcMode;

        private List<FunctionDTO> funcs = new ArrayList<>();
        
        public Builder() {
            // Keep this as default
        }
        
        // Call private constructor to create DTO
        public AuthorityDTO build() {
            return new AuthorityDTO( this );
        }
        
        public Builder id( Integer id ) {
            this.id = id;
            return this;
        }
                
        public Builder funcMode( String funcMode ) {
            this.funcMode = funcMode;
            return this;
        }
        
        public Builder name( String name ) {
            this.name = name;
            return this;
        }
        
        public Builder type( String type ) {
            this.type = type;
            return this;
        }
        
        public Builder funcs( List<FunctionDTO> funcs ) {
            this.funcs = funcs;
            return this;
        }
        
    }
    // ------------------------------------------------------------------------
    
} //:~
