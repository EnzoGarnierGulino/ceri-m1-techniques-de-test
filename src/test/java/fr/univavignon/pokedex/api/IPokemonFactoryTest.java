package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        pokemonFactory = mock(IPokemonFactory.class);
        when(pokemonFactory.createPokemon(
                0, 613, 64, 4000, 4))
                .thenReturn(new Pokemon(0, "Bulbizarre", 613, 64, 4000, 4, 126, 126, 90, 0)
                );
    }

    @Test
    public void testCreatePokemon() {
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertEquals("Bulbizarre", pokemon.getName());
        assertEquals(613, pokemon.getAttack());
        assertEquals(64, pokemon.getDefense());
        assertEquals(4000, pokemon.getStamina());
        assertEquals(126, pokemon.getHp());
        assertEquals(4, pokemon.getCp(), 0);
        assertEquals(126, pokemon.getDust(), 0);
        assertEquals(90, pokemon.getCandy(), 0);
        assertEquals(0, pokemon.getIv(), 0);
        assertEquals(0, pokemon.getIndex());
    }
}
