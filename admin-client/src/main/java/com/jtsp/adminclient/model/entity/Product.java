package com.jtsp.adminclient.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue
    @Column
    private Long productId;

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private Long amount;


}
