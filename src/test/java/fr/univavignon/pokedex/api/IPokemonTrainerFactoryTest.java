package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {
    private PokemonTrainerFactory pokemonTrainerFactory;

    @Before
    public void setUp() {
        pokemonTrainerFactory = new PokemonTrainerFactory();
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer(
                "Enzo", Team.MYSTIC, new PokedexFactory());
        assertEquals("Enzo", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertNotNull(pokemonTrainer.getPokedex());
    }
}