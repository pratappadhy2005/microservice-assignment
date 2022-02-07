package com.au.pratap.resource;

import com.au.pratap.model.StripFileTransaction;
import com.au.pratap.service.IAccountIdentifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pratap
 */
@RestController
public class AccountIdentifierResource implements  IIdentifierResource{
    @Autowired
    private IAccountIdentifierService mAccountIdentifierService;

    @Override
    @GetMapping("/account/{pBSBNumber}/{pAccountNumber}")
    public String getAccountId(@PathVariable String pBSBNumber, @PathVariable String pAccountNumber) {
        return mAccountIdentifierService.getAccountId(pBSBNumber, pAccountNumber);
    }

    @RequestMapping(value = "/accounts" , method = RequestMethod.POST, consumes = "application/json")
    @Override
    public List<StripFileTransaction> getAccountIdList(final List<StripFileTransaction> stripFileTransactions) {
        return mAccountIdentifierService.getAccountIdList(stripFileTransactions);
    }
}
