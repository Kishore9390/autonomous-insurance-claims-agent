package com.synapx.claims.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synapx.claims.model.ClaimData;

public class JsonUtil {

    public static void print(ClaimData claim) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(
                mapper.writerWithDefaultPrettyPrinter()
                      .writeValueAsString(claim)
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
