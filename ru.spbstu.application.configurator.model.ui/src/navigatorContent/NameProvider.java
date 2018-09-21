package navigatorContent;
/*******************************************************************************
 * Copyright (c) 2018 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/

/**
 * @since 3.2
 *
 */
public class NameProvider {
	public String getName (String text) {
	char arrayOfText[] = text.toCharArray();
	String name=""; //$NON-NLS-1$
	for (char c : arrayOfText) {
		if ((c=='/')&&(name!="")){ //$NON-NLS-1$
			name=""; //$NON-NLS-1$
		} else {
			if (c!='/') {
				name+=c;
			}
		}
	}
	return name;
	}
} 
