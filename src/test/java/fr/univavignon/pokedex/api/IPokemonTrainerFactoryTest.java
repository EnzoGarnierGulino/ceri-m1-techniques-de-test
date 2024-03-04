package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    private IPokemonTrainerFactory pokemonTrainerFactory;
    private IPokedexFactory pokedexFactoryMock;
    private IPokedex pokedexMock;

    @Before
    public void setUp() throws PokedexException {
        pokemonTrainerFactory = mock(IPokemonTrainerFactory.class);
        pokedexFactoryMock = mock(IPokedexFactory.class);
        PokemonTrainer trainer = new PokemonTrainer("Enzo", Team.MYSTIC, pokedexMock);
        when(pokemonTrainerFactory.createTrainer("Enzo", Team.MYSTIC, pokedexFactoryMock))
                .thenReturn(new PokemonTrainer("Enzo", Team.MYSTIC, pokedexMock));
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Enzo", Team.MYSTIC, pokedexMock);
        assertEquals("Enzo", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertEquals(pokedexMock, pokemonTrainer.getPokedex());
    }
}