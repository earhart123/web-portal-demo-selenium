package tests;

import base.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.signup.SignupInfoPage;
import pages.signup.TermsPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SignupTest extends BaseTest {

    private TermsPage terms;
    private SignupInfoPage info;

    @Before
    public void initPages() {
        terms = new TermsPage(driver);
        info = new SignupInfoPage(driver);
    }

    @Test
    public void signupFlow() {

        // 약관동의 페이지 (Step 1)
        terms.open();
        assertThat(terms.getTitle(), is("약관 동의"));

        // 전체 동의 버튼 확인
        assertThat(terms.getCheckAll(), is("전체 동의"));

        // 약관 항목 텍스트 확인
        assertThat(terms.getTerms1(), is("서비스 이용약관 동의"));
        assertThat(terms.getTerms2(), is("개인정보 수집 및 이용 동의"));
        assertThat(terms.getTerms3(), is("만 14세 이상 확인"));
        assertThat(terms.getTerms4(), is("마케팅 정보 수신 동의"));

        // 다음 버튼 확인
        assertThat(terms.getNextBtn(), is("다음"));

        // 전체 동의 후 다음으로 이동
        terms.clickCheckAll();
        terms.clickNextBtn();


        // 정보입력 페이지 (Step 2)
        assertThat(info.getTitle(), is("정보 입력"));

        // 비밀번호 유효성 검사 (input 이벤트)
        info.fillPassword("short");
        assertThat(info.getPasswordValidation(), is("8자 이상, 영문+숫자+특수문자를 포함해야 합니다."));

        info.fillPassword("Password1!");
        assertThat(info.getPasswordValidation(), is("사용 가능한 비밀번호입니다."));

        // 보안키 유효성 검사 (input 이벤트)
        info.fillSecurityKey("12345");
        assertThat(info.getSecurityKeyValidation(), is("6자 이상 입력해주세요."));

        info.fillSecurityKey("123456");
        assertThat(info.getSecurityKeyValidation(), is("사용 가능한 보안키입니다."));

        // 이메일 유효성 검사 (submit 클릭 시)
        info.fillEmail("invalid-email");
        info.fillPasswordConfirm("Password1!");
        info.clickRegisterBtn();
        assertThat(info.getEmailValidation(), is("올바른 이메일을 입력해주세요."));

        // 이메일 수정
        info.fillEmail("test@example.com");

        // 비밀번호 확인 불일치 검사 (submit 클릭 시)
        info.fillPasswordConfirm("wrongpassword");
        info.clickRegisterBtn();
        assertThat(info.getPasswordConfirmValidation(), is("비밀번호가 일치하지 않습니다."));

        // 비밀번호 확인 일치
        info.fillPasswordConfirm("Password1!");

        // 가입하기 버튼 텍스트 확인 후 제출
        assertThat(info.getRegisterBtn(), is("가입하기"));
        info.clickRegisterBtn();


        // 가입 완료 페이지 (Step 3)
        assertThat(info.getCompleteTitle(), is("가입 완료"));
    }
}
