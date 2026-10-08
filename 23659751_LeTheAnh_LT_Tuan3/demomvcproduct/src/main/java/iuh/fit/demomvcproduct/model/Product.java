package iuh.fit.demomvcproduct.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Product {
    private int id;
    private String name;
    private double price;
}
