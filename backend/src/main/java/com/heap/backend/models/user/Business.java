package com.heap.backend.models.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Business {

    @Id
    private String id;

    @NotBlank
    private String businessName;

    @NotBlank
    private String businessType;

    @NotBlank
    private String[] cuisineType;

    @NotBlank
    @JsonProperty("isFusion")
    private boolean isFusion;

    @NotBlank
    private String storeAddress;

    @Size(max = 6)
    @NotBlank
    private String postalCode;

    public Business duplicate() {

        return Business.builder()
                .businessName(this.getBusinessName())
                .businessType(this.getBusinessType())
                .cuisineType(this.getCuisineType())
                .isFusion(this.isFusion())
                .storeAddress(this.getStoreAddress())
                .postalCode(this.getPostalCode())
                .build();
    }
}
