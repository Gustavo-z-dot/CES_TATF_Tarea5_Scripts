package AdminCES_ConTestParametrizados.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Suite de humo")
@SelectPackages("AdminCES_ConTestParametrizados.suites.pruebas")
@IncludeTags("humo")
public class SuiteHumo {

}