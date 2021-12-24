package uz.tigersteam.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;
import uz.tigersteam.config.state.State;
import uz.tigersteam.config.state.UserState;
import uz.tigersteam.processors.AuthorizationProcessor;

/**
 * @author Nodirbek Abdukarimov Fri. 9:59 AM. 12/24/2021
 */
public class MessageHandler implements IBaseHandler {
    private final static MessageHandler instance = new MessageHandler();

    private final State state = State.getInstance();
    private final AuthorizationProcessor authorizationProcessor = AuthorizationProcessor.getInstance();

    @Override
    public void process(Update update) {
        long chatID = update.getMessage().getChatId();
        if (!isAuthorized(chatID)) {
            authorizationProcessor.process(update, state.getState(chatID));
        }
    }

    private boolean isAuthorized(long chatID) {
        return UserState.AUTHORIZED.equals(state.getState(chatID));
    }

    public static MessageHandler getInstance() {
        return instance;
    }
}
