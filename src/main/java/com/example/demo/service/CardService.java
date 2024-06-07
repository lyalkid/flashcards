package com.example.demo.service;

import com.example.demo.model.Card;

import java.util.List;


public interface CardService {
    List<Card> getAllCards();
    void saveCard(Card card);
}
