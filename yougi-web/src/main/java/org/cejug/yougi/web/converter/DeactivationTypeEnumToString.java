/* Yougi is a web application conceived to manage user groups or
 * communities focused on a certain domain of knowledge, whose members are
 * constantly sharing information and participating in social and educational
 * events. Copyright (C) 2011 Ceara Java User Group - CEJUG.
 *
 * This application is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation; either version 2.1 of the License, or (at your
 * option) any later version.
 *
 * This application is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * There is a full copy of the GNU Lesser General Public License along with
 * this library. Look for the file license.txt at the root level. If you do not
 * find it, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA 02111-1307 USA.
 * */
package org.cejug.yougi.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.cejug.yougi.entity.DeactivationType;
import org.cejug.yougi.util.ResourceBundleHelper;

/**
 * DeactivationType is a Enum. This converter is responsible for transforming
 * that Enum in something readable for the end-user, using ResourceBundle.
 * @author Hildeberto Mendonca  - http://www.hildeberto.com
 */
@FacesConverter(value="DeactivationTypeEnumToString")
public class DeactivationTypeEnumToString implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.equals("ownWill"))
            return DeactivationType.OWNWILL;
        else if(value.equals("administrative"))
            return DeactivationType.ADMINISTRATIVE;
        else
            return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        DeactivationType deactivationType = (DeactivationType) value;
        ResourceBundleHelper bundle = new ResourceBundleHelper();
        if(deactivationType == DeactivationType.OWNWILL)
            return bundle.getMessage("ownwill");
        else if(deactivationType == DeactivationType.ADMINISTRATIVE)
            return bundle.getMessage("administrative");
        else
            return "";
    }
}