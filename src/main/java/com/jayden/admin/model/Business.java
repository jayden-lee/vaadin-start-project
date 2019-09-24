package com.jayden.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Business {
    private static final long serialVersionUID = 1L;

    private String Year;
    private String Industry_aggregation_NZSIOC;
    private String Industry_code_NZSIOC;
    private String Industry_name_NZSIOC;
    private String Units;
    private String Variable_code;
    private String Variable_name;
    private String Variable_category;
    private String Value;
    private String Industry_code_ANZSIC06;

    @Override
    public String toString() {
        return "Business{" +
            "Year='" + Year + '\'' +
            ", Industry_aggregation_NZSIOC='" + Industry_aggregation_NZSIOC + '\'' +
            ", Industry_code_NZSIOC='" + Industry_code_NZSIOC + '\'' +
            ", Industry_name_NZSIOC='" + Industry_name_NZSIOC + '\'' +
            ", Units='" + Units + '\'' +
            ", Variable_code='" + Variable_code + '\'' +
            ", Variable_name='" + Variable_name + '\'' +
            ", Variable_category='" + Variable_category + '\'' +
            ", Value='" + Value + '\'' +
            ", Industry_code_ANZSIC06='" + Industry_code_ANZSIC06 + '\'' +
            '}';
    }
}
