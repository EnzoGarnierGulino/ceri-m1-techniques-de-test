package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IPokemonMetadataProviderTest {
    private final IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(4);
        assertEquals("Charmander", metadata.getName());
        assertEquals(52, metadata.getAttack());
        assertEquals(43, metadata.getDefense());
        assertEquals(39, metadata.getStamina());
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

    // Should change these tests, will do it later
    @Test
    public void testRuntimeException() throws RuntimeException {
        try {
            metadataProvider.getPokemonMetadata(0);
        } catch (RuntimeException | PokedexException e) {
            assertEquals("Pokemon not found", e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}