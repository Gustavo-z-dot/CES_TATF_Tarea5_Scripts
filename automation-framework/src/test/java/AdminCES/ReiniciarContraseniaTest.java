package AdminCES;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReiniciarContraseniaTest {

    private IBrowser browser;
    private IVerify verify;

    @BeforeEach
    public void setUp() {
        browser = BrowserFactory.getBrowser(false);
        verify = IVerify.create();
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().id("pass").write("3)ea60e0be3ba12c6ecd%7297868%5c4");
        browser.find().xpath("//button[contains(text(), 'Ingresar')]").click();
    }

    @Test
    public void testReiniciarContrasenia() {
        String correo = "leonardoperez@gmail.com";
        String Contrasenia = "12345";



        verify.verifyTrue(
                browser.find().css("a.btn.btn-secondary.dropdown-toggle").isDisplayed(),
                "Se esperaba no tener una sesión iniciada");

        browser.find().css("a[href*='forgot-password']").click();

        verify.verifyTrue(browser.find()
                .xpath("//h5[contains(text(), 'Reiniciar contraseña')]")
                .isDisplayed(), "No se encuentra en el formulario de reinicio de contraseña");

        browser.find().name("inputEmail").write(correo);
        browser.find().name("inputPassword").write(Contrasenia);
        browser.find().name("inputRepeatPassword").write(Contrasenia);

        browser.find().id("btnReset").click();

        browser.wait("button.swal2-confirm");
        browser.find().css("button.swal2-confirm").click();

        verify.verifyTrue(browser.find()
                .css("a.btn.btn-secondary.dropdown-toggle")
                .isDisplayed(), "No redirigio a la pantalla principal");

        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.wait("a.menu-effect-ces[href*='login']");
        browser.find().css("a.menu-effect-ces[href*='login']").click();
    }

    @AfterEach
    public void tearDown() {
        BrowserFactory.quitBrowser();
    }
}
