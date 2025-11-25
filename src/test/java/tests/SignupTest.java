package tests;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.signup.RegisterChoicePage;
import pages.signup.SignupInfoPage;
import pages.signup.TermsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SignupTest extends BaseTest {

    private RegisterChoicePage choicePage;
    private TermsPage terms;
    private SignupInfoPage info;

    @Before
    public void initPages() {
        choicePage = new RegisterChoicePage(driver);
        terms = new TermsPage(driver);
        info = new SignupInfoPage(driver);
    }

    @Test
    public void signupFlow() {

        // 회원가입 선택 페이지
        choicePage.open();
        assertThat(choicePage.getTitle(), is("회원가입"));
        assertThat(choicePage.getSubText(), is("회원가입 수단을 선택해 주세요."));

        // 회원가입 선택 페이지 > 이메일 회원가입 버튼
        assertThat(choicePage.getEmailSignupBtn(), is("이메일로 회원가입"));
        choicePage.clickEmailSignup();


        // 약관동의 페이지
        assertThat(terms.getTitle(), is("약관동의"));
        assertThat(terms.getDesc(), is("서비스 이용약관에 동의해 주세요."));

        assertThat(terms.getCheckAll(), is("모두 동의합니다."));
        terms.clickCheckAll();

        assertThat(terms.getUnder14(), is("만 14세 미만입니다"));
        terms.clickUnder14();

        assertThat(terms.getOver14(), is("만 14세 이상입니다"));
        terms.clickOver14();


        assertThat(terms.getTerms1(), is("[필수]WebPortal 이용약관"));
        terms.clickTerms1();

        assertThat(terms.getTerms2(), is("[필수]개인정보 수집 및 이용 동의"));
        terms.clickTerms2();

        assertThat(terms.getTerms3(), is("[선택] 광고성 수신동의"));
        terms.clickTerms3();

        terms.clickUnder14();

        // 약관동의 페이지 > 만 14세 미만 확인 팝업
        assertThat(terms.getUnder14Title(), is("만 14세 미만인가요?"));
        assertThat(terms.getUnder14SubText(), is("만 14세 미만의 이용자는 본인확인 후 보호자 동의를 진행해 주세요."));
        assertThat(terms.getUnder14NoBtn(), is("아니요"));
        assertThat(terms.getUnder14YesBtn(), is("네"));
        terms.clickUnder14NoBtn();

        terms.clickOver14();


        // 정보입력 페이지
        assertThat(info.getTitle(), is("정보입력"));
        assertThat(info.getSubText(), is("계정정보를 입력해 주세요"));


        // 정보입력 페이지 > 이메일 입력
        assertThat(info.getEmailTitle(), is("이메일"));

        info.fillEmail("example");
        assertThat(info.getEmailError(), is("이메일 형식이 맞지 않습니다."));

        info.fillEmail("example@gmail.com");
        assertThat(info.getEmailConfirmBtn(), is("인증메일 발송"));


        // 정보입력 페이지 > 닉네임 입력
        assertThat(info.getNicknameTitle(), is("닉네임"));
        assertThat(info.getNicknameInput(), is("닉네임(3 ~ 12자)"));

        info.fillNickname("gg");
        assertThat(info.getNicknameError(), is("닉네임은 3 ~ 12자까지 사용 가능합니다."));

        info.fillNickname("ggg");
        assertThat(info.waitForNicknameError(), is("이미 사용 중인 닉네임입니다."));

        info.fillNickname("ggghh");


        // 정보입력 페이지 > 비밀번호 입력
        assertThat(info.getPasswordTitle(), is("비밀번호"));

        assertThat(info.getPasswordInput(), is("비밀번호(8~32자)"));
        info.fillPassword("passwor");
        assertThat(info.getPasswordError(), is("비밀번호는 8~32 자의 영문 대소문자, 숫자, 특수문자 중 2가지를 조합하여 사용할 수 있으며, 연속 및 중복으로 3자 이상 숫자, 문자를 쓸 수 없습니다."));
        info.fillPassword("password");
        assertThat(info.getPasswordError(), is("영문 대소문자, 숫자, 특수문자 중 2가지를 조합해 주십시오."));
        info.fillPassword("password777");
        assertThat(info.getPasswordError(), is("연속 및 중복으로 3자 이상 숫자, 문자를 쓸 수 없습니다."));
        info.fillPassword("password7");

        assertThat(info.getPasswordConfirmInput(), is("비밀번호 확인"));
        info.fillPasswordConfirm("ddddddddd");
        assertThat(info.getPasswordConfirmError(), is("비밀번호가 일치하지 않습니다. 다시 확인해 주세요."));
        info.fillPasswordConfirm("password7");

        assertThat(info.getPasswordTip(), is("8~32자, 영문 대소문자, 숫자, 특수문자를 조합해 주세요."));


        // 정보입력 페이지 > 보안키 입력
        assertThat(info.getSecureKeyTitle(), is("WebPortal 보안키"));

        assertThat(info.getSecureKeyInput(), is("보안 키(숫자 6자)"));
        info.fillSecureKey("111111");
        assertThat(info.getSecureKeyError(), is("WebPortal 보안 키는 3자리 이상의 연속/중복 숫자는 사용할 수 없습니다."));
        info.fillSecureKey("12345");
        assertThat(info.getSecureKeyError(), is("WebPortal 보안 키는 6자리 숫자입니다."));
        info.fillSecureKey("112233");

        assertThat(info.getSecureKeyConfirmInput(), is("보안 키 확인"));
        info.fillSecureKeyConfirm("111111");
        assertThat(info.getSecureKeyConfirmError(), is("WebPortal 보안 키가 일치하지 않습니다. 다시 확인해 주세요"));
        info.fillSecureKeyConfirm("112233");


        // 가입하기 버튼
        assertThat(info.getRegisterBtn(), is("가입하기"));
    }
}
