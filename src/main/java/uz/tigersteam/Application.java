package uz.tigersteam;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.tigersteam.bot.LibraryBot;
import uz.tigersteam.migrations.Migrate;

/**
 * @author Nodirbek Abdukarimov Fri. 9:50 AM. 12/24/2021
 */
public class Application {
    public static void main(String[] args) {
        Migrate.init();
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(new LibraryBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
