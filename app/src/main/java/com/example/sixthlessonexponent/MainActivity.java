package com.example.sixthlessonexponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    // поля
    // строка для анализа
    private String exponent = "2.56392920394749309374536739446710947365821345672947637432847154609373284762048372642749" +
            "8576348104873657364529473908765467143546194756482981756478092134569087655434567840337256574474677339756371" +
            "4657802845284027463732847108465893724865743856927483945674275647839275644535654787094638284636736371253768";

    private int[] arrayInt; // массив для цифр заданного числа
    private int volune3; // количество цифр 3
    private int volune5; // количество цифр 5
    private int rareDigit; // самая редкая цифра
    private int[] reversArrayInt; // массив задом наперёд
    private String reversStringInt; // массив задом наперёд в виде строки
    private int[] sortArrayInt; // отсортированный массив

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView infoApp; // поле вывода информации анализа строки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // инициализация полей
        arrayInt = arrayInt(exponent);
        volune3 = volune3(arrayInt);
        volune5 = volune5(arrayInt);
        rareDigit = rareDigit(arrayInt);
        reversArrayInt = reversArrayInt(arrayInt);

        reversStringInt = Arrays.toString(reversArrayInt); // преобразование массива в строку

        sortArrayInt = Arrays.copyOf(arrayInt, arrayInt.length); // копирование массива
        Arrays.sort(sortArrayInt); // сортировка массива
    }

    // метод определения массива задом наперёд
    private int[] reversArrayInt(int[] arrayDigit) {
        int[] revers = new int[arrayDigit.length]; // адание нового массива
        for (int i = arrayDigit.length - 1; i >= 0; i--) { // перебор входного массива
            revers[arrayDigit.length - (i + 1)] = arrayDigit[i]; // инициализация задом наперёд
        }
        return revers;
    }

    // метод определения самой редкой цифры
    private int rareDigit(int[] arrayDigit) {
        int[] count = new int[10]; // пределение счётчика
        for (int i : arrayDigit) { // перебор входного массива
            switch (i) { // заполнение счётчиков
                case 0:
                    count[0]++;
                    break;
                case 1:
                    count[1]++;
                    break;
                case 2:
                    count[2]++;
                    break;
                case 3:
                    count[3]++;
                    break;
                case 4:
                    count[4]++;
                    break;
                case 5:
                    count[5]++;
                    break;
                case 6:
                    count[6]++;
                    break;
                case 7:
                    count[7]++;
                    break;
                case 8:
                    count[8]++;
                    break;
                case 9:
                    count[9]++;
                    break;
            }
        }
        int rare = 0; // задание параметра самой оедкой цифры
        for (int i = 0; i < count.length; i++) { //  перебор массива счётчика
            if (count[i] > count[rare]) rare = i;
        }
        return rare;
    }

    // метод определения количества цифр 3
    private int volune3(int[] arrayDigit) {
        int count = 0; // определение счётчика
        for (int i : arrayDigit) { // перебор входного массива
            if (i == 3) {
                count++;
            }
        }
        return count;
    }

    // метод определения количества цифр 5
    private int volune5(int[] arrayDigit) {
        int count = 0; // определение счётчика
        for (int i : arrayDigit) { // перебор входного массива
            if (i == 5) {
                count++;
            }
        }
        return count;
    }

    // метод получения массива заданного числа
    private int[] arrayInt(String string) {
        String stringNew = string.replace(".", ""); // удаление точки из входных данных
        String[] arrayString = stringNew.split(""); // деление входных данных на символы
        int[] arrayInteger = new int[arrayString.length]; // создание числового массива для данных
        // заполнение числового массива путём конвертирования данных строкового массива
        for (int i = 0; i < arrayString.length; i++) {
            arrayInteger[i] = Integer.parseInt(arrayString[i]);
        }
        return arrayInteger;
    }
}