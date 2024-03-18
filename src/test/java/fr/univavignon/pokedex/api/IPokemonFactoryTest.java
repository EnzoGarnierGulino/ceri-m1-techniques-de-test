package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IPokemonFactoryTest {
    private final IPokemonFactory pokemonFactory = new PokemonFactory();

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 20, 30, 10, 40);
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(49, pokemon.getAttack());
        assertEquals(49, pokemon.getDefense());
        assertEquals(45, pokemon.getStamina());
        assertEquals(20, pokemon.getCp(), 0);
        assertEquals(30, pokemon.getHp());
        assertEquals(10, pokemon.getDust(), 0);
        assertEquals(40, pokemon.getCandy(), 0);
        assertEquals(100, pokemon.getIv(), 0);
        assertEquals(1, pokemon.getIndex());
    }
}