package com.aakarsh.pokemonapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PokemonNotFoundException extends RuntimeException {
  public PokemonNotFoundException(int index) {
    super("Pokemon #" + index + " not found");
  }
}
