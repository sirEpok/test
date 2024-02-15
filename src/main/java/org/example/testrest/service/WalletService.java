package org.example.testrest.service;

import org.example.testrest.dto.OperationDto;
import org.example.testrest.entity.Wallet;
import org.example.testrest.repository.WalletRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WalletService {
    private final WalletRepository walletRepository;
    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Object editBalance(OperationDto operationDto) {
        switch (operationDto.getOperationType()) {
            case "DEPOSIT":
                Wallet walletDeposit = walletRepository.findById(operationDto.getValletId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                walletDeposit.setBalance(walletDeposit.getBalance() + operationDto.getAmount());
                walletRepository.save(walletDeposit);
                return "Это успех";
            case "WITHDRAW":
                Wallet walletWithdraw = walletRepository.findById(operationDto.getValletId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
                walletWithdraw.setBalance(walletWithdraw.getBalance() - operationDto.getAmount());
                walletRepository.save(walletWithdraw);
                return "Это провал";
            default:
                return "Я ниче не понял";
        }
    }

    public Wallet getWallet(String uuid) {
        return walletRepository.findById(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
