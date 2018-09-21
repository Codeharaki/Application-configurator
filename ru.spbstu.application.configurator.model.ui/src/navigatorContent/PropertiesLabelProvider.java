/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package navigatorContent;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
//import org.eclipse.ui.ISharedImages;
//import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

/**
 * Provides a label and icon for objects of type {@link PropertiesTreeData}.
 * 
 * @since 3.2
 *
 */
public class PropertiesLabelProvider extends LabelProvider implements ILabelProvider {
	NameProvider provider= new NameProvider();
	public Image getImage(Object element) {
		Bundle bundle = Platform.getBundle("ru.spbstu.application.configurator.model.ui"); //$NON-NLS-1$
		String path="icons/properties.gif"; //$NON-NLS-1$
		final URL fullPathString = FileLocator.find(bundle, new Path(path), null);
		if (fullPathString !=null) {
			ImageDescriptor imageDesc = ImageDescriptor.createFromURL(fullPathString);
			Image image = imageDesc.createImage();
			return image;	
		}
		System.out.println("properties Icon not found/n"); //$NON-NLS-1$
		return null;
	}
	public String getText(Object element) {
    	return(provider.getName(element.toString()));
	}
}
