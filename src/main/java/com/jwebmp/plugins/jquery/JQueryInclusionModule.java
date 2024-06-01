package com.jwebmp.plugins.jquery;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;

import java.util.HashSet;
import java.util.Set;

public class JQueryInclusionModule implements IGuiceScanModuleInclusions<JQueryInclusionModule>
{
    @Override
    public Set<String> includeModules()
    {
        Set<String> set = new HashSet<>();
        set.add("com.jwebmp.plugins.jquery");
        return set;
    }
}

