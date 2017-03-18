package pages;

import utils.Reporter;
import wrappers.OpentapsWrappers;

public class LogoutPage  extends OpentapsWrappers {
	
	 public LogoutPage() {
		 if(!verifyTitle("opentaps CRM")){
				Reporter.reportStep("This is NOT login page", "FAIL");
			}
	}

}

