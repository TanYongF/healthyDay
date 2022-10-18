package com.course.coursedesign2022.controller;
import static org.hamcrest.Matchers.equalTo;

import com.course.coursedesign2022.mapper.UserMapper;
import com.course.coursedesign2022.pojo.PointObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import javax.inject.Inject;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class restfulTest {
    //http请求的模拟
    @Inject
    private MockMvc mockMvc;

    @Autowired
    UserMapper userMapper;

    public void printUser(int id){
        PointObject pointObject=userMapper.getPointObjectByID(id);
        System.out.println(pointObject);
    }

    public void printAllUser(){
        List<PointObject> pointObjects=userMapper.getPointObject();
        for(PointObject pointObject:pointObjects){
            System.out.println(pointObject);
        }
        System.out.println("---------");
    }

    @Test
    public void testGet() throws Exception{
        printAllUser();
        RequestBuilder requestBuilder;
        requestBuilder=get("/user/");
        mockMvc.perform(requestBuilder).
                andExpect(status().isOk()).
                andExpect(content().string(equalTo("[{\"id\":3,\"growScore\":3,\"exchangeScore\":3,\"scoreTotal\":5},{\"id\":4,\"growScore\":1,\"exchangeScore\":1,\"scoreTotal\":2}]")));
    }

    @Test
    public void testAddUser() throws Exception{
        printAllUser();
        RequestBuilder requestBuilder;
        requestBuilder=post("/user/?id=5&exchange=0&grow=0&total=0");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk()).andExpect(content().string(equalTo("[{\"id\":1,\"growScore\":0,\"exchangeScore\":0,\"scoreTotal\":0},{\"id\":3,\"growScore\":3,\"exchangeScore\":3,\"scoreTotal\":5},{\"id\":4,\"growScore\":0,\"exchangeScore\":0,\"scoreTotal\":0}]")));
        printAllUser();
    }


    @Test
    public void testGetByID() throws Exception{
        printUser(1);
        RequestBuilder requestBuilder;
        requestBuilder=get("/user/query/1");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"growScore\":0,\"exchangeScore\":0,\"scoreTotal\":0}")));
    }


    @Test
    public void testDeleteUser() throws Exception{
        printAllUser();
        RequestBuilder requestBuilder;
        requestBuilder=delete("/user/1");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":3,\"growScore\":1,\"exchangeScore\":1,\"scoreTotal\":1}]")));
        printAllUser();
    }

    @Test
    public void testUpdateUser() throws Exception{

        printUser(1);
        RequestBuilder requestBuilder;
        requestBuilder=put("/user/3?exchange=1&grow=1&total=1");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"growScore\":0,\"exchangeScore\":0,\"scoreTotal\":0}")));
        printUser(1);
    }


    @Test
    public void  testBasic() throws Exception{
        printUser(1);
        RequestBuilder requestBuilder;
        requestBuilder=put("/testDesign/1");
        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("ok")));
        printUser(1);
    }
}
