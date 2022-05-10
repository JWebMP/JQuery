import com.guicedee.guicedinjection.interfaces.*;
import com.jwebmp.core.services.*;
import com.jwebmp.plugins.jquery.*;

module com.jwebmp.plugins.jquery {
	
	requires transitive com.jwebmp.core.angular;
	
	provides IPageConfigurator with JQueryPageConfigurator;
	provides IGuiceScanModuleInclusions with JQueryInclusionModule;
	
	opens com.jwebmp.plugins.jquery to com.google.guice,com.jwebmp.core.angular;
	
}
