package ru.spbstu.application.configurator.model.ui.wizard;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator;
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@ProjectTemplate(label = "InfoProject Template", icon = "InfoProject_icon.png", description = "<p><b>InfoProject Template</b></p>\r\n<p>It\'s template for InfoProject which create folders and configuration files</p>")
@SuppressWarnings("all")
public final class InfoProject extends AbstractProjectTemplate {
  @Override
  public void generateProjects(final IProjectGenerator generator) {
    PluginProjectFactory _pluginProjectFactory = new PluginProjectFactory();
    final Procedure1<PluginProjectFactory> _function = (PluginProjectFactory it) -> {
      it.setProjectName(this.getProjectInfo().getProjectName());
      it.setLocation(this.getProjectInfo().getLocationPath());
      List<String> _projectNatures = it.getProjectNatures();
      _projectNatures.add(XtextProjectHelper.NATURE_ID);
      List<String> _builderIds = it.getBuilderIds();
      _builderIds.add(XtextProjectHelper.BUILDER_ID);
      List<String> _folders = it.getFolders();
      _folders.add("config");
      List<String> _folders_1 = it.getFolders();
      _folders_1.add("data");
      List<String> _folders_2 = it.getFolders();
      _folders_2.add("config//custom-presentations");
      List<String> _folders_3 = it.getFolders();
      _folders_3.add("config//data-model-config");
      List<String> _folders_4 = it.getFolders();
      _folders_4.add("config//exports");
      List<String> _folders_5 = it.getFolders();
      _folders_5.add("config//searches");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("config//configuration.yml");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("# This is an example model of yml configuration");
      _builder_1.newLine();
      this.addFile(it, _builder, _builder_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("config//configuration.properties");
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("/*");
      _builder_3.newLine();
      _builder_3.append(" ");
      _builder_3.append("* This is an example model of properties configuration");
      _builder_3.newLine();
      _builder_3.append(" ");
      _builder_3.append("*/");
      _builder_3.newLine();
      _builder_3.newLine();
      this.addFile(it, _builder_2, _builder_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("data//.readme");
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("There are files with zip files.");
      _builder_5.newLine();
      _builder_5.append("Every single zip must contains:");
      _builder_5.newLine();
      _builder_5.append(" ");
      _builder_5.append("- no folders inside");
      _builder_5.newLine();
      _builder_5.append(" ");
      _builder_5.append("- eas_sip.xml file");
      _builder_5.newLine();
      _builder_5.append(" ");
      _builder_5.append("- eas_pdi.xml file");
      _builder_5.newLine();
      _builder_5.append(" ");
      _builder_5.append("- any amount of any ther files");
      _builder_5.newLine();
      this.addFile(it, _builder_4, _builder_5);
    };
    PluginProjectFactory _doubleArrow = ObjectExtensions.<PluginProjectFactory>operator_doubleArrow(_pluginProjectFactory, _function);
    generator.generate(_doubleArrow);
  }
}
