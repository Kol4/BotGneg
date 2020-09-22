package com.home.server.TelegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Random;

public class Bot extends TelegramLongPollingBot {
    static ArrayList<String> whereWeGoMessages = new ArrayList<>();
    static ArrayList<String> whereWeGoEatMessages = new ArrayList<>();
    static ArrayList<String> whereDidWeGoList = new ArrayList<>();
    static ArrayList<String> whereDidWeGoEatList = new ArrayList<>();

    @Override
    public void onUpdateReceived(Update update) {
        try {
            FillerUtil.fillWhereDidWeGoList();
            FillerUtil.fillWhereDidWeGoToEatList();
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
        if (messages.contains(line)) {
            outMessage.setChatId(inMessage.getChatId());
            Random random = new Random();
            int index = random.nextInt(list.size());
            String item = list.get(index);
            outMessage.setText(item);
            outMessage.setReplyToMessageId(inMessage.getMessageId());
            execute(outMessage);
        }
    }

    private void checkPhoto(Message inMessage) throws TelegramApiException {
        String line = inMessage.getText().replaceAll("[^a-zA-Zа-яА-Я\\s]", "").toLowerCase();
        if (line.equalsIgnoreCase("детка ты словно")) {
            SendPhoto sendPhoto = new SendPhoto().setChatId(inMessage.getChatId());
            sendPhoto.setPhoto("https://sun2.velcom-by-minsk.userapi.com/Z3KMd8BMdOI1krfrsULO52r60YSM8N_jCoEI-g/MyxvRnf_FTc.jpg");
            execute(sendPhoto);
            SendMessage sendMessage = new SendMessage().setChatId(inMessage.getChatId());
            sendMessage.setText("Cхожу с ума от твоих подлокотников");
            execute(sendMessage);
        }
    }


    @Override
    public String getBotUsername() {
        return "gneg";
    }

    @Override
    public String getBotToken() {
        return "1369454903:AAG6r7UtvSF2Tb2PyXz2HGOmvLutcfjvglc";
    }
}
