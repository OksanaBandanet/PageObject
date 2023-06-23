package ru.netology.web.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.DashboardPage;
import ru.netology.web.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.web.data.DataHelper.*;

class MoneyTransferTest {
    DashboardPage dashboardPage;

    @BeforeEach
    public void Authentication() {
        open("http://localhost:9999");
        var LoginPage = new LoginPage();
        var autoInfo = DataHelper.getAuthInfo();
        var verificationPage = LoginPage.validLogin(autoInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(autoInfo);
        dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @Test
    void transferFromCardToCard() {

    }
}