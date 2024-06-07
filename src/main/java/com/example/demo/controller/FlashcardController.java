package com.example.demo.controller;



import com.example.demo.model.Card;
import com.example.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FlashcardController {

    @Autowired
    private CardService cardService;

    // Обработка главной страницы
    @GetMapping("/cards")
    public String viewHomePage(Model model) {
        List<Card> listCards = cardService.getAllCards();
        model.addAttribute("listCards", listCards);
        return "cards"; // Имя шаблона HTML без расширения
    }

    @GetMapping("/cards/new")
    public String createClubForm(Model model) {
        Card card= new Card();
        model.addAttribute("club", card);
        return "clubs-create";
    }

    // Обработка добавления новой карточки
    @PostMapping("/add")
    @ResponseBody
    public String addFlashcard(@RequestParam String question, @RequestParam String answer) {
        if (question.isEmpty() || answer.isEmpty()) {
            return "Input fields cannot be empty!";
        }
        Card newCard = new Card();
        newCard.setTerm(question);
        newCard.setDefinition(answer);
        cardService.saveCard(newCard);
        return "Card added successfully!";
    }

//    // Получение всех карточек
//    @GetMapping("/cards")
//    @ResponseBody
//    public List<Card> getAllCards() {
//        return cardService.getAllCards();
//    }
}
