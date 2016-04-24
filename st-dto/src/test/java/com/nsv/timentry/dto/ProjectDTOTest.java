//: com.nsv.timentry.dto: ProjectDTOTest.java
package com.nsv.timentry.dto;

import java.util.Date;
import com.google.gson.Gson;

import org.junit.*;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;


/**
 * Testcase against to class ProjectDTO, json related
 *
 * @version 1.0.0 $ 2016-04-23 12:14 $
 */
public class ProjectDTOTest {


    private String json = "\n" +
        "  {\n" +
        "  \"projNum\":       \"N2-19\",\n" +
        "  \"name\":          \"GeHua SrPMS\",\n" +
        "  \"startDate\":     \"2016/08/08\",\n" +
        "  \"closeDate\":     \"2016/12/08\",\n" +
        "  \"isProj\":        true,\n" +
        "  \"budget\":        500000,\n" +
        "  \"status\":        3,\n" +
        "  \"memo\":          \"Sales: William\",\n" +
        "  \"creatorId\":     1\n" +
        "  \"lastUpdatedBy\": 1\n" +
        "  \"leaderId\":      2\n" +
        "}";


    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }


    private String jsonxyz = "{\"projNum\":\"N2-19\",\"name\":\"GeHua SrPMS\",\"startDate\":\"Apr 23, 2016 11:53:56 PM\",\"closeDate\":\"Apr 23, 2016 11:53:56 PM\",\"isProj\":true,\"budget\":500000,\"status\":\"S\",\"memo\":\"Sales: William\",\"creatorId\":1,\"lastUpdatedBy\":1,\"leaderId\":2}";


    @Test
    public void testJsonToObject() throws Exception {
        Gson gson = new Gson();
        ProjectDTO dto = gson.fromJson( jsonxyz, ProjectDTO.class );

        System.out.println( dto.startDate() );

    }


    @Test
    public void testItwithJson() throws Exception {


        ProjectDTO project = new ProjectDTO.Builder().id( 1 )
            .projNum( "N2-19" )
            .name( "GeHua SrPMS" )
            .startDate( new Date() )
            .closeDate( new Date() )
            .isProj( true )
            .budget( 500000 )
            .status( 'S' )
            .memo( "Sales: William" )
            .creatorId( (short) 1 )
            .lastUpdatedBy( (short) 1 ).leaderId( (short) 2 ).build();

        Gson gson = new Gson();
        System.out.println( gson.toJson( project ) );

    }


} //:~
