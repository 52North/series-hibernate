/*
 * Copyright (C) 2015-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public License
 * version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */
package org.n52.series.db.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.n52.series.db.DataAccessException;
import org.n52.series.db.beans.I18nPhenomenonEntity;
import org.n52.series.db.beans.PhenomenonEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PhenomenonDao extends AbstractDao<PhenomenonEntity> {

    private static final String SERIES_PROPERTY = "phenomenon";

    public PhenomenonDao(Session session) {
        super(session);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PhenomenonEntity> find(DbQuery query) {
        Criteria criteria = translate(I18nPhenomenonEntity.class, getDefaultCriteria(), query)
                .add(Restrictions.ilike("name", "%" + query.getSearchTerm() + "%"));
        return query.addFilters(criteria, getSeriesProperty()).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PhenomenonEntity> getAllInstances(DbQuery query) throws DataAccessException {
        Criteria criteria = translate(I18nPhenomenonEntity.class, getDefaultCriteria(), query);
        return (List<PhenomenonEntity>) query.addFilters(criteria, getSeriesProperty()).list();
    }

    @Override
    protected String getSeriesProperty() {
        return SERIES_PROPERTY;
    }

    @Override
    protected Class<PhenomenonEntity> getEntityClass() {
        return PhenomenonEntity.class;
    }

}