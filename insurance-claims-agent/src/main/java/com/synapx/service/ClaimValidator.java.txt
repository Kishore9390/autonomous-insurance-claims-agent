package com.synapx.claims.service;

import com.synapx.claims.model.ClaimData;

public class ClaimValidator {

    public static void validate(ClaimData claim) {
        String[] mandatory = {
            "Policy Number",
            "Description",
            "Estimated Amount",
            "Claim Type"
        };

        for (String field : mandatory) {
            if (!claim.extractedFields.containsKey(field)) {
                claim.missingFields.add(field);
            }
        }
    }
}
