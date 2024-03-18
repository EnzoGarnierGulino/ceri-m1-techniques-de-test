package fr.univavignon.pokedex.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("C:\\Users\\Z84cr\\Desktop\\M1\\S2\\Techniques de Test\\TP1\\ceri-m1-techniques-de-test\\src\\db\\db.json");
        PokemonMetadata pokemonMetadata = null;
        try (JsonParser jsonParser = objectMapper.getFactory().createParser(path.toFile())) {
            jsonParser.nextToken();
            int currentIndex = 0;
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                currentIndex++;
                if (currentIndex == index) {
                    pokemonMetadata = objectMapper.readValue(jsonParser, PokemonMetadata.class);
                    break;
                }
                jsonParser.skipChildren();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (pokemonMetadata == null) {
            throw new PokedexException("Pokemon not found");
        }
        return pokemonMetadata;
    }
}