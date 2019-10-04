package com.jayden.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @JsonProperty("customer_id")
    private Long customerId;

    @JsonProperty("store_id")
    private Long storeId;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address_id")
    private Long addressId;

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("create_date")
    private String createDate;

    @JsonProperty("last_update")
    private String lastUpdate;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("customerId", customerId)
                .append("storeId", storeId)
                .append("name", firstName + lastName)
                .append("email", email)
                .append("addressId", addressId)
                .append("active", active)
                .append("createDate", createDate)
                .append("lastUpdate", lastUpdate)
                .build();
    }
}
