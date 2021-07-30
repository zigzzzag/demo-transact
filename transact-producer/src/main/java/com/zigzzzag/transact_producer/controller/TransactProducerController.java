package com.zigzzzag.transact_producer.controller;

import com.zigzzzag.transact_producer.dto.TransactProducerDTO;
import com.zigzzzag.transact_producer.service.TransactionProduceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producers")
@RequiredArgsConstructor
public class TransactProducerController {

    private final TransactionProduceService transactionProduceService;

    @PostMapping("/strings")
    public void produceString(@RequestBody TransactProducerDTO dto) {
        transactionProduceService.produceStrings(dto);
    }

    @PostMapping("/transactions")
    public void produceTransaction(@RequestBody TransactProducerDTO dto) {
        transactionProduceService.produceTransactions(dto);
    }
}
