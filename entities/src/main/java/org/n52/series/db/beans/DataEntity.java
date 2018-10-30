/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
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

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.n52.series.db.beans.data.Data;
import org.n52.series.db.beans.parameter.Parameter;
import org.n52.series.db.common.Utils;

public abstract class DataEntity<T> extends DescribableEntity
        implements Comparable<DataEntity<T>>, Serializable, Data<T> {

    public static final String PROPERTY_ID = "id";

    public static final String PROPERTY_DATASET = "dataset";

    public static final String PROPERTY_RESULT_TIME = "resultTime";

    public static final String PROPERTY_SAMPLING_TIME_START = "samplingTimeStart";

    public static final String PROPERTY_SAMPLING_TIME_END = "samplingTimeEnd";

    public static final String PROPERTY_VALID_TIME_START = "valid_time_start";

    public static final String PROPERTY_VALID_TIME_END = "valid_time_end";

    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";

    public static final String PROPERTY_DELETED = "deleted";

    public static final String PROPERTY_PARENT = "parent";

    public static final String PROPERTY_IDENTIFIER = "identifier";

    public static final String PROPERTY_CHILD = "child";

    public static final String PROPERTY_VALUE = "value";

    public static final String PROPERTY_PARAMETERS = "parameters";

    private static final long serialVersionUID = 273612846605300612L;

    private Date samplingTimeStart;

    private Date samplingTimeEnd;

    private T value;

    private GeometryEntity geometryEntity;

    private boolean deleted;

    private Date validTimeStart;

    private Date validTimeEnd;

    private Date resultTime;

    private boolean parent;

    private boolean child;

    private DatasetEntity dataset;

    private Set<Parameter< ? >> parameters = new HashSet<>(0);

    private Set<RelatedDataEntity> relatedObservations = new HashSet<>(0);

    private String valueIdentifier;

    private String valueName;

    private String valueDescription;

    private BigDecimal verticalFrom = NOT_SET_VERTICAL;

    private BigDecimal verticalTo = NOT_SET_VERTICAL;

    protected DataEntity() {

    }

    /**
     * @return the samplingTimeStart
     */
    @Override
    public Date getSamplingTimeStart() {
        return Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    /**
     * @param samplingTimeStart
     *        the samplingTimeStart
     */
    @Override
    public void setSamplingTimeStart(Date samplingTimeStart) {
        this.samplingTimeStart = Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    /**
     * @return the samplingTimeEnd
     */
    @Override
    public Date getSamplingTimeEnd() {
        return Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    /**
     * @param samplingTimeEnd
     *        the samplingTimeEnd
     */
    @Override
    public void setSamplingTimeEnd(Date samplingTimeEnd) {
        this.samplingTimeEnd = Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean hasValue() {
        return getValue() != null;
    }

    @Override
    public abstract boolean isNoDataValue(Collection<String> noDataValues);

    @Override
    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    @Override
    public void setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    @Override
    public boolean isSetGeometryEntity() {
        return (geometryEntity != null) && !geometryEntity.isEmpty();
    }

    @Override
    public boolean getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public Date getValidTimeStart() {
        return Utils.createUnmutableTimestamp(validTimeStart);
    }

    @Override
    public void setValidTimeStart(Date validTimeStart) {
        this.validTimeStart = Utils.createUnmutableTimestamp(validTimeStart);
    }

    @Override
    public Date getValidTimeEnd() {
        return Utils.createUnmutableTimestamp(validTimeEnd);
    }

    @Override
    public void setValidTimeEnd(Date validTimeEnd) {
        this.validTimeEnd = Utils.createUnmutableTimestamp(validTimeEnd);
    }

    @Override
    public boolean isSetValidTime() {
        return isSetValidStartTime() && isSetValidEndTime();
    }

    @Override
    public boolean isSetValidStartTime() {
        return validTimeStart != null;
    }

    @Override
    public boolean isSetValidEndTime() {
        return validTimeEnd != null;
    }

    @Override
    public Date getResultTime() {
        return Utils.createUnmutableTimestamp(resultTime);
    }

    @Override
    public void setResultTime(Date resultTime) {
        this.resultTime = Utils.createUnmutableTimestamp(resultTime);
    }

    @Override
    public boolean isParent() {
        return parent;
    }

    @Override
    public void setParent(boolean parent) {
        this.parent = parent;
    }

    @Override
    public boolean isChild() {
        return child;
    }

    @Override
    public void setChild(boolean child) {
        this.child = child;
    }

    @Override
    public Set<Parameter< ? >> getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(Set<Parameter< ? >> parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean hasParameters() {
        return (getParameters() != null) && !getParameters().isEmpty();
    }

    @Override
    public DatasetEntity getDataset() {
        return dataset;
    }

    @Override
    public void setDataset(DatasetEntity dataset) {
        this.dataset = dataset;
    }

    @Override
    public Set<RelatedDataEntity> getRelatedObservations() {
        return relatedObservations;
    }

    @Override
    public void setRelatedObservations(Set<RelatedDataEntity> relatedObservations) {
        this.relatedObservations = relatedObservations;
    }

    @Override
    public boolean hasRelatedObservations() {
        return (getRelatedObservations() != null) && !getRelatedObservations().isEmpty();
    }

    @Override
    public String getValueIdentifier() {
        return valueIdentifier;
    }

    @Override
    public void setValueIdentifier(String valueIdentifier) {
        this.valueIdentifier = valueIdentifier;
    }

    @Override
    public boolean hasValueIdentifier() {
        return (getValueIdentifier() != null) && !getValueIdentifier().isEmpty();
    }

    @Override
    public String getValueName() {
        return valueName;
    }

    @Override
    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    @Override
    public boolean hasValueName() {
        return (getValueName() != null) && !getValueName().isEmpty();
    }

    @Override
    public String getValueDescription() {
        return valueDescription;
    }

    @Override
    public void setValueDescription(String valueDescription) {
        this.valueDescription = valueDescription;
    }

    @Override
    public boolean hasValueDescription() {
        return (getValueDescription() != null) && !getValueDescription().isEmpty();
    }

    @Override
    public BigDecimal getVerticalFrom() {
        return verticalFrom;
    }

    @Override
    public void setVerticalFrom(BigDecimal verticalFrom) {
        this.verticalFrom = verticalFrom;
    }

    @Override
    public BigDecimal getVerticalTo() {
        return verticalTo;
    }

    @Override
    public void setVerticalTo(BigDecimal verticalTo) {
        this.verticalTo = verticalTo;
    }

    @Override
    public int compareTo(DataEntity<T> o) {
        return Comparator.comparing(DataEntity<T>::getSamplingTimeEnd)
                         .thenComparing(DataEntity<T>::getSamplingTimeStart)
                         .thenComparing(DataEntity<T>::getId)
                         .compare(this, o);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result)
                + ((getId() == null)
                        ? 0
                        : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DataEntity< ? > other = (DataEntity< ? >) obj;
        if (getId() == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!getId().equals(other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName())
                 .append(" [")
                 .append(" id: ")
                 .append(getId())
                 .append(" ]")
                 .toString();
    }
}
