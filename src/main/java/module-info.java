import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.jquery.JQueryInclusionModule;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;

module com.jwebmp.plugins.jquery {

    requires transitive com.jwebmp.core.base.angular.client;
    requires com.jwebmp.client;

    provides IPageConfigurator with JQueryPageConfigurator;
    provides IGuiceScanModuleInclusions with JQueryInclusionModule;

    opens com.jwebmp.plugins.jquery to com.google.guice, com.jwebmp.core.angular;

}
