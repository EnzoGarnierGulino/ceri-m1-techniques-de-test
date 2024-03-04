package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {
    private IPokedexFactory pokedexFactory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() throws PokedexException {
        pokedexFactory = mock(IPokedexFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
    }

//    @Test
//    public void testCreatePokedex() {
//    IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
//        assertEquals(metadataProvider, pokedex.getMetadataProvider());
//        assertEquals(pokemonFactory, pokedex.getPokemonFactory());
//    }
}