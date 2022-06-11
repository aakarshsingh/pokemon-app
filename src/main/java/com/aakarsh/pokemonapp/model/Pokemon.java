package com.aakarsh.pokemonapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon {

    @Id
    int index;
    String name;
    List<String> moves;
    Type type1;
    Type type2;
}
