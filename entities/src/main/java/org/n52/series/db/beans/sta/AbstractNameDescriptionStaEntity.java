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
package org.n52.series.db.beans.sta;

import java.util.Objects;

import org.n52.series.db.beans.HibernateRelations.HasDescription;
import org.n52.series.db.beans.HibernateRelations.HasName;
import org.n52.series.db.beans.IdEntity;

public class AbstractNameDescriptionStaEntity extends IdEntity implements AbstractStaEntity, HasName, HasDescription {

    private static final long serialVersionUID = 948180142611914656L;

    private String name;

    private String description;

    private boolean processed;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IdEntity)) {
            return false;
        }
        AbstractNameDescriptionStaEntity other = (AbstractNameDescriptionStaEntity) obj;
        return super.equals(other) && Objects.equals(getName(), other.getName());
    }

    @Override
    public boolean isProcesssed() {
        return processed;
    }

    @Override
    public AbstractStaEntity setProcesssed(boolean processsed) {
        this.processed = processsed;
        return this;
    }
}
