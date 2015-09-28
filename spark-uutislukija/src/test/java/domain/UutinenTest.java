/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author santeri
 */
public class UutinenTest {
    private Uutinen uutinen;
    
    @Before
    public void setUp() {
        uutinen = new Uutinen();
    }
    
    @Test
    public void getteritJaSetterit(){
        uutinen.setBy("By");
        uutinen.setTitle("Title");
        uutinen.setUrl("www");
        
        assertEquals(uutinen.getBy(), "By");
        assertEquals(uutinen.getTitle(), "Title");
        assertEquals(uutinen.getUrl(), "www");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
