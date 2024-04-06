package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IPokemonFactoryTest {
    private final IPokemonFactory pokemonFactory = new PokemonFactory();

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = pokemonFactory.createPokemon(1, 20, 30, 10, 40);
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
}