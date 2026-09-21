package AdminCES;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearCuentaTesterTest {

    private IBrowser browser;
    private IVerify verify;

    @BeforeEach
    public void setUp() {
        browser = BrowserFactory.getBrowser(false);
        verify = IVerify.create();
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().id("pass").write("3)ea60e0be3ba12c6ecd%7297868%5c4");
        browser.find().xpath("//button[contains(text(), 'Ingresar')]").click();

        browser.wait("a.menu-effect-ces[href*='login']");
        browser.find().css("a.menu-effect-ces[href*='login']").click();

        browser.find().name("inputEmail").write("yaniscorrea@gmail.com");
        browser.find().name("inputPassword").write("12345");
        browser.find().xpath("//button[contains(normalize-space(), 'Iniciar Sesión')]").click();

        browser.wait("button.swal2-confirm");
        browser.find().css("button.swal2-confirm").click();

        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");

    }

    @Test
    public void testCrearUsuarioTester() {
        String nombre = "Gustavo";
        String apellido = "Da Rosa";
        String correo = "Gustavo@gmail.com";
        String contrasenia = "123";
        String paisNacimiento = "Uruguay";

        verify.verifyTrue(
                browser.find().css("a.btn.btn-orange-ces.dropdown-toggle").isDisplayed(),
                "No se encuentra el usuario logeuado");

        browser.find().css("a[href*='create-user']").click();
        verify.verifyTrue(browser.find().xpath("//h5[contains(text(), 'Alta de cuenta para Tester')]").isDisplayed(),
                "No se encuentra en el formulario de registro");

        browser.find().name("inputFirstName").write(nombre);
        browser.find().name("inputLastName").write(apellido);
        browser.find().name("inputEmail").write(correo);
        browser.find().name("inputCountry").write(paisNacimiento);
        browser.find().name("inputPassword").write(contrasenia);
        browser.find().id("testerJunior").click();
        browser.find().id("btnRegister").click();

        browser.wait("button.swal2-confirm");
        browser.find().css("button.swal2-confirm").click();
        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");

        browser.wait("a.menu-effect-ces[href*='view-users'']");
        browser.find().css("a.menu-effect-ces[href*='view-users']").click();

        verify.verifyTrue(browser.find().id(correo).isDisplayed(),
                "El usuario con correo " + correo + " no se encuentra en la tabla");
    }

    @AfterEach
    public void tearDown() {
        BrowserFactory.quitBrowser();
    }
}
