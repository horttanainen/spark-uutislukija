/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;


/**
 *
 * @author santeri
 */
public class MainTest extends FluentTest {
    public WebDriver webDriver = new HtmlUnitDriver();
    public WebDriver getDefaultDriver(){
        return webDriver;
    }
    
    @ClassRule
    public static ServerRule server = new ServerRule();
    
    @Test
    public void rootTest(){
        goTo("http://localhost:4567/");
        assertTrue(pageSource().contains("Hackernews-uutiset"));
    }
    
    @Test
    public void suosituinTest(){
        goTo("http://localhost:4567/suosituin");
        assertTrue(pageSource().contains("Suosituin uutinen"));
    }
    
    @Test
    public void viimeisinTest(){
        goTo("http://localhost:4567/viimeisin");
        assertTrue(pageSource().contains("Viimeisin uutinen"));
    }
    
    @Test
    public void linkinKokeiluTest(){
        goTo("http://localhost:4567/");
        click(".suosituinLinkki");
        assertTrue(pageSource().contains("Suosituin uutinen"));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
