package org.example.testrest.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.example.testrest.dto.OperationDto;
import org.example.testrest.entity.Wallet;
import org.example.testrest.service.WalletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WalletController {
    private final WalletService walletService;
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @Operation(summary = "Изменение счета")
    @PostMapping("/wallet")
    ResponseEntity<?> editBalanceWallet(@Valid @RequestBody OperationDto operationDto) {
        return new ResponseEntity<>(walletService.editBalance(operationDto), HttpStatus.OK);
    }

    @Operation(summary = "Получить баланс счета")
    @GetMapping("/wallets/{uuid}")
    ResponseEntity<Wallet> getWallet(@PathVariable String uuid) {
        final Wallet wallet = walletService.getWallet(uuid);
        return wallet != null ? new ResponseEntity<>(wallet, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
