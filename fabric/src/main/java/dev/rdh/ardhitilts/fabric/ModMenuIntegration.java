package dev.rdh.ardhitilts.fabric;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;

public class ModMenuIntegration implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return ArdhitiltsConfig::createConfigScreen;
	}
}
