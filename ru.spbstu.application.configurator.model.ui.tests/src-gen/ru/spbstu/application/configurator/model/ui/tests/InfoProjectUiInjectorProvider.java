/*
 * generated by Xtext 2.14.0
 */
package ru.spbstu.application.configurator.model.ui.tests;

import com.google.inject.Injector;
import org.eclipse.xtext.testing.IInjectorProvider;
import ru.spbstu.application.configurator.model.ui.internal.ModelActivator;

public class InfoProjectUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return ModelActivator.getInstance().getInjector("ru.spbstu.application.configurator.model.InfoProject");
	}

}
