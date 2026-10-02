package AdminCES_Script2.home.pom;

import com.tatf.core.browser.IBrowser;

public class HomePO {
    private final IBrowser browser;
    private final String btnUsuarioLogueado = "a.btn.btn-orange-ces.dropdown-toggle";
    private final String btnUsuarioSinSesion = "a.btn.btn-secondary.dropdown-toggle";
    private final String btnLogin = "a.menu-effect-ces[href*='login']";
    private final String btnCrearAdmin = "a[href*='register']";
    private final String btnCrearTester = "a[href*='create-user']";
    private final String btnVerUsuarios = "a.menu-effect-ces[href*='view-users']";
    private final String btnOlvideContrasenia = "a[href*='forgot-password']";

    public HomePO(IBrowser browser) {
        this.browser=browser;
    }

    public boolean usuarioNoLogueado() {
        return this.browser.find().css(this.btnUsuarioSinSesion).isDisplayed();
    }

    public boolean usuarioLogueado() {
        return this.browser.find().css(this.btnUsuarioLogueado).isDisplayed();
    }

    public void clickIrALogin() {
        this.browser.find().css(this.btnLogin).click();
    }

    public void clickIrACrearAdmin() {
        this.browser.find().css(this.btnCrearAdmin).click();
    }

    public void clickIrACrearTester() {
        this.browser.find().css(this.btnCrearTester).click();
    }

    public void clickIrAVerUsuarios() {
        this.browser.wait(this.btnVerUsuarios);
        this.browser.find().css(this.btnVerUsuarios).click();
    }

    public void clickIrAReiniciarContrasenia() {
        this.browser.find().css(this.btnOlvideContrasenia).click();
    }

}
