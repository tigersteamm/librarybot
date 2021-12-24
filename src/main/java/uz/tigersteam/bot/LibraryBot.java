package uz.tigersteam.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.tigersteam.config.PConfig;
import uz.tigersteam.handlers.UpdateHandler;

/**
 * @author Nodirbek Abdukarimov Fri. 10:17 AM. 12/24/2021
 */
public class LibraryBot extends TelegramLongPollingBot {

    public static final LibraryBot instance = new LibraryBot();

    private final UpdateHandler handler = UpdateHandler.getInstance();

    @Override
    public String getBotUsername() {
        return PConfig.get("bot.username");
    }

    @Override
    public String getBotToken() {
        return PConfig.get("bot.token");
    }

    @Override
    public void onUpdateReceived(Update update) {
        handler.handle(update);
    }

    public static LibraryBot getInstance() {
        return instance;
    }

    public void executeMessage(BotApiMethod<?> message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void executePhone(SendPhoto message){
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
