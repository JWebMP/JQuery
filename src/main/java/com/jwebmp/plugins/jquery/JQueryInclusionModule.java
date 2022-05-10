package com.jwebmp.plugins.jquery;

import com.guicedee.guicedinjection.interfaces.*;
import jakarta.validation.constraints.*;

import java.util.*;

public class JQueryInclusionModule implements IGuiceScanModuleInclusions<JQueryInclusionModule>
{
	@Override
	public @NotNull Set<String> includeModules()
	{
		Set<String> set = new HashSet<>();
		set.add("com.jwebmp.plugins.jquery");
		return set;
	}
}

