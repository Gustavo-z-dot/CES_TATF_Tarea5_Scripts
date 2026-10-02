package AdminCES_Script2.tester.pom;

import com.tatf.core.browser.IBrowser;

public class RegistrarTesterPO {
    private final IBrowser browser;

    private final String campoNombre = "inputFirstName";
    private final String campoApellido = "inputLastName";
    private final String campoEmail = "inputEmail";
    private final String campoPais = "inputCountry";
    private final String campoContrasenia = "inputPassword";
    private final String catTester = "testerJunior";
    private final String btnRegistrarse = "btnRegister";
    private final String btnPopUpConfirmar = "button.swal2-confirm";

    public RegistrarTesterPO(IBrowser browser) {
        this.browser = browser;
    }

    public boolean tituloVisible(String titulo) {
        String aux = "//h5[contains(text(), '" + titulo + "')]";
        return this.browser.find().xpath(aux).isDisplayed();
    }

    public void ingresarNombre(String nombre) {
        this.browser.find().name(this.campoNombre).write(nombre);
    }

    public void ingresarApellido(String apellido) {
        this.browser.find().name(this.campoApellido).write(apellido);
    }

    public void ingresarEmail(String email) {
        this.browser.find().name(this.campoEmail).write(email);
    }

    public void ingresarPais(String pais) {
        this.browser.find().name(this.campoPais).write(pais);
    }

    public void ingresarContrasenia(String contrasenia) {
        this.browser.find().name(this.campoContrasenia).write(contrasenia);
    }

    public void seleccionarTipoTester() {
        this.browser.find().id(this.catTester).click();
    }

    public void clickRegistrar() {
        this.browser.find().id(this.btnRegistrarse).click();
    }

    public void confirmarAlerta() {
        this.browser.find().css(this.btnPopUpConfirmar).click();
    }
}
