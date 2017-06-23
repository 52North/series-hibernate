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
package org.n52.series.db.beans;

import java.io.Serializable;
import java.util.Date;

import org.n52.series.common.DbUtils;
import org.n52.series.db.beans.HibernateRelations.HasDescriptionXml;
import org.n52.series.db.beans.HibernateRelations.HasProcedure;
import org.n52.series.db.beans.HibernateRelations.HasProcedureDescriptionFormat;

/**
 * @since 1.0.0
 *
 */
public class ValidProcedureTimeEntity extends PkidEntity implements Serializable, HasProcedure<ValidProcedureTimeEntity>,
        HasProcedureDescriptionFormat<ValidProcedureTimeEntity>, HasDescriptionXml<ValidProcedureTimeEntity> {

    private static final long serialVersionUID = -3658568714438752174L;

    public static final String START_TIME = "startTime";

    public static final String END_TIME = "endTime";

    private ProcedureEntity procedure;

    private ProcedureDescriptionFormatEntity procedureDescriptionFormat;

    private Date startTime;

    private Date endTime;

    private String descriptionXml;

    @Override
    public ProcedureEntity getProcedure() {
        return this.procedure;
    }

    @Override
    public ValidProcedureTimeEntity setProcedure(ProcedureEntity procedure) {
        this.procedure = procedure;
        return this;
    }

    @Override
    public ProcedureDescriptionFormatEntity getProcedureDescriptionFormat() {
        return this.procedureDescriptionFormat;
    }

    @Override
    public ValidProcedureTimeEntity setProcedureDescriptionFormat(ProcedureDescriptionFormatEntity procedureDescriptionFormat) {
        this.procedureDescriptionFormat = procedureDescriptionFormat;
        return this;
    }

    public Date getStartTime() {
        return DbUtils.createUnmutableTimestamp(this.startTime);
    }

    public ValidProcedureTimeEntity setStartTime(Date startTime) {
        this.startTime = DbUtils.createUnmutableTimestamp(startTime);
        return this;
    }

    public Date getEndTime() {
        return DbUtils.createUnmutableTimestamp(this.endTime);
    }

    public ValidProcedureTimeEntity setEndTime(Date endTime) {
        this.endTime = DbUtils.createUnmutableTimestamp(endTime);
        return this;
    }

    @Override
    public String getDescriptionXml() {
        return descriptionXml;
    }

    @Override
    public ValidProcedureTimeEntity setDescriptionXml(String descriptionXml) {
        this.descriptionXml = descriptionXml;
        return this;
    }
}
