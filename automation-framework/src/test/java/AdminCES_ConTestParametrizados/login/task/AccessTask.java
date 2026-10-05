package AdminCES_ConTestParametrizados.login.task;

import AdminCES_ConTestParametrizados.login.pom.AccessPO;
import com.tatf.core.browser.IBrowser;

public class AccessTask {
    private final AccessPO accessPO;

    public AccessTask(IBrowser browser) {
        this.accessPO= new AccessPO(browser);
    }

    public void acceder(String clave) {
        this.accessPO.ingresarClave(clave);
        this.accessPO.clickIngresar();
    }
}
