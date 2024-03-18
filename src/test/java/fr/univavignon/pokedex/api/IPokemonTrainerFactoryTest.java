package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    private IPokedex pokedex = new Pokedex(new PokemonFactory(), new PokemonMetadataProvider());

    @Before
    public void setUp() {
        PokemonTrainer trainer = new PokemonTrainer("Enzo", Team.MYSTIC, pokedex);
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Enzo", Team.MYSTIC, pokedex);
        assertEquals("Enzo", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertEquals(pokedex, pokemonTrainer.getPokedex());
    }
}