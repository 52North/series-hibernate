/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
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
package org.n52.series.db.beans;

import java.util.Set;

public class ProfileDataEntity extends CompositeDataEntity {

    private static final long serialVersionUID = -7431276500677067329L;

    private VerticalMetadataEntity verticalMetadata;

    public VerticalMetadataEntity getVerticalMetadata() {
        if (!hasVerticalMetadataLocal() && getDataset().hasVerticalMetadata()) {
            return getDataset().getVerticalMetadata();
        }
        return verticalMetadata;
    }

    public void setVerticalMetadata(VerticalMetadataEntity verticalMetadata) {
        this.verticalMetadata = verticalMetadata;
    }

    private boolean hasVerticalMetadataLocal() {
        return getVerticalMetadata() != null;
    }

    public boolean hasVerticalMetadata() {
        return hasVerticalMetadataLocal() || getDataset().hasVerticalMetadata();
    }

    @Override
    public Set<DataEntity<?>> getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Set<DataEntity<?>> value) {
        super.setValue(value);
    }

    public String getOrientation() {
        return hasVerticalMetadata() ? getVerticalMetadata().getOrientation() : null;
    }

    public void setOrientation(String orientation) {
        checkAndGetVerticalMetadata().setOrientation(orientation);
    }

    private VerticalMetadataEntity checkAndGetVerticalMetadata() {
        if (hasVerticalMetadata()) {
            setVerticalMetadata(new VerticalMetadataEntity());
        }
        return getVerticalMetadata();

    }

    public String getVerticalFromName() {
        return hasVerticalMetadata() ? getVerticalMetadata().getVerticalFromName() : null;
    }

    public void setVerticalFromName(String name) {
        checkAndGetVerticalMetadata().setVerticalFromName(name);
    }

    public String getVerticalToName() {
        return hasVerticalMetadata() ? getVerticalMetadata().getVerticalToName() : null;
    }

    public void setVerticalToName(String name) {
        checkAndGetVerticalMetadata().setVerticalToName(name);
    }

    public UnitEntity getVerticalUnit() {
        return hasVerticalMetadata() ? getVerticalMetadata().getVerticalUnit() : null;
    }

    public void setVerticalUnit(UnitEntity verticalUnit) {
        checkAndGetVerticalMetadata().setVerticalUnit(verticalUnit);
    }

    public boolean hasVerticalUnit() {
        return getVerticalUnit() != null && getVerticalUnit().isSetIdentifier();
    }

}
