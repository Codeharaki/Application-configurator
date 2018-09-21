package navigatorContent;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;

//import java.io.File;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

/**
 * @since 3.2
 *
 */
public class XmlLabelProvider extends LabelProvider implements ILabelProvider {
	NameProvider provider= new NameProvider();
	public Image getImage(Object element) {
		Bundle bundle = Platform.getBundle("ru.spbstu.application.configurator.model.ui"); //$NON-NLS-1$
		String path="icons/xml.gif"; //$NON-NLS-1$
		final URL fullPathString = FileLocator.find(bundle, new Path(path), null);
		if (fullPathString !=null) {
			ImageDescriptor imageDesc = ImageDescriptor.createFromURL(fullPathString);
			Image image = imageDesc.createImage();
			return image;	
		}
		System.out.println("XML Icon not found/n"); //$NON-NLS-1$
		return null;
	}
	public String getText(Object element) {
    	return(provider.getName(element.toString()));
	}
}
