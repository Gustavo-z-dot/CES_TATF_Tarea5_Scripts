package AdminCES_ConTestParametrizados.login.pom;

import com.tatf.core.browser.IBrowser;

public class AccessPO {
    private final IBrowser browser;
    private final String campoHash = "pass";
    private final String btnIngresar = "//button[contains(text(), 'Ingresar')]";

    public AccessPO(IBrowser browser) {
        this.browser = browser;
    }

    public void ingresarClave(String clave) {
        this.browser.find().id(this.campoHash).write(clave);
    }

    public void clickIngresar() {
        this.browser.find().xpath(this.btnIngresar).click();
    }

}
