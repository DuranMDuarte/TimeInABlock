package net.mcreator.timeinablock; // Seu pacote principal

import com.magorage.tiab.api.ITimeInABottleAPI;
import com.magorage.tiab.api.TiabProvider; // O TiabProvider é usado para 'encapsular' a API
import net.minecraftforge.fml.InterModComms; // Para comunicacao entre mods
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent; // Evento de setup para enviar a mensagem
import net.minecraftforge.fml.common.Mod; // Para a anotacao @Mod


@Mod("timeinablock") // Substitua "timeinablock" pelo MODID do seu mod no MCreator
public class TiabApiHolder {

    // A instancia da API do Time In A Bottle
    private static ITimeInABottleAPI API = null;

    // O provedor da API que sera enviado via InterModComms
    public static final TiabProvider API_PROVIDER = new TiabProvider((api) -> {
        if (API == null) { // Apenas defina a API uma vez
            API = api;
            System.out.println("Time In A Bottle API recebida com sucesso via InterModComms!");
        }
    });

    // Metodo para obter a API (sera chamado dos procedimentos)
    public static ITimeInABottleAPI getApi() {
        return API;
    }

    // Este evento e chamado no momento certo para enviar a mensagem InterModComms
    // Adicione esta anotacao no SEU MOD PRINCIPAL (@Mod class) ou em uma classe de evento Forge
    // O MCreator pode ter uma maneira especifica de adicionar listeners de evento.
    // Se voce nao puder adicionar @Mod.EventBusSubscriber aqui, teremos que adaptar.
    // Por enquanto, suponha que esta classe seja tambem o seu mod principal ou que voce adicionara o listener.
    public TiabApiHolder() {
         // No construtor do seu mod principal, ou onde voce registra eventos
         // FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
         // Mas para o MCreator, isso pode ser complicado.
         // Vamos testar se o simples fato de a classe existir com o API_PROVIDER publico estatico funciona.
    }
}