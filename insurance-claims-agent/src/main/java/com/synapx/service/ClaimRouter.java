package com.synapx.claims.service;

import com.synapx.claims.model.ClaimData;

public class ClaimRouter {

    public static void route(ClaimData claim) {

        if (!claim.missingFields.isEmpty()) {
            claim.recommendedRoute = "Manual Review";
            claim.reasoning = "Missing mandatory fields";
            return;
        }

        String desc = claim.extractedFields.get("Description").toLowerCase();

        if (desc.contains("fraud") || desc.contains("staged")) {
            claim.recommendedRoute = "Investigation";
            claim.reasoning = "Suspicious keywords found";
            return;
        }

        if ("injury".equalsIgnoreCase(claim.extractedFields.get("Claim Type"))) {
            claim.recommendedRoute = "Specialist Queue";
            claim.reasoning = "Injury claim";
            return;
        }

        int amount = Integer.parseInt(
            claim.extractedFields.get("Estimated Amount")
        );

        if (amount < 25000) {
            claim.recommendedRoute = "Fast Track";
            claim.reasoning = "Low damage estimate";
        }
    }
}
