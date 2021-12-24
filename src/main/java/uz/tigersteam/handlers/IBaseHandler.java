package uz.tigersteam.handlers;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author Nodirbek Abdukarimov Fri. 9:59 AM. 12/24/2021
 */
public interface IBaseHandler {
    void process(Update update);
}
