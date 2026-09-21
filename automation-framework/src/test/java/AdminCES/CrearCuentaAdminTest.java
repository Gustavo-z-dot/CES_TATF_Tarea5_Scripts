package AdminCES;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearCuentaAdminTest {
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
    public void testCrearCuentaAdmin() {
        String nombre = "Gustavo";
        String apellido = "Da Rosa";
        String correo = "Gustavo@gmail.com";
        String contrasenia = "1234";
        String paisNacimiento = "Uruguay";

        verify.verifyTrue(browser.find().css("a.btn.btn-secondary.dropdown-toggle")
                .isDisplayed(), "Se esperaba no tener una sesión iniciada");

        browser.find().css("a[href*='register']").click();

        verify.verifyTrue(browser.find()
                        .xpath("//h5[contains(text(), 'Crear cuenta Administrador')]")
                        .isDisplayed(), "No se encuentra en el formulario de registro");
        browser.find().name("inputFirstName").write(nombre);
        browser.find().name("inputLastName").write(apellido);
        browser.find().name("inputEmail").write(correo);
        browser.find().name("inputPassword").write(contrasenia);
        browser.find().name("inputRepeatPassword").write(contrasenia);
        browser.find().name("inputCountry").write(paisNacimiento);
        browser.find().id("btnRegister").click();

        browser.wait("button.swal2-confirm");
        browser.find().css("button.swal2-confirm").click();

        verify.verifyTrue(browser.find()
                .css("a.btn.btn-secondary.dropdown-toggle")
                .isDisplayed(), "No redirigio a la pantalla principal");

        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.wait("a.menu-effect-ces[href*='login']");
        browser.find().css("a.menu-effect-ces[href*='login']").click();

        verify.verifyTrue(browser
                        .find().xpath("//h5[contains(text(), 'Iniciar sesión Administrador')]")
                        .isDisplayed(), "No se encuentra en el formulario de inicio de sesión");
        browser.find().name("inputEmail").write(correo);
        browser.find().name("inputPassword").write(contrasenia);
        browser.find().css("#formLogin button.rounded-end-pill").click();

        browser.wait("button.swal2-confirm");
        browser.find().css("button.swal2-confirm").click();
        IVerify.create().verifyTrue(browser.find()
                .css("a.btn.btn-orange-ces.dropdown-toggle")
                .isDisplayed(), "No hay usuario logueado");
    }

    @AfterEach
    public void tearDown() {
        BrowserFactory.quitBrowser();
    }
}