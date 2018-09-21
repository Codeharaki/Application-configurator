package ru.spbstu.application.configurator.model.ui.wizard

import org.eclipse.core.runtime.Status
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.ui.XtextProjectHelper
import org.eclipse.xtext.ui.util.PluginProjectFactory
import org.eclipse.xtext.ui.wizard.template.IProjectGenerator
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider
import org.eclipse.xtext.ui.wizard.template.ProjectTemplate
import static org.eclipse.core.runtime.IStatus.*

class InfoProjectProjectTemplateProvider implements IProjectTemplateProvider {
	override getProjectTemplates() {
		#[new InfoProject]
	}
}

@ProjectTemplate(label="InfoProject Template", icon="InfoProject_icon.png", description="<p><b>InfoProject Template</b></p>
<p>It's template for InfoProject which create folders and configuration files</p>")
final class InfoProject {
	override generateProjects(IProjectGenerator generator) {
		generator.generate(new PluginProjectFactory => [
			projectName = projectInfo.projectName
			location = projectInfo.locationPath
			projectNatures += XtextProjectHelper.NATURE_ID
			builderIds += XtextProjectHelper.BUILDER_ID
			folders += "config"
			folders +="data"
			folders +="config//custom-presentations"
			folders +="config//data-model-config"
            folders +="config//exports"
            folders +="config//searches"
			addFile('''config//configuration.yml''', '''
				 # This is an example model of yml configuration
			''')
			addFile('''config//configuration.properties''', '''
				/*
				 * This is an example model of properties configuration
				 */
				
			''')
			addFile('''data//.readme''', '''
				There are files with zip files.
				Every single zip must contains:
				 - no folders inside
				 - eas_sip.xml file
				 - eas_pdi.xml file
				 - any amount of any ther files
			''')
		])
	}
}
