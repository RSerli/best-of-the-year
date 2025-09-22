package com.yearrimander.best_of_the_year.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yearrimander.best_of_the_year.model.movies;
import com.yearrimander.best_of_the_year.model.songs;


@Controller
@RequestMapping("/")
public class BestOfTheYearController {

    //funzione per ritornare il file HTML
    @GetMapping("/BestOfTheYear")
    public String BestOfTheYear( @RequestParam(required=false) String userFirstName,
                                Model model) {
        // model.addAttribute("userFirstName", userFirstName);
        return "BestOfTheYear";
    }

    // Lista canzoni e film
    @GetMapping("/movies")
    public String ViewMovies (Model model){
        model.addAttribute("film", creaListaFilm ());
        return "movies";
    }

     @GetMapping("/songs")
    public String ViewSongs (Model model){
        model.addAttribute("canzoni", creaListaCanzoni ());
        return "songs";
    }

    // visualizzazione specifica canzone\film a seconda dell'id passato
    @GetMapping("/movies/{id}")
    public String ViewSelectedMovie (@PathVariable(name="id", required=false) Integer param, Model model){
        List<movies> listaFilm = creaListaFilm ();
        movies FilmSelezionato = null;
        for (movies u : listaFilm){
            if(u.getId() == param){
                FilmSelezionato = u;
                break;
            }
        }
        if (FilmSelezionato != null){
            model.addAttribute("selectedObj", FilmSelezionato);
        }
        return "detail";
    }

     @GetMapping("/songs/{id}")
    public String ViewSelectedSong (@PathVariable(name="id", required=false) Integer param, Model model){
        List<songs> listaCanzoni = creaListaCanzoni ();
        songs CanzoneSelezionata = null;
        for (songs u : listaCanzoni){
            if(u.getId() == param){
                CanzoneSelezionata = u;
                break;
            }
        }
        if (CanzoneSelezionata != null){
            model.addAttribute("selectedObj", CanzoneSelezionata);
        }
        return "detail";
    }

    private List<movies> creaListaFilm (){
        List<movies> listaFilm = new ArrayList<>();

        listaFilm.add(new movies("Inception", 1, "Fantascienza", 2010, 8.8));
        listaFilm.add(new movies("Il Padrino", 2, "Dramma", 1972, 9.2));
        listaFilm.add(new movies("Interstellar", 3, "Fantascienza", 2014, 8.6));

        return listaFilm;
    }

    private List<songs> creaListaCanzoni (){
        List<songs> listaCanzoni = new ArrayList<>();

        listaCanzoni.add(new songs("Bohemian Rhapsody", 1, "Rock", 1975, 9.8));
        listaCanzoni.add(new songs("Billie Jean", 2, "Pop", 1982, 9.5));
        listaCanzoni.add(new songs("Smells Like Teen Spirit", 3, "Grunge", 1991, 9.0));
        listaCanzoni.add(new songs("Shape of You", 4, "Pop", 2017, 8.2));
        listaCanzoni.add(new songs("Imagine", 5, "Soft Rock", 1971, 9.7));

        return listaCanzoni;
    }
    
}
