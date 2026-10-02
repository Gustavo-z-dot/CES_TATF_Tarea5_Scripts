package AdminCES_Script2.login.pom;

import com.tatf.core.browser.IBrowser;

public class LoginPO {
    private final IBrowser browser;
    private final String campoEmail = "inputEmail";
    private final String campoContrasenia = "inputPassword";
    private final String btnIngresar = "#formLogin button.rounded-end-pill";


    public LoginPO(IBrowser browser) {
        this.browser = browser;
    }

    public boolean tituloVisible(String titulo) {
        String var = "//h5[contains(text(), '" + titulo + "')]";
        return this.browser.find().xpath(var).isDisplayed();
    }

    public void ingresarEmail(String email) {
        this.browser.find().name(this.campoEmail).write(email);
    }

    public void ingresarContrasenia(String contrasenia) {
        this.browser.find().name(this.campoContrasenia).write(contrasenia);
    }

    public void clickIngresar() {
        this.browser.find().css(this.btnIngresar).click();
    }
}