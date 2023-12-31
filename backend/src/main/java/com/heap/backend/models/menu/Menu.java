package com.heap.backend.models.menu;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("menu")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Menu {

    @Id
    private String id;

    @NotBlank
    private String userId;

    @NotBlank
    private String name;

    @NotBlank
    private MenuSection[] sections;

    @NotBlank
    private String type;

    private String image;

    private String createDateTime;

}
