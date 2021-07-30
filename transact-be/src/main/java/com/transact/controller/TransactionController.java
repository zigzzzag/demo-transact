package com.transact.controller;

import com.transact.dto.transaction.TransactionDTO;
import com.transact.dto.transaction.TransactionFilterDTO;
import com.transact.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import static com.transact.controller.ApiVersion.API_V1;

@RestController
@RequestMapping(API_V1 + "/transactions")
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
