

package goplaces;


import com.stackroute.project.*;
import com.stackroute.project.controller.*;
import com.stackroute.project.domains.*;

import static org.junit.Assert.*;

import org.apache.catalina.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyApplicationTest {
    String user1;
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    Places place;
    @Before
    public void setUp() throws Exception {
         place = new Places("3","Paul Dawson");
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSaveUser() throws Exception {
        HttpEntity<Places> entity = new HttpEntity<Places>(place, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/goplaces/update"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("User saved successfully",actual);
    }
    @Test
    public void testList() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/goplaces/list"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    }
//    @Test
//    public void testGetUser() throws Exception {
//    }
//    @Test
//    public void testUpdateUser() throws Exception {
//    }
//    @Test
//    public void testDeleteUser() throws Exception {
//    }
}