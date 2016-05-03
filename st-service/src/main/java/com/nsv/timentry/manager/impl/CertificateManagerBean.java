//: com.nsv.timentry.manager.impl: CertificateManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.CertificateManagerLocal;
import com.nsv.timentry.entity.Certificate;


/**
 * Certificate manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 16:42 $
 */
@Stateless( name = "CertificateManager" )
public class CertificateManagerBean extends GenericManagerBean< Certificate, Short >
        implements CertificateManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( CertificateManagerBean.class );


    private static final String SQL_INSERT = "INSERT INTO CERTIFICATES "
            + "( "
            +   "CERT_NAME, "
            +   "EMP_ID, "
            +   "ISSUER, "
            +   "ISSUE_DATE, "
            +   "EXPIRE_DATE "
            + ") VALUES ( ?, ?, ?, ?, ? )";


    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public CertificateManagerBean() {
        super( Certificate.class );
    }

    protected EntityManager em() {
        return em;
    }

    protected String insertSQL() {
        return SQL_INSERT;
    }


    @Override
    public void update( Certificate certificate ) {

        Short id = certificate.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No Certificate entity with ID: " + id );
        }

        em.merge( certificate );

    }


} //:~
