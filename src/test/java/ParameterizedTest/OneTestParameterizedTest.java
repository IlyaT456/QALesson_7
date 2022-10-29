package ParameterizedTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;


public class OneTestParameterizedTest {

    @CsvSource(value = {
            "Фантастика 0 Три дня Индиго",
            "Детективы 0 Судьба по книге перемен",
    }, delimiter = '0')
    @ParameterizedTest()
    public void checkingBookstore(String genre, String nameBook) {
        open("https://www.litres.ru/");
        $x("//div[@class='LowerMenu-module__item LowerMenu-module__genres']/a[text()='Жанры']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        $x("//a[text()='"+genre+"']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        $("img[alt='"+nameBook+"']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        $("button[rel='#buy_book_data']").shouldBe(Condition.visible, Duration.ofSeconds(30));
    }
}
