package org.example.testrest.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ExtendWith(SpringExtension.class)
class WalletControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void editBalanceWalletWithdraw() throws Exception {
        String request = "{\n" +
                "    \"valletId\": \"5ba5dfe1-577c-4513-8550-ef63b4a15a97\",\n" +
                "    \"operationType\": \"WITHDRAW\",\n" +
                "    \"amount\": 800\n" +
                "}";

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request));

        resultActions.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.equalTo("Это провал")));
    }

    @Test
    void editBalanceWalletDeposit() throws Exception {
        String request = "{\n" +
                "    \"valletId\": \"5ba5dfe1-577c-4513-8550-ef63b4a15a97\",\n" +
                "    \"operationType\": \"DEPOSIT\",\n" +
                "    \"amount\": 800\n" +
                "}";

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/wallet")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request));

        resultActions.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.equalTo("Это успех")));
    }

    @Test
    void getWallet() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/wallets/5ba5dfe1-577c-4513-8550-ef63b4a15a97")
                .contentType(MediaType.APPLICATION_JSON));



        resultActions.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }
}