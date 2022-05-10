/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.jquery;

import com.jwebmp.core.*;
import com.jwebmp.core.base.angular.services.annotations.*;
import com.jwebmp.core.base.angular.services.annotations.angularconfig.*;
import com.jwebmp.core.plugins.*;
import com.jwebmp.core.services.*;
import jakarta.validation.constraints.*;

/**
 * The 3 meta tags *must* come first in the head; any other head content must come *after* these tags
 * <p>
 * HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries WARNING: Respond.js doesn't work if you view the page via
 * file://
 */
@PluginInformation(pluginName = "JQuery Plugin",
        pluginDescription = "Adds JQuery to the Angular TS Build",
        pluginUniqueName = "jwebmp-jquery",
        pluginVersion = "3.4.0",
        pluginCategories = "jquery",
        pluginSubtitle = "JQuery is a widely used library for web components.",
        pluginSourceUrl = "https://github.com/GedMarc/JWebMP-JQuery",
        pluginWikiUrl = "https://github.com/GedMarc/JWebMP-JQuery/wiki",
        pluginGitUrl = "https://github.com/GedMarc/JWebMP-JQuery",
        pluginIconUrl = "bower_components/componenttemplate/componenttemplateicon.jpg",
        pluginIconImageUrl = "bower_components/componenttemplate/componenttemplatelogo.jpg",
        pluginOriginalHomepage = "https://jquery.com",
        pluginDownloadUrl = "https://jwebmp.com/?p=ComponentTemplate")

@TsDependency(value = "jquery",version = "^3.6.0")
@TsDevDependency(value = "@types/jquery",version = "*")
@NgScript(value = "node_modules/jquery/dist/jquery.js",sortOrder = 1)

public class JQueryPageConfigurator
        implements IPageConfigurator<JQueryPageConfigurator> {
    public JQueryPageConfigurator() {
        //Nothing Needed
    }

    @NotNull
    @Override
    public Page<?> configure(Page<?> page) {
        return page;
    }

    @Override
    public boolean enabled() {
        return true;
    }

}
