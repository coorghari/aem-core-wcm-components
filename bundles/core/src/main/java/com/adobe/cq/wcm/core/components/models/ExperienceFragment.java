/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2019 Adobe
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
package com.adobe.cq.wcm.core.components.models;

import org.jetbrains.annotations.NotNull;
import org.osgi.annotation.versioning.ConsumerType;

import com.adobe.cq.export.json.ComponentExporter;

/**
 * Defines the {@code ExperienceFragment} Sling Model used for the
 * {@code /apps/core/wcm/components/experiencefragment} component.
 *
 * @since com.adobe.cq.wcm.core.components.models 12.9.0
 */
@ConsumerType
public interface ExperienceFragment extends ComponentExporter {

    /**
     * Name of the configuration policy property that specifies the experience fragment variation path. The property
     * should provide a String value.
     *
     * @since com.adobe.cq.wcm.core.components.models 12.9.0
     */
    String PN_FRAGMENT_PATH = "fragmentPath";

    /**
     * Returns the localized path of the experience fragment variation if the experience fragment resource is defined
     * in the template. If not, it returns the configured fragment path if it exists, null otherwise.
     *
     * If both the content page and the experience fragment have a localized root (language, live copy or blueprint),
     * - it is then assumed that the content pages and the experience fragments follow the same structure patterns -
     * this method returns the localized path of the experience fragment based on the localization of the content page
     * if it exists, otherwise it returns the fragment path that is configured, suffixed with "/jcr:content".
     *
     * @return Localized experience fragment variation path
     * @since com.adobe.cq.wcm.core.components.models 12.9.0
     */
    default String getLocalizedFragmentPath() {
        throw new UnsupportedOperationException();
    }

    /**
     * @see ComponentExporter#getExportedType()
     * @since com.adobe.cq.wcm.core.components.models 12.9.0
     */
    @NotNull
    @Override
    default String getExportedType() {
        throw new UnsupportedOperationException();
    }

}
