package com.synapx.claims;

import com.synapx.claims.model.ClaimData;
import com.synapx.claims.parser.PdfParser;
import com.synapx.claims.service.*;
import com.synapx.claims.util.JsonUtil;

public class Main {

    public static void main(String[] args) {

        String text = PdfParser.extractText(
            "sample-input/ACORD-Automobile-Loss-Notice.pdf"
        );

        ClaimData claim = new ClaimData();

        claim.extractedFields.put("Policy Number", "AUTO123");
        claim.extractedFields.put("Description", "Rear-end collision");
        claim.extractedFields.put("Estimated Amount", "18000");
        claim.extractedFields.put("Claim Type", "auto");

        ClaimValidator.validate(claim);
        ClaimRouter.route(claim);
        JsonUtil.print(claim);
    }
}
