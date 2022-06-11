package com.aakarsh.pokemonapp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.aakarsh.pokemonapp.model.Pokemon;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private final PokemonDataRepository repository;

    public PokemonController(PokemonDataRepository repository) {
        this.repository = repository;
    }

  @GetMapping
  public List<Pokemon> getPokemon(@RequestParam(value = "type", required = false) String type) {
    if (type != null) {
      List<Pokemon> pokemon1 = repository.findByType1(type);
      List<Pokemon> pokemon2 = repository.findByType2(type);
      return Stream.concat(pokemon1.stream(), pokemon2.stream()).collect(Collectors.toList());
    }
    return repository.findAll();
  }

    @GetMapping("/{index}")
    public Pokemon getPokemonByIndex(@PathVariable Integer index) {
        return repository.findById(index).orElseThrow(() -> new PokemonNotFoundException(index));
    }

    @PostMapping
    public void savePokemon(@RequestBody Pokemon pokemon) {
        repository.save(pokemon);
    }

    @DeleteMapping
    public void deletePokemon(@PathVariable Integer index) {
        repository.deleteById(index);
    }
}
