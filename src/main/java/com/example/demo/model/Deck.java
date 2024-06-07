package com.example.demo.model;

//import javax.persistence.*;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "deck")
public class Deck {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student createdBy;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cards;
    /*
    * Добавлена аннотация @ManyToOne для связи Deck с Student.
    *  Это означает, что каждая колода создается одним студентом.
    *  Добавлена аннотация @OneToMany для связи Deck с Card.
    *  Это означает, что каждая колода может содержать много карточек.
    */
}
