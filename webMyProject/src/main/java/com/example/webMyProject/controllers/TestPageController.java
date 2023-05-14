package com.example.webMyProject.controllers;

import com.example.webMyProject.models.Card;
import com.example.webMyProject.models.User;
import com.example.webMyProject.models.UserCard;
import com.example.webMyProject.repository.CardRepository;
import com.example.webMyProject.repository.UserCardRepository;
import com.example.webMyProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class TestPageController {

//    @Autowired
//    CardRepository cardRepository;
//
//    @Autowired
//    UserCardRepository userCardRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    private Card card1;
//    private Card card2;
//    private Card card3;
//    private Card card4;
//    private boolean isDone;
//
//    private boolean isTrue1;
//    private boolean isTrue2;
//    private boolean isTrue3;
//    private boolean isTrue4;
//
//    @GetMapping("/profile/learn")
//    public String cardLearnPageShow(
//            Model model){
//        System.out.println("cardLearnPageShow");
//        model.addAttribute("isDone", isDone);
//        model.addAttribute("isTrue1", isTrue1);
//        model.addAttribute("isTrue2", isTrue2);
//        model.addAttribute("isTrue3", isTrue3);
//        model.addAttribute("isTrue4", isTrue4);
//        model.addAttribute("card1", card1);
//        model.addAttribute("card2", card2);
//        model.addAttribute("card3", card3);
//        model.addAttribute("card4", card4);
//        isDone = false;
//        card1 = null;
//        card2 = null;
//        card3 = null;
//        card4 = null;
//        isTrue1 = false;
//        isTrue2 = false;
//        isTrue3 = false;
//        isTrue4 = false;
//        return "learn";
//    }
//
//    @PostMapping("/profile/learn")
//    public String cardLearnPagePost(
//            Authentication authentication,
//            @ModelAttribute("rus1") String rus1,
//            @ModelAttribute("rus2") String rus2,
//            @ModelAttribute("rus3") String rus3,
//            @ModelAttribute("rus4") String rus4,
//            Model model
//    ) {
//        System.out.println("cardLearnPagePost");
//        if(card1 != null && !card1.getRus().equals(rus1)) {
//            isTrue1 = false;
//        }
//        else if(card1 != null && card1.getRus().equals(rus1)){
//            User user = userRepository.findByLogin(authentication.getName());
//            long id = user.getId();
//            UserCard userCard = userCardRepository.findByCardIdAndUserId(card1.getId(), id);
//            userCard.setLearn(true);
//            LocalDate localDate = LocalDate.now(ZoneId.of("Europe/Moscow"));
//            Date date = new Date(localDate.getYear() - 1900, localDate.getMonthValue(), localDate.getDayOfMonth());
//            userCard.setDate(date);
//            userCardRepository.save(userCard);
//        }
//        if(card2 != null && !card2.getRus().equals(rus2)) {
//            isTrue2 = false;
//        }else if(card2 != null && card2.getRus().equals(rus2)){
//            User user = userRepository.findByLogin(authentication.getName());
//            long id = user.getId();
//            UserCard userCard = userCardRepository.findByCardIdAndUserId(card2.getId(), id);
//            userCard.setLearn(true);
//            LocalDate localDate = LocalDate.now(ZoneId.of("Europe/Moscow"));
//            Date date = new Date(localDate.getYear() - 1900, localDate.getMonthValue(), localDate.getDayOfMonth());
//            userCard.setDate(date);
//            userCardRepository.save(userCard);
//        }
//        if(card3 != null && !card3.getRus().equals(rus3)) {
//            isTrue3 = false;
//        }else if(card3 != null && card3.getRus().equals(rus3)){
//            User user = userRepository.findByLogin(authentication.getName());
//            long id = user.getId();
//            UserCard userCard = userCardRepository.findByCardIdAndUserId(card3.getId(), id);
//            userCard.setLearn(true);
//            LocalDate localDate = LocalDate.now(ZoneId.of("Europe/Moscow"));
//            Date date = new Date(localDate.getYear() - 1900, localDate.getMonthValue(), localDate.getDayOfMonth());
//            userCard.setDate(date);
//            userCardRepository.save(userCard);
//        }
//        if(card4 != null && !card4.getRus().equals(rus4)) {
//            isTrue4 = false;
//        }else if(card4 != null && card4.getRus().equals(rus4)){
//            User user = userRepository.findByLogin(authentication.getName());
//            long id = user.getId();
//            UserCard userCard = userCardRepository.findByCardIdAndUserId(card4.getId(), id);
//            userCard.setLearn(true);
//            LocalDate localDate = LocalDate.now(ZoneId.of("Europe/Moscow"));
//            Date date = new Date(localDate.getYear() - 1900, localDate.getMonthValue(), localDate.getDayOfMonth());
//            userCard.setDate(date);
//            userCardRepository.save(userCard);
//        }
//        isDone = true;
//        return "redirect:/profile/learn";
//    }
//
//    @GetMapping("/profile/learn/search")
//    public String cardGetByTag(
//            @RequestParam(required = false) String tag,
//            @ModelAttribute("rus1") String rus1,
//            @ModelAttribute("rus2") String rus2,
//            @ModelAttribute("rus3") String rus3,
//            @ModelAttribute("rus4") String rus4,
//            Model model
//    ) {
//        card1 = null;
//        card2 = null;
//        card3 = null;
//        card4 = null;
//        isDone = false;
//        isTrue1 = true;
//        isTrue2 = true;
//        isTrue3 = true;
//        isTrue4 = true;
//
//        List<Card> cards;
//        if(tag == null){
//            cards = null;
//        }
//        cards = cardRepository.findByTagAndIsGlobal(tag, false);
//        for(Card card: cards){
//            System.out.println(card.getRus());
//        }
//        if(cards.size() == 1){
//            card1 = cards.get(0);
//        }
//        else if(cards.size() == 2){
//            card1 = cards.get(0);
//            card2 = cards.get(1);
//        }
//        else if(cards.size() == 3){
//            card1 = cards.get(0);
//            card2 = cards.get(1);
//            card3 = cards.get(2);
//        }
//        else if(cards.size() == 4){
//            card1 = cards.get(0);
//            card2 = cards.get(1);
//            card3 = cards.get(2);
//            card4 = cards.get(3);
//        }
//        else if(cards.size() > 4){
//            Random rand = new Random();
//            int n = cards.size();
//            List<Integer> randoms = new ArrayList<>(4);
//            int i = 0;
//            while(i < 4){
//                int x = rand.nextInt() % n;
//                if(x >= 0 && x < n && !randoms.contains(x)) {
//                    randoms.add(x);
//                    ++i;
//                }
//            }
//            card1 = cards.get(randoms.get(0));
//            card2 = cards.get(randoms.get(1));
//            card3 = cards.get(randoms.get(2));
//            card4 = cards.get(randoms.get(3));
//        }
//        System.out.println("cardGetByTag");
//        System.out.println(card1);
//        model.addAttribute("isTrue1", isTrue1);
//        model.addAttribute("isTrue2", isTrue2);
//        model.addAttribute("isTrue3", isTrue3);
//        model.addAttribute("isTrue4", isTrue4);
//        model.addAttribute("isDone", isDone);
//        model.addAttribute("card1", card1);
//        model.addAttribute("card2", card2);
//        model.addAttribute("card3", card3);
//        model.addAttribute("card4", card4);
//        return "learn";
//    }
//
//    @GetMapping("/profile/learn/exit")
//    public String exit(){
//        return "redirect:/profile";
//    }
}
