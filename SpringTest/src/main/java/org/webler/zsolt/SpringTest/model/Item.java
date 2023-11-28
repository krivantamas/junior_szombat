package org.webler.zsolt.SpringTest.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
