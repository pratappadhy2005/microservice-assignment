package com.au.pratap.service;

import com.au.pratap.model.Account;
import com.au.pratap.model.StripFileTransaction;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pratap
 */
@Service
public class AccountIdentifierService implements IAccountIdentifierService {

    private List<StripFileTransaction> mAccountList = Arrays.asList(new StripFileTransaction("MQ", "Test Message",
            "062-983", "147252318", "5555555"), new StripFileTransaction("MQ", "Test Message", "33333317", "147252317",
            "5555555"), new StripFileTransaction("MQ", "Test Message", "33333319", "147252319", "5555555"),
            new StripFileTransaction("MQ", "Test Message", "33333315", "147252315", "5555555"),
            new StripFileTransaction("MQ", "Test Message", "147252323", "534534523", "5555555"));

    @Override
    public String getAccountId(String pBSBNumber, String pAccountNumber) {
        return mAccountList.stream().filter(e -> (e.getAccountNumber().equals(pAccountNumber) && e.getBsb().equalsIgnoreCase(pBSBNumber))).findFirst().get().getAccountId();
    }

    @Override
    public List<StripFileTransaction> getAccountIdList(List<StripFileTransaction> stripFileTransactions) {
        final List<StripFileTransaction> filteredTransactionList = mAccountList.stream()
                .filter(target -> stripFileTransactions.stream()
                        .anyMatch(source ->
                                source.getAccountNumber().equals(target.getAccountNumber()) &&
                                        target.getBsb().equals(source.getBsb())))
                .collect(Collectors.toList());
        return filteredTransactionList;
    }
}
