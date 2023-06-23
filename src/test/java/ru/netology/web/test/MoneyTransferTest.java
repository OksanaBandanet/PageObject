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
    public void setup() {
        open("http://localhost:9999");
        var LoginPage = new LoginPage();
        var autoInfo = DataHelper.getAuthInfo();
        var verificationPage = LoginPage.validLogin(autoInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(autoInfo);
        dashboardPage = verificationPage.validVerify(verificationCode);

        int oneCardBalance = dashboardPage.getCardBalance(0);
        int twoCardBalance = dashboardPage.getCardBalance(1);
//        if (oneCardBalance < 10000) {
//            dashboardPage.selectCardToTransfer(0).amountCard(Integer.toString(10000 - oneCardBalance), DataHelper.getOneCardNumber());
//        } else if (oneCardBalance > 10000) {
//            dashboardPage.selectCardToTransfer(1).amountCard(Integer.toString(10000 - twoCardBalance), DataHelper.getTwoCardNumber());
//        }
    }

    @Test
    void transferFromCardToCard0() {
        var firstCardNumber = getOneCardNumber();
        var twoCardNumber = getTwoCardNumber();
        var oneCardBalance = dashboardPage.getCardBalance(0);
        var twoCardBalance = dashboardPage.getCardBalance(1);
        var amount = 0;
        var expectedBalanceOneCard = oneCardBalance - amount;
        var expectedBalanceTwoCard = twoCardBalance + amount;
        var transferPages = dashboardPage.selectCardToTransfer(twoCardNumber);
        dashboardPage = transferPages.setRefill(0,getOneCardNumber());
        var actualBalanceOneCard = dashboardPage.getCardBalance(0);
        var actualBalanceTwoCard = dashboardPage.getCardBalance(1);
        assertEquals(expectedBalanceOneCard, actualBalanceOneCard);
        assertEquals(expectedBalanceTwoCard ,actualBalanceTwoCard);
    }
    @Test
    void transferFromCardToCard1000() {
        var firstCardNumber = getOneCardNumber();
        var twoCardNumber = getTwoCardNumber();
        var oneCardBalance = dashboardPage.getCardBalance(0);
        var twoCardBalance = dashboardPage.getCardBalance(1);
        var amount = 1000;
        var expectedBalanceOneCard = oneCardBalance - amount;
        var expectedBalanceTwoCard = twoCardBalance + amount;
        var transferPages = dashboardPage.selectCardToTransfer(twoCardNumber);
        dashboardPage = transferPages.setRefill(1000,getOneCardNumber());
        var actualBalanceOneCard = dashboardPage.getCardBalance(0);
        var actualBalanceTwoCard = dashboardPage.getCardBalance(1);
        assertEquals(expectedBalanceOneCard, actualBalanceOneCard);
        assertEquals(expectedBalanceTwoCard ,actualBalanceTwoCard);
    }
    @Test
    void transferFromCardToCard10000() {
        var firstCardNumber = getOneCardNumber();
        var twoCardNumber = getTwoCardNumber();
        var oneCardBalance = dashboardPage.getCardBalance(0);
        var twoCardBalance = dashboardPage.getCardBalance(1);
        var amount = 10000;
        var expectedBalanceOneCard = oneCardBalance - amount;
        var expectedBalanceTwoCard = twoCardBalance + amount;
        var transferPages = dashboardPage.selectCardToTransfer(twoCardNumber);
        dashboardPage = transferPages.setRefill(10000,getOneCardNumber());
        var actualBalanceOneCard = dashboardPage.getCardBalance(0);
        var actualBalanceTwoCard = dashboardPage.getCardBalance(1);
        assertEquals(expectedBalanceOneCard, actualBalanceOneCard);
        assertEquals(expectedBalanceTwoCard ,actualBalanceTwoCard);
    }
    @Test
    void transferFromCardToCard999() {
        var firstCardNumber = getOneCardNumber();
        var twoCardNumber = getTwoCardNumber();
        var oneCardBalance = dashboardPage.getCardBalance(0);
        var twoCardBalance = dashboardPage.getCardBalance(1);
        var amount = 999;
        var expectedBalanceOneCard = oneCardBalance - amount;
        var expectedBalanceTwoCard = twoCardBalance + amount;
        var transferPages = dashboardPage.selectCardToTransfer(twoCardNumber);
        dashboardPage = transferPages.setRefill(999,getOneCardNumber());
        var actualBalanceOneCard = dashboardPage.getCardBalance(0);
        var actualBalanceTwoCard = dashboardPage.getCardBalance(1);
        assertEquals(expectedBalanceOneCard, actualBalanceOneCard);
        assertEquals(expectedBalanceTwoCard ,actualBalanceTwoCard);
    }
    @Test
    void transferFromCardToCard10001() {
        var firstCardNumber = getOneCardNumber();
        var twoCardNumber = getTwoCardNumber();
        var oneCardBalance = dashboardPage.getCardBalance(0);
        var twoCardBalance = dashboardPage.getCardBalance(1);
        var amount = 10001;
        var expectedBalanceOneCard = oneCardBalance - amount;
        var expectedBalanceTwoCard = twoCardBalance + amount;
        var transferPages = dashboardPage.selectCardToTransfer(twoCardNumber);
        dashboardPage = transferPages.setRefill(10001,getOneCardNumber());
        var actualBalanceOneCard = dashboardPage.getCardBalance(0);
        var actualBalanceTwoCard = dashboardPage.getCardBalance(1);
        assertEquals(expectedBalanceOneCard, actualBalanceOneCard);
        assertEquals(expectedBalanceTwoCard ,actualBalanceTwoCard);
    }
    @Test
    void transferFromCardToCard2000() {
        var firstCardNumber = getOneCardNumber();
        var twoCardNumber = getTwoCardNumber();
        var oneCardBalance = dashboardPage.getCardBalance(0);
        var twoCardBalance = dashboardPage.getCardBalance(1);
        var amount = 20000;
        var expectedBalanceOneCard = oneCardBalance - amount;
        var expectedBalanceTwoCard = twoCardBalance + amount;
        var transferPages = dashboardPage.selectCardToTransfer(twoCardNumber);
        dashboardPage = transferPages.setRefill(20000,getOneCardNumber());
        var actualBalanceOneCard = dashboardPage.getCardBalance(0);
        var actualBalanceTwoCard = dashboardPage.getCardBalance(1);
        assertEquals(expectedBalanceOneCard, actualBalanceOneCard);
        assertEquals(expectedBalanceTwoCard ,actualBalanceTwoCard);
    }
}
