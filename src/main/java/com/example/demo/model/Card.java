package com.example.demo.model;

//import javax.persistence.*;
import jakarta.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards")
public class Card {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String question;
    private String answer;

//    @ManyToOne
//    @JoinColumn(name = "deck_id")
//    private Deck deck;
    //Добавлена аннотация @ManyToOne для связи Card с Deck.
    // Это означает, что каждая карточка принадлежит одной колоде.

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "deck_and_card",
            joinColumns = {@JoinColumn(name = "card_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "deck_id", referencedColumnName = "id")}
    )
    private Set<Deck> decks = new HashSet<>();

}
