package com.example.demo.model;

//import javax.persistence.*;
import jakarta.persistence.*;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards")
public class Card {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String term;
    private String definition;

    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;
    //Добавлена аннотация @ManyToOne для связи Card с Deck.
    // Это означает, что каждая карточка принадлежит одной колоде.
}
