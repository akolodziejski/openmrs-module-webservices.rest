/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.webservices.rest.web.v1_0.resource;

import org.openmrs.Form;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest;

public class FormResourceTest extends BaseDelegatingResourceTest<FormResource, Form> {
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest#newObject()
	 */
	@Override
	public Form newObject() {
		return Context.getFormService().getFormByUuid(getUuidProperty());
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest#getDisplayProperty()
	 */
	@Override
	public String getDisplayProperty() {
		return "Basic Form - Test form";
	}
	
	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResourceTest#getUuidProperty()
	 */
	@Override
	public String getUuidProperty() {
		return ResourceTestConstants.FORM_UUID;
	}
	
	@Override
	public void validateDefaultRepresentation() throws Exception {
		super.validateDefaultRepresentation();
		assertPropEquals("name", getObject().getName());
		assertPropEquals("description", getObject().getDescription());
		assertPropEquals("retired", getObject().isRetired());
		assertPropPresent("encounterType");
		assertPropEquals("version", getObject().getVersion());
		assertPropEquals("build", getObject().getBuild());
		assertPropEquals("published", getObject().getPublished());
		assertPropPresent("formFields");
	}
	
	@Override
	public void validateFullRepresentation() throws Exception {
		super.validateFullRepresentation();
		assertPropEquals("name", getObject().getName());
		assertPropEquals("description", getObject().getDescription());
		assertPropEquals("retired", getObject().isRetired());
		assertPropPresent("encounterType");
		assertPropEquals("version", getObject().getVersion());
		assertPropEquals("build", getObject().getBuild());
		assertPropEquals("published", getObject().getPublished());
		assertPropPresent("formFields");
		
		assertPropPresent("auditInfo");
		assertPropEquals("xslt", getObject().getXslt());
		assertPropEquals("template", getObject().getTemplate());
	}
	
}
