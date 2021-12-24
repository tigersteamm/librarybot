package uz.tigersteam.buttons;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import uz.tigersteam.utils.Emojis;

import java.util.Arrays;
import java.util.List;

/**
 * @author Nodirbek Abdukarimov Fri. 9:55 AM. 12/24/2021
 */
public class InlineBoards {
    private static final InlineKeyboardMarkup board = new InlineKeyboardMarkup();


    public static InlineKeyboardMarkup languageButtons(String... caption) {
        InlineKeyboardButton uz = new InlineKeyboardButton(Emojis.UZ + " Uzbek");
        uz.setCallbackData("uz");

        InlineKeyboardButton ru = new InlineKeyboardButton(Emojis.RU + " Russian");
        ru.setCallbackData("ru");

        InlineKeyboardButton en = new InlineKeyboardButton(Emojis.EN + " English");
        en.setCallbackData("en");
        board.setKeyboard(Arrays.asList(getRow(uz), getRow(ru), getRow(en)));
        return board;
    }

    private static List<InlineKeyboardButton> getRow(InlineKeyboardButton... buttons) {
        return Arrays.stream(buttons).toList();
    }

}
