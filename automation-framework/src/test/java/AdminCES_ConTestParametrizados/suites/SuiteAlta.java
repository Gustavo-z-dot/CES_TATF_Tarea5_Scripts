package AdminCES_ConTestParametrizados.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;



@Suite
@SuiteDisplayName("Suite de Altas de Usuario")
@SelectPackages("AdminCES_ConTestParametrizados.suites.pruebas")
@IncludeTags("alta-usuario")
public class SuiteAlta {

}