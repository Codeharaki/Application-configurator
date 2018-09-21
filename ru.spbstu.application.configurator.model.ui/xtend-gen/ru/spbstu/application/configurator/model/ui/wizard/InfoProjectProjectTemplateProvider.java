package ru.spbstu.application.configurator.model.ui.wizard;

import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider;
import ru.spbstu.application.configurator.model.ui.wizard.InfoProject;

@SuppressWarnings("all")
public class InfoProjectProjectTemplateProvider implements IProjectTemplateProvider {
  @Override
  public AbstractProjectTemplate[] getProjectTemplates() {
    InfoProject _infoProject = new InfoProject();
    return new AbstractProjectTemplate[] { _infoProject };
  }
}
