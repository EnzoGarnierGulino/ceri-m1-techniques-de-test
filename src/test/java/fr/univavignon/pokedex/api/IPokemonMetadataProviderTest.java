package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() throws PokedexException {
        metadataProvider = mock(IPokemonMetadataProvider.class);
        when(metadataProvider.getPokemonMetadata(0)).thenReturn(
                new PokemonMetadata( 0, "Bulbizarre", 126, 126, 90));
        when(metadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Pokemon not found"));
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(0);
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test
    public void testGetPokemonMetadataException() throws PokedexException {
        try {
            metadataProvider.getPokemonMetadata(-1);
        } catch (PokedexException e) {
            assertEquals("Pokemon not found", e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}