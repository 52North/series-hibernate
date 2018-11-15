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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.n52.series.db.beans.data.Data;
import org.n52.series.db.beans.dataset.AggregationType;
import org.n52.series.db.beans.dataset.DatasetType;
import org.n52.series.db.beans.dataset.ValueType;
import org.n52.series.db.beans.sampling.MeasuringProgramEntity;
import org.n52.series.db.beans.sampling.SamplingEntity;
import org.n52.series.db.common.Utils;

public class DatasetEntity extends DescribableEntity implements Serializable {

    public static final String ENTITY_ALIAS = "dataset";

    public static final String PROPERTY_OFFERING = "offering";
    public static final String PROPERTY_PROCEDURE = "procedure";
    public static final String PROPERTY_PLATFORM = "platform";
    public static final String PROPERTY_PHENOMENON = "phenomenon";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_FEATURE = "feature";
    public static final String PROPERTY_DATASET_TYPE = "datasetType";
    public static final String PROPERTY_AGGREGATION_TYPE = "aggregationType";
    public static final String PROPERTY_VALUE_TYPE = "valueType";
    public static final String PROPERTY_FIRST_VALUE_AT = "firstValueAt";
    public static final String PROPERTY_LAST_VALUE_AT = "lastValueAt";
    public static final String PROPERTY_PUBLISHED = "published";
    public static final String PROPERTY_DELETED = "deleted";
    public static final String HIDDEN_CHILD = "hidden";

    public static final String PROPERTY_MOBILE = "mobile";
    public static final String PROPERTY_INSITU = "insitu";

    public static final String PROPERTY_UNIT = "unit";

    private static final long serialVersionUID = -7491530543976690237L;

    private PhenomenonEntity phenomenon;

    private ProcedureEntity procedure;

    private OfferingEntity offering;

    private AbstractFeatureEntity<?> feature;

    private CategoryEntity category;

    private PlatformEntity platform;

    private boolean published = true;

    private boolean deleted;

    private boolean disabled;

    private DatasetType datasetType;

    private AggregationType aggregationType;

    private ValueType valueType;

    private Set<Date> resultTimes;

    private Date firstValueAt;

    private Date lastValueAt;

    private Data<?> firstObservation;

    private Data<?> lastObservation;

    private BigDecimal firstQuantityValue;

    private BigDecimal lastQuantityValue;

    private UnitEntity unit;

    private long observationCount = -1;

    private boolean hidden;

    private FormatEntity observationType;

    private boolean mobile;

    private boolean insitu = true;

    private String originTimezone;

    private final Set<RelatedDatasetEntity> relatedDatasets = new LinkedHashSet<>();

    private List<DatasetEntity> referenceValues = new ArrayList<>();

    private Integer numberOfDecimals;

    private final Set<SamplingEntity> samplings = new LinkedHashSet<>();

    private final Set<MeasuringProgramEntity> measuringPrograms = new LinkedHashSet<>();

    public DatasetEntity() {
        this(ValueType.not_initialized);
    }

    public DatasetEntity(String type) {
        this(ValueType.valueOf(type));
    }

    public DatasetEntity(ValueType type) {
        this.valueType = type;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public PhenomenonEntity getPhenomenon() {
        return phenomenon;
    }

    public DatasetEntity setPhenomenon(PhenomenonEntity phenomenon) {
        this.phenomenon = phenomenon;
        return this;
    }

    public PhenomenonEntity getObservableProperty() {
        return getPhenomenon();
    }

    public DatasetEntity setObservableProperty(PhenomenonEntity observableProperty) {
        return setPhenomenon(observableProperty);
    }

    public ProcedureEntity getProcedure() {
        return procedure;
    }

    public DatasetEntity setProcedure(ProcedureEntity procedure) {
        this.procedure = procedure;
        return this;
    }

    public OfferingEntity getOffering() {
        return offering;
    }

    public DatasetEntity setOffering(OfferingEntity offering) {
        this.offering = offering;
        return this;
    }

    public boolean isSetOffering() {
        return getOffering() != null;
    }

    public AbstractFeatureEntity<?> getFeature() {
        return feature;
    }

    public void setFeature(AbstractFeatureEntity<?> feature) {
        this.feature = feature;
    }

    public boolean isSetFeature() {
        return getFeature() != null;
    }

    public PlatformEntity getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformEntity platform) {
        this.platform = platform;
    }

