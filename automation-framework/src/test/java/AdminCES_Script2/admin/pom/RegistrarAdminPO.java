package AdminCES_Script2.admin.pom;

import com.tatf.core.browser.IBrowser;

public class RegistrarAdminPO {
    private final IBrowser browser;

    private final String campoNombre = "inputFirstName";
    private final String campoApellido = "inputLastName";
    private final String campoEmail = "inputEmail";
    private final String campoContrasenia = "inputPassword";
    private final String campoRepContrasenia = "inputRepeatPassword";
    private final String campoPais = "inputCountry";
    private final String btnRegistrarse = "btnRegister";
    private final String btnPopUpConfirmar = "button.swal2-confirm";


    public RegistrarAdminPO(IBrowser browser) {
        this.browser = browser;
    }

    public boolean verificarTexto(String texto) {
        String aux = "//h5[contains(text(), '" + texto + "')]";
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

    public void ingresarPassword(String contrasenia) {
        this.browser.find().name(this.campoContrasenia).write(contrasenia);
    }

    public void ingresarRepeatPassword(String repContrasenia) {
        this.browser.find().name(this.campoRepContrasenia).write(repContrasenia);
    }

    public void ingresarPais(String pais) {
        this.browser.find().name(this.campoPais).write(pais);
    }

    public void clickRegistrar() {
        this.browser.find().id(this.btnRegistrarse).click();

    }

    public void confirmarAlerta() {
        this.browser.find().css(this.btnPopUpConfirmar).click();
    }
}
