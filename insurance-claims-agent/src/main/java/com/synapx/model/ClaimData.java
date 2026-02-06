package com.synapx.claims.model;

import java.util.*;

public class ClaimData {
    public Map<String, String> extractedFields = new HashMap<>();
    public List<String> missingFields = new ArrayList<>();
    public String recommendedRoute;
    public String reasoning;
}
