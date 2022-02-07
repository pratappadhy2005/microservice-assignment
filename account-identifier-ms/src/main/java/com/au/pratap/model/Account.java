package com.au.pratap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This is the model class to hold the properties
 *
 * @author Pratap
 */
@AllArgsConstructor
public class Account {

    @Getter
    @Setter
    private String bsb;

    @Getter
    @Setter
    private String accountNumber;

    @Getter
    @Setter
    private Integer accountId;
}
