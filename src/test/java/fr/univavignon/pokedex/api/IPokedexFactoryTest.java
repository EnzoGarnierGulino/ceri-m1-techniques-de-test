package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class IPokedexFactoryTest {
    private final IPokedexFactory pokedexFactory = new PokedexFactory();

    @Test
    public void IPokedexFactoryTestTest() throws PokedexException {
        assertEquals(pokedexFactory.createPokedex(any(), any()).size(), 0);
    }
}