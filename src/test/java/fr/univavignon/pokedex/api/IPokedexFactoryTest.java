package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);
        when(pokedex.size()).thenReturn(0);
        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);
    }


    @Test
    public void IPokedexFactoryTestTest() throws PokedexException {
        assertEquals(pokedexFactory.createPokedex(any(), any()).size(), 0);
    }
}