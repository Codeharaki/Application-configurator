# Application-configurator
## Introduction 
This project is an RCP application for editing and creating "Declarative Configuration" for InfoProject.
## Getting started
- This project uses Java 1.8
- To run the application, you need  IDE eclipse  and the xtext plug-in  installed in it (you can see more here http://www.eclipse.org/Xtext/download.html)
+ You must copy the project to your computer and open it using prepared eclipse.
  + First you must generate the language structure yourself. This can be done through **Run as -> Generate Language Infrastructure**
  + After the end of generation  the application can be started as a usual eclipse application
## Required plug-in
This project requires snakeyaml plug-in. You can download it here: http://www.java2s.com/Code/Jar/s/Downloadsnakeyaml18sourcesjar.htm. To install it you should right-click on the ru.spbstu.application.configurator.model project.  **Build Path -> Confugure Build Path -> Libraries -> Add External JARs**. Choose snakeyaml jar.
Go to Order and Export and put check mark next to snakeyaml jar. Apply and Close. You must also add the jar to the classpath, click on plugin.xml and go to Runtime.