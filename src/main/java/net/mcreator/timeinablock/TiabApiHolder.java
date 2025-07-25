package net.mcreator.timeinablock; // Ajuste o pacote para o seu mod, se diferente

import com.magorage.tiab.api.ITimeInABottleAPI;
import com.magorage.tiab.api.TiabProvider;
 // Esta linha é a causa do "cannot find symbol"
import net.minecraftforge.fml.InterModComms;

public class TiabApiHolder {
    private static ITimeInABottleAPI API_INSTANCE;

    public static ITimeInABottleAPI getApi() {
        if (API_INSTANCE == null) {
            // Se a API ainda não foi definida, solicita-a
            TiabProvider provider = new TiabProvider((api) -> {
                API_INSTANCE = api; // Quando o TIAB mod nos der a API, guardamos aqui
            });
            // Envia a mensagem IMC para que o TIAB mod nos forneça a API
            // O ID do mod é "timeinabottle" e a constante da API é "tiab_api" (deduzido de ITimeInABottleAPI.IMC)
            InterModComms.sendTo("timeinabottle", "tiab_api", () -> provider);
        }
        return API_INSTANCE;
    }
}