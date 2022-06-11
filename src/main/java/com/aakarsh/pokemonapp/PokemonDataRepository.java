package com.aakarsh.pokemonapp;

import java.util.List;

import com.aakarsh.pokemonapp.model.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PokemonDataRepository extends MongoRepository<Pokemon, Integer> {
    List<Pokemon> findByType1(String name);
    List<Pokemon> findByType2(String name);
}
