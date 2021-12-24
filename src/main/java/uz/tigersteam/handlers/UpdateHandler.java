package uz.tigersteam.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;
import uz.tigersteam.services.LogService;
import uz.tigersteam.utils.Utils;

/**
 * @author Nodirbek Abdukarimov Fri. 9:59 AM. 12/24/2021
 */
public class UpdateHandler {
    private final MessageHandler messageHandler = MessageHandler.getInstance();
    private final CallbackHandler callbackHandler = CallbackHandler.getInstance();
    private final LogService logoService = LogService.getInstance();
    private final static UpdateHandler instance = new UpdateHandler();

    public void handle(Update update) {
        logMe(update);
        if (update.hasMessage()) messageHandler.process(update);
        else if (update.hasCallbackQuery()) callbackHandler.process(update);
    }

    private void logMe(Update update) {
        logoService.save(Utils.withoutNulls().toJson(update));
    }

    public static UpdateHandler getInstance() {
        return instance;
    }
}
