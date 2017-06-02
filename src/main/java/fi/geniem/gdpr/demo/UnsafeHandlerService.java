package fi.geniem.gdpr.demo;

public class UnsafeHandlerService {

	public void thisShouldWarn(Object ob){
		ob.toString();
	}
}
