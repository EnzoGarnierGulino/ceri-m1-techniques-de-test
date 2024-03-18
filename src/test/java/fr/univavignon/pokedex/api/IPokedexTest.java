package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class IPokedexTest {
    private final PokemonFactory pokemonFactory = new PokemonFactory();
    private final PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
    private final Pokedex pokedex = new Pokedex(pokemonFactory, pokemonMetadataProvider);

    @Before
    public void setUp() throws PokedexException {
        pokemonMetadataProvider.getPokemonMetadata(1);
        pokedex.addPokemon(pokemonFactory.createPokemon(1, 20, 30, 10, 40));
        pokemonMetadataProvider.getPokemonMetadata(2);
        pokedex.addPokemon(pokemonFactory.createPokemon(2, 20, 30, 10, 40));
    }

    @Test
    public void testGetPokemon() {
        PokemonMetadata metadata = pokedex.getPokemon(0);
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(49, metadata.getAttack());
        assertEquals(49, metadata.getDefense());
        assertEquals(45, metadata.getStamina());
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("Ivysaur", pokemons.get(1).getName());
        assertEquals(60, pokemons.get(1).getStamina());
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        List<Pokemon> sortedPokemons = pokemons.stream().sorted(comparator).toList();
        assertEquals("Bulbasaur", sortedPokemons.get(0).getName());
        assertEquals("Ivysaur", sortedPokemons.get(1).getName());
    }
}