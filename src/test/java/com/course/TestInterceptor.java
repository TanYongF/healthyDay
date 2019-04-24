package com.course;

import com.course.controller.TestDesign;
import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lixuy
 * Created on 2019-04-10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class TestInterceptor {
	
	@Autowired
	TestDesign testDesign;
	
    //检验当前积分情况
    private int assertScore(){
        try {
            String file = FileUtils.readFile("score");
            PointObject pointObject = JsonUtils.jsonToPojo(file,PointObject.class);
            System.out.println("成长积分："+pointObject.getGrowScore());
            System.out.println("可交换积分："+pointObject.getExchangeScore());
            System.out.println("总积分："+pointObject.getScoreTotal());
            
            return pointObject.getScoreTotal();
        }catch (Exception e){
            e.printStackTrace();
        }
		return 0;        
    }
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("this is setUpBeforeClass...");
    }
 
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("this is tearDownAfterClass...");
    }
 
    @Before
    public void setUp() throws Exception {
        System.out.println("this is setUp...");
    }
 
    @After
    public void tearDown() throws Exception {
        System.out.println("this is tearDown...");
    }
    
    @Test
    public void testDesign() {
    	try {
    		int score1=assertScore();
    		testDesign.testDesign();
    		int score2=assertScore();
    		
    		assertEquals(1, score2-score1);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
}
