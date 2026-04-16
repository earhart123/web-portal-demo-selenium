package pages.account.info;

import org.openqa.selenium.WebDriver;

/**
 * 데모 사이트에서는 회원탈퇴가 account-info.html 내 모달로 처리됩니다.
 * WithdrawAgreePage를 통해 모달 상호작용을 수행합니다.
 */
public class WithdrawRequestPage {

    private WebDriver driver;

    public WithdrawRequestPage(WebDriver driver) {
        this.driver = driver;
    }
}
