package com.jtsp.adminclient.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDTO {

    @Min(1L)
    private Long productId;

    @NotBlank
    @Size(min = 3, max = 50, message = "name length must b/w 3 and 50")
    private String name;

    private String category;

    @Min(1L)
    private Long amount;
}
