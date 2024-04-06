package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertTrue("Attack value should be >= 0", metadata.getAttack() >= 0);
        assertTrue("Attack value should be <= 100", metadata.getAttack() <= 100);
        assertTrue("Defense value should be >= 0", metadata.getDefense() >= 0);
        assertTrue("Defense value should be <= 100", metadata.getDefense() <= 100);
        assertTrue("Stamina value should be >= 0", metadata.getStamina() >= 0);
        assertTrue("Stamina value should be <= 100", metadata.getStamina() <= 100);
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbasaur", pokemons.get(0).getName());
        assertEquals("MISSINGNO", pokemons.get(1).getName());
        assertTrue("Stamina value should be >= 0", pokemons.get(1).getStamina() >= 0);
        assertTrue("Stamina value should be <= 100", pokemons.get(1).getStamina() <= 100);
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> sortedPokemons = pokedex.getPokemons(PokemonComparators.NAME);
        assertEquals("Bulbasaur", sortedPokemons.get(0).getName());
        assertEquals("MISSINGNO", sortedPokemons.get(1).getName());
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = pokedex.createPokemon(1, 20, 30, 10, 40);
        assertEquals("Bulbasaur", pokemon.getName());
        assertTrue("Attack value should be >= 0", pokemon.getAttack() >= 0);
        assertTrue("Attack value should be <= 100", pokemon.getAttack() <= 100);
        assertTrue("Defense value should be >= 0", pokemon.getDefense() >= 0);
        assertTrue("Defense value should be <= 100", pokemon.getDefense() <= 100);
        assertTrue("Stamina value should be >= 0", pokemon.getStamina() >= 0);
        assertTrue("Stamina value should be <= 100", pokemon.getStamina() <= 100);
        assertEquals(20, pokemon.getCp(), 0);
        assertEquals(30, pokemon.getHp());
        assertEquals(10, pokemon.getDust(), 0);
        assertEquals(40, pokemon.getCandy(), 0);
        assertTrue("IV value should be >= 0", pokemon.getIv() >= 0);
        assertTrue("IV value should be <= 100", pokemon.getIv() <= 1);
        assertEquals(1, pokemon.getIndex());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(1);
        assertEquals("Bulbasaur", metadata.getName());
        assertTrue("Attack value should be >= 0", metadata.getAttack() >= 0);
        assertTrue("Attack value should be <= 100", metadata.getAttack() <= 100);
        assertTrue("Defense value should be >= 0", metadata.getDefense() >= 0);
        assertTrue("Defense value should be <= 100", metadata.getDefense() <= 100);
        assertTrue("Stamina value should be >= 0", metadata.getStamina() >= 0);
        assertTrue("Stamina value should be <= 100", metadata.getStamina() <= 100);
    }

    @Test
    public void testGetPokemonMetadataException() throws PokedexException {
        try {
            pokedex.getPokemonMetadata(-1);
        } catch (PokedexException e) {
            assertEquals("Pokemon not found", e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}