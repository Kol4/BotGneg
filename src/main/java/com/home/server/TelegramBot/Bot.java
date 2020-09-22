import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Random;

public class Bot extends TelegramLongPollingBot {
    public static ArrayList<String> whereWeGoMessages = new ArrayList<>();
    public static ArrayList<String> whereWeGoEatMessages = new ArrayList<>();
    public static ArrayList<String> whereDidWeGoList = new ArrayList<>();
    public static ArrayList<String> whereDidWeGoEatList = new ArrayList<>();
    /**
     * Метод, который возвращает токен, выданный нам ботом @BotFather.
     *
     * @return токен
     */
    @Override
    public String getBotToken() {
        return "1369454903:AAG6r7UtvSF2Tb2PyXz2HGOmvLutcfjvglc";
    }

    /**
     * Метод-обработчик поступающих сообщений.
     *
     * @param update объект, содержащий информацию о входящем сообщении
     */
    @Override
    public void onUpdateReceived(Update update) {
        try {
            fillWhereDidWeGoList();
            fillWhereDidWeGoToEatList();
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();
                checkMessageType(inMessage, whereWeGoMessages, whereDidWeGoList);
                checkMessageType(inMessage, whereWeGoEatMessages, whereDidWeGoEatList);
                checkPhoto(inMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void checkMessageType(Message inMessage, ArrayList<String> messages, ArrayList<String> list) throws TelegramApiException {
        SendMessage outMessage = new SendMessage();
        String line = inMessage.getText().replaceAll("[^a-zA-Zа-яА-Я\\s]", "").toLowerCase();
        if (messages.contains(line)){
            outMessage.setChatId(inMessage.getChatId());
            Random random = new Random();
            int index = random.nextInt(list.size());
            String item = list.get(index);
            outMessage.setText(item);
            execute(outMessage);
        }
    }

    private void checkPhoto(Message inMessage) throws TelegramApiException {
        String line = inMessage.getText().replaceAll("[^a-zA-Zа-яА-Я\\s]", "").toLowerCase();
        if (line.equalsIgnoreCase("детка ты словно")){
            SendPhoto sendPhoto = new SendPhoto().setChatId(inMessage.getChatId());
            sendPhoto.setPhoto("https://sun2.velcom-by-minsk.userapi.com/Z3KMd8BMdOI1krfrsULO52r60YSM8N_jCoEI-g/MyxvRnf_FTc.jpg");
            execute(sendPhoto);
        }
    }

    private static void fillWhereDidWeGoList() {
        whereWeGoMessages.add("куда едем");
        whereWeGoMessages.add("куда отправимся");
        whereDidWeGoList.add("Минское");
        whereDidWeGoList.add("Вяча");
        whereDidWeGoList.add("К Сане");
        whereDidWeGoList.add("К Вике");
        whereDidWeGoList.add("К Марку");
        whereDidWeGoList.add("К Коле");
        whereDidWeGoList.add("На чижовку арену");
        whereDidWeGoList.add("В мак уручье");
        whereDidWeGoList.add("На цну");
        whereDidWeGoList.add("На вячу");
        whereDidWeGoList.add("На Беларуснефть(Беларусфильм)");
    }

    private static void fillWhereDidWeGoToEatList() {
        whereWeGoEatMessages.add("куда кушать");
        whereWeGoEatMessages.add("куда едем кушоть");
        whereWeGoEatMessages.add("где кушать");
        whereWeGoEatMessages.add("где кушать будем");
        whereDidWeGoEatList.add("Mc Donalds");
        whereDidWeGoEatList.add("KFC");
        whereDidWeGoEatList.add("Burger King");
        whereDidWeGoEatList.add("Texas Chicken");
        whereDidWeGoEatList.add("Лидо");
        whereDidWeGoEatList.add("К цыганам на летнюю кухню");
        whereDidWeGoEatList.add("Domino's");
        whereDidWeGoEatList.add("Пицца Лисицца");
        whereDidWeGoEatList.add("Терра Пицца");
        whereDidWeGoEatList.add("Дома");
    }

    /**
     * Метод, который возвращает имя пользователя бота.
     *
     * @return имя пользователя
     */
    @Override
    public String getBotUsername() {
        return "gneg";
    }
}
