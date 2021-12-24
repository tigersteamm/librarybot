package uz.tigersteam.config.state;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nodirbek Abdukarimov Fri. 9:56 AM. 12/24/2021
 */


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class State {
    private static State state = new State();
    private Map<Long, UserState> userState = new HashMap<>();

    public UserState getState(Long chatID) {
        for (Map.Entry<Long, UserState> entry : userState.entrySet()) {
            if (entry.getKey().equals(chatID)) return entry.getValue();
        }
        return null;
    }

    public void setState(long chatID, UserState newState) {
        userState.put(chatID, newState);
    }

    public static State getInstance() {
        return state;
    }
}
