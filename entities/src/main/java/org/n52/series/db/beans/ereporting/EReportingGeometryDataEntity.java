/*
 * Copyright 2015-2017 52°North Initiative for Geospatial Open Source
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

package org.n52.series.db.beans.ereporting;

import java.util.Collection;

import org.n52.series.db.beans.GeometryEntity;

public class EReportingGeometryDataEntity extends EReportingDataEntity<GeometryEntity> {

    private static final long serialVersionUID = -3578232304258898505L;

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        GeometryEntity value = getValue();
        return value == null
                || value.isEmpty();
    }

    @Override
    public boolean isSetValue() {
        return getValue() != null;
    }

    @Override
    public String getValueAsString() {
        return isSetValue()
                ? getValue().getGeometry()
                            .toText()
                : "";
    }
}