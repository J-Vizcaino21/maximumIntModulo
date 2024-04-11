package com.example.maximumintmodulo.controler;

import com.example.maximumintmodulo.model.RequestMaximumModulo;
import com.example.maximumintmodulo.service.MaximumModuloServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MaximumModuloController.class)
class MaximumModuloControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MaximumModuloServiceImpl maximumModuloService;

    private  RequestMaximumModulo requestMaximumModuloSetUp = new RequestMaximumModulo();

    @BeforeEach
    void setUp(){
        requestMaximumModuloSetUp.setMaximumNumber(12345);
        requestMaximumModuloSetUp.setRemainder(5);
        requestMaximumModuloSetUp.setModulo(7);
    }


    @Test
    public void testSetParametersSuccess() throws Exception {
        //given
        RequestMaximumModulo requestMaximumModulo = new RequestMaximumModulo();
        requestMaximumModulo.setMaximumNumber(12345);
        requestMaximumModulo.setRemainder(5);
        requestMaximumModulo.setModulo(7);

        //when
        Mockito.when(maximumModuloService.setParameters(requestMaximumModulo))
                .thenReturn("Parameters= ".concat(requestMaximumModulo.toString()) + " saved successfully");

        mockMvc.perform(post("/setParameters").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"maximumNumber\": 12345 ,\n" +
                        "  \"modulo\": 7 ,\n" +
                        "  \"remainder\": 5\n" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Parameters= RequestMaximumModulo(maximumNumber=12345, modulo=7, remainder=5) saved successfully"));
    }
    @Test
    public void getMaximumModuloSuccess() throws Exception {
        Mockito.when(maximumModuloService.getParameters()).thenReturn(requestMaximumModuloSetUp);
        mockMvc.perform(get("/getMaximumInteger")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.maximumModulo").value(12339));
    }


}