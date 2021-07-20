package com.example.demotransact.controller;

import com.example.demotransact.dto.transaction.TransactionDTO;
import com.example.demotransact.dto.transaction.TransactionFilterDTO;
import com.example.demotransact.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }

    @PostMapping("/search")
    public Page<TransactionDTO> searchTransactions(
            @PageableDefault Pageable pageable,
            @RequestBody TransactionFilterDTO filter
    ) {
        return transactionService.searchTransactions(filter, pageable);
    }
}
