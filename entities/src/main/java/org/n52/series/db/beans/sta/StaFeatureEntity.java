/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.series.db.beans.sta;

import org.n52.series.db.beans.AbstractFeatureEntity;

import java.util.Set;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public class StaFeatureEntity<T> extends AbstractFeatureEntity<T> {

    private Set<StaDataEntity<?>> observations;

    public StaFeatureEntity(AbstractFeatureEntity<T> afe) {
        super();
        this.setIdentifier(afe.getIdentifier());
        this.setName(afe.getName());
        this.setDescription(afe.getDescription());
        this.setParameters(afe.getParameters());

        this.setGeometry(afe.getGeometry());
        this.setGeometryEntity(afe.getGeometryEntity());
        this.setXml(afe.getXml());
        this.setFeatureType(afe.getFeatureType());
        this.setUrl(afe.getUrl());
        this.setChildren(afe.getChildren());
        this.setParents(afe.getParents());
        this.setIdentifier(afe.getIdentifier());
    }

    public StaFeatureEntity<T> setObservations(Set<StaDataEntity<?>> observations) {
        this.observations = observations;
        return this;
    }

    public Set<StaDataEntity<?>> getObservations() {
        return observations;
    }
}
