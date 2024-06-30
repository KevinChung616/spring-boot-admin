package com.jtsp.adminclient;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDTO {

    private Long productId;
    private String name;
    private String category;
    private Long amount;
}
