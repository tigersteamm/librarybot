package uz.tigersteam.handlers;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.tigersteam.bot.LibraryBot;
import uz.tigersteam.config.state.State;
import uz.tigersteam.config.state.UserState;

/**
 * @author Nodirbek Abdukarimov Fri. 9:59 AM. 12/24/2021
 */
public class CallbackHandler implements IBaseHandler {
    public static final CallbackHandler instance = new CallbackHandler();

    @Override
    public void process(Update update) {
        final LibraryBot BOT = LibraryBot.getInstance();
        CallbackQuery callbackQuery = update.getCallbackQuery();
        Message message = callbackQuery.getMessage();
        long chatId = message.getChatId();
        String data = callbackQuery.getData();

        switch (data) {
            case "ru", "en", "uz" -> {
                SendMessage sendMessage = messageObj(chatId, "Please send your fullname");
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                BOT.executeMessage(new DeleteMessage("" + chatId, message.getMessageId()));
                BOT.executeMessage(sendMessage);
                changeState(chatId, UserState.LANGUAGE_CHOSEN);
            }
        }
    }

    private void changeState(long chatId, UserState age) {
        State.getInstance().setState(chatId, age);
    }

    private SendMessage messageObj(long chatId, String text) {
        return new SendMessage(chatId + "", text);
    }

    public static CallbackHandler getInstance() {
        return instance;
    }
}
