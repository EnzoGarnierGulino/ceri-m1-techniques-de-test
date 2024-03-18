package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    // The iv value was set manually to test purposes
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
        PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
        return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(),
                pokemonMetadata.getStamina(), cp, hp, dust, candy, 100);
    }
}