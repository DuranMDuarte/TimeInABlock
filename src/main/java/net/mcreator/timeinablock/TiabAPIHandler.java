package net.mcreator.timeinablock; // Seu pacote principal

import com.magorage.tiab.api.ITimeInABottleAPI;
import com.magorage.tiab.api.TiabProvider; // Usado pelo TIAB para entregar a API

public class TiabAPIHandler {

    // A instancia da API do Time In A Bottle que sera preenchida pelo TIAB
    private static ITimeInABottleAPI API_INSTANCE = null;

    // Este e o TiabProvider que o TIAB vai usar para nos enviar a API.
    // Ele e publico e estatico para ser referenciado facilmente pelo InterModComms.
    public static final TiabProvider TIAB_API_PROVIDER = new TiabProvider((api) -> {
        if (API_INSTANCE == null) {
            API_INSTANCE = api; // Armazena a API assim que ela e recebida
            System.out.println("Time In A Bottle API recebida com sucesso via TiabProvider!");
        }
    });

    // Metodo publico para que seus procedimentos possam obter a API
    public static ITimeInABottleAPI getAPI() {
        return API_INSTANCE;
    }
}