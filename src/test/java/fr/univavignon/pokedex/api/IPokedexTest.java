package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {
    private IPokedex pokedex;
    public Pokemon pokemon = new Pokemon(3, "Jules", 3, 2000, 1,
            0, 1000, 4, 2, 2);

    @Before
    public void setUp() throws PokedexException {
        pokedex = mock(IPokedex.class);
        when(pokedex.getPokemons()).thenReturn(
                List.of(
                        new Pokemon(0, "Bulbizarre", 120, 126, 90, 0, 100, 0, 0, 0),
                        new Pokemon(1, "Salamèche", 126, 126, 90, 0, 150, 0, 0, 0),
                        new Pokemon(2, "Kaiminus", 220, 126, 55, 0, 200, 0, 0, 0)
                )
        );
        when (pokedex.getPokemon(0)).thenReturn(
            new Pokemon(0, "Bulbizarre", 126, 126, 90, 0, 0, 0, 0, 0)
        );
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemon(0);
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(3, pokemons.size());
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Salamèche", pokemons.get(1).getName());
        assertEquals("Kaiminus", pokemons.get(2).getName());
        assertEquals(55, pokemons.get(2).getStamina());
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        List<Pokemon> sortedPokemons = pokemons.stream().sorted(comparator).toList();
        assertEquals("Bulbizarre", sortedPokemons.get(0).getName());
        assertEquals("Kaiminus", sortedPokemons.get(1).getName());
        assertEquals("Salamèche", sortedPokemons.get(2).getName());
    }
}