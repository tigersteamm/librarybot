package uz.tigersteam.processors;

import org.apache.commons.lang3.StringUtils;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ForceReplyKeyboard;
import uz.tigersteam.bot.LibraryBot;
import uz.tigersteam.buttons.InlineBoards;
import uz.tigersteam.buttons.MarkupBoard;
import uz.tigersteam.config.PConfig;
import uz.tigersteam.config.state.State;
import uz.tigersteam.config.state.UserState;
import uz.tigersteam.utils.Emojis;

import java.io.File;
import java.util.Objects;

/**
 * @author Nodirbek Abdukarimov Fri. 10:02 AM. 12/24/2021
 */
public class AuthorizationProcessor {
    public static final AuthorizationProcessor instance = new AuthorizationProcessor();

    public void process(Update update, UserState state) {
        LibraryBot bot = LibraryBot.getInstance();
        Message message = update.getMessage();
        long chatId = message.getChatId();
        User user = message.getFrom();
        if (Objects.isNull(state)) {
            SendPhoto sendPhoto = new SendPhoto(message.getChatId().toString(), new InputFile(new File(PConfig.get("bot.logo"))));
            sendPhoto.setCaption("Welcome to out %s %s".formatted(PConfig.get("bot.name"), user.getFirstName()));
            bot.executePhone(sendPhoto);
            // todo need translation
            SendMessage sendMessage = messageObj(chatId, "Choose Language please ");
            sendMessage.setReplyMarkup(InlineBoards.languageButtons());
            bot.executeMessage(sendMessage);
            changeState(chatId, UserState.LANGUAGE);

        } else if (UserState.LANGUAGE.equals(state)) {
            bot.executeMessage(new DeleteMessage("" + chatId, message.getMessageId()));
        } else if (UserState.LANGUAGE_CHOSEN.equals(state)) {
            SendMessage sendMessage = messageObj(chatId, "Your age please");
            sendMessage.setReplyMarkup(new ForceReplyKeyboard());
            bot.executeMessage(sendMessage);
            changeState(chatId, UserState.AGE);
        } else if (UserState.AGE.equals(state)) {
            if (!StringUtils.isNumeric(message.getText())) {
                SendMessage sendMessage = messageObj(chatId, "Invalid input\nEnter again");
                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
                bot.executeMessage(sendMessage);
            } else {
                SendMessage sendMessage = messageObj(chatId, Emojis.PHONE + "Share Your phone number please");
                sendMessage.setReplyMarkup(MarkupBoard.sharePhoneNumber());
                bot.executeMessage(sendMessage);
                changeState(chatId, UserState.PHONE);
            }
        } else if (UserState.PHONE.equals(state)) {
            SendMessage sendMessage = messageObj(chatId, "Successfully registered");
            sendMessage.setReplyMarkup(MarkupBoard.mainMenu());
            bot.executeMessage(sendMessage);
            changeState(chatId, UserState.AUTHORIZED);
        }
    }

    private SendMessage messageObj(long chatId, String text) {
        return new SendMessage(String.valueOf(chatId), text);
    }

    private void changeState(long chatId, UserState age) {
        State.getInstance().setState(chatId, age);
    }

    public static AuthorizationProcessor getInstance() {
        return instance;
    }
}
