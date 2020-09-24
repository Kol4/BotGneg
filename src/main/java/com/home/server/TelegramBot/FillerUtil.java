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
//        whereDidWeGoList.add("На Минское");
        whereDidWeGoList.add("К Сане");
//        whereDidWeGoList.add("К Вике");
//        whereDidWeGoList.add("К Марку");
//        whereDidWeGoList.add("К Коле");
//        whereDidWeGoList.add("На чижовку арену");
//        whereDidWeGoList.add("В мак уручье");
//        whereDidWeGoList.add("На Цну");
//        whereDidWeGoList.add("На Вячу");
//        whereDidWeGoList.add("На Беларуснефть(Беларусфильм)");
//        whereDidWeGoList.add("На Комсомольское Озеро");
//        whereDidWeGoList.add("На заброшку к самолетам");
//        whereDidWeGoList.add("На лавки");
    }

    public static void fillWhereDidWeGoToEatList() {
        whereWeGoEatMessages.add("куда кушать");
        whereWeGoEatMessages.add("куда кушоть");
        whereWeGoEatMessages.add("куда кушать поедем");
        whereWeGoEatMessages.add("куда кушоть поедем");
        whereWeGoEatMessages.add("куда едем кушоть");
        whereWeGoEatMessages.add("куда едем кушать");
        whereWeGoEatMessages.add("где кушать");
        whereWeGoEatMessages.add("где кушоть");
        whereWeGoEatMessages.add("где кушать будем");
        whereDidWeGoEatList.add("В Mc Donalds");
        whereDidWeGoEatList.add("В KFC");
        whereDidWeGoEatList.add("В Burger King");
        whereDidWeGoEatList.add("В Texas Chicken");
        whereDidWeGoEatList.add("В Лидо");
        whereDidWeGoEatList.add("К цыганам на летнюю кухню");
        whereDidWeGoEatList.add("В Domino's");
        whereDidWeGoEatList.add("В Пицца Лисицца");
        whereDidWeGoEatList.add("В Терра Пицца");
        whereDidWeGoEatList.add("Дома");
        whereDidWeGoEatList.add("В Doner King");
        whereDidWeGoEatList.add("В Grill Kebab");
        whereDidWeGoEatList.add("В Хинкальню");
        whereDidWeGoEatList.add("На Беларуснефть(не путать с Беларусфильм)");
    }
}
