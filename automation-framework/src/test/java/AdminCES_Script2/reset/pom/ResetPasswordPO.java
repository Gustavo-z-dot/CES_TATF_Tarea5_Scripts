package AdminCES_Script2.reset.pom;

import com.tatf.core.browser.IBrowser;

public class ResetPasswordPO {
    private final IBrowser browser;

    private final String campoCorreo = "inputEmail";
    private final String campoContrasenia = "inputPassword";
    private final String campoRepContrasenia = "inputRepeatPassword";
    private final String btnReiniciarContraseniaa = "btnReset";
    private final String btnConfirmarAlerta = "button.swal2-confirm";

    public ResetPasswordPO(IBrowser browser) {
        this.browser = browser; }

    public boolean verificarTexto(String titulo) {
        String aux = "//h5[contains(text(), '" + titulo + "')]";
        return this.browser.find().xpath(aux).isDisplayed();
    }

    public void ingresarEmail(String email) {
        this.browser.find().name(this.campoCorreo).write(email);
    }

    public void ingresarContraenia(String contrasenia) {
        this.browser.find().name(this.campoContrasenia).write(contrasenia);
    }

    public void confirmarContrasenia(String repContrasenia) {
        this.browser.find().name(this.campoRepContrasenia).write(repContrasenia);
    }

    public void clickReiniciarContrasenia() {
        this.browser.find().id(this.btnReiniciarContraseniaa).click(); }

    public void confirmarAlerta() {
        this.browser.wait(this.btnConfirmarAlerta);
        this.browser.find().css(this.btnConfirmarAlerta).click();
    }

}
