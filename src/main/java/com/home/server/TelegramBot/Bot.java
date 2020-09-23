package com.home.server.TelegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Bot extends TelegramLongPollingBot {
    private static final Pattern COMPILE = Pattern.compile("[^a-zA-Zа-яА-Я\\s]");
    static List<String> whereWeGoMessages = new ArrayList<>();
    static List<String> whereWeGoEatMessages = new ArrayList<>();
    static List<String> whereDidWeGoList = new ArrayList<>();
    static List<String> whereDidWeGoEatList = new ArrayList<>();

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
                checkGolodni(inMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void checkMessageType(Message inMessage, List<String> messages, List<String> list) throws TelegramApiException {
        String line = COMPILE.matcher(inMessage.getText()).replaceAll("").toLowerCase();
        if (messages.contains(line)) {
            int index = new SecureRandom().nextInt(list.size());
            String item = list.get(index);
            SendMessage outMessage = new SendMessage();
            outMessage.setChatId(inMessage.getChatId());
            outMessage.setText(item);
            outMessage.setReplyToMessageId(inMessage.getMessageId());
            execute(outMessage);
        }
    }

    private void checkPhoto(Message inMessage) throws TelegramApiException {
        String line = COMPILE.matcher(inMessage.getText()).replaceAll("").toLowerCase();
        if (line.equalsIgnoreCase("детка ты словно")) {
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId(inMessage.getChatId());
            sendPhoto.setPhoto("https://sun2.velcom-by-minsk.userapi.com/Z3KMd8BMdOI1krfrsULO52r60YSM8N_jCoEI-g/MyxvRnf_FTc.jpg");
            execute(sendPhoto);
            SendMessage outMessage = new SendMessage().setChatId(inMessage.getChatId());
            outMessage.setText("Cхожу с ума от твоих подлокотников");
            execute(outMessage);
        }
    }

    private void checkGolodni(Message inMessage) throws TelegramApiException {
        String line = COMPILE.matcher(inMessage.getText()).replaceAll("").toLowerCase();
        if (line.equalsIgnoreCase("хочу кушать")) {
            SendSticker sticker = new SendSticker();
            sticker.setChatId(inMessage.getChatId());
            sticker.setSticker("CAACAgIAAxkBAAEBXMRfa1MNpNIGYa1mdTcUx7bD-imMgQACuAADmY-lB4KvrWz3nRM1GwQ");
            execute(sticker);
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
