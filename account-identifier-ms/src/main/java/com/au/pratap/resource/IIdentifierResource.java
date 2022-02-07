package com.au.pratap.resource;

import com.au.pratap.model.StripFileTransaction;

import java.util.List;

/**
 * @author Pratap
 */
public interface IIdentifierResource {

    /**
     * This method takes input as BSB and account number and returns the account identifier
     *
     * @param pBSBNumber
     * @param pAccountNumber
     * @return
     */
    public String getAccountId(final String pBSBNumber, final String pAccountNumber);

    /**
     * Get the list of account ids
     *
     * @param stripFileTransaction
     * @return
     */
    public List<StripFileTransaction> getAccountIdList(final List<StripFileTransaction> stripFileTransaction);
}
