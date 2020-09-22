package com.home.server.TelegramBot;

import static com.home.server.TelegramBot.Bot.whereDidWeGoEatList;
import static com.home.server.TelegramBot.Bot.whereDidWeGoList;
import static com.home.server.TelegramBot.Bot.whereWeGoEatMessages;
import static com.home.server.TelegramBot.Bot.whereWeGoMessages;

public class FillerUtil {
    public static void fillWhereDidWeGoList() {
        whereWeGoMessages.add("куда едем");
        whereWeGoMessages.add("куда отправимся");
        whereWeGoMessages.add("куда поедем");
        whereWeGoMessages.add("куда пойдем");
        whereWeGoMessages.add("куда покатим");
        whereDidWeGoList.add("Минское");
        whereDidWeGoList.add("Вяча");
        whereDidWeGoList.add("К Сане");
        whereDidWeGoList.add("К Вике");
        whereDidWeGoList.add("К Марку");
        whereDidWeGoList.add("К Коле");
        whereDidWeGoList.add("На чижовку арену");
        whereDidWeGoList.add("В мак уручье");
        whereDidWeGoList.add("На Цну");
        whereDidWeGoList.add("На Вячу");
        whereDidWeGoList.add("На Беларуснефть(Беларусфильм)");
        whereDidWeGoList.add("На Комсомольское Озеро");
        whereDidWeGoList.add("На заброшку к самолетам");
        whereDidWeGoList.add("На лавки");
    }

    public static void fillWhereDidWeGoToEatList() {
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
        whereDidWeGoEatList.add("За шавой");
    }
}
