package com.transact;

import com.transact.service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public abstract class BaseTest {

    @Autowired
    public AgreementService agreementService;
}
