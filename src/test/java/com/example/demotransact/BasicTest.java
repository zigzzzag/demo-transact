package com.example.demotransact;

import com.example.demotransact.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public abstract class BasicTest {

    @Autowired
    public AgreementService agreementService;
}
