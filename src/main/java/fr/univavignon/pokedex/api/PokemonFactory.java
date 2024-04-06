package fr.univavignon.pokedex.api;

import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PokemonFactory implements IPokemonFactory {

//    @Override
//    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
//        PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
//        PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
//        return new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(), pokemonMetadata.getDefense(),
//                pokemonMetadata.getStamina(), cp, hp, dust, candy, 100);
//    }

    private static Map<Integer, String> index2name;
    static {
        Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        // TODO : Gotta map them all !
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
    }

    private static int generateRandomStat() {
        int total = 0;
        for (int i = 0; i < 1000000; i++) {
            Random rn = new Random();
            int r = rn.nextInt(2);
            total = total + r;
        }
        return total / 10000;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        String name;
        if (!index2name.containsKey(index)) {
            name = index2name.get(0);
        } else {
            name = index2name.get(index);
        }
        int attack;
        int defense;
        int stamina;
        double iv;
        if (index < 0) {
            attack = 1000;
            defense = 1000;
            stamina = 1000;
            iv = 0;
        } else {
            attack = PokemonFactory.generateRandomStat();
            defense = PokemonFactory.generateRandomStat();
            stamina = PokemonFactory.generateRandomStat();
            iv = 1;
        }
        return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
    }
}