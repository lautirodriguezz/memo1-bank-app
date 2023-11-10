package com.aninfo.service;

// import com.aninfo.exceptions.DepositNegativeSumException;
// import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.exceptions.InvalidTransactionTypeException;
import com.aninfo.model.Transaction;
// import com.aninfo.repository.AccountRepository;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountService accountService;

    public Transaction createTransaction(Long cbu, Double sum, String typeTransaction) {


        if (typeTransaction.toLowerCase().equals("deposit")){
            accountService.deposit(cbu,sum);
        } else if (typeTransaction.toLowerCase().equals("withdraw")){
            accountService.withdraw(cbu, sum);
        } else {
            throw new InvalidTransactionTypeException("Invalid type transaction");
        }
        Transaction transaction = new Transaction(cbu, sum, typeTransaction);

        return transactionRepository.save(transaction);
    }


    public Collection<Transaction> getTransactionsByCBU(Long cbu){

        List<Transaction> transactionWithCBU = new ArrayList<Transaction>();
        List<Transaction> transactions = transactionRepository.findAll();

        for (Transaction aTransaction: transactions){
            if(aTransaction.getCbu().equals(cbu)){
                transactionWithCBU.add(aTransaction);
            }
        }
        return transactionWithCBU;
    }

    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }

    public Optional<Transaction> getTransactionById(Long id) { 
        return transactionRepository.findById(id);
    }
}