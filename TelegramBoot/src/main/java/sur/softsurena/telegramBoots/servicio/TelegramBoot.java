package sur.softsurena.telegramBoots.servicio;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBoot extends TelegramLongPollingBot{

    private static final Logger LOG = Logger.getLogger(TelegramBoot.class.getName());

    @Override
    public void onUpdateReceived(Update update) {
        Long chatID = update.getMessage().getChatId();
        
        SendMessage m = new SendMessage();
        
        m.setChatId(chatID);
        m.setText("Bienvenido de Netbeans.");
        
        try {
            execute(m);
        } catch (TelegramApiException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public String getBotUsername() {
        return "Bingo_Social_San_Juan_bot";
    }
    
    @Override
    public String getBotToken() {
        return "5507157755:AAEIk_1uT82S6Dlm_qWFrHnGwQYY-t5Le5A";
    }
    
}