    public Boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public DatasetEntity setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public DatasetEntity setDisabled(boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public boolean isSetObservationType() {
        return (getObservationType() != null) && getObservationType().isSetFormat();
    }

    public Date getFirstValueAt() {
        return Utils.createUnmutableTimestamp(firstValueAt);
    }

    public void setFirstValueAt(Date firstValueAt) {
        this.firstValueAt = Utils.createUnmutableTimestamp(firstValueAt);
    }

    public boolean isSetFirstValueAt() {
        return getFirstValueAt() != null;
    }

    public Date getLastValueAt() {
        return Utils.createUnmutableTimestamp(lastValueAt);
    }

    public void setLastValueAt(Date lastValueAt) {
        this.lastValueAt = Utils.createUnmutableTimestamp(lastValueAt);
    }

    public boolean isSetLastValueAt() {
        return getLastValueAt() != null;
    }

    public Data<?> getFirstObservation() {
        return firstObservation;
    }

    public void setFirstObservation(Data<?> firstObservation) {
        this.firstObservation = firstObservation;
    }

    public Data<?> getLastObservation() {
        return lastObservation;
    }

    public void setLastObservation(Data<?> lastObservation) {
        this.lastObservation = lastObservation;
    }

    public BigDecimal getFirstQuantityValue() {
        return firstQuantityValue;
    }

    public void setFirstQuantityValue(BigDecimal firstValue) {
        this.firstQuantityValue = firstValue;
    }

    public BigDecimal getLastQuantityValue() {
        return lastQuantityValue;
    }

    public void setLastQuantityValue(BigDecimal lastValue) {
        this.lastQuantityValue = lastValue;
    }

    public DatasetType getDatasetType() {
        return datasetType;
    }

    public void setDatasetType(DatasetType datasetType) {
        this.datasetType = datasetType;
    }

    public AggregationType getAggregationType() {
        return aggregationType;
    }

    public void setAggregationType(AggregationType aggregationType) {
        this.aggregationType = aggregationType;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    /**
     * @return a list of result times
     * @since 2.0.0
     */

    public Set<Date> getResultTimes() {
        Set<Date> unmodifiableResultTimes = wrapToUnmutables(resultTimes);
        return unmodifiableResultTimes != null ? Collections.unmodifiableSet(unmodifiableResultTimes) : null;
    }

    /**
     * @param resultTimes
     *            a list of result times
     * @since 2.0.0
     */

    public void setResultTimes(Set<Date> resultTimes) {
        this.resultTimes = wrapToUnmutables(resultTimes);
    }

    private Set<Date> wrapToUnmutables(Set<Date> dates) {
        return dates != null
                ? dates.stream().map(d -> d != null ? new Timestamp(d.getTime()) : null).collect(Collectors.toSet())
                : null;
    }

    public UnitEntity getUnit() {
        return unit;
    }

    public void setUnit(UnitEntity unit) {
        this.unit = unit;
    }

    public boolean hasUnit() {
        return unit != null;
    }

    public String getUnitI18nName(String locale) {
        return unit != null
                // ? unit.getNameI18n(locale)
                ? unit.getUnit()
                : "";
    }

    public List<DatasetEntity> getReferenceValues() {
        return referenceValues;
    }

    public DatasetEntity setReferenceValues(Collection<DatasetEntity> referenceValues) {
        this.referenceValues.clear();
        if (referenceValues != null) {
            this.referenceValues.addAll(referenceValues);
        }
        return this;
    }

    public boolean hasReferenceValues() {
        return getReferenceValues() != null && !getReferenceValues().isEmpty();
    }

    public Integer getNumberOfDecimals() {
        return numberOfDecimals;
    }

    public DatasetEntity setNumberOfDecimals(Integer numberOfDecimals) {
        this.numberOfDecimals = numberOfDecimals;
        return this;
    }

    public void setObservationCount(long count) {
        this.observationCount = count;
    }

    public long getObservationCount() {
        return observationCount;
    }

    public boolean isHidden() {
        return hidden;
    }

    public DatasetEntity setHidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    public FormatEntity getObservationType() {
        return observationType;

    }

    public DatasetEntity setObservationType(FormatEntity observationType) {
        this.observationType = observationType;
        return this;
    }

    public boolean isSetObservationtype() {
        return (getObservationType() != null) && getObservationType().isSetFormat();
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean isInsitu() {
        return insitu;
    }

    public void setInsitu(boolean insitu) {
        this.insitu = insitu;
    }

    public String getOriginTimezone() {
        return originTimezone;
    }

    public void setOriginTimezone(String originTimezone) {
        this.originTimezone = originTimezone;
    }

    public boolean isSetOriginTimezone() {
        return getOriginTimezone() != null && !getOriginTimezone().isEmpty();
    }

    public Set<RelatedDatasetEntity> getRelatedDatasets() {
        return relatedDatasets;
    }

    public void setRelatedObservations(Set<RelatedDatasetEntity> relatedDataset) {
        this.relatedDatasets.clear();
        if (relatedDataset != null) {
            this.relatedDatasets.addAll(relatedDataset);
        }
    }

    public boolean hasRelatedDatasets() {
        return (getRelatedDatasets() != null) && !getRelatedDatasets().isEmpty();
    }

    public Set<SamplingEntity> getSamplings() {
        return samplings;
    }

    public void setSamplings(Set<SamplingEntity> samplings) {
        this.samplings.clear();
        if (samplings != null) {
            this.samplings.addAll(samplings);
        }
    }

    public boolean hasSamplings() {
        return getSamplings() != null && !getSamplings().isEmpty();
    }

    public Set<MeasuringProgramEntity> getMeasuringPrograms() {
        return measuringPrograms;
    }

    public void setMeasuringPrograms(Set<MeasuringProgramEntity> measuringPrograms) {
        this.measuringPrograms.clear();
        if (measuringPrograms != null) {
            this.measuringPrograms.addAll(measuringPrograms);
        }
    }

    public boolean hasMeasuringPrograms() {
        return getMeasuringPrograms() != null && !getMeasuringPrograms().isEmpty();
    }

    @Override
    public String getLabelFrom(String locale) {
        StringBuilder sb = new StringBuilder();
        sb.append(phenomenon.getLabelFrom(locale)).append(" ");
        sb.append(procedure.getLabelFrom(locale)).append(", ");
        sb.append(feature.getLabelFrom(locale)).append(", ");
        return sb.append(offering.getLabelFrom(locale)).toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName()).append(" [").append(" id: ").append(getId())
                .append(" , category: ").append(getCategory()).append(" , phenomenon: ").append(getPhenomenon())
                .append(" , procedure: ").append(getProcedure()).append(" , offering: ").append(getOffering())
                .append(" , feature: ").append(getFeature()).append(" , service: ").append(getService()).append(" ]")
                .toString();
    }

    public void copy(DatasetEntity dataset) {
        setIdentifier(dataset.getIdentifier());
        setIdentifierCodespace(dataset.getIdentifierCodespace());
        setName(dataset.getName());
        setNameCodespace(dataset.getNameCodespace());
        setDescription(dataset.getDescription());
        if (dataset.getParameters() != null) {
            setParameters(dataset.getParameters().stream().collect(Collectors.toSet()));
        }
        setCategory(dataset.getCategory());
        setDeleted(dataset.isDeleted());
        setDeleted(dataset.isDeleted());
        setDisabled(dataset.isDisabled());
        setFeature(dataset.getFeature());
        setFirstObservation(dataset.getFirstObservation());
        setFirstQuantityValue(dataset.getFirstQuantityValue());
        setFirstValueAt(dataset.getFirstValueAt());
        setHidden(dataset.isHidden());
        setLastObservation(dataset.getLastObservation());
        setLastQuantityValue(dataset.getLastQuantityValue());
        setLastValueAt(dataset.getLastValueAt());
        setObservationCount(dataset.getObservationCount());
        setObservationType(dataset.getObservationType());
        setOffering(dataset.getOffering());
        setPhenomenon(dataset.getPhenomenon());
        setPlatform(dataset.getPlatform());
        setProcedure(dataset.getProcedure());
        setPublished(dataset.isPublished());
        if (dataset.getRelatedDatasets() != null) {
            setRelatedObservations(dataset.getRelatedDatasets().stream().collect(Collectors.toSet()));
        }
        if (dataset.getResultTimes() != null) {
            setResultTimes(dataset.getResultTimes().stream().collect(Collectors.toSet()));
        }
        if (dataset.hasSamplings()) {
            setSamplings(dataset.getSamplings().stream().collect(Collectors.toSet()));
        }
        if (dataset.hasMeasuringPrograms()) {
            setMeasuringPrograms(dataset.getMeasuringPrograms().stream().collect(Collectors.toSet()));
        }
        setUnit(dataset.getUnit());
    }

}
