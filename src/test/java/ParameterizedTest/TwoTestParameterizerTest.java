package ParameterizedTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TwoTestParameterizerTest {

    @ValueSource(strings = {
            "Фантастика",
            "Детективы"
    })
    @ParameterizedTest()
    public void checkingBookstore(String genre) {
        open("https://www.litres.ru/");
        $x("//div[@class='LowerMenu-module__item LowerMenu-module__genres']/a[text()='Жанры']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        $x("//a[text()='" + genre + "']")
                .shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
    }
}

