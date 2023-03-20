package com.yupi.vapiinterface;

import com.example.vapiclientsdk.client.VapiClient;
import com.example.vapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VapiInterfaceApplicationTests {
    @Autowired
    private VapiClient vapiClient;

    @Test
    void contextLoads() {
        String result = vapiClient.getNameByGet("zwq");
        System.out.println(result);
        User user = new User();
        user.setUsername("zwq");
        String result2 = vapiClient.getUsernameByPost(user);
        System.out.println(result2);
    }

}
